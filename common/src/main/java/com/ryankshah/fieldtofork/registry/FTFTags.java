package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class FTFTags
{
    public static void init() {}

    public static final TagKey<Item> BELL_PEPPERS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "bell_peppers"));
    public static final TagKey<Item> GRAPES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "grapes"));
    public static final TagKey<Item> VEGETABLES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "vegetables"));
    public static final TagKey<Item> FRUITS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fruits"));

    public static final TagKey<Block> FLOWER_BLOCKS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flower_blocks"));
    public static final TagKey<Item> FLOWERS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flowers"));

//    public static final TagKey<Biome> CAN_SPAWN_SILK_MOTHS = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "can_spawn_silk_moths"));
}