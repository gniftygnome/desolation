package raltsmc.desolation.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AshBrambleBlock extends Block {
    public AshBrambleBlock(Settings settings) { super(settings); }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (!world.isClient && world.random.nextInt(25) == 0 && entity instanceof PlayerEntity && entity.getVelocity().length() > 0.05f) {
            //world.playSound(null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 0.2F, 0.9F);
            //world.removeBlock(pos, false);
            world.breakBlock(pos, false, entity);
        }
    }
}
