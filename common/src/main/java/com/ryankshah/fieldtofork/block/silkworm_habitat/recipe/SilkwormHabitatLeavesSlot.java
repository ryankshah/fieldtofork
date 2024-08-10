package com.ryankshah.fieldtofork.block.silkworm_habitat.recipe;

import com.ryankshah.fieldtofork.gui.menu.SilkwormHabitatMenu;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SilkwormHabitatLeavesSlot extends Slot
{
    private final SilkwormHabitatMenu menu;

    public SilkwormHabitatLeavesSlot(SilkwormHabitatMenu pFurnaceMenu, Container pFurnaceContainer, int pSlot, int pXPosition, int pYPosition) {
        super(pFurnaceContainer, pSlot, pXPosition, pYPosition);
        this.menu = pFurnaceMenu;
    }

    public boolean mayPlace(ItemStack pStack) {
        return this.menu.isLeaves(pStack);
    }

    public int getMaxStackSize(ItemStack pStack) {
        return super.getMaxStackSize(pStack);
    }
}
