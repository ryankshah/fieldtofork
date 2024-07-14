package com.ryankshah.fieldtofork.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class FTFLootModifierProvider extends GlobalLootModifierProvider
{
    public FTFLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, registries, modid);
    }

    @Override
    protected void start() {
//        this.add("chests/desert_pyramid", new AddTableLootModifier(
//                new LootItemCondition[] {
//                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/desert_pyramid")).build()
//                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/desert_pyramid"))
//        ));
//        this.add("chests/simple_dungeon", new AddTableLootModifier(
//                new LootItemCondition[] {
//                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/simple_dungeon")).build()
//                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/simple_dungeon"))
//        ));
//        this.add("chests/shipwreck_supply", new AddTableLootModifier(
//                new LootItemCondition[] {
//                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_supply")).build()
//                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/shipwreck_supply"))
//        ));
//        this.add("chests/jungle_temple", new AddTableLootModifier(
//                new LootItemCondition[] {
//                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
//                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/jungle_temple"))
//        ));
//        this.add("chests/village/village_savanna_house", new AddTableLootModifier(
//                new LootItemCondition[] {
//                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_savanna_house")).build()
//                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_savanna_house"))
//        ));
//        this.add("chests/village/village_plains_house", new AddTableLootModifier(
//                new LootItemCondition[] {
//                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_plains_house")).build()
//                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_plains_house"))
//        ));
    }
}