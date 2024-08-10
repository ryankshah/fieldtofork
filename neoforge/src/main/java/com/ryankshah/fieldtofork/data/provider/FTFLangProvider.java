package com.ryankshah.fieldtofork.data.provider;

import com.mojang.datafixers.kinds.Const;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class FTFLangProvider extends LanguageProvider {
    public FTFLangProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);

    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + Constants.MOD_ID + ".blocks", "Field to Fork Blocks");
        add("itemGroup." + Constants.MOD_ID + ".fruits", "Field to Fork Fruits");
        add("itemGroup." + Constants.MOD_ID + ".vegetables", "Field to Fork Vegetables");
        add("itemGroup." + Constants.MOD_ID + ".meats", "Field to Fork Meats");
        add("itemGroup." + Constants.MOD_ID + ".foods", "Field to Fork Foods");
        add("itemGroup." + Constants.MOD_ID + ".seeds", "Field to Fork Seeds");
        add("itemGroup." + Constants.MOD_ID + ".tools", "Field to Fork Tools");

        add(ItemRegistry.BANANAS.get(), "Bananas");
        add(ItemRegistry.BANANA_SINGLE.get(), "Banana");
        add(ItemRegistry.DRAGONFRUIT.get(), "Dragonfruit");
        add(ItemRegistry.EGGPLANT.get(), "Eggplant");
        add(ItemRegistry.COCONUT.get(), "Coconut");
        add(ItemRegistry.COCONUT_OPEN.get(), "Coconut");
        add(ItemRegistry.GREEN_GRAPES.get(), "Green Grapes");
        add(ItemRegistry.PURPLE_GRAPES.get(), "Purple Grapes");
        add(ItemRegistry.GREEN_BANANAS.get(), "Green Bananas");
        add(ItemRegistry.LYCHEE.get(), "Lychee");
        add(ItemRegistry.MANGO.get(), "Mango");
        add(ItemRegistry.ORANGE.get(), "Orange");
        add(ItemRegistry.PASSIONFRUIT.get(), "Passionfruit");
        add(ItemRegistry.PEAR.get(), "Pear");
        add(ItemRegistry.POMEGRANATE.get(), "Pomegranate");
        add(ItemRegistry.RED_PEPPER.get(), "Red Bell Pepper");
        add(ItemRegistry.YELLOW_PEPPER.get(), "Yellow Bell Pepper");
        add(ItemRegistry.TOMATO.get(), "Tomato");
        add(ItemRegistry.STRAWBERRY.get(), "Strawberry");
        add(ItemRegistry.MULBERRY.get(), "Mulberry");

        add(ItemRegistry.ASPARAGUS.get(), "Asparagus");
        add(ItemRegistry.CHILLI.get(), "Chilli");
        add(ItemRegistry.LEEK.get(), "Leek");
        add(ItemRegistry.RADISH.get(), "Radish");
        add(ItemRegistry.SWEET_POTATO.get(), "Sweet Potato");
        add(ItemRegistry.ZUCCHINI.get(), "Zucchini");
        add(ItemRegistry.GARLIC.get(), "Garlic");
        add(ItemRegistry.GINGER.get(), "Ginger");

        add(ItemRegistry.FLOUR.get(), "Flour");
        add(ItemRegistry.SALT.get(), "Salt");
        add(ItemRegistry.BUTTER.get(), "Butter");
        add(ItemRegistry.GOAT_MILK_BUCKET.get(), "Bucket of Goat Milk");
        add(ItemRegistry.SILKWORM_EGGS.get(), "Silkworm Eggs");
        add(ItemRegistry.TOMATO_SOUP.get(), "Tomato Soup");
        add(ItemRegistry.VEGETABLE_SOUP.get(), "Vegetable Soup");

        add(ItemRegistry.UNWOVEN_SILK.get(), "Unwoven Silk");

        add("entity." + Constants.MOD_ID + ".silkmoth", "Silk Moth");

        add(ItemRegistry.BANANA_TREE_SEEDS.get(), "Banana Tree Seeds");
        add(ItemRegistry.DRAGONFRUIT_TREE_SEEDS.get(), "Dragonfruit Tree Seeds");
        add(ItemRegistry.EGGPLANT_SEEDS.get(), "Eggplant Seeds");
        add(ItemRegistry.GRAPE_SEEDS.get(), "Grape Seeds");
        add(ItemRegistry.LYCHEE_TREE_SEED.get(), "Lychee Tree Seed");
        add(ItemRegistry.MANGO_TREE_SEED.get(), "Mango Tree Seed");
        add(ItemRegistry.ORANGE_TREE_SEEDS.get(), "Orange Tree Seeds");
        add(ItemRegistry.PASSIONFRUIT_SEEDS.get(), "Passionfruit Seeds");
        add(ItemRegistry.PEAR_TREE_SEEDS.get(), "Pear Tree Seeds");
        add(ItemRegistry.POMEGRANATE_TREE_SEEDS.get(), "Pomegranate Tree Seeds");
        add(ItemRegistry.BELL_PEPPER_SEEDS.get(), "Bell Pepper Seeds");
        add(ItemRegistry.ASPARAGUS_CROWNS.get(), "Asparagus Crowns");
        add(ItemRegistry.CHILLI_SEEDS.get(), "Chilli Seeds");
        add(ItemRegistry.LEEK_SEEDS.get(), "Leek Seeds");
        add(ItemRegistry.RADISH_SEEDS.get(), "Radish Seeds");
        add(ItemRegistry.SWEET_POTATO_SLIPS.get(), "Sweet Potato Slips");
        add(ItemRegistry.ZUCCHINI_SEEDS.get(), "Zucchini Seeds");
        add(ItemRegistry.TOMATO_SEEDS.get(), "Tomato Seeds");
        add(ItemRegistry.STRAWBERRY_SEEDS.get(), "Strawberry Seeds");
        add(ItemRegistry.DURUM_WHEAT_SEEDS.get(), "Durum Wheat Seeds");
        add(ItemRegistry.GINGER_ROOT_SLIP.get(), "Ginger Root Slip");

        add(ItemRegistry.GOAT_LEG.get(), "Goat Leg");
        add(ItemRegistry.ROAST_GOAT_LEG.get(), "Roast Goat Leg");
        add(ItemRegistry.HORSE_MEAT.get(), "Horse Meat");
        add(ItemRegistry.HORSE_HAUNCH.get(), "Horse Haunch");
        add(ItemRegistry.SALMON_ROE.get(), "Salmon Roe");
        add(ItemRegistry.DURUM_WHEAT.get(), "Durum Wheat");
        add(ItemRegistry.DURUM_WHEAT_FLOUR.get(), "Durum Wheat Flour");

        add(BlockRegistry.VILLAGER_SCARECROW_BLOCK.get(), "Villager Scarecrow");
        add(BlockRegistry.CHURN.get(), "Churn");
        add(Constants.MOD_ID + ".container.churn", "Churn");
        add(BlockRegistry.SILKWORM_HABITAT.get(), "Silkworm Habitat");
        add(Constants.MOD_ID + ".container.silkworm_habitat", "Silkworm Habitat");

        add(BlockRegistry.PALM_SAPLING.get(), "Palm Sapling");
        add(BlockRegistry.PALM_LOG.get(), "Palm Log");
        add(BlockRegistry.PALM_LEAVES.get(), "Palm Leaves");
        add(BlockRegistry.DENSE_PALM_LEAVES.get(), "Dense Palm Leaves");
        add(BlockRegistry.PALM_PLANKS.get(), "Palm Planks");
        add(BlockRegistry.PALM_DOOR.get(), "Palm Door");
        add(BlockRegistry.PALM_TRAPDOOR.get(), "Palm Trapdoor");
        add(BlockRegistry.PALM_SLAB.get(), "Palm Slab");
        add(BlockRegistry.PALM_STAIRS.get(), "Palm Stairs");
        add(BlockRegistry.PALM_BUTTON.get(), "Palm Button");
        add(BlockRegistry.PALM_FENCE.get(), "Palm Fence");
        add(BlockRegistry.PALM_FENCE_GATE.get(), "Palm Fence Gate");
        add(BlockRegistry.PALM_HANGING_SIGN.get(), "Palm Hanging Sign");
        add(BlockRegistry.PALM_SIGN.get(), "Palm Sign");
        add(BlockRegistry.PALM_PRESSURE_PLATE.get(), "Palm Pressure Plate");

        add(BlockRegistry.BANANA_SAPLING.get(), "Banana Sapling");
        add(BlockRegistry.BANANA_TREE_LOG.get(), "Banana Log");
        add(BlockRegistry.BANANA_TREE_PLANKS.get(), "Banana Planks");
        add(BlockRegistry.BANANA_LEAVES.get(), "Banana Leaves");
        add(BlockRegistry.BANANA_DOOR.get(), "Banana Door");
        add(BlockRegistry.BANANA_TRAPDOOR.get(), "Banana Trapdoor");
        add(BlockRegistry.BANANA_SLAB.get(), "Banana Slab");
        add(BlockRegistry.BANANA_STAIRS.get(), "Banana Stairs");
        add(BlockRegistry.BANANA_BUTTON.get(), "Banana Button");
        add(BlockRegistry.BANANA_FENCE.get(), "Banana Fence");
        add(BlockRegistry.BANANA_FENCE_GATE.get(), "Banana Fence Gate");
        add(BlockRegistry.BANANA_HANGING_SIGN.get(), "Banana Hanging Sign");
        add(BlockRegistry.BANANA_SIGN.get(), "Banana Sign");
        add(BlockRegistry.BANANA_PRESSURE_PLATE.get(), "Banana Pressure Plate");

        add(BlockRegistry.DRAGONFRUIT_SAPLING.get(), "Dragonfruit Sapling");
        add(BlockRegistry.DRAGONFRUIT_TREE_LOG.get(), "Dragonfruit Log");
        add(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get(), "Dragonfruit Planks");
        add(BlockRegistry.DRAGONFRUIT_LEAVES.get(), "Dragonfruit Leaves");
        add(BlockRegistry.DRAGONFRUIT_DOOR.get(), "Dragonfruit Door");
        add(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get(), "Dragonfruit Trapdoor");
        add(BlockRegistry.DRAGONFRUIT_SLAB.get(), "Dragonfruit Slab");
        add(BlockRegistry.DRAGONFRUIT_STAIRS.get(), "Dragonfruit Stairs");
        add(BlockRegistry.DRAGONFRUIT_BUTTON.get(), "Dragonfruit Button");
        add(BlockRegistry.DRAGONFRUIT_FENCE.get(), "Dragonfruit Fence");
        add(BlockRegistry.DRAGONFRUIT_FENCE_GATE.get(), "Dragonfruit Fence Gate");
        add(BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get(), "Dragonfruit Hanging Sign");
        add(BlockRegistry.DRAGONFRUIT_SIGN.get(), "Dragonfruit Sign");
        add(BlockRegistry.DRAGONFRUIT_PRESSURE_PLATE.get(), "Dragonfruit Pressure Plate");

        add(BlockRegistry.LYCHEE_SAPLING.get(), "Lychee Sapling");
        add(BlockRegistry.LYCHEE_TREE_LOG.get(), "Lychee Log");
        add(BlockRegistry.LYCHEE_TREE_PLANKS.get(), "Lychee Planks");
        add(BlockRegistry.LYCHEE_LEAVES.get(), "Lychee Leaves");
        add(BlockRegistry.LYCHEE_DOOR.get(), "Lychee Door");
        add(BlockRegistry.LYCHEE_TRAPDOOR.get(), "Lychee Trapdoor");
        add(BlockRegistry.LYCHEE_SLAB.get(), "Lychee Slab");
        add(BlockRegistry.LYCHEE_STAIRS.get(), "Lychee Stairs");
        add(BlockRegistry.LYCHEE_BUTTON.get(), "Lychee Button");
        add(BlockRegistry.LYCHEE_FENCE.get(), "Lychee Fence");
        add(BlockRegistry.LYCHEE_FENCE_GATE.get(), "Lychee Fence Gate");
        add(BlockRegistry.LYCHEE_HANGING_SIGN.get(), "Lychee Hanging Sign");
        add(BlockRegistry.LYCHEE_SIGN.get(), "Lychee Sign");
        add(BlockRegistry.LYCHEE_PRESSURE_PLATE.get(), "Lychee Pressure Plate");

        add(BlockRegistry.MANGO_LOG.get(), "Mango Log");
        add(BlockRegistry.MANGO_PLANKS.get(), "Mango Planks");
        add(BlockRegistry.MANGO_SAPLING.get(), "Mango Sapling");
        add(BlockRegistry.MANGO_LEAVES.get(), "Mango Leaves");
        add(BlockRegistry.MANGO_DOOR.get(), "Mango Door");
        add(BlockRegistry.MANGO_TRAPDOOR.get(), "Mango Trapdoor");
        add(BlockRegistry.MANGO_SLAB.get(), "Mango Slab");
        add(BlockRegistry.MANGO_STAIRS.get(), "Mango Stairs");
        add(BlockRegistry.MANGO_BUTTON.get(), "Mango Button");
        add(BlockRegistry.MANGO_FENCE.get(), "Mango Fence");
        add(BlockRegistry.MANGO_FENCE_GATE.get(), "Mango Fence Gate");
        add(BlockRegistry.MANGO_HANGING_SIGN.get(), "Mango Hanging Sign");
        add(BlockRegistry.MANGO_SIGN.get(), "Mango Sign");
        add(BlockRegistry.MANGO_PRESSURE_PLATE.get(), "Mango Pressure Plate");

        add(BlockRegistry.ORANGE_LOG.get(), "Orange Log");
        add(BlockRegistry.ORANGE_PLANKS.get(), "Orange Planks");
        add(BlockRegistry.ORANGE_SAPLING.get(), "Orange Sapling");
        add(BlockRegistry.ORANGE_LEAVES.get(), "Orange Leaves");
        add(BlockRegistry.ORANGE_DOOR.get(), "Orange Door");
        add(BlockRegistry.ORANGE_TRAPDOOR.get(), "Orange Trapdoor");
        add(BlockRegistry.ORANGE_SLAB.get(), "Orange Slab");
        add(BlockRegistry.ORANGE_STAIRS.get(), "Orange Stairs");
        add(BlockRegistry.ORANGE_BUTTON.get(), "Orange Button");
        add(BlockRegistry.ORANGE_FENCE.get(), "Orange Fence");
        add(BlockRegistry.ORANGE_FENCE_GATE.get(), "Orange Fence Gate");
        add(BlockRegistry.ORANGE_HANGING_SIGN.get(), "Orange Hanging Sign");
        add(BlockRegistry.ORANGE_SIGN.get(), "Orange Sign");
        add(BlockRegistry.ORANGE_PRESSURE_PLATE.get(), "Orange Pressure Plate");

        add(BlockRegistry.PEAR_LOG.get(), "Pear Log");
        add(BlockRegistry.PEAR_PLANKS.get(), "Pear Planks");
        add(BlockRegistry.PEAR_SAPLING.get(), "Pear Sapling");
        add(BlockRegistry.PEAR_LEAVES.get(), "Pear Leaves");
        add(BlockRegistry.PEAR_DOOR.get(), "Pear Door");
        add(BlockRegistry.PEAR_TRAPDOOR.get(), "Pear Trapdoor");
        add(BlockRegistry.PEAR_SLAB.get(), "Pear Slab");
        add(BlockRegistry.PEAR_STAIRS.get(), "Pear Stairs");
        add(BlockRegistry.PEAR_BUTTON.get(), "Pear Button");
        add(BlockRegistry.PEAR_FENCE.get(), "Pear Fence");
        add(BlockRegistry.PEAR_FENCE_GATE.get(), "Pear Fence Gate");
        add(BlockRegistry.PEAR_HANGING_SIGN.get(), "Pear Hanging Sign");
        add(BlockRegistry.PEAR_SIGN.get(), "Pear Sign");
        add(BlockRegistry.PEAR_PRESSURE_PLATE.get(), "Pear Pressure Plate");

        add(BlockRegistry.POMEGRANATE_LOG.get(), "Pomegranate Log");
        add(BlockRegistry.POMEGRANATE_PLANKS.get(), "Pomegranate Planks");
        add(BlockRegistry.POMEGRANATE_SAPLING.get(), "Pomegranate Sapling");
        add(BlockRegistry.POMEGRANATE_LEAVES.get(), "Pomegranate Leaves");
        add(BlockRegistry.POMEGRANATE_DOOR.get(), "Pomegranate Door");
        add(BlockRegistry.POMEGRANATE_TRAPDOOR.get(), "Pomegranate Trapdoor");
        add(BlockRegistry.POMEGRANATE_SLAB.get(), "Pomegranate Slab");
        add(BlockRegistry.POMEGRANATE_STAIRS.get(), "Pomegranate Stairs");
        add(BlockRegistry.POMEGRANATE_BUTTON.get(), "Pomegranate Button");
        add(BlockRegistry.POMEGRANATE_FENCE.get(), "Pomegranate Fence");
        add(BlockRegistry.POMEGRANATE_FENCE_GATE.get(), "Pomegranate Fence Gate");
        add(BlockRegistry.POMEGRANATE_HANGING_SIGN.get(), "Pomegranate Hanging Sign");
        add(BlockRegistry.POMEGRANATE_SIGN.get(), "Pomegranate Sign");
        add(BlockRegistry.POMEGRANATE_PRESSURE_PLATE.get(), "Pomegranate Pressure Plate");

        add(BlockRegistry.MULBERRY_LOG.get(), "Mulberry Log");
        add(BlockRegistry.MULBERRY_PLANKS.get(), "Mulberry Planks");
        add(BlockRegistry.MULBERRY_SAPLING.get(), "Mulberry Sapling");
        add(BlockRegistry.MULBERRY_LEAVES.get(), "Mulberry Leaves");
        add(BlockRegistry.MULBERRY_DOOR.get(), "Mulberry Door");
        add(BlockRegistry.MULBERRY_TRAPDOOR.get(), "Mulberry Trapdoor");
        add(BlockRegistry.MULBERRY_SLAB.get(), "Mulberry Slab");
        add(BlockRegistry.MULBERRY_STAIRS.get(), "Mulberry Stairs");
        add(BlockRegistry.MULBERRY_BUTTON.get(), "Mulberry Button");
        add(BlockRegistry.MULBERRY_FENCE.get(), "Mulberry Fence");
        add(BlockRegistry.MULBERRY_FENCE_GATE.get(), "Mulberry Fence Gate");
        add(BlockRegistry.MULBERRY_HANGING_SIGN.get(), "Mulberry Hanging Sign");
        add(BlockRegistry.MULBERRY_SIGN.get(), "Mulberry Sign");
        add(BlockRegistry.MULBERRY_PRESSURE_PLATE.get(), "Mulberry Pressure Plate");

        add(ItemRegistry.STONE_SCYTHE.get(), "Stone Scythe");
        add(ItemRegistry.IRON_SCYTHE.get(), "Iron Scythe");
        add(ItemRegistry.GOLD_SCYTHE.get(), "Gold Scythe");
        add(ItemRegistry.DIAMOND_SCYTHE.get(), "Diamond Scythe");
        add(ItemRegistry.NETHERITE_SCYTHE.get(), "Netherite Scythe");
        add(ItemRegistry.WATERING_CAN.get(), "Watering Can");
        add(ItemRegistry.PITCHFORK.get(), "Pitchfork");
    }
}