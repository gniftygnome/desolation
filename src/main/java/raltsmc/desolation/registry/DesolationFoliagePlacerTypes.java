package raltsmc.desolation.registry;

import com.terraformersmc.terraform.tree.api.placer.PlacerTypes;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.world.gen.foliage.CharredFoliagePlacer;

public class DesolationFoliagePlacerTypes {
    public static final FoliagePlacerType<CharredFoliagePlacer> CHARRED_FOLIAGE_PLACER = PlacerTypes.registerFoliagePlacer(Identifier.of(Desolation.MOD_ID, "charred_foliage_placer"), CharredFoliagePlacer.CODEC);

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationFoliagePlacerTypes() {
        return;
    }

    public static void init() { }
}
