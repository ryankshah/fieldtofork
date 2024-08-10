package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.registry.EntityRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class FTFEntityLootProvider extends EntityLootSubProvider
{
    public FTFEntityLootProvider(HolderLookup.Provider provider) {
        super(FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    public void generate() {
        this.add(EntityRegistry.SILKMOTH.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(ItemRegistry.SILKWORM_EGGS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(1.0F, 2.0F))))));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return EntityRegistry.ENTITIES.getEntries().stream().map(Supplier::get);
    }
}
