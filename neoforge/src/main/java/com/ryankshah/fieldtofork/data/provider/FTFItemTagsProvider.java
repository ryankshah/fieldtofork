package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.FTFTags;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FTFItemTagsProvider extends ItemTagsProvider
{

    public FTFItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags) {
        super(pOutput, pLookupProvider, pBlockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(FTFTags.BELL_PEPPERS).add(ItemRegistry.RED_PEPPER.get(), ItemRegistry.YELLOW_PEPPER.get());
        tag(FTFTags.GRAPES).add(ItemRegistry.GREEN_GRAPES.get(), ItemRegistry.PURPLE_GRAPES.get());
        tag(FTFTags.FRUITS).add(
                ItemRegistry.GREEN_GRAPES.get(), ItemRegistry.PURPLE_GRAPES.get(), ItemRegistry.YELLOW_PEPPER.get(),
                ItemRegistry.RED_PEPPER.get(), ItemRegistry.BANANA_SINGLE.get(), ItemRegistry.DRAGONFRUIT.get(),
                ItemRegistry.COCONUT_OPEN.get(), ItemRegistry.EGGPLANT.get(), ItemRegistry.LYCHEE.get(),
                ItemRegistry.MANGO.get(), ItemRegistry.ORANGE.get(), ItemRegistry.PASSIONFRUIT.get(),
                ItemRegistry.PEAR.get(), ItemRegistry.POMEGRANATE.get(), ItemRegistry.TOMATO.get(),
                ItemRegistry.STRAWBERRY.get(), ItemRegistry.MULBERRY.get()
        );
        tag(FTFTags.VEGETABLES).add(
                ItemRegistry.ASPARAGUS.get(), ItemRegistry.LEEK.get(), ItemRegistry.RADISH.get(),
                ItemRegistry.SWEET_POTATO.get(), ItemRegistry.ZUCCHINI.get(), ItemRegistry.GARLIC.get(),
                ItemRegistry.GINGER.get(), ItemRegistry.CABBAGE.get()
        );

        tag(FTFTags.FLOWERS).add(
                BlockRegistry.IRIS_FLOWER_BLOCK_ITEM.get(),
                BlockRegistry.CROCUS_VERNUS_BLOCK_ITEM.get(),
                BlockRegistry.CROCUS_FLAVUS_BLOCK_ITEM.get(),
                BlockRegistry.DAFFODIL_BLOCK_ITEM.get(),
                BlockRegistry.BELLFLOWER_BLOCK_ITEM.get(),
                BlockRegistry.WHITE_ROSE_BLOCK_ITEM.get(),
                BlockRegistry.GERANIUM_BLOCK_ITEM.get(),
                BlockRegistry.MARIGOLD_BLOCK_ITEM.get(),
                BlockRegistry.THISTLE_BLOCK_ITEM.get(),
                BlockRegistry.CHRYSANTHEMUM_BLOCK_ITEM.get()
        );
    }
}