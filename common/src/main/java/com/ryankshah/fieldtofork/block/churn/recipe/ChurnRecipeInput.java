package com.ryankshah.fieldtofork.block.churn.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record ChurnRecipeInput(ItemStack input1, ItemStack input2) implements RecipeInput
{
    public ChurnRecipeInput(ItemStack input1, ItemStack input2) {
        this.input1 = input1;
        this.input2 = input2;
    }

    public ItemStack getItem(int p_346205_) {
        ItemStack var10000;
        switch (p_346205_) {
            case 0:
                var10000 = this.input1;
                break;
            case 1:
                var10000 = this.input2;
                break;
            default:
                throw new IllegalArgumentException("Recipe does not contain slot " + p_346205_);
        }

        return var10000;
    }

    public int size() {
        return 2;
    }

    public boolean isEmpty() {
        return this.input1.isEmpty() && this.input2.isEmpty();
    }

    public ItemStack input1() {
        return this.input1;
    }

    public ItemStack input2() {
        return this.input2;
    }
}
