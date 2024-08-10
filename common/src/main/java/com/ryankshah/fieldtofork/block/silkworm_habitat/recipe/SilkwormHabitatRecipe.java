package com.ryankshah.fieldtofork.block.silkworm_habitat.recipe;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.RecipeRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.Blocks;

public class SilkwormHabitatRecipe extends AbstractCookingRecipe
{
    public SilkwormHabitatRecipe(String pGroup, CookingBookCategory pCategory, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
        super(RecipeRegistry.SILKWORM_HABITAT.get(), pGroup, pCategory, pIngredient, pResult, pExperience, pCookingTime);
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(BlockRegistry.SILKWORM_HABITAT.get());
    }

    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.SILKWORM_HABITAT_SERIALIZER.get();
    }
}
