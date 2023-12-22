package raltsmc.desolation.registry;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;
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

	public static TerraformSignBlock CHARRED_SIGN;
	public static TerraformWallSignBlock CHARRED_WALL_SIGN;
	public static TerraformHangingSignBlock CHARRED_HANGING_SIGN;
	public static TerraformWallHangingSignBlock CHARRED_WALL_HANGING_SIGN;

    public static Block CHARRED_SLAB;
    public static Block CHARRED_STAIRS;
    public static Block CHARRED_PRESSURE_PLATE;
    public static Block CHARRED_TRAPDOOR;
    public static Block CHARRED_FENCE;
    public static Block CHARRED_FENCE_GATE;
    public static Block CHARRED_BUTTON;
    public static Block CHARRED_DOOR;

    static void init() {
        CHARRED_SOIL = DesolationRegistries.register("charred_soil", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.GRAVEL)));
        COOLED_EMBER_BLOCK = DesolationRegistries.register("cooled_ember_block", new CooledEmberBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY).requiresTool()));
        EMBER_BLOCK = DesolationRegistries.register("ember_block", new EmberBlock(COOLED_EMBER_BLOCK, FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.ORANGE).luminance(8).requiresTool()));
        ASH_BLOCK = DesolationRegistries.register("ash_block", new AshBlock(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.GRAY).requiresTool()));
        ASH_LAYER_BLOCK = DesolationRegistries.register("ash", new AshLayerBlock(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.GRAY).strength(0.3f).requiresTool()));
        ACTIVATED_CHARCOAL_BLOCK = DesolationRegistries.register("activated_charcoal_block", new Block(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.BLACK).strength(0.5f).requiresTool()));
        SCORCHED_TUFT = DesolationRegistries.register("scorched_tuft", new ScorchedTuftBlock(FabricBlockSettings.copyOf(Blocks.SHORT_GRASS).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.CROP)));
        ASH_BRAMBLE = DesolationRegistries.register("ash_bramble", new AshBrambleBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.GRAY).strength(0.3f).sounds(BlockSoundGroup.CROP)));
        CHARRED_BRANCHES = DesolationRegistries.register("charred_branches", new CharredBranchBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.GRAY).strength(0.3f).sounds(BlockSoundGroup.VINE).allowsSpawning((state, world, pos, entityType) -> false)));
        CHARRED_LOG = DesolationRegistries.register("charred_log", new CharredLogBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.GRAY).strength(1.8f).sounds(BlockSoundGroup.BASALT)));
        CHARRED_WOOD = DesolationRegistries.register("charred_wood", new CharredLogBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.GRAY).strength(1.8f).sounds(BlockSoundGroup.BASALT)));
        STRIPPED_CHARRED_LOG = DesolationRegistries.register("stripped_charred_log", new CharredLogBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GRAY).strength(1.8f)));
        STRIPPED_CHARRED_WOOD = DesolationRegistries.register("stripped_charred_wood", new CharredLogBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY).strength(1.8f)));
        CHARRED_PLANKS = DesolationRegistries.register("charred_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.GRAY)));
        CHARRED_SAPLING = DesolationRegistries.register("charred_sapling", new CharredSaplingBlock(new SaplingGenerator("charred", Optional.empty(), Optional.of(DesolationConfiguredFeatures.TREE_CHARRED), Optional.empty()), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        POTTED_CHARRED_SAPLING = DesolationRegistries.register("potted_charred_sapling", new FlowerPotBlock(CHARRED_SAPLING, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).mapColor(MapColor.GRAY)));
        CINDERFRUIT_PLANT = DesolationRegistries.register("cinderfruit_plant", new CinderfruitPlantBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.TERRACOTTA_GRAY).strength(0.1f).luminance(10).sounds(BlockSoundGroup.CROP)));

        final Identifier CHARRED_SIGN_TEXTURE = Identifier.of(Desolation.MOD_ID, "entity/signs/charred");
        CHARRED_SIGN = DesolationRegistries.register("charred_sign", new TerraformSignBlock(CHARRED_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
        CHARRED_WALL_SIGN = DesolationRegistries.register("charred_wall_sign", new TerraformWallSignBlock(CHARRED_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).dropsLike(CHARRED_SIGN)));
        final Identifier CHARRED_HANGING_SIGN_TEXTURE = Identifier.of(Desolation.MOD_ID, "entity/signs/hanging/charred");
        final Identifier CHARRED_HANGING_SIGN_GUI_TEXTURE = Identifier.of(Desolation.MOD_ID, "textures/gui/hanging_signs/charred");
        CHARRED_HANGING_SIGN = DesolationRegistries.register("charred_hanging_sign", new TerraformHangingSignBlock(CHARRED_HANGING_SIGN_TEXTURE, CHARRED_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
        CHARRED_WALL_HANGING_SIGN = DesolationRegistries.register("charred_wall_hanging_sign", new TerraformWallHangingSignBlock(CHARRED_HANGING_SIGN_TEXTURE, CHARRED_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(CHARRED_HANGING_SIGN)));

        CHARRED_SLAB = DesolationRegistries.register("charred_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.GRAY)));
        CHARRED_STAIRS = DesolationRegistries.register("charred_stairs", new StairsBlock(CHARRED_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(CHARRED_PLANKS)));
        CHARRED_PRESSURE_PLATE = DesolationRegistries.register("charred_pressure_plate", new PressurePlateBlock(DesolationBlockSets.CHARRED, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GRAY)));
        CHARRED_TRAPDOOR = DesolationRegistries.register("charred_trapdoor", new TrapdoorBlock(DesolationBlockSets.CHARRED, FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GRAY).strength(3.0f).allowsSpawning((state, world, pos, entityType) -> false)));
        CHARRED_FENCE = DesolationRegistries.register("charred_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.GRAY)));
        CHARRED_FENCE_GATE = DesolationRegistries.register("charred_fence_gate", new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GRAY)));
        CHARRED_BUTTON = DesolationRegistries.register("charred_button", new ButtonBlock(DesolationBlockSets.CHARRED, 30, FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.GRAY)));
        CHARRED_DOOR = DesolationRegistries.register("charred_door", new DoorBlock(DesolationBlockSets.CHARRED, FabricBlockSettings.copyOf(Blocks.OAK_DOOR).mapColor(MapColor.GRAY)));
    }
}
