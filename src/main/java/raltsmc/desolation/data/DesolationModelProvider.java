package raltsmc.desolation.data;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import raltsmc.desolation.registry.DesolationBlockFamilies;
import raltsmc.desolation.registry.DesolationBlocks;
import raltsmc.desolation.registry.DesolationBoats;
import raltsmc.desolation.registry.DesolationItems;

import java.util.Optional;

public class DesolationModelProvider extends FabricModelProvider {
    public DesolationModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        // Charred wood type
        generator.registerCubeAllModelTexturePool(DesolationBlockFamilies.CHARRED.getBaseBlock()).family(DesolationBlockFamilies.CHARRED);
        generator.registerLog(DesolationBlocks.CHARRED_LOG).log(DesolationBlocks.CHARRED_LOG).wood(DesolationBlocks.CHARRED_WOOD);
        generator.registerLog(DesolationBlocks.STRIPPED_CHARRED_LOG).log(DesolationBlocks.STRIPPED_CHARRED_LOG).wood(DesolationBlocks.STRIPPED_CHARRED_WOOD);
        generator.registerHangingSign(DesolationBlockFamilies.CHARRED.getBaseBlock(), DesolationBlocks.CHARRED_HANGING_SIGN, DesolationBlocks.CHARRED_WALL_HANGING_SIGN);
        generator.registerFlowerPotPlantAndItem(DesolationBlocks.CHARRED_SAPLING, DesolationBlocks.POTTED_CHARRED_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerSingleton(DesolationBlocks.CHARRED_BRANCHES, TexturedModel.LEAVES);

        this.registerBlockItemModel(generator, DesolationBlocks.CHARRED_BRANCHES);

        // Misc. blocks
        generator.registerSimpleCubeAll(DesolationBlocks.ACTIVATED_CHARCOAL_BLOCK);
        generator.registerSingleton(DesolationBlocks.ASH_BRAMBLE, TexturedModel.LEAVES);
        generator.registerSimpleCubeAll(DesolationBlocks.COOLED_EMBER_BLOCK);
        generator.registerSimpleCubeAll(DesolationBlocks.EMBER_BLOCK);

        // BlockStateModelGenerator.registerSnows() equivalent  (Ash is a snow-like layered powder block)
        // We have to make models inheriting from vanilla's hand-rolled snow models...
        TextureMap ashTexture = TextureMap.all(DesolationBlocks.ASH_BLOCK);
        Identifier ashModelId = Models.CUBE_ALL.upload(DesolationBlocks.ASH_BLOCK, ashTexture, generator.modelCollector);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(DesolationBlocks.ASH_LAYER_BLOCK).coordinate(
                BlockStateVariantMap.create(Properties.LAYERS).register(height -> BlockStateVariant.create()
                        .put(VariantSettings.MODEL,
                                height < 8 ?
                                        new Model(Optional.of(ModelIds.getBlockSubModelId(Blocks.SNOW, "_height" + height * 2)),
                                                Optional.empty(), TextureKey.PARTICLE, TextureKey.TEXTURE)
                                                .upload(ModelIds.getBlockSubModelId(DesolationBlocks.ASH_LAYER_BLOCK, "_height" + height * 2),
                                                        ashTexture, generator.modelCollector) :
                                        ashModelId))));
        generator.registerParentedItemModel(DesolationBlocks.ASH_LAYER_BLOCK, ModelIds.getBlockSubModelId(DesolationBlocks.ASH_LAYER_BLOCK, "_height2"));
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(DesolationBlocks.ASH_BLOCK, ashModelId));
        this.registerBlockItemModel(generator, DesolationBlocks.ASH_BLOCK);

        // Charred Soil is randomly selected from two different textures
        TextureMap charredSoilVariant1Texture = TextureMap.of(TextureKey.ALL, TextureMap.getSubId(DesolationBlocks.CHARRED_SOIL, "_var1"));
        TextureMap charredSoilVariant2Texture = TextureMap.of(TextureKey.ALL, TextureMap.getSubId(DesolationBlocks.CHARRED_SOIL, "_var2"));
        Identifier charredSoilVariant1 = Models.CUBE_ALL.upload(ModelIds.getBlockSubModelId(DesolationBlocks.CHARRED_SOIL, "_var1"), charredSoilVariant1Texture, generator.modelCollector);
        Identifier charredSoilVariant2 = Models.CUBE_ALL.upload(ModelIds.getBlockSubModelId(DesolationBlocks.CHARRED_SOIL, "_var2"), charredSoilVariant2Texture, generator.modelCollector);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(DesolationBlocks.CHARRED_SOIL,
                BlockStateVariant.create().put(VariantSettings.MODEL, charredSoilVariant1),
                BlockStateVariant.create().put(VariantSettings.MODEL, charredSoilVariant2)
        ));
        generator.registerItemModel(DesolationItems.CHARRED_SOIL,
                ModelIds.getBlockSubModelId(DesolationBlocks.CHARRED_SOIL, "_var1"));

        // Adapted copy of BlockStateModelGenerator.registerSweetBerryBush for Cinder Fruit
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(DesolationBlocks.CINDERFRUIT_PLANT)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_1).register(stage -> BlockStateVariant.create()
                        .put(VariantSettings.MODEL, generator.createSubModel(DesolationBlocks.CINDERFRUIT_PLANT,
                                "_age" + stage, Models.CROSS, TextureMap::cross)))));

        // Scorched Tuft is an untinted cross randomly selected from three different size models
        TextureMap tuftSmallTexture = TextureMap.of(TextureKey.CROSS, TextureMap.getId(DesolationBlocks.SCORCHED_TUFT));
        TextureMap tuftMediumTexture = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(DesolationBlocks.SCORCHED_TUFT, "_medium"));
        TextureMap tuftLargeTexture = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(DesolationBlocks.SCORCHED_TUFT, "_large"));
        Identifier tuftSmallModel = Models.TINTED_CROSS.upload(ModelIds.getBlockModelId(DesolationBlocks.SCORCHED_TUFT), tuftSmallTexture, generator.modelCollector);
        Identifier tuftMediumModel = Models.TINTED_CROSS.upload(ModelIds.getBlockSubModelId(DesolationBlocks.SCORCHED_TUFT, "_medium"), tuftMediumTexture, generator.modelCollector);
        Identifier tuftLargeModel = Models.TINTED_CROSS.upload(ModelIds.getBlockSubModelId(DesolationBlocks.SCORCHED_TUFT, "_large"), tuftLargeTexture, generator.modelCollector);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(DesolationBlocks.SCORCHED_TUFT,
                BlockStateVariant.create().put(VariantSettings.MODEL, tuftSmallModel),
                BlockStateVariant.create().put(VariantSettings.MODEL, tuftMediumModel),
                BlockStateVariant.create().put(VariantSettings.MODEL, tuftLargeModel)
        ));
        this.registerBlockItemModel(generator, DesolationBlocks.SCORCHED_TUFT);

        // Item models missed by vanilla code
        this.registerBlockItemModel(generator, DesolationBlocks.CHARRED_FENCE_GATE);
        this.registerBlockItemModel(generator, DesolationBlocks.CHARRED_LOG);
        this.registerBlockItemModel(generator, DesolationBlocks.CHARRED_PLANKS);
        this.registerBlockItemModel(generator, DesolationBlocks.CHARRED_PRESSURE_PLATE);
        this.registerBlockItemModel(generator, DesolationBlocks.CHARRED_WOOD);
        this.registerBlockItemModel(generator, DesolationBlocks.STRIPPED_CHARRED_LOG);
        this.registerBlockItemModel(generator, DesolationBlocks.STRIPPED_CHARRED_WOOD);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        // Charred wood type
        generator.register(DesolationBoats.CHARRED_BOAT, Models.GENERATED);
        generator.register(DesolationBoats.CHARRED_CHEST_BOAT, Models.GENERATED);

        // Spawn eggs
        generator.registerSpawnEgg(DesolationItems.SPAWN_EGG_ASH_SCUTTLER, 0x111111, 0xff7b00);
        generator.registerSpawnEgg(DesolationItems.SPAWN_EGG_BLACKENED, 0x0a0a0a, 0xcf4b00);

        // Misc.
        generator.register(DesolationItems.ACTIVATED_CHARCOAL, Models.GENERATED);
        generator.register(DesolationItems.AIR_FILTER, Models.GENERATED);
        generator.register(DesolationItems.ASH_PILE, Models.GENERATED);
        generator.register(DesolationItems.CHARCOAL_BIT, Models.GENERATED);
        generator.register(DesolationItems.CINDERFRUIT, Models.GENERATED);
        generator.register(DesolationItems.CINDERFRUIT_SEEDS, Models.GENERATED);
        generator.register(DesolationItems.GOGGLES, Models.GENERATED);
        generator.register(DesolationItems.HEART_OF_CINDER, Models.GENERATED);
        generator.register(DesolationItems.MUSIC_DISC_ASHES, Models.GENERATED);
        generator.register(DesolationItems.INFUSED_POWDER, Models.GENERATED);
        generator.register(DesolationItems.MASK, Models.GENERATED);
        generator.register(DesolationItems.PRIMED_ASH, Models.GENERATED);
    }


    /*
     * Shorthand for registering just the item model of a block item which uses its block's model.
     */
    private void registerBlockItemModel(BlockStateModelGenerator generator, Block block) {
        generator.registerParentedItemModel(block, ModelIds.getBlockModelId(block));
    }

    @Override
    public String getName() {
        return "Desolation Models";
    }
}
