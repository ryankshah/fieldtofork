package com.ryankshah.fieldtofork.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class FTFLootTableProvider implements LootTableSubProvider
{
    private HolderLookup.Provider pRegistries;

    public FTFLootTableProvider(HolderLookup.Provider pRegistries) {
        this.pRegistries = pRegistries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pOutput) {
//        LootTable.Builder chestPool = LootTable.lootTable().withPool(LootPool.lootPool()
//                .setRolls(UniformGenerator.between(0.5F, 2.0F))
//                .add(LootItem.lootTableItem(ItemRegistry.PINEAPPLE.get())
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 1.0F)))
//                )
//                .add(LootItem.lootTableItem(ItemRegistry.PINEAPPLE_SEEDS.get())
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 2.0F)))
//                )
//                .add(LootItem.lootTableItem(ItemRegistry.GOLDEN_PINEAPPLE.get())
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
//                )
//        );
//
//        pOutput.accept(
//                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/desert_pyramid")),
//                chestPool
//        );
//        pOutput.accept(
//                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/simple_dungeon")),
//                chestPool
//        );
//        pOutput.accept(
//                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/shipwreck_supply")),
//                chestPool
//        );
//        pOutput.accept(
//                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/jungle_temple")),
//                chestPool
//        );
//        pOutput.accept(
//                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_savanna_house")),
//                chestPool
//        );
//        pOutput.accept(
//                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_plains_house")),
//                chestPool
//        );
    }
}