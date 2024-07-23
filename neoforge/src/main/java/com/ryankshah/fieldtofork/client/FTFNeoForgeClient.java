package com.ryankshah.fieldtofork.client;

import com.ryankshah.fieldtofork.Constants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public final class FTFNeoForgeClient
{
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
//            Sheets.addWoodType(BlockRegistry.PALM);
//            Sheets.createSignMaterial(BlockRegistry.PALM);
//            Sheets.createHangingSignMaterial(BlockRegistry.PALM);
            FTFCommonClient.clientSetup();
        });
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        FTFCommonClient.registerRenderers(event::registerEntityRenderer, event::registerBlockEntityRenderer);
    }
}