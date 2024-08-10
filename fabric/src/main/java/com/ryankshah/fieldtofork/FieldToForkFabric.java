package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.EntityRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class FieldToForkFabric implements ModInitializer
{
    @Override
    public void onInitialize() {
        FieldToForkCommon.init();

        EntityRegistry.registerEntityAttributes(FabricDefaultAttributeRegistry::register);

        LootTableEvents.MODIFY.register((lootTableResourceKey, lootBuilder, lootTableSource) -> {
            if(lootTableSource.isBuiltin() && (
                    lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/desert_pyramid"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/simple_dungeon"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/shipwreck_supply"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/jungle_temple"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/village/village_savanna_house"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/village/village_plains_house"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/village/village_desert_house"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/village/village_snowy_house"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/village/village_taiga_house"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/stronghold_corridor"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/woodland_mansion"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/pillager_outpost"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/buried_treasure"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")))
            )) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0.5F, 4.0F))
                        .add(LootItem.lootTableItem(ItemRegistry.PASSIONFRUIT_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 1.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.ZUCCHINI_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.EGGPLANT_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.GRAPE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.LEEK_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.CHILLI_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.BELL_PEPPER_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.RADISH_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(BlockRegistry.POMEGRANATE_SAPLING.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(BlockRegistry.PALM_SAPLING.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(BlockRegistry.BANANA_SAPLING.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(BlockRegistry.DRAGONFRUIT_SAPLING.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(BlockRegistry.LYCHEE_SAPLING.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(BlockRegistry.PEAR_SAPLING.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(BlockRegistry.MANGO_SAPLING.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        )
                        .add(LootItem.lootTableItem(BlockRegistry.ORANGE_SAPLING.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                        );
                lootBuilder.withPool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((lootTableResourceKey, lootBuilder, lootTableSource) -> {
            if(lootTableSource.isBuiltin() && (lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("goat"))))) {
                lootBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.GOAT_LEG.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.875F, 1.0F)))
                        ));
            }
        });
        LootTableEvents.MODIFY.register((lootTableResourceKey, lootBuilder, lootTableSource) -> {
            if(lootTableSource.isBuiltin() && (lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("horse"))))) {
                lootBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.HORSE_MEAT.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.875F, 1.0F)))
                        ));
            }
        });
        LootTableEvents.MODIFY.register((lootTableResourceKey, lootBuilder, lootTableSource) -> {
            if(lootTableSource.isBuiltin() && (lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("salmon"))))) {
                lootBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.SALMON_ROE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.875F, 1.0F)))
                        ));
            }
        });
    }
}
