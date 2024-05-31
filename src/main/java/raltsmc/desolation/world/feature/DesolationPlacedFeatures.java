package raltsmc.desolation.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.registry.DesolationBlocks;
import raltsmc.desolation.registry.DesolationRegistries;
import raltsmc.desolation.tag.DesolationBlockTags;

public class DesolationPlacedFeatures {
    public static final RegistryKey<PlacedFeature> TREES_CHARRED_LARGE = createRegistryKey("trees_charred_large");
    public static final RegistryKey<PlacedFeature> TREES_CHARRED_SMALL = createRegistryKey("trees_charred_small");
    public static final RegistryKey<PlacedFeature> TREES_CHARRED_FALLEN_LARGE = createRegistryKey("trees_charred_fallen_large");
    public static final RegistryKey<PlacedFeature> TREES_CHARRED_FALLEN_SMALL = createRegistryKey("trees_charred_fallen_small");

    public static final RegistryKey<PlacedFeature> PATCH_CHARRED_SAPLING = createRegistryKey("patch_charred_sapling");
    public static final RegistryKey<PlacedFeature> PATCH_SCORCHED_TUFT = createRegistryKey("patch_scorched_tuft");
    public static final RegistryKey<PlacedFeature> PATCH_ASH_LAYER = createRegistryKey("patch_ash_layer");
    public static final RegistryKey<PlacedFeature> PATCH_EMBER_CHUNK = createRegistryKey("patch_ember_chunk");
    public static final RegistryKey<PlacedFeature> PATCH_ASH_BRAMBLE = createRegistryKey("patch_ash_bramble");
    public static final RegistryKey<PlacedFeature> PLANT_CINDERFRUIT = createRegistryKey("plant_cinderfruit");
    public static final RegistryKey<PlacedFeature> GIANT_BOULDER = createRegistryKey("giant_boulder");

    public static void bootstrap(Registerable<PlacedFeature> registerable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        final BlockPredicate ON_CHARRED_SOIL = BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), DesolationBlocks.CHARRED_SOIL);
        final BlockPredicate ON_SCORCHED_EARTH = BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), DesolationBlockTags.SCORCHED_EARTH);

        registerTreeFeature(registerable, TREES_CHARRED_LARGE, 15, ON_SCORCHED_EARTH, DesolationConfiguredFeatures.TREE_CHARRED);

        registerTreeFeature(registerable, TREES_CHARRED_SMALL, 10, ON_SCORCHED_EARTH, DesolationConfiguredFeatures.TREE_CHARRED_SMALL);

        registerTreeFeature(registerable, TREES_CHARRED_FALLEN_LARGE, 4, ON_SCORCHED_EARTH, DesolationConfiguredFeatures.TREE_CHARRED_FALLEN);

        registerTreeFeature(registerable, TREES_CHARRED_FALLEN_SMALL, 3, ON_SCORCHED_EARTH, DesolationConfiguredFeatures.TREE_CHARRED_FALLEN_SMALL);

        DesolationRegistries.register(registerable, PATCH_CHARRED_SAPLING, DesolationConfiguredFeatures.PATCH_CHARRED_SAPLING,
                CountPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BlockFilterPlacementModifier.of(ON_CHARRED_SOIL),
                BiomePlacementModifier.of());

        DesolationRegistries.register(registerable, PATCH_SCORCHED_TUFT, DesolationConfiguredFeatures.PATCH_SCORCHED_TUFT,
                CountPlacementModifier.of(8),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BlockFilterPlacementModifier.of(ON_CHARRED_SOIL),
                BiomePlacementModifier.of());

        DesolationRegistries.register(registerable, PATCH_ASH_LAYER, DesolationConfiguredFeatures.PATCH_ASH_LAYER,
                CountPlacementModifier.of(3),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BlockFilterPlacementModifier.of(ON_SCORCHED_EARTH),
                BiomePlacementModifier.of());

        DesolationRegistries.register(registerable, PATCH_EMBER_CHUNK, DesolationConfiguredFeatures.PATCH_EMBER_CHUNK,
                CountPlacementModifier.of(4),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());

        DesolationRegistries.register(registerable, PATCH_ASH_BRAMBLE, DesolationConfiguredFeatures.PATCH_ASH_BRAMBLE,
                CountPlacementModifier.of(5),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(),
                        DesolationBlocks.CHARRED_SOIL,
                        DesolationBlocks.CHARRED_LOG,
                        DesolationBlocks.ASH_BRAMBLE)),
                BiomePlacementModifier.of());

        DesolationRegistries.register(registerable, PLANT_CINDERFRUIT, DesolationConfiguredFeatures.PLANT_CINDERFRUIT,
                CountPlacementModifier.of(1),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());

        DesolationRegistries.register(registerable, GIANT_BOULDER, DesolationConfiguredFeatures.GIANT_BOULDER,
                CountPlacementModifier.of(1),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
    }

    private static RegistryKey<PlacedFeature> createRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Desolation.id(name));
    }

    private static void registerTreeFeature(Registerable<PlacedFeature> registerable, RegistryKey<PlacedFeature> key, int count, BlockPredicate predicate, RegistryKey<ConfiguredFeature<?, ?>> feature) {
        DesolationRegistries.register(registerable, key, feature,
                PlacedFeatures.createCountExtraModifier(count, 0.1f, 1),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BlockFilterPlacementModifier.of(predicate),
                BiomePlacementModifier.of());
    }
}
