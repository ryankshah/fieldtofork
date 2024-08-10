package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.block.sign.entity.*;
import com.ryankshah.fieldtofork.block.silkworm_habitat.SilkwormHabitatBlockEntity;
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

    public static final Supplier<BlockEntityType<SilkwormHabitatBlockEntity>> SILKWORM_HABITAT = BLOCK_ENTITIES.register("silkworm_habitat", () ->
            BlockEntityType.Builder.of(SilkwormHabitatBlockEntity::new, BlockRegistry.SILKWORM_HABITAT.get()).build(null));

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

    public static final Supplier<BlockEntityType<LycheeSignBlockEntity>> LYCHEE_SIGN = BLOCK_ENTITIES.register("lychee_sign", () ->
            BlockEntityType.Builder.of(LycheeSignBlockEntity::new,
                    BlockRegistry.LYCHEE_SIGN.get(), BlockRegistry.LYCHEE_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<LycheeHangingSignBlockEntity>> LYCHEE_HANGING_SIGN = BLOCK_ENTITIES.register("lychee_hanging_sign", () ->
            BlockEntityType.Builder.of(LycheeHangingSignBlockEntity::new,
                    BlockRegistry.LYCHEE_HANGING_SIGN.get(), BlockRegistry.LYCHEE_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<MangoSignBlockEntity>> MANGO_SIGN = BLOCK_ENTITIES.register("mango_sign", () ->
            BlockEntityType.Builder.of(MangoSignBlockEntity::new,
                    BlockRegistry.MANGO_SIGN.get(), BlockRegistry.MANGO_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<MangoHangingSignBlockEntity>> MANGO_HANGING_SIGN = BLOCK_ENTITIES.register("mango_hanging_sign", () ->
            BlockEntityType.Builder.of(MangoHangingSignBlockEntity::new,
                    BlockRegistry.MANGO_HANGING_SIGN.get(), BlockRegistry.MANGO_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<OrangeSignBlockEntity>> ORANGE_SIGN = BLOCK_ENTITIES.register("orange_sign", () ->
            BlockEntityType.Builder.of(OrangeSignBlockEntity::new,
                    BlockRegistry.ORANGE_SIGN.get(), BlockRegistry.ORANGE_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<OrangeHangingSignBlockEntity>> ORANGE_HANGING_SIGN = BLOCK_ENTITIES.register("orange_hanging_sign", () ->
            BlockEntityType.Builder.of(OrangeHangingSignBlockEntity::new,
                    BlockRegistry.ORANGE_HANGING_SIGN.get(), BlockRegistry.ORANGE_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<PearSignBlockEntity>> PEAR_SIGN = BLOCK_ENTITIES.register("pear_sign", () ->
            BlockEntityType.Builder.of(PearSignBlockEntity::new,
                    BlockRegistry.PEAR_SIGN.get(), BlockRegistry.PEAR_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<PearHangingSignBlockEntity>> PEAR_HANGING_SIGN = BLOCK_ENTITIES.register("pear_hanging_sign", () ->
            BlockEntityType.Builder.of(PearHangingSignBlockEntity::new,
                    BlockRegistry.PEAR_HANGING_SIGN.get(), BlockRegistry.PEAR_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<PomegranateSignBlockEntity>> POMEGRANATE_SIGN = BLOCK_ENTITIES.register("pomegranate_sign", () ->
            BlockEntityType.Builder.of(PomegranateSignBlockEntity::new,
                    BlockRegistry.POMEGRANATE_SIGN.get(), BlockRegistry.POMEGRANATE_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<PomegranateHangingSignBlockEntity>> POMEGRANATE_HANGING_SIGN = BLOCK_ENTITIES.register("pomegranate_hanging_sign", () ->
            BlockEntityType.Builder.of(PomegranateHangingSignBlockEntity::new,
                    BlockRegistry.POMEGRANATE_HANGING_SIGN.get(), BlockRegistry.POMEGRANATE_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<MulberrySignBlockEntity>> MULBERRY_SIGN = BLOCK_ENTITIES.register("mulberry_sign", () ->
            BlockEntityType.Builder.of(MulberrySignBlockEntity::new,
                    BlockRegistry.MULBERRY_SIGN.get(), BlockRegistry.MULBERRY_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<MulberryHangingSignBlockEntity>> MULBERRY_HANGING_SIGN = BLOCK_ENTITIES.register("mulberry_hanging_sign", () ->
            BlockEntityType.Builder.of(MulberryHangingSignBlockEntity::new,
                    BlockRegistry.MULBERRY_HANGING_SIGN.get(), BlockRegistry.MULBERRY_WALL_HANGING_SIGN.get()).build(null));

    
    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntity) {
        return FieldToForkCommon.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
    }
}