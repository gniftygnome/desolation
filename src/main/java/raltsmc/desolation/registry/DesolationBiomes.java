package raltsmc.desolation.registry;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.world.biome.BiomeCreator;

public class DesolationBiomes {
    public static final RegistryKey<Biome> CHARRED_FOREST = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Desolation.MOD_ID, "charred_forest"));
    public static final RegistryKey<Biome> CHARRED_FOREST_CLEARING = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Desolation.MOD_ID, "charred_forest_clearing"));
    public static final RegistryKey<Biome> CHARRED_FOREST_SMALL = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Desolation.MOD_ID, "charred_forest_small"));

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationBiomes() {
        return;
    }

    public static void bootstrap(Registerable<Biome> registerable) {
        registerable.register(CHARRED_FOREST, BiomeCreator.createCharredForest(registerable, false, false));
        registerable.register(CHARRED_FOREST_CLEARING, BiomeCreator.createCharredForest(registerable, true, true));
        registerable.register(CHARRED_FOREST_SMALL, BiomeCreator.createCharredForest(registerable, false, true));
    }
}
