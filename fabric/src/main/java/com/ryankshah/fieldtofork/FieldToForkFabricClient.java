package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.client.FTFCommonClient;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FieldToForkFabricClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient() {
        FTFCommonClient.clientSetup();
        FTFCommonClient.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PALM_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.BANANA_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PALM_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.BANANA_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.DRAGONFRUIT_DOOR.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PALM_SAPLING.get(), RenderType.cutout());
    }
}