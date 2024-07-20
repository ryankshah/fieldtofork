package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FTFItemModelProvider extends ItemModelProvider
{
    public FTFItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ItemRegistry.BANANA.get());
        basicItem(ItemRegistry.DRAGONFRUIT.get());
        basicItem(ItemRegistry.EGGPLANT.get());
        basicItem(ItemRegistry.GREEN_BANANA.get());
        basicItem(ItemRegistry.LYCHEE.get());
        basicItem(ItemRegistry.MANGO.get());
        basicItem(ItemRegistry.ORANGE.get());
        basicItem(ItemRegistry.PASSIONFRUIT.get());
        basicItem(ItemRegistry.PEAR.get());
        basicItem(ItemRegistry.POMEGRANATE.get());
        basicItem(ItemRegistry.RED_PEPPER.get());
        basicItem(ItemRegistry.YELLOW_PEPPER.get());

        basicItem(ItemRegistry.ASPARAGUS.get());
        basicItem(ItemRegistry.CHILLI.get());
        basicItem(ItemRegistry.LEEK.get());
        basicItem(ItemRegistry.RADISH.get());
        basicItem(ItemRegistry.SWEET_POTATO.get());
        basicItem(ItemRegistry.ZUCCHINI.get());

        basicItem(ItemRegistry.BANANA_TREE_SEEDS.get());
        basicItem(ItemRegistry.DRAGONFRUIT_TREE_SEEDS.get());
        basicItem(ItemRegistry.EGGPLANT_SEEDS.get());
        basicItem(ItemRegistry.LYCHEE_TREE_SEED.get());
        basicItem(ItemRegistry.MANGO_TREE_SEED.get());
        basicItem(ItemRegistry.ORANGE_TREE_SEEDS.get());
        basicItem(ItemRegistry.PASSIONFRUIT_SEEDS.get());
        basicItem(ItemRegistry.PEAR_TREE_SEEDS.get());
        basicItem(ItemRegistry.POMEGRANATE_TREE_SEEDS.get());
        basicItem(ItemRegistry.BELL_PEPPER_SEEDS.get());
        basicItem(ItemRegistry.ASPARAGUS_CROWNS.get());
        basicItem(ItemRegistry.CHILLI_SEEDS.get());
        basicItem(ItemRegistry.LEEK_SEEDS.get());
        basicItem(ItemRegistry.RADISH_SEEDS.get());
        basicItem(ItemRegistry.SWEET_POTATO_SLIPS.get());
        basicItem(ItemRegistry.ZUCCHINI_SEEDS.get());
    }
}