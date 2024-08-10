package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class FTFLootModifierProvider extends GlobalLootModifierProvider
{
    public FTFLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, registries, modid);
    }

    @Override
    protected void start() {
        this.add("chests/desert_pyramid", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/desert_pyramid")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/desert_pyramid"))
        ));
        this.add("chests/simple_dungeon", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/simple_dungeon")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/simple_dungeon"))
        ));
        this.add("chests/shipwreck_supply", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_supply")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/shipwreck_supply"))
        ));
        this.add("chests/jungle_temple", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/jungle_temple"))
        ));
        this.add("chests/village/village_savanna_house", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_savanna_house")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_savanna_house"))
        ));
        this.add("chests/village/village_plains_house", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_plains_house")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_plains_house"))
        ));
        this.add("chests/village/village_desert_house", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_desert_house")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_desert_house"))
        ));
        this.add("chests/village/village_snowy_house", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_snowy_house")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_snowy_house"))
        ));
        this.add("chests/village/village_taiga_house", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_taiga_house")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/village/village_taiga_house"))
        ));
        this.add("chests/stronghold_corridor", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/stronghold_corridor")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/stronghold_corridor"))
        ));
        this.add("chests/woodland_mansion", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/woodland_mansion")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/woodland_mansion"))
        ));
        this.add("chests/pillager_outpost", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/pillager_outpost")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/pillager_outpost"))
        ));
        this.add("chests/buried_treasure", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/buried_treasure")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/buried_treasure"))
        ));
        this.add("chests/abandoned_mineshaft", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/abandoned_mineshaft"))
        ));

        this.add("salmon",
                new AddTableLootModifier(
                        new LootItemCondition[] {
                                LootItemKilledByPlayerCondition.killedByPlayer()
                                        .and(LootItemEntityPropertyCondition.hasProperties(
                                                LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().of(EntityType.SALMON)
                                        )).build()
                        },
                        ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "salmon"))
                )
        );

        this.add("goat",
                new AddTableLootModifier(
                        new LootItemCondition[] {
                                LootItemKilledByPlayerCondition.killedByPlayer()
                                        .and(LootItemEntityPropertyCondition.hasProperties(
                                                LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().of(EntityType.GOAT)
                                        )).build()
                        },
                        ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "goat"))
                )
        );

        this.add("horse",
                new AddTableLootModifier(
                        new LootItemCondition[] {
                                LootItemKilledByPlayerCondition.killedByPlayer()
                                        .and(LootItemEntityPropertyCondition.hasProperties(
                                                LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().of(EntityType.HORSE)
                                        )).build()
                        },
                        ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "horse"))
                )
        );
    }
}