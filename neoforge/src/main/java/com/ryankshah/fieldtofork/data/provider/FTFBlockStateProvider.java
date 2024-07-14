package com.ryankshah.fieldtofork.data.provider;

import com.mojang.datafixers.kinds.Const;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FTFBlockStateProvider extends BlockStateProvider
{
    public FTFBlockStateProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        doorBlock(BlockRegistry.PALM_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_door_top"));

        itemModels().basicItem(BlockRegistry.PALM_DOOR.get().asItem());

        trapdoorBlock(BlockRegistry.PALM_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_trapdoor"), true);
        simpleBlockItem(BlockRegistry.PALM_LOG.get(), itemModels().withExistingParent("block/palm_trapdoor_bottom", "item/generated"));
//        itemModels().basicItem(BlockRegistry.PALM_TRAPDOOR.get().asItem());

        logBlock(BlockRegistry.PALM_LOG.get());
        simpleBlockItem(BlockRegistry.PALM_LOG.get(), itemModels().withExistingParent("block/palm_log", "item/generated"));
//        itemModels().basicItem(BlockRegistry.PALM_LOG.get().asItem());

        simpleBlock(BlockRegistry.PALM_PLANKS.get());
        simpleBlockItem(BlockRegistry.PALM_PLANKS.get(), itemModels().withExistingParent("block/palm_planks", "item/generated"));
//        itemModels().basicItem(BlockRegistry.PALM_PLANKS.get().asItem());
    }
}