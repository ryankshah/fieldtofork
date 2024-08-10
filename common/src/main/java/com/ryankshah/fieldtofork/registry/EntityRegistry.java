package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.entity.SilkMoth;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import com.ryankshah.fieldtofork.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;

import java.util.function.BiConsumer;

public class EntityRegistry
{
    public static void init() {}

    public static final RegistrationProvider<EntityType<?>> ENTITIES = RegistrationProvider.get(Registries.ENTITY_TYPE, Constants.MOD_ID);

    public static final RegistryObject<EntityType<?>, EntityType<SilkMoth>> SILKMOTH = ENTITIES.register("silkmoth", () -> EntityType.Builder.of(SilkMoth::new, MobCategory.CREATURE).sized(0.7f, 1.3f).build("silkmoth"));


    public static void registerEntityAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeSupplier> registrar) {
        AttributeSupplier.Builder genericAttribs = PathfinderMob.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.FLYING_SPEED, 1);
        AttributeSupplier.Builder genericMovingAttribs = PathfinderMob.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.25f);
        AttributeSupplier.Builder genericMonsterAttribs = Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.ATTACK_KNOCKBACK, 0.1);

        registrar.accept(EntityRegistry.SILKMOTH.get(), genericAttribs.build());
    }
}