package raltsmc.desolation.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import raltsmc.desolation.registry.DesolationParticles;
import raltsmc.desolation.registry.DesolationSounds;

// TODO:  Consider merging CooledEmberBlock into EmberBlock,
//        using Properties.LIT,
//        and mixing in to tools (flint_and_steel, fire_charge, shovels) to change state.
public class EmberBlock extends Block {
    private final BlockState cooledState;

    public EmberBlock(Block cooled, Settings settings) {
        super(settings);
        this.cooledState = cooled.getDefaultState();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        Hand hand = player.getActiveHand();
        ItemStack stack = player.getStackInHand(hand);

        if (stack.getItem() instanceof ShovelItem) {
            if (world.isClient()) {
                for (int i = 0; i < 20; ++i) {
                    CampfireBlock.spawnSmokeParticle(world, pos, false, true);
                }
            } else {
                world.syncWorldEvent(null, 1009, pos, 0);
                stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            }
            world.playSound(player, pos, SoundEvents.BLOCK_BASALT_HIT, SoundCategory.BLOCKS, 1f, 1f);
            world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.3f, 1f);
            world.setBlockState(pos, this.cooledState);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);

            return ActionResult.success(world.isClient);
        }

        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && !entity.isFireImmune()) {
            DamageSource hotFloor = world.getDamageSources().hotFloor();

            if (entity instanceof LivingEntity && !entity.isInvulnerableTo(hotFloor)) {
                entity.damage(hotFloor, 1.0F);

                if (Math.random() > 0.9D) {
                    entity.setFireTicks(120);
                }
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState blockstate, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY();
        double f = (double)pos.getZ() + 0.5D;

        double g = random.nextDouble() * 0.6D - 0.3D;
        double h = random.nextDouble() * 6.0D / 16.0D;
        double i = random.nextDouble() * 0.6D - 0.3D;

        double j = random.nextDouble() * 0.6D - 0.3D;
        double k = random.nextDouble() * 6.0D / 16.0D;
        double l = random.nextDouble() * 0.6D - 0.3D;

        double rdY = (random.nextDouble() - 0.5D) / 5.0D;

        if (random.nextBoolean()) {
            world.addParticle(ParticleTypes.LARGE_SMOKE, d + g, e + h, f + i, 0.0D, 0.1D + rdY, 0.0D);
        }
        if (random.nextFloat() < 0.3f) {
            world.addParticle((ParticleEffect) DesolationParticles.SPARK, d + j, e + k, f + l, 0.0D, random.nextDouble() * 0.3D + 0.1D, 0.0D);
            if (random.nextFloat() < 0.05f) {
                int index = random.nextInt(4);
                SoundEvent popSound = switch (index) {
                    case 0 -> DesolationSounds.EMBER_BLOCK_POP_1;
                    case 1 -> DesolationSounds.EMBER_BLOCK_POP_2;
                    case 2 -> DesolationSounds.EMBER_BLOCK_POP_3;
                    case 3 -> DesolationSounds.EMBER_BLOCK_POP_4;
                    default -> throw new IllegalStateException("Unexpected value: " + index);
                };
                world.playSound(d + j, e + k, f + l, popSound, SoundCategory.BLOCKS, random.nextFloat() * 0.2F + 0.8F, 1.0F, true);
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = blockView.getBlockState(blockPos);
        return shouldCool(blockView, blockPos, blockState) ? this.cooledState : super.getPlacementState(ctx);
    }

    private static boolean shouldCool(BlockView world, BlockPos pos, BlockState state) {
        return coolsIn(state) || coolsOnAnySide(world, pos) != CoolType.NONE;
    }

    private enum CoolType {
        NONE,
        TOUCHED_WATER,
        SMOTHERED
    }

    private static CoolType coolsOnAnySide(BlockView world, BlockPos pos) {
        boolean isTouchingWater = false;
        boolean isSmothered = true;
        BlockPos.Mutable mutable = pos.mutableCopy();
        Direction[] dirs = Direction.values();

        for (Direction direction : dirs) {
            BlockState blockState = world.getBlockState(mutable);
            if (direction != Direction.DOWN || coolsIn(blockState)) {
                mutable.set(pos, direction);
                blockState = world.getBlockState(mutable);
                if (coolsIn(blockState) && !blockState.isSideSolidFullSquare(world, pos, direction.getOpposite())) {
                    isTouchingWater = true;
                    break;
                } else if (!blockState.isOpaqueFullCube(world, mutable)) {
                    isSmothered = false;
                }
            }
        }

        if (isTouchingWater) {
            return CoolType.TOUCHED_WATER;
        } else if (isSmothered) {
            return CoolType.SMOTHERED;
        } else {
            return CoolType.NONE;
        }
    }

    private static boolean coolsIn(BlockState state) {
        return state.getFluidState().isIn(FluidTags.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        CoolType coolType = coolsOnAnySide(world, pos);
        if (coolType != CoolType.NONE) {
            if (!world.isClient() && coolType == CoolType.TOUCHED_WATER) {
                world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);
            }
            return this.cooledState;
        } else {
            return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
        }
    }
}
