package raltsmc.desolation.registry;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import raltsmc.desolation.block.*;
import raltsmc.desolation.world.feature.DesolationConfiguredFeatures;

import java.util.Optional;

public final class DesolationBlocks {
    public static Block CHARRED_SOIL;
    public static Block COOLED_EMBER_BLOCK;
    public static Block EMBER_BLOCK;
    public static Block ASH_BLOCK;
    public static Block ASH_LAYER_BLOCK;
    public static Block ACTIVATED_CHARCOAL_BLOCK;
    public static Block SCORCHED_TUFT;
    public static Block ASH_BRAMBLE;
    public static Block CHARRED_BRANCHES;
    public static Block CHARRED_LOG;
    public static Block CHARRED_WOOD;
    public static Block STRIPPED_CHARRED_LOG;
    public static Block STRIPPED_CHARRED_WOOD;
    public static Block CHARRED_PLANKS;
    public static Block CHARRED_SAPLING;
    public static Block POTTED_CHARRED_SAPLING;
    public static Block CINDERFRUIT_PLANT;

	public static SignBlock CHARRED_SIGN;
	public static WallSignBlock CHARRED_WALL_SIGN;
	public static HangingSignBlock CHARRED_HANGING_SIGN;
	public static WallHangingSignBlock CHARRED_WALL_HANGING_SIGN;

    public static Block CHARRED_SLAB;
    public static Block CHARRED_STAIRS;
    public static Block CHARRED_PRESSURE_PLATE;
    public static Block CHARRED_TRAPDOOR;
    public static Block CHARRED_FENCE;
    public static Block CHARRED_FENCE_GATE;
    public static Block CHARRED_BUTTON;
    public static Block CHARRED_DOOR;

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationBlocks() {
        return;
    }

    static void init() {
        CHARRED_SOIL = DesolationRegistries.register("charred_soil", Block::new, AbstractBlock.Settings.copy(Blocks.DIRT).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.GRAVEL));
        COOLED_EMBER_BLOCK = DesolationRegistries.register("cooled_ember_block", CooledEmberBlock::new, AbstractBlock.Settings.copy(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY).requiresTool());
        EMBER_BLOCK = DesolationRegistries.register("ember_block", settings -> new EmberBlock(COOLED_EMBER_BLOCK, settings), AbstractBlock.Settings.copy(Blocks.STONE).mapColor(MapColor.ORANGE).luminance(state -> 8).requiresTool());
        ASH_BLOCK = DesolationRegistries.register("ash_block", AshBlock::new, AbstractBlock.Settings.copy(Blocks.SAND).mapColor(MapColor.GRAY).requiresTool());
        ASH_LAYER_BLOCK = DesolationRegistries.register("ash", AshLayerBlock::new, AbstractBlock.Settings.copy(Blocks.SAND).mapColor(MapColor.GRAY).strength(0.3f).requiresTool());
        ACTIVATED_CHARCOAL_BLOCK = DesolationRegistries.register("activated_charcoal_block", Block::new, AbstractBlock.Settings.copy(Blocks.BASALT).mapColor(MapColor.BLACK).strength(0.5f).requiresTool());
        SCORCHED_TUFT = DesolationRegistries.register("scorched_tuft", ScorchedTuftBlock::new, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.CROP));
        ASH_BRAMBLE = DesolationRegistries.register("ash_bramble", AshBrambleBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.GRAY).strength(0.3f).sounds(BlockSoundGroup.CROP));
        CHARRED_BRANCHES = DesolationRegistries.register("charred_branches", CharredBranchBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.GRAY).strength(0.3f).sounds(BlockSoundGroup.VINE).allowsSpawning((state, world, pos, entityType) -> false));
        CHARRED_LOG = DesolationRegistries.register("charred_log", CharredLogBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(MapColor.GRAY).strength(1.8f).sounds(BlockSoundGroup.BASALT));
        CHARRED_WOOD = DesolationRegistries.register("charred_wood", CharredLogBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GRAY).strength(1.8f).sounds(BlockSoundGroup.BASALT));
        STRIPPED_CHARRED_LOG = DesolationRegistries.register("stripped_charred_log", CharredLogBlock::new, AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GRAY).strength(1.8f));
        STRIPPED_CHARRED_WOOD = DesolationRegistries.register("stripped_charred_wood", CharredLogBlock::new, AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY).strength(1.8f));
        CHARRED_PLANKS = DesolationRegistries.register("charred_planks", Block::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GRAY));
        CHARRED_SAPLING = DesolationRegistries.register("charred_sapling", settings -> new CharredSaplingBlock(new SaplingGenerator("charred", Optional.empty(), Optional.of(DesolationConfiguredFeatures.TREE_CHARRED), Optional.empty()), settings), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));
        POTTED_CHARRED_SAPLING = DesolationRegistries.register("potted_charred_sapling", settings -> new FlowerPotBlock(CHARRED_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.GRAY));
        CINDERFRUIT_PLANT = DesolationRegistries.register("cinderfruit_plant", CinderfruitPlantBlock::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.TERRACOTTA_GRAY).strength(0.1f).luminance(state -> 10).sounds(BlockSoundGroup.CROP));

        CHARRED_SIGN = DesolationRegistries.registerSignBlock("charred_sign", settings -> new SignBlock(DesolationWoodTypes.CHARRED, settings), AbstractBlock.Settings.copy(Blocks.OAK_SIGN));
        CHARRED_WALL_SIGN = DesolationRegistries.registerSignBlock("charred_wall_sign", settings -> new WallSignBlock(DesolationWoodTypes.CHARRED, settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).lootTable(CHARRED_SIGN.getLootTableKey()));
        CHARRED_HANGING_SIGN = DesolationRegistries.registerSignBlock("charred_hanging_sign", settings -> new HangingSignBlock(DesolationWoodTypes.CHARRED, settings), AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN));
        CHARRED_WALL_HANGING_SIGN = DesolationRegistries.registerSignBlock("charred_wall_hanging_sign", settings -> new WallHangingSignBlock(DesolationWoodTypes.CHARRED, settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).lootTable(CHARRED_HANGING_SIGN.getLootTableKey()));

        CHARRED_SLAB = DesolationRegistries.register("charred_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.GRAY));
        CHARRED_STAIRS = DesolationRegistries.register("charred_stairs", settings -> new StairsBlock(CHARRED_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.copy(CHARRED_PLANKS));
        CHARRED_PRESSURE_PLATE = DesolationRegistries.register("charred_pressure_plate", settings -> new PressurePlateBlock(DesolationBlockSetTypes.CHARRED, settings), AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GRAY));
        CHARRED_TRAPDOOR = DesolationRegistries.register("charred_trapdoor", settings -> new TrapdoorBlock(DesolationBlockSetTypes.CHARRED, settings), AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GRAY).strength(3.0f).allowsSpawning((state, world, pos, entityType) -> false));
        CHARRED_FENCE = DesolationRegistries.register("charred_fence", FenceBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GRAY));
        CHARRED_FENCE_GATE = DesolationRegistries.register("charred_fence_gate", settings -> new FenceGateBlock(DesolationWoodTypes.CHARRED, settings), AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GRAY));
        CHARRED_BUTTON = DesolationRegistries.register("charred_button", settings -> new ButtonBlock(DesolationBlockSetTypes.CHARRED, 30, settings), AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GRAY));
        CHARRED_DOOR = DesolationRegistries.register("charred_door", settings -> new DoorBlock(DesolationBlockSetTypes.CHARRED, settings), AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.GRAY));

        addFlammables();
        addStrippables();
    }

    private static void addFlammables() {
        FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();

        // TODO: Need to ponder this some more...
        //flammableRegistry.add(CHARRED_BRANCHES, 30, 60);
    }

    private static void addStrippables() {
        StrippableBlockRegistry.register(CHARRED_LOG, STRIPPED_CHARRED_LOG);
        StrippableBlockRegistry.register(CHARRED_WOOD, STRIPPED_CHARRED_WOOD);
    }
}
