package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
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
        add(ItemRegistry.RED_PEPPER.get(), "Red Pepper");
        add(ItemRegistry.YELLOW_PEPPER.get(), "Yellow Pepper");

        add(ItemRegistry.ASPARAGUS.get(), "Asparagus");
        add(ItemRegistry.CHILLI.get(), "Chilli");
        add(ItemRegistry.LEEK.get(), "Leek");
        add(ItemRegistry.RADISH.get(), "Radish");
        add(ItemRegistry.SWEET_POTATO.get(), "Sweet Potato");
        add(ItemRegistry.ZUCCHINI.get(), "Zucchini");

//        add(ItemRegistry.PINEAPPLE_BLOCK.get(), "Pineapples");
//        add(ItemRegistry.PINEAPPLE.get(), "Pineapple");
//        add(ItemRegistry.PINEAPPLE_SEEDS.get(), "Pineapple Seeds");
//        add(ItemRegistry.GOLDEN_PINEAPPLE.get(), "Golden Pineapple");
//        add(ItemRegistry.PINEAPPLE_TOP.get(), "Pineapple Top");
//        add(ItemRegistry.PINEAPPLE_BOTTOM.get(), "Pineapple Bottom");
//        add(ItemRegistry.PINEAPPLE_CHUNKS.get(), "Pineapple Chunks");
//        add(ItemRegistry.PINEAPPLE_SLICE.get(), "Pineapple Slice");
//        add(ItemRegistry.PINEAPPLE_JUICE.get(), "Pineapple Juice");
    }
}