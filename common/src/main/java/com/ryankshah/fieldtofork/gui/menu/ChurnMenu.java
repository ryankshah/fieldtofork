package com.ryankshah.fieldtofork.gui.menu;

import com.ryankshah.fieldtofork.block.churn.recipe.ChurnRecipe;
import com.ryankshah.fieldtofork.block.churn.recipe.ChurnRecipeInput;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.MenuRegistry;
import com.ryankshah.fieldtofork.registry.RecipeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.OptionalInt;

public class ChurnMenu extends ItemCombinerMenu
{
    public static final int INGREDIENT_1_SLOT = 0;
    public static final int INGREDIENT_2_SLOT = 1;
    public static final int RESULT_SLOT = 2;
    public static final int INGREDIENT_1_SLOT_X_PLACEMENT = 49;
    public static final int INGREDIENT_1_SLOT_Y_PLACEMENT = 34;
    public static final int INGREDIENT_2_SLOT_X_PLACEMENT = 49;
    public static final int INGREDIENT_2_SLOT_Y_PLACEMENT = 55;
    private static final int RESULT_SLOT_X_PLACEMENT = 129;
    public static final int RESULT_SLOY_Y_PLACEMENT = 39;
    private final Level level;
    @Nullable
    private RecipeHolder<ChurnRecipe> selectedRecipe;
    private final List<RecipeHolder<ChurnRecipe>> recipes;

    public ChurnMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL);
    }

    public ChurnMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(MenuRegistry.CHURN_MENU.get(), containerId, playerInventory, access);
        this.level = playerInventory.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(RecipeRegistry.CHURN_RECIPE_TYPE.get());
    }

    public ChurnMenu(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        super(MenuRegistry.CHURN_MENU.get(), i, inventory, ContainerLevelAccess.NULL);
        this.level = inventory.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(RecipeRegistry.CHURN_RECIPE_TYPE.get());
    }

    public ChurnMenu(int i, Inventory inventory, FriendlyByteBuf o) {
        this(i, inventory);
    }

    public ChurnMenu(int i, Inventory inventory, Object o) {
        this(i, inventory);
    }

    protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create().withSlot(INGREDIENT_1_SLOT, INGREDIENT_1_SLOT_X_PLACEMENT, INGREDIENT_1_SLOT_Y_PLACEMENT, (itemStack) -> {
            return this.recipes.stream().anyMatch((recipeHolder) -> {
                return ((ChurnRecipe)recipeHolder.value()).isIngredient1(itemStack);
            });
        }).withSlot(INGREDIENT_2_SLOT, INGREDIENT_2_SLOT_X_PLACEMENT, INGREDIENT_2_SLOT_Y_PLACEMENT, (itemStack) -> {
            return this.recipes.stream().anyMatch((recipeHolder) -> {
                return ((ChurnRecipe)recipeHolder.value()).isIngredient2(itemStack);
            });
        }).withResultSlot(RESULT_SLOT, RESULT_SLOT_X_PLACEMENT, RESULT_SLOY_Y_PLACEMENT).build();
    }

    protected boolean isValidBlock(BlockState state) {
        return state.is(BlockRegistry.CHURN.get());
    }

    protected boolean mayPickup(Player player, boolean hasStack) {
        return this.selectedRecipe != null && ((ChurnRecipe)this.selectedRecipe.value()).matches(this.createRecipeInput(), this.level);
    }

    protected void onTake(Player player, ItemStack stack) {
        stack.onCraftedBy(player.level(), player, stack.getCount());
        this.resultSlots.awardUsedRecipes(player, this.getRelevantItems());
        this.shrinkStackInSlot(0);
        this.shrinkStackInSlot(1);
//        this.shrinkStackInSlot(2);
        this.access.execute((level, blockPos) -> {
            level.levelEvent(1044, blockPos, 0);
        });
    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.inputSlots.getItem(0), this.inputSlots.getItem(1));
    }

    private ChurnRecipeInput createRecipeInput() {
        return new ChurnRecipeInput(this.inputSlots.getItem(0), this.inputSlots.getItem(1));
    }

    private void shrinkStackInSlot(int index) {
        ItemStack itemStack = this.inputSlots.getItem(index);
        if (!itemStack.isEmpty()) {
            itemStack.shrink(1);
            this.inputSlots.setItem(index, itemStack);
        }

    }

    public void createResult() {
        ChurnRecipeInput smithingRecipeInput = this.createRecipeInput();
        List<RecipeHolder<ChurnRecipe>> list = this.level.getRecipeManager().getRecipesFor(RecipeRegistry.CHURN_RECIPE_TYPE.get(), smithingRecipeInput, this.level);
        if (list.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            RecipeHolder<ChurnRecipe> recipeHolder = (RecipeHolder)list.get(0);
            ItemStack itemStack = ((ChurnRecipe)recipeHolder.value()).assemble(smithingRecipeInput, this.level.registryAccess());
            if (itemStack.isItemEnabled(this.level.enabledFeatures())) {
                this.selectedRecipe = recipeHolder;
                this.resultSlots.setRecipeUsed(recipeHolder);
                this.resultSlots.setItem(0, itemStack);
            }
        }

    }

    public int getSlotToQuickMoveTo(ItemStack stack) {
        return this.findSlotToQuickMoveTo(stack).orElse(0);
    }

    private static OptionalInt findSlotMatchingIngredient(ChurnRecipe recipe, ItemStack stack) {
        if (recipe.isIngredient1(stack)) {
            return OptionalInt.of(0);
        } else if (recipe.isIngredient2(stack)) {
            return OptionalInt.of(1);
        } else {
            return OptionalInt.empty();
        }
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultSlots && super.canTakeItemForPickAll(stack, slot);
    }

    public boolean canMoveIntoInputSlots(ItemStack stack) {
        return this.findSlotToQuickMoveTo(stack).isPresent();
    }

    private OptionalInt findSlotToQuickMoveTo(ItemStack stack) {
        return this.recipes.stream().flatMapToInt((recipeHolder) -> {
            return findSlotMatchingIngredient((ChurnRecipe)recipeHolder.value(), stack).stream();
        }).filter((i) -> {
            return !this.getSlot(i).hasItem();
        }).findFirst();
    }
}
