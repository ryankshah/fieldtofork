package com.ryankshah.fieldtofork.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class FTFRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public FTFRecipeProvider(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(p_248933_, lookupProvider); //, lookupProvider
    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_SEEDS.get(), 1)).requires(ItemRegistry.PINEAPPLE.get()).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_JUICE.get(), 1)).requires(ItemRegistry.PINEAPPLE.get()).requires(Items.GLASS_BOTTLE).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_CHUNKS.get(), 1)).requires(ItemRegistry.PINEAPPLE_BOTTOM.get()).requires(Items.STICK).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_SLICE.get(), 1)).requires(ItemRegistry.PINEAPPLE_BOTTOM.get()).requires(Items.FLINT).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_SLICE.get(), 1)).requires(ItemRegistry.PINEAPPLE_TOP.get()).requires(Items.STICK).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_SLICE.get(), 1)).requires(ItemRegistry.PINEAPPLE_BOTTOM.get()).requires(Items.STICK).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
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