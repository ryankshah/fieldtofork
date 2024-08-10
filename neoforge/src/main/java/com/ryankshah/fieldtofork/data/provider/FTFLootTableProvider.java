package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class FTFLootTableProvider implements LootTableSubProvider
{
    private HolderLookup.Provider pRegistries;

    public FTFLootTableProvider(HolderLookup.Provider pRegistries) {
        this.pRegistries = pRegistries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pOutput) {
        LootTable.Builder chestPool = LootTable.lootTable().withPool(LootPool.lootPool()
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
                .add(LootItem.lootTableItem(ItemRegistry.TOMATO_SEEDS.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
                )
                .add(LootItem.lootTableItem(ItemRegistry.GARLIC.get())
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
                )

        );

        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/desert_pyramid")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/simple_dungeon")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/shipwreck_supply")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/jungle_temple")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_savanna_house")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_plains_house")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_desert_house")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_snowy_house")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_taiga_house")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/stronghold_corridor")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/woodland_mansion")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/pillager_outpost")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/buried_treasure")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/abandoned_mineshaft")),
                chestPool
        );

        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "salmon")),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.SALMON_ROE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.45f, 1.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(pRegistries, UniformGenerator.between(0.85F, 1.0F)))
                        )
                )
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "goat")),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.GOAT_LEG.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.875F, 1.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(pRegistries, UniformGenerator.between(1.0F, 2.0F)))
                        )
                )
        );

        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "horse")),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.HORSE_MEAT.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.875F, 1.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(pRegistries, UniformGenerator.between(1.0F, 2.0F)))
                        )
                )
        );
    }
}