package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.client.FTFCommonClient;
import com.ryankshah.fieldtofork.gui.screen.ChurnScreen;
import com.ryankshah.fieldtofork.gui.screen.SilkwormHabitatScreen;
import com.ryankshah.fieldtofork.registry.MenuRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class FieldToForkForgeClient
{
    SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
//            Sheets.addWoodType(BlockRegistry.PALM);
//            Sheets.createSignMaterial(BlockRegistry.PALM);
//            Sheets.createHangingSignMaterial(BlockRegistry.PALM);
            FTFCommonClient.clientSetup();

            // TODO: If there is ever RegUtils forge support
//            MenuScreens.register(MenuRegistry.CHURN_MENU.get(), ChurnScreen::new);
//            MenuScreens.register(MenuRegistry.SILKWORM_HABITAT.get(), SilkwormHabitatScreen::new);
        });
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        FTFCommonClient.registerRenderers(event::registerEntityRenderer, event::registerBlockEntityRenderer);
    }
}