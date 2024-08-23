package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.FTFTags;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.block.Blocks;
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get(), 4)).requires(BlockRegistry.DRAGONFRUIT_TREE_LOG.get()).unlockedBy("has_dragonfruit_log", has(BlockRegistry.DRAGONFRUIT_TREE_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_BUTTON.get(), 1)).requires(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()).unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.DRAGONFRUIT_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get())
                .unlockedBy("has_dragonfruit_planks", has(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_TREE_PLANKS.get(), 4)).requires(BlockRegistry.LYCHEE_TREE_LOG.get()).unlockedBy("has_lychee_log", has(BlockRegistry.LYCHEE_TREE_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_BUTTON.get(), 1)).requires(BlockRegistry.LYCHEE_TREE_PLANKS.get()).unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.LYCHEE_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.LYCHEE_TREE_PLANKS.get())
                .unlockedBy("has_lychee_planks", has(BlockRegistry.LYCHEE_TREE_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_PLANKS.get(), 4)).requires(BlockRegistry.MANGO_LOG.get()).unlockedBy("has_mango_log", has(BlockRegistry.MANGO_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_BUTTON.get(), 1)).requires(BlockRegistry.MANGO_PLANKS.get()).unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.MANGO_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.MANGO_PLANKS.get())
                .unlockedBy("has_mango_planks", has(BlockRegistry.MANGO_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_PLANKS.get(), 4)).requires(BlockRegistry.ORANGE_LOG.get()).unlockedBy("has_orange_log", has(BlockRegistry.ORANGE_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_BUTTON.get(), 1)).requires(BlockRegistry.ORANGE_PLANKS.get()).unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.ORANGE_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.ORANGE_PLANKS.get())
                .unlockedBy("has_orange_planks", has(BlockRegistry.ORANGE_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_PLANKS.get(), 4)).requires(BlockRegistry.PEAR_LOG.get()).unlockedBy("has_pear_log", has(BlockRegistry.PEAR_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_BUTTON.get(), 1)).requires(BlockRegistry.PEAR_PLANKS.get()).unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.PEAR_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.PEAR_PLANKS.get())
                .unlockedBy("has_pear_planks", has(BlockRegistry.PEAR_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_PLANKS.get(), 4)).requires(BlockRegistry.POMEGRANATE_LOG.get()).unlockedBy("has_pomegranate_log", has(BlockRegistry.POMEGRANATE_LOG.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_BUTTON.get(), 1)).requires(BlockRegistry.POMEGRANATE_PLANKS.get()).unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_TRAPDOOR.get(), 1))
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_DOOR.get(), 3))
                .pattern("aa ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_SLAB.get(), 6))
                .pattern("   ")
                .pattern("   ")
                .pattern("aaa")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_SIGN.get(), 3))
                .pattern("aaa")
                .pattern("aaa")
                .pattern(" b ")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_HANGING_SIGN.get(), 3))
                .pattern("b b")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .define('b', Items.CHAIN)
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_FENCE.get(), 3))
                .pattern("aba")
                .pattern("aba")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_FENCE_GATE.get(), 4))
                .pattern("bab")
                .pattern("bab")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .define('b', Items.STICK)
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_PRESSURE_PLATE.get(), 1))
                .pattern("aa")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.POMEGRANATE_STAIRS.get(), 4))
                .pattern("  a")
                .pattern(" aa")
                .pattern("aaa")
                .define('a', BlockRegistry.POMEGRANATE_PLANKS.get())
                .unlockedBy("has_pomegranate_planks", has(BlockRegistry.POMEGRANATE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.SILKWORM_HABITAT.get(), 1))
                .pattern("aaa")
                .pattern("aca")
                .pattern("aaa")
                .define('a', ItemTags.PLANKS)
                .define('c', Items.IRON_INGOT)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(pWriter);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.BANANA_TREE_SEEDS.get(), 1)).requires(ItemRegistry.BANANA_SINGLE.get()).unlockedBy("has_banana", has(ItemRegistry.BANANA_SINGLE.get())).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, new ItemStack(ItemRegistry.COCONUT_OPEN.get(), 1)).requires(ItemRegistry.COCONUT.get()).requires(Items.FLINT).unlockedBy("has_coconut", has(ItemRegistry.COCONUT.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, new ItemStack(ItemRegistry.BANANA_SINGLE.get(), 3)).requires(ItemRegistry.BANANAS.get()).unlockedBy("has_bananas", has(ItemRegistry.BANANAS.get())).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.SWEET_POTATO_SLIPS.get(), 1)).requires(ItemRegistry.SWEET_POTATO.get()).unlockedBy("has_sweet_potato", has(ItemRegistry.SWEET_POTATO.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.GRAPE_SEEDS.get(), 2)).requires(FTFTags.GRAPES).unlockedBy("has_grapes", has(FTFTags.GRAPES)).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.ASPARAGUS_CROWNS.get(), 1)).requires(ItemRegistry.ASPARAGUS.get()).unlockedBy("has_asparagus", has(ItemRegistry.ASPARAGUS.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.CHILLI_SEEDS.get(), 3)).requires(ItemRegistry.CHILLI.get()).unlockedBy("has_chilli", has(ItemRegistry.CHILLI.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.RADISH_SEEDS.get(), 2)).requires(ItemRegistry.RADISH.get()).unlockedBy("has_radish", has(ItemRegistry.RADISH.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.LEEK_SEEDS.get(), 2)).requires(ItemRegistry.LEEK.get()).unlockedBy("has_leek", has(ItemRegistry.LEEK.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.ZUCCHINI_SEEDS.get(), 2)).requires(ItemRegistry.ZUCCHINI.get()).unlockedBy("has_zucchini", has(ItemRegistry.ZUCCHINI.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.EGGPLANT_SEEDS.get(), 2)).requires(ItemRegistry.EGGPLANT.get()).unlockedBy("has_eggplant", has(ItemRegistry.EGGPLANT.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.BELL_PEPPER_SEEDS.get(), 3)).requires(FTFTags.BELL_PEPPERS).unlockedBy("has_bell_pepper", has(FTFTags.BELL_PEPPERS)).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PASSIONFRUIT_SEEDS.get(), 3)).requires(ItemRegistry.PASSIONFRUIT.get()).unlockedBy("has_passionfruit", has(ItemRegistry.PASSIONFRUIT.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.STRAWBERRY_SEEDS.get(), 3)).requires(ItemRegistry.STRAWBERRY.get()).unlockedBy("has_strawberry", has(ItemRegistry.STRAWBERRY.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.GINGER_ROOT_SLIP.get(), 3)).requires(ItemRegistry.GINGER.get()).unlockedBy("has_ginger", has(ItemRegistry.GINGER.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.CABBAGE_SEEDS.get(), 2)).requires(ItemRegistry.CABBAGE.get()).unlockedBy("has_cabbage", has(ItemRegistry.CABBAGE.get())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, new ItemStack(ItemRegistry.STONE_SCYTHE.get(), 1))
                .pattern(" ab")
                .pattern("a b")
                .pattern("a b")
                .define('a', Blocks.STONE)
                .define('b', Items.STICK)
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, new ItemStack(ItemRegistry.IRON_SCYTHE.get(), 1))
                .pattern(" ab")
                .pattern("a b")
                .pattern("a b")
                .define('a', Items.IRON_INGOT)
                .define('b', Items.STICK)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, new ItemStack(ItemRegistry.GOLD_SCYTHE.get(), 1))
                .pattern(" ab")
                .pattern("a b")
                .pattern("a b")
                .define('a', Items.GOLD_INGOT)
                .define('b', Items.STICK)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, new ItemStack(ItemRegistry.DIAMOND_SCYTHE.get(), 1))
                .pattern(" ab")
                .pattern("a b")
                .pattern("a b")
                .define('a', Items.DIAMOND)
                .define('b', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(pWriter);
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(ItemRegistry.DIAMOND_SCYTHE.get()),
                Ingredient.of(Items.NETHERITE_INGOT),
                RecipeCategory.TOOLS,
                ItemRegistry.NETHERITE_SCYTHE.get()
        ).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(pWriter, getItemName(ItemRegistry.NETHERITE_SCYTHE.get())+"_smithing");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, new ItemStack(ItemRegistry.WATERING_CAN.get(), 1))
                .pattern("a  ")
                .pattern("aaa")
                .pattern(" aa")
                .define('a', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(ItemRegistry.PITCHFORK.get(), 1))
                .pattern("a a")
                .pattern(" a ")
                .pattern(" b ")
                .define('a', Items.IRON_INGOT)
                .define('b', Items.STICK)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.VILLAGER_SCARECROW_BLOCK.get(), 1))
                .pattern(" h ")
                .pattern("shs")
                .pattern(" s ")
                .define('h', Blocks.HAY_BLOCK)
                .define('s', Items.STICK)
                .unlockedBy("has_hay", has(Blocks.HAY_BLOCK))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegistry.CHURN.get(), 1))
                .pattern("s")
                .pattern("h")
                .pattern("h")
                .define('h', ItemTags.PLANKS)
                .define('s', Items.STICK)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(pWriter);

        simpleCookingRecipe(pWriter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, 600, ItemRegistry.GOAT_LEG.get(), ItemRegistry.ROAST_GOAT_LEG.get(), 0.35F);
        simpleCookingRecipe(pWriter, "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100, ItemRegistry.GOAT_LEG.get(), ItemRegistry.ROAST_GOAT_LEG.get(), 0.35F);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistry.GOAT_LEG.get()), RecipeCategory.FOOD, ItemRegistry.ROAST_GOAT_LEG.get(), 0.35F, 200)
                .unlockedBy("has_goat_meat", has(ItemRegistry.GOAT_LEG.get()))
                .save(pWriter);

        simpleCookingRecipe(pWriter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, 600, ItemRegistry.HORSE_MEAT.get(), ItemRegistry.HORSE_HAUNCH.get(), 0.35F);
        simpleCookingRecipe(pWriter, "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100, ItemRegistry.HORSE_MEAT.get(), ItemRegistry.HORSE_HAUNCH.get(), 0.35F);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistry.HORSE_MEAT.get()), RecipeCategory.FOOD, ItemRegistry.HORSE_HAUNCH.get(), 0.35F, 200)
                .unlockedBy("has_horse_meat", has(ItemRegistry.HORSE_MEAT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.DURUM_WHEAT_FLOUR.get(), 2)).requires(ItemRegistry.DURUM_WHEAT.get()).unlockedBy("has_durum_wheat", has(ItemRegistry.DURUM_WHEAT.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.FLOUR.get(), 2)).requires(Items.WHEAT).unlockedBy("has_wheat", has(Items.WHEAT)).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.TOMATO_SOUP.get(), 1)).requires(ItemRegistry.TOMATO.get()).requires(Items.BOWL).unlockedBy("has_tomato", has(ItemRegistry.TOMATO.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.VEGETABLE_SOUP.get(), 1)).requires(FTFTags.VEGETABLES).requires(Items.BOWL).unlockedBy("has_vegetable", has(FTFTags.VEGETABLES)).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.SILK_STRING.get(), 1)).requires(ItemRegistry.UNWOVEN_SILK.get()).requires(Items.STICK).unlockedBy("has_unwoven_silk", has(ItemRegistry.UNWOVEN_SILK.get())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.SILK_HELMET.get(), 1))
                .pattern("sss")
                .pattern("s s")
                .define('s', ItemRegistry.SILK_STRING.get())
                .unlockedBy("has_silk", has(ItemRegistry.SILK_STRING.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.SILK_ROBE.get(), 1))
                .pattern("s s")
                .pattern("sss")
                .pattern("sss")
                .define('s', ItemRegistry.SILK_STRING.get())
                .unlockedBy("has_silk", has(ItemRegistry.SILK_STRING.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.SILK_LEGGINGS.get(), 1))
                .pattern("sss")
                .pattern("s s")
                .pattern("s s")
                .define('s', ItemRegistry.SILK_STRING.get())
                .unlockedBy("has_silk", has(ItemRegistry.SILK_STRING.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.SILK_BOOTS.get(), 1))
                .pattern("s s")
                .pattern("s s")
                .define('s', ItemRegistry.SILK_STRING.get())
                .unlockedBy("has_silk", has(ItemRegistry.SILK_STRING.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(BlockRegistry.SPINNING_WHEEL.get(), 1))
                .pattern(" pp")
                .pattern("tpt")
                .pattern("sss")
                .define('p', ItemTags.PLANKS)
                .define('t', Items.STICK)
                .define('s', ItemTags.WOODEN_SLABS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.BOUQUET.get(), 1)).requires(Items.STRING).requires(Items.PAPER).requires(FTFTags.FLOWERS).requires(FTFTags.FLOWERS).requires(FTFTags.FLOWERS).unlockedBy("has_flowers", has(FTFTags.FLOWERS)).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_SEEDS.get(), 1)).requires(ItemRegistry.PINEAPPLE.get()).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_JUICE.get(), 1)).requires(ItemRegistry.PINEAPPLE.get()).requires(Items.GLASS_BOTTLE).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_CHUNKS.get(), 1)).requires(ItemRegistry.PINEAPPLE_BOTTOM.get()).requires(Items.STICK).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_SLICE.get(), 1)).requires(ItemRegistry.PINEAPPLE_BOTTOM.get()).requires(Items.FLINT).unlockedBy("has_pineapple", has(ItemRegistry.PINEAPPLE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_BOTTOM.get(), 1))
                .pattern(" a ")
                .pattern(" b ")
                .define('a', Items.FLINT)
                .define('b', ItemRegistry.PINEAPPLE.get())
                .unlockedBy("criteria", has(ItemRegistry.PINEAPPLE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.PINEAPPLE_TOP.get(), 1))
                .pattern(" b ")
                .pattern(" a ")
                .define('a', Items.FLINT)
                .define('b', ItemRegistry.PINEAPPLE.get())
                .unlockedBy("criteria", has(ItemRegistry.PINEAPPLE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistry.GOLDEN_PINEAPPLE.get(), 1))
                .pattern("bbb")
                .pattern("bab")
                .pattern("bbb")
                .define('b', Items.GOLD_BLOCK)
                .define('a', ItemRegistry.PINEAPPLE.get())
                .unlockedBy("criteria", has(ItemRegistry.PINEAPPLE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.CABBAGE_POTATO_SOUP.get(), 1)).requires(ItemRegistry.CABBAGE.get()).requires(Items.POTATO).requires(Items.BOWL).unlockedBy("has_cabbage", has(ItemRegistry.CABBAGE.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.CABBAGE_SOUP.get(), 1)).requires(ItemRegistry.CABBAGE.get()).requires(Items.BOWL).unlockedBy("has_cabbage", has(ItemRegistry.CABBAGE.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.BEEF_STEW.get(), 1)).requires(Items.BEEF).requires(Items.BOWL).unlockedBy("has_beef", has(Items.BEEF)).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.APPLE_CABBAGE_STEW.get(), 1)).requires(ItemRegistry.CABBAGE.get()).requires(Items.APPLE).requires(Items.BOWL).unlockedBy("has_cabbage", has(ItemRegistry.CABBAGE.get())).save(pWriter);
    }
}