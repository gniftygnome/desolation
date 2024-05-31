package raltsmc.desolation.registry;

import com.terraformersmc.terraform.tree.placer.PlacerTypes;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.world.gen.trunk.BasedTrunkPlacer;
import raltsmc.desolation.world.gen.trunk.FallenTrunkPlacer;

public class DesolationTrunkPlacerTypes {
    public static final TrunkPlacerType<FallenTrunkPlacer> FALLEN = PlacerTypes.registerTrunkPlacer(Desolation.id("fallen_trunk_placer"), FallenTrunkPlacer.CODEC);
    public static final TrunkPlacerType<BasedTrunkPlacer> BASED = PlacerTypes.registerTrunkPlacer(Desolation.id("based_trunk_placer"), BasedTrunkPlacer.CODEC);

    public static void init() { }
}
