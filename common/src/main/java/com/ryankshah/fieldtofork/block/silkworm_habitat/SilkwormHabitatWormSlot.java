package com.ryankshah.fieldtofork.block.silkworm_habitat;

import com.ryankshah.fieldtofork.gui.menu.SilkwormHabitatMenu;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class SilkwormHabitatWormSlot extends Slot
{
    private final SilkwormHabitatMenu menu;

    public SilkwormHabitatWormSlot(SilkwormHabitatMenu pFurnaceMenu, Container pFurnaceContainer, int pSlot, int pXPosition, int pYPosition) {
        super(pFurnaceContainer, pSlot, pXPosition, pYPosition);
        this.menu = pFurnaceMenu;
    }

    public boolean mayPlace(ItemStack pStack) {
        return this.menu.isFuel(pStack);
    }

    public int getMaxStackSize(ItemStack pStack) {
        return super.getMaxStackSize(pStack);
    }
}
