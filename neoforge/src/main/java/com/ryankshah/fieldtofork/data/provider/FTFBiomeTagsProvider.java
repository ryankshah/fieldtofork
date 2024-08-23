package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.registry.FTFTags;
import com.ryankshah.fieldtofork.registry.WorldGenRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FTFBiomeTagsProvider extends BiomeTagsProvider
{
    public FTFBiomeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        tag(FTFTags.CAN_SPAWN_SILK_MOTHS).add(
//                WorldGenRegistry.MULBERRY_GROVE
//        );
    }
}
