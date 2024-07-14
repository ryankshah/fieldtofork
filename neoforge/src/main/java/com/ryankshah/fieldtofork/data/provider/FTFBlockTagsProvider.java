package com.ryankshah.fieldtofork.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FTFBlockTagsProvider extends BlockTagsProvider
{
    public FTFBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //ores
//        tag(TagsInit.BlockTagsInit.CORUNDUM_ORE_TAG).add(BlockInit.CORUNDUM_ORE.get());
//        tag(TagsInit.BlockTagsInit.EBONY_ORE_TAG).add(BlockInit.EBONY_ORE.get());
//        tag(TagsInit.BlockTagsInit.MALACHITE_ORE_TAG).add(BlockInit.MALACHITE_ORE.get());
//        tag(TagsInit.BlockTagsInit.MOONSTONE_ORE_TAG).add(BlockInit.MOONSTONE_ORE.get());
//        tag(TagsInit.BlockTagsInit.ORICHALCUM_ORE_TAG).add(BlockInit.ORICHALCUM_ORE.get());
//        tag(TagsInit.BlockTagsInit.QUICKSILVER_ORE_TAG).add(BlockInit.QUICKSILVER_ORE.get());
//        tag(TagsInit.BlockTagsInit.SILVER_ORE_TAG).add(BlockInit.SILVER_ORE.get());
    }
}