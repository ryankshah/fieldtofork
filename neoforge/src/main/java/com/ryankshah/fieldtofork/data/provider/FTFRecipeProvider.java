package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * TODO:
 * - add recipes for palm blocks
 */
public class FTFRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public FTFRecipeProvider(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(p_248933_, lookupProvider); //, lookupProvider
    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(BlockRegistry.PALM_PLANKS.get(), 4)).requires(BlockRegistry.PALM_LOG.get()).unlockedBy("has_palm_log", has(BlockRegistry.PALM_LOG.get())).save(pWriter);

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_BOTTOM.get(), 1))
//                .pattern(" a ")
//                .pattern(" b ")
//                .define('a', Items.FLINT)
//                .define('b', ItemRegistry.PINEAPPLE.get())
//                .unlockedBy("criteria", has(ItemRegistry.PINEAPPLE.get()))
//                .save(pWriter);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_TOP.get(), 1))
//                .pattern(" b ")
//                .pattern(" a ")
//                .define('a', Items.FLINT)
//                .define('b', ItemRegistry.PINEAPPLE.get())
//                .unlockedBy("criteria", has(ItemRegistry.PINEAPPLE.get()))
//                .save(pWriter);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.GOLDEN_PINEAPPLE.get(), 1))
//                .pattern("bbb")
//                .pattern("bab")
//                .pattern("bbb")
//                .define('b', Items.GOLD_BLOCK)
//                .define('a', ItemRegistry.PINEAPPLE.get())
//                .unlockedBy("criteria", has(ItemRegistry.PINEAPPLE.get()))
//                .save(pWriter);
    }
}