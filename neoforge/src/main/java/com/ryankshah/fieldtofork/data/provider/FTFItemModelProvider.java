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
        basicItem(ItemRegistry.BANANA_SINGLE.get());
        basicItem(ItemRegistry.BANANAS.get());
        basicItem(ItemRegistry.DRAGONFRUIT.get());
        basicItem(ItemRegistry.EGGPLANT.get());
        basicItem(ItemRegistry.COCONUT.get());
        basicItem(ItemRegistry.COCONUT_OPEN.get());
        basicItem(ItemRegistry.GREEN_GRAPES.get());
        basicItem(ItemRegistry.PURPLE_GRAPES.get());
        basicItem(ItemRegistry.GREEN_BANANAS.get());
        basicItem(ItemRegistry.LYCHEE.get());
        basicItem(ItemRegistry.MANGO.get());
        basicItem(ItemRegistry.ORANGE.get());
        basicItem(ItemRegistry.PASSIONFRUIT.get());
        basicItem(ItemRegistry.PEAR.get());
        basicItem(ItemRegistry.POMEGRANATE.get());
        basicItem(ItemRegistry.RED_PEPPER.get());
        basicItem(ItemRegistry.YELLOW_PEPPER.get());
        basicItem(ItemRegistry.TOMATO.get());
        basicItem(ItemRegistry.STRAWBERRY.get());
        basicItem(ItemRegistry.MULBERRY.get());

        basicItem(ItemRegistry.ASPARAGUS.get());
        basicItem(ItemRegistry.CHILLI.get());
        basicItem(ItemRegistry.LEEK.get());
        basicItem(ItemRegistry.RADISH.get());
        basicItem(ItemRegistry.SWEET_POTATO.get());
        basicItem(ItemRegistry.ZUCCHINI.get());
        basicItem(ItemRegistry.GARLIC.get());
        basicItem(ItemRegistry.GINGER.get());

        basicItem(ItemRegistry.BANANA_TREE_SEEDS.get());
        basicItem(ItemRegistry.DRAGONFRUIT_TREE_SEEDS.get());
        basicItem(ItemRegistry.EGGPLANT_SEEDS.get());
        basicItem(ItemRegistry.GRAPE_SEEDS.get());
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
        basicItem(ItemRegistry.TOMATO_SEEDS.get());
        basicItem(ItemRegistry.GINGER_ROOT_SLIP.get());
        basicItem(ItemRegistry.STRAWBERRY_SEEDS.get());
        basicItem(ItemRegistry.DURUM_WHEAT_SEEDS.get());

        basicItem(ItemRegistry.GOAT_LEG.get());
        basicItem(ItemRegistry.ROAST_GOAT_LEG.get());
        basicItem(ItemRegistry.HORSE_MEAT.get());
        basicItem(ItemRegistry.HORSE_HAUNCH.get());
        basicItem(ItemRegistry.SALMON_ROE.get());
        basicItem(ItemRegistry.SILKWORM_EGGS.get());

        basicItem(ItemRegistry.FLOUR.get());
        basicItem(ItemRegistry.SALT.get());
        basicItem(ItemRegistry.BUTTER.get());
        basicItem(ItemRegistry.DURUM_WHEAT.get());
        basicItem(ItemRegistry.DURUM_WHEAT_FLOUR.get());
        basicItem(ItemRegistry.GOAT_MILK_BUCKET.get());
        basicItem(ItemRegistry.TOMATO_SOUP.get());
        basicItem(ItemRegistry.VEGETABLE_SOUP.get());

        basicItem(ItemRegistry.UNWOVEN_SILK.get());
        basicItem(ItemRegistry.SILK_STRING.get());

        basicItem(ItemRegistry.STONE_SCYTHE.get());
        basicItem(ItemRegistry.IRON_SCYTHE.get());
        basicItem(ItemRegistry.GOLD_SCYTHE.get());
        basicItem(ItemRegistry.DIAMOND_SCYTHE.get());
        basicItem(ItemRegistry.NETHERITE_SCYTHE.get());
        basicItem(ItemRegistry.WATERING_CAN.get()); //TODO: Change model based on whether it is full or not + number of uses left
    }
}