package raltsmc.desolation.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class CharredLogBlock extends PillarBlock {
    public CharredLogBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        super.onStateReplaced(state, world, pos, moved);

        if (!state.isOf(world.getBlockState(pos).getBlock())) {
            CharredBranchBlock.notifyLossOfSupport(world, pos);
        }
    }
}
