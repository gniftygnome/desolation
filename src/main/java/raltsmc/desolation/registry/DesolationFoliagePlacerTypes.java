package raltsmc.desolation.registry;

import com.terraformersmc.terraform.tree.placer.PlacerTypes;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.world.gen.foliage.CharredFoliagePlacer;

public class DesolationFoliagePlacerTypes {
    public static final FoliagePlacerType<CharredFoliagePlacer> CHARRED_FOLIAGE_PLACER = PlacerTypes.registerFoliagePlacer(Desolation.id("charred_foliage_placer"), CharredFoliagePlacer.CODEC);

    public static void init() { }
}
