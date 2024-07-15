package raltsmc.desolation.registry;

import com.terraformersmc.terraform.tree.api.placer.PlacerTypes;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.world.gen.trunk.BasedTrunkPlacer;
import raltsmc.desolation.world.gen.trunk.FallenTrunkPlacer;

public class DesolationTrunkPlacerTypes {
    public static final TrunkPlacerType<FallenTrunkPlacer> FALLEN = PlacerTypes.registerTrunkPlacer(Identifier.of(Desolation.MOD_ID, "fallen_trunk_placer"), FallenTrunkPlacer.CODEC);
    public static final TrunkPlacerType<BasedTrunkPlacer> BASED = PlacerTypes.registerTrunkPlacer(Identifier.of(Desolation.MOD_ID, "based_trunk_placer"), BasedTrunkPlacer.CODEC);

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationTrunkPlacerTypes() {
        return;
    }

    public static void init() { }
}
