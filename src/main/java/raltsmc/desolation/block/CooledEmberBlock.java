package raltsmc.desolation.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireChargeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import raltsmc.desolation.registry.DesolationBlocks;

public class CooledEmberBlock extends Block {
    public CooledEmberBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        Hand hand = player.getActiveHand();
        ItemStack stack = player.getStackInHand(hand);

        if (stack.getItem() == Items.FLINT_AND_STEEL) {
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0f, world.getRandom().nextFloat() * 0.4f + 0.8f);
            world.setBlockState(pos, DesolationBlocks.EMBER_BLOCK.getDefaultState());
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            stack.damage(1, player, LivingEntity.getSlotForHand(hand));

            return ActionResult.success(world.isClient());
        } else if (stack.getItem() == Items.FIRE_CHARGE) {
            ((FireChargeItem) Items.FIRE_CHARGE).playUseSound(world, pos);
            world.setBlockState(pos, DesolationBlocks.EMBER_BLOCK.getDefaultState());
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            stack.decrement(1);

            return ActionResult.success(world.isClient);
        }

        return super.onUse(state, world, pos, player, hit);
    }
}
