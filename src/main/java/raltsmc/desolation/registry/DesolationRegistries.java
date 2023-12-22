package raltsmc.desolation.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.world.feature.DesolationConfiguredFeatures;
import raltsmc.desolation.world.feature.DesolationFeatures;
import raltsmc.desolation.world.feature.DesolationPlacedFeatures;

public class DesolationRegistries {
    @SuppressWarnings("UnnecessaryReturnStatement")
    public DesolationRegistries() {
        return;
    }

    public static BlockItem registerBlockItem(String name, Block block) {
        BlockItem item = new BlockItem(block, new Item.Settings());
        return register(name, item);
    }

    public static <I extends Item> I register(String name, I item) {
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, blockItem);
        }
        return Registry.register(Registries.ITEM, Identifier.of(Desolation.MOD_ID, name), item);
    }

    public static <B extends Block> B register(String name, B block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Desolation.MOD_ID, name), block);
    }

    public static void init() {
        DesolationSounds.init();
        DesolationBlocks.init();
        DesolationItems.init();
        DesolationBoatTypes.init();
        DesolationEntities.init();
        DesolationTrunkPlacerTypes.init();
        DesolationFoliagePlacerTypes.init();
        DesolationFeatures.init();
        DesolationConfiguredFeatures.init();
        DesolationPlacedFeatures.init();
        DesolationStructures.init();
        DesolationStatusEffects.init();
        DesolationPotions.init();
        DesolationParticles.init();
        DesolationBiomes.init();
        DesolationItemGroups.init();
    }
}
