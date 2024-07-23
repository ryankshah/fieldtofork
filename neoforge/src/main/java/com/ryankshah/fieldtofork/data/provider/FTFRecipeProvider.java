package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_PLANKS.get(), 4)).requires(BlockRegistry.PALM_LOG.get()).unlockedBy("has_palm_log", has(BlockRegistry.PALM_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_BUTTON.get(), 1)).requires(BlockRegistry.PALM_PLANKS.get()).unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DENSE_PALM_LEAVES.get(), 1))
                .pattern("aa")
                .pattern("aa")
                .define('a', BlockRegistry.PALM_LEAVES.get())
                .unlockedBy("has_palm_leaves", has(BlockRegistry.PALM_LEAVES.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PALM_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", has(BlockRegistry.PALM_PLANKS.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_TREE_PLANKS.get(), 4)).requires(BlockRegistry.BANANA_TREE_LOG.get()).unlockedBy("has_banana_log", has(BlockRegistry.BANANA_TREE_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_BUTTON.get(), 1)).requires(BlockRegistry.BANANA_TREE_PLANKS.get()).unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.BANANA_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.BANANA_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.BANANA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get(), 4)).requires(BlockRegistry.DRAGONFRUIT_TREE_LOG.get()).unlockedBy("has_banana_log", has(BlockRegistry.DRAGONFRUIT_TREE_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_BUTTON.get(), 1)).requires(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()).unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_banana_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
    }
}