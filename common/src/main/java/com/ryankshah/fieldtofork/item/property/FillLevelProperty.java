package com.ryankshah.fieldtofork.item.property;

import com.ryankshah.fieldtofork.item.WateringCan;
import com.ryankshah.fieldtofork.registry.DataComponentRegistry;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

//TODO: Register on both neo and fabric sides and then use in model properties for watering can item model
public class FillLevelProperty implements ItemPropertyFunction
{
    @Override
    public float call(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i) {
        if (!itemStack.has((DataComponentType<?>) itemStack.get(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get())) || itemStack.get(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get()).getCurrentFillLevel() < 0)
            return WateringCan.EMPTY;
        return itemStack.get(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get()).getCurrentFillLevel(); // itemStack.getOrDefault(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get(), WateringCan.EMPTY);
    }
}