package raltsmc.desolation.mixin.tree;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import raltsmc.desolation.registry.DesolationBlocks;

import java.util.function.BiConsumer;

@Mixin(TrunkPlacer.class)
public class TrunkPlacerMixin {
    @Inject(method = "setToDirt", at = @At("HEAD"), cancellable = true)
    private static void desolation$notAlwaysDirt(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos pos, TreeFeatureConfig config, CallbackInfo ci) {
        if (world.testBlockState(pos, state ->
                state.isOf(DesolationBlocks.CHARRED_SOIL) ||
                state.isOf(DesolationBlocks.EMBER_BLOCK) ||
                state.isOf(DesolationBlocks.COOLED_EMBER_BLOCK))) {
            ci.cancel();
        }
    }
}
