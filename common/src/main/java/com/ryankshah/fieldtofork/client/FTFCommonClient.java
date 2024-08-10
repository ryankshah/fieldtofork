package com.ryankshah.fieldtofork.client;

import com.ryankshah.fieldtofork.entity.render.SilkMothRenderer;
import com.ryankshah.fieldtofork.registry.BlockEntityRegistry;
import com.ryankshah.fieldtofork.registry.EntityRegistry;
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
//        Sheets.createSignMaterial(BlockRegistry.PALM);
//        Sheets.createHangingSignMaterial(BlockRegistry.PALM);
    }

    public static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers,
                                         BiConsumer<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider> blockEntityRenderers) {
        blockEntityRenderers.accept(BlockEntityRegistry.PALM_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.PALM_HANGING_SIGN.get(), HangingSignRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.BANANA_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.BANANA_HANGING_SIGN.get(), HangingSignRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.DRAGONFRUIT_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.DRAGONFRUIT_HANGING_SIGN.get(), HangingSignRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.LYCHEE_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.LYCHEE_HANGING_SIGN.get(), HangingSignRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.MANGO_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.MANGO_HANGING_SIGN.get(), HangingSignRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.ORANGE_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.ORANGE_HANGING_SIGN.get(), HangingSignRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.PEAR_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.PEAR_HANGING_SIGN.get(), HangingSignRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.POMEGRANATE_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.POMEGRANATE_HANGING_SIGN.get(), HangingSignRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.MULBERRY_SIGN.get(), SignRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.MULBERRY_HANGING_SIGN.get(), HangingSignRenderer::new);

        entityRenderers.accept(EntityRegistry.SILKMOTH.get(), SilkMothRenderer::new);
    }
}