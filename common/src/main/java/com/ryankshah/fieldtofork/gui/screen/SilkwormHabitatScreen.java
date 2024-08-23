package com.ryankshah.fieldtofork.gui.screen;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.gui.menu.ChurnMenu;
import com.ryankshah.fieldtofork.gui.menu.SilkwormHabitatMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.inventory.FurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;

public class SilkwormHabitatScreen extends AbstractContainerScreen<SilkwormHabitatMenu>
{
    private boolean widthTooNarrow;
    private static final ResourceLocation litProgressSprite = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "container/silkworm_habitat_producing_progress");
    private static final ResourceLocation burnProgressSprite = ResourceLocation.withDefaultNamespace("container/furnace/burn_progress");
    private static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "textures/gui/container/silkworm_habitat.png");


    public SilkwormHabitatScreen(SilkwormHabitatMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);// ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "textures/gui/container/silkworm_habitat.png"));
//        this.imageWidth = 176;
//        this.imageHeight = 166;
        this.titleLabelX = 10;
        this.titleLabelY = 10;
        this.inventoryLabelX = this.imageWidth - 60;
    }

    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
//        this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, (RecipeBookMenu)this.menu);
//        this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
//        this.addRenderableWidget(new ImageButton(this.leftPos + 20, this.height / 2 - 49, 20, 18, RecipeBookComponent.RECIPE_BUTTON_SPRITES, (p_313431_) -> {
//            this.recipeBookComponent.toggleVisibility();
//            this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
//            p_313431_.setPosition(this.leftPos + 20, this.height / 2 - 49);
//        }));
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void containerTick() {
        super.containerTick();
//        this.recipeBookComponent.tick();
    }

    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
//        if (this.recipeBookComponent.isVisible() && this.widthTooNarrow) {
//            this.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
//            this.recipeBookComponent.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
//        } else {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
//        this.recipeBookComponent.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
//        this.recipeBookComponent.renderGhostRecipe(pGuiGraphics, this.leftPos, this.topPos, true, pPartialTick);
//        }

        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
//        this.recipeBookComponent.renderTooltip(pGuiGraphics, this.leftPos, this.topPos, pMouseX, pMouseY);
    }

    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = this.leftPos;
        int j = this.topPos;
        pGuiGraphics.blit(this.texture, i, j, 0, 0, this.imageWidth, this.imageHeight);
        boolean i1;
        int j1;
        if (((SilkwormHabitatMenu)this.menu).isLit()) {
            i1 = true;
            j1 = Mth.ceil(((SilkwormHabitatMenu)this.menu).getLitProgress() * 13.0F) + 1;
            pGuiGraphics.blitSprite(this.litProgressSprite, 14, 14, 0, 14 - j1, i + 56, j + 36 + 14 - j1, 14, j1);
        }

        i1 = true;
        j1 = Mth.ceil(((SilkwormHabitatMenu)this.menu).getBurnProgress() * 24.0F);
        pGuiGraphics.blitSprite(this.burnProgressSprite, 24, 16, 0, 0, i + 79, j + 34, j1, 16);
    }

    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
//        if (this.recipeBookComponent.mouseClicked(pMouseX, pMouseY, pButton)) {
//            return true;
//        } else {
            return super.mouseClicked(pMouseX, pMouseY, pButton);
//        }
    }

    protected void slotClicked(Slot pSlot, int pSlotId, int pMouseButton, ClickType pType) {
        super.slotClicked(pSlot, pSlotId, pMouseButton, pType);
//        this.recipeBookComponent.slotClicked(pSlot);
    }

    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    protected boolean hasClickedOutside(double pMouseX, double pMouseY, int pGuiLeft, int pGuiTop, int pMouseButton) {
        boolean flag = pMouseX < (double)pGuiLeft || pMouseY < (double)pGuiTop || pMouseX >= (double)(pGuiLeft + this.imageWidth) || pMouseY >= (double)(pGuiTop + this.imageHeight);
        return flag;
    }

    public boolean charTyped(char pCodePoint, int pModifiers) {
        return super.charTyped(pCodePoint, pModifiers);
    }

//    public void recipesUpdated() {
//        this.recipeBookComponent.recipesUpdated();
//    }
//
//    public RecipeBookComponent getRecipeBookComponent() {
//        return this.recipeBookComponent;
//    }
}
