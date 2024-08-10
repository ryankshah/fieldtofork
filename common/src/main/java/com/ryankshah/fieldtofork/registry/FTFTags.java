package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class FTFTags
{
    public static void init() {}

    public static final TagKey<Item> BELL_PEPPERS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "bell_peppers"));
    public static final TagKey<Item> GRAPES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "grapes"));
    public static final TagKey<Item> VEGETABLES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "vegetables"));
    public static final TagKey<Item> FRUITS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fruits"));

}