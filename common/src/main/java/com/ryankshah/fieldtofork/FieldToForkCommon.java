package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.platform.Services;
import com.ryankshah.fieldtofork.registry.BlockEntityRegistry;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import com.ryankshah.fieldtofork.registry.WorldGenRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.ServiceLoader;

public class FieldToForkCommon
{
    public static final Services COMMON_PLATFORM = ServiceLoader.load(Services.class).findFirst().orElseThrow();

    public static final ResourceKey<PlacedFeature> PALM_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "palm_tree"));
    public static final ResourceKey<ConfiguredFeature<?,?>> PALM_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "palm_tree"));


    public static void init() {
        BlockRegistry.init();
        BlockEntityRegistry.init();
        ItemRegistry.init();
        WorldGenRegistry.init();
    }
}