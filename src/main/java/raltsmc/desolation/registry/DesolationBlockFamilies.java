package raltsmc.desolation.registry;

import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

public class DesolationBlockFamilies {
    public static final BlockFamily CHARRED = BlockFamilies.register(DesolationBlocks.CHARRED_PLANKS)
            .button(DesolationBlocks.CHARRED_BUTTON)
            .fence(DesolationBlocks.CHARRED_FENCE)
            .fenceGate(DesolationBlocks.CHARRED_FENCE_GATE)
            .pressurePlate(DesolationBlocks.CHARRED_PRESSURE_PLATE)
            .sign(DesolationBlocks.CHARRED_SIGN, DesolationBlocks.CHARRED_WALL_SIGN)
            .slab(DesolationBlocks.CHARRED_SLAB)
            .stairs(DesolationBlocks.CHARRED_STAIRS)
            .door(DesolationBlocks.CHARRED_DOOR)
            .trapdoor(DesolationBlocks.CHARRED_TRAPDOOR)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();
}
