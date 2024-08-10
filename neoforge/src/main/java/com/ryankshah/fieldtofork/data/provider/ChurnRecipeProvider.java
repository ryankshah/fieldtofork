package com.ryankshah.fieldtofork.data.provider;

import com.google.common.collect.Sets;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.block.churn.recipe.ChurnRecipe;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.WithConditions;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ChurnRecipeProvider implements DataProvider, IConditionBuilder {
    protected final PackOutput.PathProvider recipePathProvider;
    protected final CompletableFuture<HolderLookup.Provider> lookupProvider;

    public ChurnRecipeProvider(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        this.recipePathProvider = p_248933_.createPathProvider(PackOutput.Target.DATA_PACK, "recipe");
        this.lookupProvider = lookupProvider;
    }

    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        pRecipeOutput.accept(
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, BuiltInRegistries.ITEM.getKey(ItemRegistry.BUTTER.get()).getPath()),
                new ChurnRecipe(
                            Ingredient.of(new ItemStack(ItemRegistry.SALT.get(), 1)),
                            Ingredient.of(new ItemStack(Items.MILK_BUCKET, 1)),
                            new ItemStack(ItemRegistry.BUTTER.get(), 1)
                ),
                null
        );
    }

    @Override
    public CompletableFuture<?> run(CachedOutput pOutput) {
        return this.lookupProvider.thenCompose((provider) -> {
            final Set<ResourceLocation> set = Sets.newHashSet();
            final List<CompletableFuture<?>> list = new ArrayList<>();
            this.buildRecipes(new RecipeOutput() {
                @Override
                public Advancement.Builder advancement() {
                    return null;
                }

                public void accept(ResourceLocation p_312039_, Recipe<?> p_312254_, @Nullable AdvancementHolder p_311794_, ICondition... conditions) {
                    if (!set.add(p_312039_)) {
                        throw new IllegalStateException("Duplicate recipe " + p_312039_);
                    } else {
                        list.add(DataProvider.saveStable(pOutput, provider, Recipe.CONDITIONAL_CODEC, Optional.of(new WithConditions(p_312254_, conditions)), ChurnRecipeProvider.this.recipePathProvider.json(p_312039_)));
                    }
                }
            });
            return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
        });
    }

    @Override
    public String getName() {
        return Constants.MOD_ID + " Churn Recipes";
    }
}