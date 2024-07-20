package com.ryankshah.fieldtofork.client;

import com.ryankshah.fieldtofork.registry.BlockEntityRegistry;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;

public class FTFCommonClient
{
    public static void clientSetup() {
        Sheets.createSignMaterial(BlockRegistry.PALM);
        Sheets.createHangingSignMaterial(BlockRegistry.PALM);
    }

    public static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers,
                                         BiConsumer<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider> blockEntityRenderers) {
//        entityRenderers.accept(EntityRegistry.RACE_CAR.get(), RaceCarRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.PALM_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.PALM_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}