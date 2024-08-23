package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.FTFTags;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.Tags;
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
        tag(FTFTags.FLOWER_BLOCKS).add(
                BlockRegistry.IRIS_FLOWER.get(),
                BlockRegistry.CROCUS_VERNUS.get(),
                BlockRegistry.CROCUS_FLAVUS.get(),
                BlockRegistry.DAFFODIL.get()
        );
    }
}