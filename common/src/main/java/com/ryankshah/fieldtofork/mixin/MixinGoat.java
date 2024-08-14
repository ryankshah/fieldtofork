package com.ryankshah.fieldtofork.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Goat.class)
public abstract class MixinGoat extends Animal
{
    protected MixinGoat(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @ModifyExpressionValue(method="mobInteract", at=@At(value="FIELD", target="Lnet/minecraft/world/item/Items;MILK_BUCKET:Lnet/minecraft/world/item/Item;"))
    private Item returnGoatMilkBucket(Item original) {
        return ItemRegistry.GOAT_MILK_BUCKET.get();
    }
}