package com.ryankshah.fieldtofork.gui.screen;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.gui.menu.ChurnMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CyclingSlotBackground;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SmithingTemplateItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class ChurnScreen extends ItemCombinerScreen<ChurnMenu>
{
    private static final ResourceLocation ERROR_SPRITE = ResourceLocation.withDefaultNamespace("container/smithing/error");
    private static final ResourceLocation EMPTY_SLOT_SMITHING_TEMPLATE_ARMOR_TRIM = ResourceLocation.withDefaultNamespace("item/empty_slot_smithing_template_armor_trim");
    private static final ResourceLocation EMPTY_SLOT_SMITHING_TEMPLATE_NETHERITE_UPGRADE = ResourceLocation.withDefaultNamespace("item/empty_slot_smithing_template_netherite_upgrade");
    private static final Component MISSING_TEMPLATE_TOOLTIP = Component.translatable("container.upgrade.missing_template_tooltip");
    private static final Component ERROR_TOOLTIP = Component.translatable("container.upgrade.error_tooltip");
    private static final List<ResourceLocation> EMPTY_SLOT_SMITHING_TEMPLATES;
    private static final int TITLE_LABEL_X = 44;
    private static final int TITLE_LABEL_Y = 15;
    private static final int ERROR_ICON_WIDTH = 28;
    private static final int ERROR_ICON_HEIGHT = 21;
    private static final int ERROR_ICON_X = 65;
    private static final int ERROR_ICON_Y = 46;
    private static final int TOOLTIP_WIDTH = 115;
    private final CyclingSlotBackground templateIcon = new CyclingSlotBackground(0);
    private final CyclingSlotBackground baseIcon = new CyclingSlotBackground(1);
    @Nullable
    private ArmorStand armorStandPreview;

    public ChurnScreen(ChurnMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "textures/gui/container/churn.png"));
//        this.imageWidth = 176;
//        this.imageHeight = 166;
        this.titleLabelX = 10;
        this.titleLabelY = 10;
        this.inventoryLabelX = this.imageWidth - 60;
    }

    public void containerTick() {
        super.containerTick();
//        Optional<SmithingTemplateItem> optional = this.getTemplateItem();
        this.templateIcon.tick(List.of()); //EMPTY_SLOT_SMITHING_TEMPLATES
        this.baseIcon.tick(List.of()); //(List)optional.map(SmithingTemplateItem::getBaseSlotEmptyIcons).orElse(List.of())
    }

    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderOnboardingTooltips(pGuiGraphics, pMouseX, pMouseY);
    }

    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        super.renderBg(pGuiGraphics, pPartialTick, pMouseX, pMouseY);
        this.templateIcon.render(this.menu, pGuiGraphics, pPartialTick, this.leftPos, this.topPos);
        this.baseIcon.render(this.menu, pGuiGraphics, pPartialTick, this.leftPos, this.topPos);
    }

    public void slotChanged(AbstractContainerMenu pContainerToSend, int pSlotInd, ItemStack pStack) {
    }

    protected void renderErrorIcon(GuiGraphics pGuiGraphics, int pX, int pY) {
        if (this.hasRecipeError()) {
            pGuiGraphics.blitSprite(ERROR_SPRITE, pX + 65, pY + 46, 28, 21);
        }

    }

    private void renderOnboardingTooltips(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        Optional<Component> optional = Optional.empty();
        if (this.hasRecipeError() && this.isHovering(65, 46, 28, 21, (double)pMouseX, (double)pMouseY)) {
            optional = Optional.of(ERROR_TOOLTIP);
        }

        if (this.hoveredSlot != null) {
            ItemStack itemstack = ((ChurnMenu)this.menu).getSlot(0).getItem();
            ItemStack itemstack1 = this.hoveredSlot.getItem();
            if (itemstack.isEmpty()) {
                if (this.hoveredSlot.index == 0) {
                    optional = Optional.of(MISSING_TEMPLATE_TOOLTIP);
                }
            } else {
                Item var8 = itemstack.getItem();
                if (var8 instanceof SmithingTemplateItem) {
                    SmithingTemplateItem smithingtemplateitem = (SmithingTemplateItem)var8;
                    if (itemstack1.isEmpty()) {
                        if (this.hoveredSlot.index == 1) {
                            optional = Optional.of(smithingtemplateitem.getBaseSlotDescription());
                        }
                    }
                }
            }
        }

        optional.ifPresent((p_280863_) -> {
            pGuiGraphics.renderTooltip(this.font, this.font.split(p_280863_, 115), pMouseX, pMouseY);
        });
    }

    private boolean hasRecipeError() {
        return ((ChurnMenu)this.menu).getSlot(0).hasItem() && ((ChurnMenu)this.menu).getSlot(1).hasItem() && !((ChurnMenu)this.menu).getSlot(((ChurnMenu)this.menu).getResultSlot()).hasItem();
    }

    static {
        EMPTY_SLOT_SMITHING_TEMPLATES = List.of(EMPTY_SLOT_SMITHING_TEMPLATE_ARMOR_TRIM, EMPTY_SLOT_SMITHING_TEMPLATE_NETHERITE_UPGRADE);
    }
}
