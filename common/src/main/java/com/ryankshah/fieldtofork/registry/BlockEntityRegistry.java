package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.block.sign.entity.PalmHangingSignBlockEntity;
import com.ryankshah.fieldtofork.block.sign.entity.PalmSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public final class BlockEntityRegistry
{
    public static void init() {}

    public static final Supplier<BlockEntityType<PalmSignBlockEntity>> PALM_SIGN = registerBlockEntity("palm_sign", () ->
            BlockEntityType.Builder.of(PalmSignBlockEntity::new,
                    BlockRegistry.PALM_SIGN.get(), BlockRegistry.PALM_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<PalmHangingSignBlockEntity>> PALM_HANGING_SIGN = registerBlockEntity("palm_hanging_sign", () ->
            BlockEntityType.Builder.of(PalmHangingSignBlockEntity::new,
                    BlockRegistry.PALM_HANGING_SIGN.get(), BlockRegistry.PALM_WALL_HANGING_SIGN.get()).build(null));


    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntity) {
        return FieldToForkCommon.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
    }
}