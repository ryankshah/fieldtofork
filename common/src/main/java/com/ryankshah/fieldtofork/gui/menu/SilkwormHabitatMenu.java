package com.ryankshah.fieldtofork.gui.menu;

import com.ryankshah.fieldtofork.block.churn.recipe.ChurnRecipe;
import com.ryankshah.fieldtofork.block.churn.recipe.ChurnRecipeInput;
import com.ryankshah.fieldtofork.block.silkworm_habitat.SilkwormHabitat;
import com.ryankshah.fieldtofork.block.silkworm_habitat.SilkwormHabitatBlockEntity;
import com.ryankshah.fieldtofork.block.silkworm_habitat.SilkwormHabitatResultSlot;
import com.ryankshah.fieldtofork.block.silkworm_habitat.SilkwormHabitatWormSlot;
import com.ryankshah.fieldtofork.block.silkworm_habitat.recipe.SilkwormHabitatLeavesSlot;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.MenuRegistry;
import com.ryankshah.fieldtofork.registry.RecipeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.OptionalInt;

public class SilkwormHabitatMenu extends RecipeBookMenu<SingleRecipeInput, AbstractCookingRecipe>
{
    public static final int INGREDIENT_SLOT = 0;
    public static final int FUEL_SLOT = 1;
    public static final int RESULT_SLOT = 2;
    public static final int SLOT_COUNT = 3;
    public static final int DATA_COUNT = 4;
    private static final int INV_SLOT_START = 3;
    private static final int INV_SLOT_END = 30;
    private static final int USE_ROW_SLOT_START = 30;
    private static final int USE_ROW_SLOT_END = 39;
    private final Container container;
    protected ContainerLevelAccess access;
    private final ContainerData data;
    protected Level level;
    private final RecipeType<? extends AbstractCookingRecipe> recipeType;
    private final RecipeBookType recipeBookType;

    public SilkwormHabitatMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL);
    }

    public SilkwormHabitatMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        this(MenuRegistry.SILKWORM_HABITAT.get(), RecipeRegistry.SILKWORM_HABITAT.get(), RecipeBookType.FURNACE, containerId, playerInventory, new SimpleContainer(3), new SimpleContainerData(4));
        this.access = access;
        this.level = playerInventory.player.level();
    }

    protected SilkwormHabitatMenu(MenuType<?> pMenuType, RecipeType<? extends AbstractCookingRecipe> pRecipeType, RecipeBookType pRecipeBookType, int pContainerId, Inventory pPlayerInventory, Container pContainer, ContainerData pData) {
        super(pMenuType, pContainerId);
        this.recipeType = pRecipeType;
        this.recipeBookType = pRecipeBookType;
        checkContainerSize(pContainer, 3);
        checkContainerDataCount(pData, 4);
        this.container = pContainer;
        this.data = pData;
        this.level = pPlayerInventory.player.level();
        this.addSlot(new SilkwormHabitatLeavesSlot(this, pContainer, 0, 56, 17));
        this.addSlot(new SilkwormHabitatWormSlot(this, pContainer, 1, 56, 53));
        this.addSlot(new SilkwormHabitatResultSlot(pPlayerInventory.player, pContainer, 2, 116, 35));

        int k;
        for(k = 0; k < 3; ++k) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(pPlayerInventory, j + k * 9 + 9, 8 + j * 18, 84 + k * 18));
            }
        }

        for(k = 0; k < 9; ++k) {
            this.addSlot(new Slot(pPlayerInventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(pData);
    }

    public SilkwormHabitatMenu(int i, Inventory inventory, Recipe<?> recipe) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

    public void fillCraftSlotsStackedContents(StackedContents pItemHelper) {
        if (this.container instanceof StackedContentsCompatible) {
            ((StackedContentsCompatible)this.container).fillStackedContents(pItemHelper);
        }

    }

    public void clearCraftingContent() {
        this.getSlot(0).set(ItemStack.EMPTY);
        this.getSlot(2).set(ItemStack.EMPTY);
    }

    public boolean recipeMatches(RecipeHolder<AbstractCookingRecipe> pRecipe) {
        return ((AbstractCookingRecipe)pRecipe.value()).matches(new SingleRecipeInput(this.container.getItem(0)), this.level);
    }

    public int getResultSlotIndex() {
        return 2;
    }

    public int getGridWidth() {
        return 1;
    }

    public int getGridHeight() {
        return 1;
    }

    public int getSize() {
        return 3;
    }

    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex == 2) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (pIndex != 1 && pIndex != 0) {
                if (this.canSmelt(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 3 && pIndex < 30) {
                    if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 30 && pIndex < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
        }

        return itemstack;
    }

    public static SilkwormHabitatMenu getClientMenu(int id, Inventory playerInventory) {
        return new SilkwormHabitatMenu(MenuRegistry.SILKWORM_HABITAT.get(), RecipeRegistry.SILKWORM_HABITAT.get(), RecipeBookType.FURNACE, id, playerInventory, new SimpleContainer(3), new SimpleContainerData(4));
    }

    public static MenuProvider getServerMenuProvider(SilkwormHabitatBlockEntity te)
    {
        return new SimpleMenuProvider((id, playerInventory, serverPlayer) ->
                new SilkwormHabitatMenu(MenuRegistry.SILKWORM_HABITAT.get(), RecipeRegistry.SILKWORM_HABITAT.get(),
                        RecipeBookType.FURNACE, id, playerInventory, te, te.getContainerData()),
                SilkwormHabitat.CONTAINER_TITLE);
    }

    protected boolean canSmelt(ItemStack pStack) {
        return this.level.getRecipeManager().getRecipeFor(this.recipeType, new SingleRecipeInput(pStack), this.level).isPresent();
    }

    public boolean isFuel(ItemStack pStack) {
        return SilkwormHabitatBlockEntity.getFuel().containsKey(pStack.getItem());
    }

    public boolean isLeaves(ItemStack pStack) {
        return pStack.getItem() == SilkwormHabitatBlockEntity.getLeaves();
    }

    public float getBurnProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? Mth.clamp((float)i / (float)j, 0.0F, 1.0F) : 0.0F;
    }

    public float getLitProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return Mth.clamp((float)this.data.get(0) / (float)i, 0.0F, 1.0F);
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }

    public RecipeBookType getRecipeBookType() {
        return this.recipeBookType;
    }

    public boolean shouldMoveToInventory(int pSlotIndex) {
        return pSlotIndex != 1;
    }
}