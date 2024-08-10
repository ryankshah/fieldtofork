package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.client.FTFCommonClient;
import com.ryankshah.fieldtofork.gui.screen.ChurnScreen;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.MenuRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.screen.ScreenEventFactory;
import net.fabricmc.fabric.impl.client.screen.ScreenExtensions;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FieldToForkFabricClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient() {
        FTFCommonClient.clientSetup();

//        Screen.register(MenuRegistry.CHURN_MENU.get(), ChurnScreen::new);

        MenuScreens.register(MenuRegistry.CHURN_MENU.get(), ChurnScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PALM_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.BANANA_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.LYCHEE_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.MANGO_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ORANGE_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PEAR_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.POMEGRANATE_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.MULBERRY_TRAPDOOR.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PALM_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.BANANA_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.DRAGONFRUIT_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.LYCHEE_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.MANGO_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ORANGE_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PEAR_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.POMEGRANATE_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.MULBERRY_DOOR.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ZUCCHINI_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CHILLI_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.BELL_PEPPER_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.EGGPLANT_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.LEEK_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.RADISH_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ASPARAGUS_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.SWEET_POTATO_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PASSIONFRUIT_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.GRAPE_CROP.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.VILLAGER_SCARECROW_BLOCK.get(), RenderType.cutout());

        FTFCommonClient.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);
    }
}