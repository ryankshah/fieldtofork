package com.ryankshah.fieldtofork.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.datacomponent.WateringCanFillLevelDataComponent;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.function.Supplier;

public class DataComponentRegistry
{
    public static void init() {}

    public static final RegistrationProvider<DataComponentType<?>> DATA_COMPONENTS = RegistrationProvider.get(Registries.DATA_COMPONENT_TYPE, Constants.MOD_ID);

    public static final Codec<WateringCanFillLevelDataComponent> FILL_LEVEL_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("currentFillLevel").forGetter(WateringCanFillLevelDataComponent::getCurrentFillLevel),
                    Codec.INT.fieldOf("maxFillLevel").forGetter(WateringCanFillLevelDataComponent::getMaxFillLevel)
            ).apply(instance, WateringCanFillLevelDataComponent::new)
    );
    public static final StreamCodec<ByteBuf, WateringCanFillLevelDataComponent> FILL_LEVEL_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, WateringCanFillLevelDataComponent::getCurrentFillLevel,
            ByteBufCodecs.INT, WateringCanFillLevelDataComponent::getMaxFillLevel,
            WateringCanFillLevelDataComponent::new
    );
    public static final Supplier<DataComponentType<WateringCanFillLevelDataComponent>> WATERING_CAN_FILL_LEVEL = DATA_COMPONENTS.register("watering_can", () ->
            DataComponentType.<WateringCanFillLevelDataComponent>builder()
                    .persistent(FILL_LEVEL_CODEC).networkSynchronized(FILL_LEVEL_STREAM_CODEC).build());

//    public static final Supplier<BlockEntityType<PalmSignBlockEntity>> PALM_SIGN = BLOCK_ENTITIES.register("palm_sign", () ->
//            BlockEntityType.Builder.of(PalmSignBlockEntity::new,
//                    BlockRegistry.PALM_SIGN.get(), BlockRegistry.PALM_WALL_SIGN.get()).build(null));
}