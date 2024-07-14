package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class FieldToForkFabric implements ModInitializer
{
    @Override
    public void onInitialize() {
        FieldToForkCommon.init();

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PINEAPPLE_BLOCK.get(), RenderType.cutout());

        LootTableEvents.MODIFY.register((lootTableResourceKey, lootBuilder, lootTableSource) -> {
            if(lootTableSource.isBuiltin() && (
                    lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/desert_pyramid"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/simple_dungeon"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/shipwreck_supply"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/jungle_temple"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/village/village_savanna_house"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/village/village_plains_house")))
            )) {
                LootPool.Builder poolBuilder = LootPool.lootPool().setRolls(UniformGenerator.between(0.5F, 2.0F))
                        .add(LootItem.lootTableItem(ItemRegistry.PINEAPPLE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 1.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.PINEAPPLE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.GOLDEN_PINEAPPLE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
                        );
                lootBuilder.pool(poolBuilder.build());
            }
        });
    }
}
