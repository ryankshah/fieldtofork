package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public class ItemRegistry
{
    public static void init() {}

//    public static final Supplier<BlockItem> PINEAPPLE_BLOCK = registerItem("pineapple_block", () -> new BlockItem(BlockRegistry.PINEAPPLE_BLOCK.get(), new Item.Properties()));

//    public static final Supplier<Item> PINEAPPLE = registerItem("pineapple", () -> new Item(new Item.Properties()));
//    public static final Supplier<Item> PINEAPPLE_SEEDS = registerItem("pineapple_seeds", () -> new ItemNameBlockItem(BlockRegistry.PINEAPPLE_BLOCK.get(), new Item.Properties()));
//    public static final Supplier<Item> PINEAPPLE_TOP = registerItem("pineapple_top", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.6F).build())));
//    public static final Supplier<Item> PINEAPPLE_BOTTOM = registerItem("pineapple_bottom", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.6F).build())));
//    public static final Supplier<Item> PINEAPPLE_CHUNKS = registerItem("pineapple_chunks", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.6F).build())));
//    public static final Supplier<Item> PINEAPPLE_SLICE = registerItem("pineapple_slice", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.6F).build())));
//    public static final Supplier<Item> PINEAPPLE_JUICE = registerItem("pineapple_juice", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).build())));
//    public static final Supplier<Item> GOLDEN_PINEAPPLE = registerItem("golden_pineapple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.8F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEdible().build())));


    //Fruits
    public static final Supplier<Item> BANANA = registerItem("banana", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.4F).build())));
    public static final Supplier<Item> BANANA_TREE_SEEDS = registerItem("banana_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.BANANA_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> DRAGONFRUIT = registerItem("dragonfruit", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> DRAGONFRUIT_TREE_SEEDS = registerItem("dragonfruit_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.DRAGONFRUIT_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> EGGPLANT = registerItem("eggplant", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> EGGPLANT_SEEDS = registerItem("eggplant_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.EGGPLANT_BUSH, new Item.Properties()));
    public static final Supplier<Item> GREEN_BANANA = registerItem("green_banana", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.8F).build())));
    public static final Supplier<Item> LYCHEE = registerItem("lychee", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).build())));
    public static final Supplier<Item> LYCHEE_TREE_SEED = registerItem("lychee_tree_seed", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.LYCHEE_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> MANGO = registerItem("mango", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(1.6F).build())));
    public static final Supplier<Item> MANGO_TREE_SEED = registerItem("mango_tree_seed", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.MANGO_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> ORANGE = registerItem("orange", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(1.4F).build())));
    public static final Supplier<Item> ORANGE_TREE_SEEDS = registerItem("orange_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.ORANGE_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> PASSIONFRUIT = registerItem("passionfruit", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.9F).build())));
    public static final Supplier<Item> PASSIONFRUIT_SEEDS = registerItem("passionfruit_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.PASSIONFRUIT_VINE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> PEAR = registerItem("pear", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> PEAR_TREE_SEEDS = registerItem("pear_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.PEAR_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> POMEGRANATE = registerItem("pomegranate", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> POMEGRANATE_TREE_SEEDS = registerItem("pomegranate_tree_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.POMEGRANATE_TREE_BLOCK, new Item.Properties()));
    public static final Supplier<Item> RED_PEPPER = registerItem("red_pepper", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));
    public static final Supplier<Item> BELL_PEPPER_SEEDS = registerItem("bell_pepper_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.BELL_PEPPER_BLOCK, new Item.Properties()));
    public static final Supplier<Item> YELLOW_PEPPER = registerItem("yellow_pepper", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F).build())));

    //Vegetables
    public static final Supplier<Item> ASPARAGUS = registerItem("asparagus", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.1F).build())));
    public static final Supplier<Item> ASPARAGUS_CROWNS = registerItem("asparagus_crowns", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.ASPARAGUS_BLOCK, new Item.Properties()));
    public static final Supplier<Item> CHILLI = registerItem("chilli", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(1.2F).build())));
    public static final Supplier<Item> CHILLI_SEEDS = registerItem("chilli_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.CHILLI_BLOCK, new Item.Properties()));
    public static final Supplier<Item> LEEK = registerItem("leek", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).build())));
    public static final Supplier<Item> LEEK_SEEDS = registerItem("leek_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.LEEK_BLOCK, new Item.Properties()));
    public static final Supplier<Item> RADISH = registerItem("radish", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.8F).build())));
    public static final Supplier<Item> RADISH_SEEDS = registerItem("radish_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.RADISH_BLOCK, new Item.Properties()));
    public static final Supplier<Item> SWEET_POTATO = registerItem("sweet_potato", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.4F).build())));
    public static final Supplier<Item> SWEET_POTATO_SLIPS = registerItem("sweet_potato_slips", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.SWEET_POTATO_BLOCK, new Item.Properties()));
    public static final Supplier<Item> ZUCCHINI = registerItem("zucchini", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.3F).build())));
    public static final Supplier<Item> ZUCCHINI_SEEDS = registerItem("zucchini_seeds", () -> new Item(new Item.Properties())); // () -> new ItemNameBlockItem(BlockRegistry.ZUCCHINI_BLOCK, new Item.Properties()));

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return FieldToForkCommon.COMMON_PLATFORM.registerItem(id, item);
    }

    public static final Supplier<CreativeModeTab> FRUITS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_fruits", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".fruits"))
            .icon(() -> new ItemStack(ItemRegistry.BANANA.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.BANANA.get());
                entries.accept(ItemRegistry.DRAGONFRUIT.get());
                entries.accept(ItemRegistry.EGGPLANT.get());
                entries.accept(ItemRegistry.GREEN_BANANA.get());
                entries.accept(ItemRegistry.LYCHEE.get());
                entries.accept(ItemRegistry.MANGO.get());
                entries.accept(ItemRegistry.ORANGE.get());
                entries.accept(ItemRegistry.PASSIONFRUIT.get());
                entries.accept(ItemRegistry.PEAR.get());
                entries.accept(ItemRegistry.POMEGRANATE.get());
                entries.accept(ItemRegistry.RED_PEPPER.get());
                entries.accept(ItemRegistry.YELLOW_PEPPER.get());
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
            })
            .build());

    public static final Supplier<CreativeModeTab> SEEDS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_seeds", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".fruits"))
            .icon(() -> new ItemStack(ItemRegistry.ORANGE_TREE_SEEDS.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.BANANA_TREE_SEEDS.get());
                entries.accept(ItemRegistry.DRAGONFRUIT_TREE_SEEDS.get());
                entries.accept(ItemRegistry.EGGPLANT_SEEDS.get());
                entries.accept(ItemRegistry.LYCHEE_TREE_SEED.get());
                entries.accept(ItemRegistry.MANGO_TREE_SEED.get());
                entries.accept(ItemRegistry.ORANGE_TREE_SEEDS.get());
                entries.accept(ItemRegistry.PASSIONFRUIT_SEEDS.get());
                entries.accept(ItemRegistry.PEAR_TREE_SEEDS.get());
                entries.accept(ItemRegistry.POMEGRANATE_TREE_SEEDS.get());
                entries.accept(ItemRegistry.BELL_PEPPER_SEEDS.get());
                entries.accept(ItemRegistry.ASPARAGUS_CROWNS.get());
                entries.accept(ItemRegistry.CHILLI_SEEDS.get());
                entries.accept(ItemRegistry.LEEK_SEEDS.get());
                entries.accept(ItemRegistry.RADISH_SEEDS.get());
                entries.accept(ItemRegistry.SWEET_POTATO_SLIPS.get());
                entries.accept(ItemRegistry.ZUCCHINI_SEEDS.get());
            })
            .build());
}
