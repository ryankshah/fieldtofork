package com.ryankshah.fieldtofork.data.provider;

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
        add("itemGroup." + Constants.MOD_ID + ".seeds", "Field to Fork Seeds");

        add(ItemRegistry.BANANA.get(), "Banana");
        add(ItemRegistry.DRAGONFRUIT.get(), "Dragonfruit");
        add(ItemRegistry.EGGPLANT.get(), "Eggplant");
        add(ItemRegistry.GREEN_BANANA.get(), "Green Banana");
        add(ItemRegistry.LYCHEE.get(), "Lychee");
        add(ItemRegistry.MANGO.get(), "Mango");
        add(ItemRegistry.ORANGE.get(), "Orange");
        add(ItemRegistry.PASSIONFRUIT.get(), "Passionfruit");
        add(ItemRegistry.PEAR.get(), "Pear");
        add(ItemRegistry.POMEGRANATE.get(), "Pomegranate");
        add(ItemRegistry.RED_PEPPER.get(), "Red Bell Pepper");
        add(ItemRegistry.YELLOW_PEPPER.get(), "Yellow Bell Pepper");

        add(ItemRegistry.ASPARAGUS.get(), "Asparagus");
        add(ItemRegistry.CHILLI.get(), "Chilli");
        add(ItemRegistry.LEEK.get(), "Leek");
        add(ItemRegistry.RADISH.get(), "Radish");
        add(ItemRegistry.SWEET_POTATO.get(), "Sweet Potato");
        add(ItemRegistry.ZUCCHINI.get(), "Zucchini");

        add(ItemRegistry.BANANA_TREE_SEEDS.get(), "Banana Tree Seeds");
        add(ItemRegistry.DRAGONFRUIT_TREE_SEEDS.get(), "Dragonfruit Tree Seeds");
        add(ItemRegistry.EGGPLANT_SEEDS.get(), "Eggplant Seeds");
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

        add(BlockRegistry.LYCHEE_TREE_LOG.get(), "Lychee Log");
        add(BlockRegistry.LYCHEE_TREE_PLANKS.get(), "Lychee Planks");

        add(BlockRegistry.MANGO_LOG.get(), "Mango Log");
        add(BlockRegistry.MANGO_PLANKS.get(), "Mango Planks");

        add(BlockRegistry.ORANGE_LOG.get(), "Orange Log");
        add(BlockRegistry.ORANGE_PLANKS.get(), "Orange Planks");

        add(BlockRegistry.PEAR_LOG.get(), "Pear Log");
        add(BlockRegistry.PEAR_PLANKS.get(), "Pear Planks");

        add(BlockRegistry.POMEGRANATE_LOG.get(), "Pomegranate Log");
        add(BlockRegistry.POMEGRANATE_PLANKS.get(), "Pomegranate Planks");
    }
}