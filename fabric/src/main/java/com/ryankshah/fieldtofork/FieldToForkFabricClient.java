package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.client.FTFCommonClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FieldToForkFabricClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient() {
        FTFCommonClient.clientSetup();
        FTFCommonClient.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);
    }
}