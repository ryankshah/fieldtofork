package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.datacomponent.WateringCanFillLevelDataComponent;
import com.ryankshah.fieldtofork.item.Scythe;
import com.ryankshah.fieldtofork.item.WateringCan;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

/**
 * TODO:
 * Add: Yeast, Wort (for beer), Hops (for beer), Beer
 * Add: Mixin for Goat entity to get goat milk by using a bucket on it
 * Add:
 * - Cabbage + Cabbage Crop
 * - Butter (Churn recipe)
 * - Garlic Butter
 * - Garlic Bread
 * - Apple Cabbage Stew
 * - Apple Dumpling
 * - Apple Pie
 * - Beef Stew
 * - Cabbage Soup
 * - Cabbage & Potato Soup
 * - Goat Cheese
 * - Slice of Goat Cheese
 */
public class ItemRegistry
{
    public static void init() {}

    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MOD_ID);

    //Fruits
    public static final Supplier<Item> BANANAS = registerItem("bananas", () -> new Item(new Item.Properties()));//.food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.4F).build())));
    public static final Supplier<Item> BANANA_SINGLE = registerItem("banana_single", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.4F).build())));
    public static final Supplier<Item> BANANA_TREE_SEEDS = registerItem("banana_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.BANANA_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> DRAGONFRUIT = registerItem("dragonfruit", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> DRAGONFRUIT_TREE_SEEDS = registerItem("dragonfruit_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.DRAGONFRUIT_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> COCONUT = registerItem("coconut", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> COCONUT_OPEN = registerItem("coconut_open", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> EGGPLANT = registerItem("eggplant", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> GRAPE_SEEDS = registerItem("grape_seeds", () -> new ItemNameBlockItem(BlockRegistry.GRAPE_CROP.get(), new Item.Properties())); //new Item(new Item.Properties()));
    public static final Supplier<Item> GREEN_GRAPES = registerItem("green_grapes", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> PURPLE_GRAPES = registerItem("purple_grapes", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> EGGPLANT_SEEDS = registerItem("eggplant_seeds", () -> new ItemNameBlockItem(BlockRegistry.EGGPLANT_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_BANANAS = registerItem("green_bananas", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8F).build())));
    public static final Supplier<Item> LYCHEE = registerItem("lychee", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).build())));
    public static final Supplier<Item> LYCHEE_TREE_SEED = registerItem("lychee_tree_seed", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.LYCHEE_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> MANGO = registerItem("mango", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(1.6F).build())));
    public static final Supplier<Item> MANGO_TREE_SEED = registerItem("mango_tree_seed", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.MANGO_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> ORANGE = registerItem("orange", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(1.4F).build())));
    public static final Supplier<Item> ORANGE_TREE_SEEDS = registerItem("orange_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.ORANGE_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> PASSIONFRUIT = registerItem("passionfruit", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.9F).build())));
    public static final Supplier<Item> PASSIONFRUIT_SEEDS = registerItem("passionfruit_seeds", () -> new ItemNameBlockItem(BlockRegistry.PASSIONFRUIT_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> PEAR = registerItem("pear", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> PEAR_TREE_SEEDS = registerItem("pear_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.PEAR_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> POMEGRANATE = registerItem("pomegranate", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> POMEGRANATE_TREE_SEEDS = registerItem("pomegranate_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.POMEGRANATE_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> RED_PEPPER = registerItem("red_pepper", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> BELL_PEPPER_SEEDS = registerItem("bell_pepper_seeds", () -> new ItemNameBlockItem(BlockRegistry.BELL_PEPPER_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_PEPPER = registerItem("yellow_pepper", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> TOMATO_SEEDS = registerItem("tomato_seeds", () -> new ItemNameBlockItem(BlockRegistry.TOMATO_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> TOMATO = registerItem("tomato", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.9F).build())));
    public static final Supplier<Item> STRAWBERRY_SEEDS = registerItem("strawberry_seeds", () -> new ItemNameBlockItem(BlockRegistry.STRAWBERRY_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> STRAWBERRY = registerItem("strawberry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.9F).build())));
    public static final Supplier<Item> MULBERRY = registerItem("mulberry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.9F).build())));

    //Vegetables
    public static final Supplier<Item> ASPARAGUS = registerItem("asparagus", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.1F).build())));
    public static final Supplier<Item> ASPARAGUS_CROWNS = registerItem("asparagus_crowns", () -> new ItemNameBlockItem(BlockRegistry.ASPARAGUS_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> CHILLI = registerItem("chilli", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(1.2F).build())));
    public static final Supplier<Item> CHILLI_SEEDS = registerItem("chilli_seeds", () -> new ItemNameBlockItem(BlockRegistry.CHILLI_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> LEEK = registerItem("leek", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).build())));
    public static final Supplier<Item> LEEK_SEEDS = registerItem("leek_seeds", () -> new ItemNameBlockItem(BlockRegistry.LEEK_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> RADISH = registerItem("radish", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8F).build())));
    public static final Supplier<Item> RADISH_SEEDS = registerItem("radish_seeds", () -> new ItemNameBlockItem(BlockRegistry.RADISH_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> SWEET_POTATO = registerItem("sweet_potato", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.4F).build())));
    public static final Supplier<Item> SWEET_POTATO_SLIPS = registerItem("sweet_potato_slips", () -> new ItemNameBlockItem(BlockRegistry.SWEET_POTATO_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> ZUCCHINI = registerItem("zucchini", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.3F).build())));
    public static final Supplier<Item> ZUCCHINI_SEEDS = registerItem("zucchini_seeds", () -> new ItemNameBlockItem(BlockRegistry.ZUCCHINI_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> GARLIC = registerItem("garlic", () -> new ItemNameBlockItem(BlockRegistry.GARLIC_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> GINGER = registerItem("ginger", () -> new ItemNameBlockItem(BlockRegistry.GINGER_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> GINGER_ROOT_SLIP = registerItem("ginger_root_slip", () -> new ItemNameBlockItem(BlockRegistry.GINGER_CROP.get(), new Item.Properties()));

    //Tools
    public static final Supplier<Scythe> STONE_SCYTHE = registerItem("stone_scythe", () -> new Scythe(Tiers.STONE, new Item.Properties()));
    public static final Supplier<Scythe> IRON_SCYTHE = registerItem("iron_scythe", () -> new Scythe(Tiers.IRON, new Item.Properties()));
    public static final Supplier<Scythe> GOLD_SCYTHE = registerItem("gold_scythe", () -> new Scythe(Tiers.GOLD, new Item.Properties()));
    public static final Supplier<Scythe> DIAMOND_SCYTHE = registerItem("diamond_scythe", () -> new Scythe(Tiers.DIAMOND, new Item.Properties()));
    public static final Supplier<Scythe> NETHERITE_SCYTHE = registerItem("netherite_scythe", () -> new Scythe(Tiers.NETHERITE, new Item.Properties()));
    public static final Supplier<WateringCan> WATERING_CAN = registerItem("watering_can", () -> new WateringCan(new Item.Properties().stacksTo(1).component(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get(), new WateringCanFillLevelDataComponent(0, 8))));
    public static final Supplier<SwordItem> PITCHFORK = registerItem("pitchfork", () -> new SwordItem(Tiers.IRON, new Item.Properties()));

    // Animal Products
    public static final Supplier<Item> GOAT_MILK_BUCKET = registerItem("goat_milk_bucket", () -> new MilkBucketItem((new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Supplier<Item> GOAT_LEG = registerItem("goat_leg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.1F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F).build())));
    public static final Supplier<Item> ROAST_GOAT_LEG = registerItem("roast_goat_leg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final Supplier<Item> HORSE_MEAT = registerItem("horse_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.1F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F).build())));
    public static final Supplier<Item> HORSE_HAUNCH = registerItem("horse_haunch", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build())));
    public static final Supplier<Item> SALMON_ROE = registerItem("salmon_roe", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).build())));
    public static final Supplier<Item> SILKWORM_EGGS = registerItem("silkworm_eggs", () -> new Item(new Item.Properties()));

    // Foods
    public static final Supplier<Item> FLOUR = registerItem("flour", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> SALT = registerItem("salt", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BUTTER = registerItem("butter", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> UNWOVEN_SILK = registerItem("unwoven_silk", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DURUM_WHEAT_SEEDS = registerItem("durum_wheat_seeds", () -> new ItemNameBlockItem(BlockRegistry.DURUM_WHEAT_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> DURUM_WHEAT = registerItem("durum_wheat", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DURUM_WHEAT_FLOUR = registerItem("durum_wheat_flour", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> TOMATO_SOUP = registerItem("tomato_soup", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).usingConvertsTo(Items.BOWL).build())));
    public static final Supplier<Item> VEGETABLE_SOUP = registerItem("vegetable_soup", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).usingConvertsTo(Items.BOWL).build())));


//    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
//        return FieldToForkCommon.COMMON_PLATFORM.registerItem(id, item);
//    }

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return ITEMS.register(id, item);
    }

    public static final Supplier<CreativeModeTab> FRUITS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_fruits", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".fruits"))
            .icon(() -> new ItemStack(ItemRegistry.BANANAS.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.BANANAS.get());
                entries.accept(ItemRegistry.BANANA_SINGLE.get());
                entries.accept(ItemRegistry.GREEN_BANANAS.get());
                entries.accept(ItemRegistry.COCONUT.get());
                entries.accept(ItemRegistry.COCONUT_OPEN.get());
                entries.accept(ItemRegistry.DRAGONFRUIT.get());
                entries.accept(ItemRegistry.EGGPLANT.get());
                entries.accept(ItemRegistry.GREEN_GRAPES.get());
                entries.accept(ItemRegistry.PURPLE_GRAPES.get());
                entries.accept(ItemRegistry.LYCHEE.get());
                entries.accept(ItemRegistry.MANGO.get());
                entries.accept(ItemRegistry.ORANGE.get());
                entries.accept(ItemRegistry.PASSIONFRUIT.get());
                entries.accept(ItemRegistry.PEAR.get());
                entries.accept(ItemRegistry.POMEGRANATE.get());
                entries.accept(ItemRegistry.RED_PEPPER.get());
                entries.accept(ItemRegistry.YELLOW_PEPPER.get());
                entries.accept(ItemRegistry.TOMATO.get());
                entries.accept(ItemRegistry.STRAWBERRY.get());
            })
            .build());

    public static final Supplier<CreativeModeTab> VEGETABLES_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_vegetables", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".vegetables"))
            .icon(() -> new ItemStack(ItemRegistry.RADISH.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.ASPARAGUS.get());
                entries.accept(ItemRegistry.CHILLI.get());
                entries.accept(ItemRegistry.LEEK.get());
                entries.accept(ItemRegistry.RADISH.get());
                entries.accept(ItemRegistry.SWEET_POTATO.get());
                entries.accept(ItemRegistry.ZUCCHINI.get());
                entries.accept(ItemRegistry.GARLIC.get());
                entries.accept(ItemRegistry.GINGER.get());
            })
            .build());

    public static final Supplier<CreativeModeTab> SEEDS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_seeds", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".seeds"))
            .icon(() -> new ItemStack(ItemRegistry.ORANGE_TREE_SEEDS.get()))
            .displayItems((enabledFeatures, entries) -> {
                // TODO: put saplings here instead
//                entries.accept(ItemRegistry.BANANA_TREE_SEEDS.get());
//                entries.accept(ItemRegistry.DRAGONFRUIT_TREE_SEEDS.get());
                entries.accept(ItemRegistry.EGGPLANT_SEEDS.get());
                entries.accept(ItemRegistry.GRAPE_SEEDS.get());
//                entries.accept(ItemRegistry.LYCHEE_TREE_SEED.get());
//                entries.accept(ItemRegistry.MANGO_TREE_SEED.get());
//                entries.accept(ItemRegistry.ORANGE_TREE_SEEDS.get());
                entries.accept(ItemRegistry.PASSIONFRUIT_SEEDS.get());
//                entries.accept(ItemRegistry.PEAR_TREE_SEEDS.get());
//                entries.accept(ItemRegistry.POMEGRANATE_TREE_SEEDS.get());
                entries.accept(ItemRegistry.BELL_PEPPER_SEEDS.get());
                entries.accept(ItemRegistry.ASPARAGUS_CROWNS.get());
                entries.accept(ItemRegistry.CHILLI_SEEDS.get());
                entries.accept(ItemRegistry.LEEK_SEEDS.get());
                entries.accept(ItemRegistry.RADISH_SEEDS.get());
                entries.accept(ItemRegistry.SWEET_POTATO_SLIPS.get());
                entries.accept(ItemRegistry.ZUCCHINI_SEEDS.get());
                entries.accept(ItemRegistry.TOMATO_SEEDS.get());
                entries.accept(ItemRegistry.STRAWBERRY_SEEDS.get());
                entries.accept(ItemRegistry.DURUM_WHEAT_SEEDS.get());
                entries.accept(ItemRegistry.GINGER_ROOT_SLIP.get());
            })
            .build());

    public static final Supplier<CreativeModeTab> MEATS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_meats", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".meats"))
            .icon(() -> new ItemStack(ItemRegistry.GOAT_LEG.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.GOAT_LEG.get());
                entries.accept(ItemRegistry.ROAST_GOAT_LEG.get());
                entries.accept(ItemRegistry.HORSE_MEAT.get());
                entries.accept(ItemRegistry.HORSE_HAUNCH.get());
                entries.accept(ItemRegistry.SALMON_ROE.get());
                entries.accept(ItemRegistry.GOAT_MILK_BUCKET.get());
                entries.accept(ItemRegistry.SILKWORM_EGGS.get());
            })
            .build());

    public static final Supplier<CreativeModeTab> FOODS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_foods", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".foods"))
            .icon(() -> new ItemStack(ItemRegistry.TOMATO_SOUP.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.FLOUR.get());
                entries.accept(ItemRegistry.SALT.get());
                entries.accept(ItemRegistry.BUTTER.get());
                entries.accept(ItemRegistry.TOMATO_SOUP.get());
                entries.accept(ItemRegistry.VEGETABLE_SOUP.get());
                entries.accept(ItemRegistry.DURUM_WHEAT.get());
                entries.accept(ItemRegistry.DURUM_WHEAT_FLOUR.get());
            })
            .build());

    public static final Supplier<CreativeModeTab> TOOLS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_tools", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".tools"))
            .icon(() -> new ItemStack(ItemRegistry.NETHERITE_SCYTHE.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.STONE_SCYTHE.get());
                entries.accept(ItemRegistry.IRON_SCYTHE.get());
                entries.accept(ItemRegistry.GOLD_SCYTHE.get());
                entries.accept(ItemRegistry.DIAMOND_SCYTHE.get());
                entries.accept(ItemRegistry.NETHERITE_SCYTHE.get());
                entries.accept(ItemRegistry.WATERING_CAN.get());
                entries.accept(ItemRegistry.PITCHFORK.get());
                entries.accept(ItemRegistry.UNWOVEN_SILK.get());
            }).build());
}
