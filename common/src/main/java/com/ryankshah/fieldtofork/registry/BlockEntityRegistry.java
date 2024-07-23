package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.block.sign.entity.*;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public final class BlockEntityRegistry
{
    public static void init() {}

    public static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);

    public static final Supplier<BlockEntityType<PalmSignBlockEntity>> PALM_SIGN = BLOCK_ENTITIES.register("palm_sign", () ->
            BlockEntityType.Builder.of(PalmSignBlockEntity::new,
                    BlockRegistry.PALM_SIGN.get(), BlockRegistry.PALM_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<PalmHangingSignBlockEntity>> PALM_HANGING_SIGN = BLOCK_ENTITIES.register("palm_hanging_sign", () ->
            BlockEntityType.Builder.of(PalmHangingSignBlockEntity::new,
                    BlockRegistry.PALM_HANGING_SIGN.get(), BlockRegistry.PALM_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<BananaSignBlockEntity>> BANANA_SIGN = BLOCK_ENTITIES.register("banana_sign", () ->
            BlockEntityType.Builder.of(BananaSignBlockEntity::new,
                    BlockRegistry.BANANA_SIGN.get(), BlockRegistry.BANANA_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<BananaHangingSignBlockEntity>> BANANA_HANGING_SIGN = BLOCK_ENTITIES.register("banana_hanging_sign", () ->
            BlockEntityType.Builder.of(BananaHangingSignBlockEntity::new,
                    BlockRegistry.BANANA_HANGING_SIGN.get(), BlockRegistry.BANANA_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<DragonfruitSignBlockEntity>> DRAGONFRUIT_SIGN = BLOCK_ENTITIES.register("dragonfruit_sign", () ->
            BlockEntityType.Builder.of(DragonfruitSignBlockEntity::new,
                    BlockRegistry.DRAGONFRUIT_SIGN.get(), BlockRegistry.DRAGONFRUIT_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<DragonfruitHangingSignBlockEntity>> DRAGONFRUIT_HANGING_SIGN = BLOCK_ENTITIES.register("dragonfruit_hanging_sign", () ->
            BlockEntityType.Builder.of(DragonfruitHangingSignBlockEntity::new,
                    BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get(), BlockRegistry.DRAGONFRUIT_WALL_HANGING_SIGN.get()).build(null));

    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntity) {
        return FieldToForkCommon.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
    }
}