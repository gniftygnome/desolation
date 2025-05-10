package raltsmc.desolation.registry;

import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.item.AshItem;
import raltsmc.desolation.item.CinderHeartItem;

public final class DesolationItems {
    public static BlockItem CHARRED_SOIL;
    public static BlockItem COOLED_EMBER_BLOCK;
    public static BlockItem EMBER_BLOCK;
    public static BlockItem ASH_BLOCK;
    public static BlockItem ASH_LAYER_BLOCK;
    public static BlockItem ACTIVATED_CHARCOAL_BLOCK;
    public static BlockItem SCORCHED_TUFT;
    public static BlockItem ASH_BRAMBLE;
    public static BlockItem CHARRED_BRANCHES;
    public static BlockItem CHARRED_LOG;
    public static BlockItem CHARRED_WOOD;
    public static BlockItem STRIPPED_CHARRED_LOG;
    public static BlockItem STRIPPED_CHARRED_WOOD;
    public static BlockItem CHARRED_PLANKS;
    public static BlockItem CHARRED_SAPLING;
    public static BlockItem CINDERFRUIT_PLANT;

    public static BlockItem CHARRED_SLAB;
    public static BlockItem CHARRED_STAIRS;
    public static BlockItem CHARRED_PRESSURE_PLATE;
    public static BlockItem CHARRED_TRAPDOOR;
    public static BlockItem CHARRED_FENCE;
    public static BlockItem CHARRED_FENCE_GATE;
    public static BlockItem CHARRED_BUTTON;
    public static BlockItem CHARRED_DOOR;

    public static SignItem CHARRED_SIGN;
    public static HangingSignItem CHARRED_HANGING_SIGN;

    public static Item CHARCOAL_BIT;
    public static Item ASH_PILE;
    //public static final Item GLASS_SHARD;
    public static Item PRIMED_ASH;
    public static Item ACTIVATED_CHARCOAL;
    public static Item AIR_FILTER;
    public static Item MASK;
    public static Item GOGGLES;
    //public static final Item MASK_GOGGLES;
    public static Item CINDERFRUIT;
    public static Item CINDERFRUIT_SEEDS;
    public static Item INFUSED_POWDER;
    public static Item HEART_OF_CINDER;

    public static Item MUSIC_DISC_ASHES;

    public static Item SPAWN_EGG_ASH_SCUTTLER;
    public static Item SPAWN_EGG_BLACKENED;

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationItems() {
        return;
    }

    public static Item register(Item item, String path) {
        return Registry.register(Registries.ITEM, Identifier.of(Desolation.MOD_ID, path), item);
    }

    static void init() {
        CHARRED_SOIL = DesolationRegistries.registerBlockItem("charred_soil", DesolationBlocks.CHARRED_SOIL);
        COOLED_EMBER_BLOCK = DesolationRegistries.registerBlockItem("cooled_ember_block", DesolationBlocks.COOLED_EMBER_BLOCK);
        EMBER_BLOCK = DesolationRegistries.registerBlockItem("ember_block", DesolationBlocks.EMBER_BLOCK);
        ASH_BLOCK = DesolationRegistries.registerBlockItem("ash_block", DesolationBlocks.ASH_BLOCK);
        ASH_LAYER_BLOCK = DesolationRegistries.registerBlockItem("ash", DesolationBlocks.ASH_LAYER_BLOCK);
        ACTIVATED_CHARCOAL_BLOCK = DesolationRegistries.registerBlockItem("activated_charcoal_block", DesolationBlocks.ACTIVATED_CHARCOAL_BLOCK);
        SCORCHED_TUFT = DesolationRegistries.registerBlockItem("scorched_tuft", DesolationBlocks.SCORCHED_TUFT);
        ASH_BRAMBLE = DesolationRegistries.registerBlockItem("ash_bramble", DesolationBlocks.ASH_BRAMBLE);
        CHARRED_BRANCHES = DesolationRegistries.registerBlockItem("charred_branches", DesolationBlocks.CHARRED_BRANCHES);
        CHARRED_LOG = DesolationRegistries.registerBlockItem("charred_log", DesolationBlocks.CHARRED_LOG);
        CHARRED_WOOD = DesolationRegistries.registerBlockItem("charred_wood", DesolationBlocks.CHARRED_WOOD);
        STRIPPED_CHARRED_LOG = DesolationRegistries.registerBlockItem("stripped_charred_log", DesolationBlocks.STRIPPED_CHARRED_LOG);
        STRIPPED_CHARRED_WOOD = DesolationRegistries.registerBlockItem("stripped_charred_wood", DesolationBlocks.STRIPPED_CHARRED_WOOD);
        CHARRED_PLANKS = DesolationRegistries.registerBlockItem("charred_planks", DesolationBlocks.CHARRED_PLANKS);
        CHARRED_SAPLING = DesolationRegistries.registerBlockItem("charred_sapling", DesolationBlocks.CHARRED_SAPLING);
        CINDERFRUIT_PLANT = DesolationRegistries.registerBlockItem("cinderfruit_plant", DesolationBlocks.CINDERFRUIT_PLANT);

        CHARRED_SLAB = DesolationRegistries.registerBlockItem("charred_slab", DesolationBlocks.CHARRED_SLAB);
        CHARRED_STAIRS = DesolationRegistries.registerBlockItem("charred_stairs", DesolationBlocks.CHARRED_STAIRS);
        CHARRED_PRESSURE_PLATE = DesolationRegistries.registerBlockItem("charred_pressure_plate", DesolationBlocks.CHARRED_PRESSURE_PLATE);
        CHARRED_TRAPDOOR = DesolationRegistries.registerBlockItem("charred_trapdoor", DesolationBlocks.CHARRED_TRAPDOOR);
        CHARRED_FENCE = DesolationRegistries.registerBlockItem("charred_fence", DesolationBlocks.CHARRED_FENCE);
        CHARRED_FENCE_GATE = DesolationRegistries.registerBlockItem("charred_fence_gate", DesolationBlocks.CHARRED_FENCE_GATE);
        CHARRED_BUTTON = DesolationRegistries.registerBlockItem("charred_button", DesolationBlocks.CHARRED_BUTTON);
        CHARRED_DOOR = DesolationRegistries.registerBlockItem("charred_door", DesolationBlocks.CHARRED_DOOR);

        CHARRED_SIGN = DesolationRegistries.register("charred_sign", settings -> new SignItem(DesolationBlocks.CHARRED_SIGN, DesolationBlocks.CHARRED_WALL_SIGN, settings), new Item.Settings().maxCount(16));
        CHARRED_HANGING_SIGN = DesolationRegistries.register("charred_hanging_sign", settings -> new HangingSignItem(DesolationBlocks.CHARRED_HANGING_SIGN, DesolationBlocks.CHARRED_WALL_HANGING_SIGN, settings), new Item.Settings().maxCount(16));


        CHARCOAL_BIT = DesolationRegistries.register("charcoal_bit", Item::new, new Item.Settings());
        ASH_PILE = DesolationRegistries.register("ash_pile", AshItem::new, new Item.Settings());
        //GLASS_SHARD = DesolationRegistries.register("glass_shard", Item::new, new Item.Settings());
        PRIMED_ASH = DesolationRegistries.register("primed_ash", Item::new, new Item.Settings());
        ACTIVATED_CHARCOAL = DesolationRegistries.register("activated_charcoal", Item::new, new Item.Settings());
        AIR_FILTER = DesolationRegistries.register("air_filter", Item::new, new Item.Settings());
        MASK = DesolationRegistries.register("mask", TrinketItem::new, new Item.Settings().maxCount(1));
        GOGGLES = DesolationRegistries.register("goggles", TrinketItem::new, new Item.Settings().maxCount(1));
        //MASK_GOGGLES = DesolationRegistries.register("mask_and_goggles", Item::new, new Item.Settings().equipmentSlot(itemStack -> EquipmentSlot.HEAD).maxCount(1));
        CINDERFRUIT = DesolationRegistries.register("cinderfruit", Item::new, new Item.Settings().food(
                new FoodComponent.Builder()
                        .nutrition(5)
                        .saturationModifier(6.5F)
                        .alwaysEdible()
                        .build(),
                ConsumableComponents.food()
                        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200), 1.0F))
                        .build()
        ));
        CINDERFRUIT_SEEDS = DesolationRegistries.register("cinderfruit_seeds", settings -> new BlockItem(DesolationBlocks.CINDERFRUIT_PLANT, settings.useItemPrefixedTranslationKey()), new Item.Settings());
        INFUSED_POWDER = DesolationRegistries.register("infused_powder", Item::new, new Item.Settings());
        HEART_OF_CINDER = DesolationRegistries.register("heart_of_cinder", CinderHeartItem::new, new Item.Settings().rarity(Rarity.RARE));

        MUSIC_DISC_ASHES = DesolationRegistries.register("music_disc_ashes", Item::new, new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(DesolationJukeboxSongs.ASHES));
        SPAWN_EGG_ASH_SCUTTLER = DesolationRegistries.register("ash_scuttler_spawn_egg", settings ->
                new SpawnEggItem(DesolationEntities.ASH_SCUTTLER, 0x111111, 0xff7b00, settings), new Item.Settings());
        SPAWN_EGG_BLACKENED = DesolationRegistries.register("blackened_spawn_egg", settings ->
                new SpawnEggItem(DesolationEntities.BLACKENED, 0x0a0a0a, 0xcf4b00, settings), new Item.Settings());


        addCompostables();
        addFuels();
    }

    private static void addCompostables() {
        CompostingChanceRegistry compostingRegistry = CompostingChanceRegistry.INSTANCE;
        float LEAVES_CHANCE = compostingRegistry.get(Items.OAK_LEAVES);
        float SAPLING_CHANCE = compostingRegistry.get(Items.OAK_SAPLING);

        compostingRegistry.add(CHARRED_BRANCHES, LEAVES_CHANCE);
        compostingRegistry.add(CHARRED_SAPLING, SAPLING_CHANCE);
    }

    private static void addFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(DesolationItems.CHARCOAL_BIT, 400);
        });
    }
}
