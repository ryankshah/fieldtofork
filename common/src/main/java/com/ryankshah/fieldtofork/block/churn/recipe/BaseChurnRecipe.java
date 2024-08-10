package com.ryankshah.fieldtofork.block.churn.recipe;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.RecipeRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface BaseChurnRecipe extends Recipe<ChurnRecipeInput>
{
    default RecipeType<?> getType() {
        return RecipeRegistry.CHURN_RECIPE_TYPE.get();
    }

    default boolean canCraftInDimensions(int width, int height) {
        return width >= 2 && height >= 1;
    }

    default ItemStack getToastSymbol() {
        return new ItemStack(BlockRegistry.CHURN.get());
    }

    boolean isIngredient1(ItemStack stack);

    boolean isIngredient2(ItemStack stack);
}
