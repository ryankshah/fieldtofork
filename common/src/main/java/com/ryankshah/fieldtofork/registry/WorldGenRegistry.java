package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import com.ryankshah.fieldtofork.worldgen.feature.*;
import com.ryankshah.fieldtofork.worldgen.processor.LocProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

import java.util.function.Supplier;

public class WorldGenRegistry
{
    public static void init() {}

    public static final ResourceKey<PlacedFeature> PALM_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "palm_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> PALM_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "palm_tree_cf"));

    public static final ResourceKey<PlacedFeature> BANANA_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "banana_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> BANANA_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "banana_tree_cf"));

    public static final ResourceKey<PlacedFeature> DRAGONFRUIT_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonfruit_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DRAGONFRUIT_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonfruit_tree_cf"));

    public static final ResourceKey<PlacedFeature> LYCHEE_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "lychee_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> LYCHEE_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "lychee_tree_cf"));

    public static final ResourceKey<PlacedFeature> MANGO_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mango_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> MANGO_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mango_tree_cf"));

    public static final ResourceKey<PlacedFeature> ORANGE_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orange_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> ORANGE_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orange_tree_cf"));

    public static final ResourceKey<PlacedFeature> PEAR_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "pear_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> PEAR_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "pear_tree_cf"));

    public static final ResourceKey<PlacedFeature> POMEGRANATE_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "pomegranate_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> POMEGRANATE_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "pomegranate_tree_cf"));

    public static final ResourceKey<PlacedFeature> MULBERRY_TREE_RK = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mulberry_tree_pf"));
    public static final ResourceKey<ConfiguredFeature<?,?>> MULBERRY_TREE_CF_RK = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mulberry_tree_cf"));


    public static final RegistrationProvider<Feature<?>> FEATURES = RegistrationProvider.get(Registries.FEATURE, Constants.MOD_ID);
    public static final RegistrationProvider<StructureProcessorType<?>> STRUCTURE_PROCESSOR_TYPES = RegistrationProvider.get(Registries.STRUCTURE_PROCESSOR, Constants.MOD_ID);
    public static final Supplier<StructureProcessorType<?>> LOC_PROCESSOR = STRUCTURE_PROCESSOR_TYPES.register("loc_processor",
            () -> StructureProcessorType.register(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "loc_processor_type").toString(), LocProcessor.MAP_CODEC));

    public static final Supplier<Feature<TreeConfiguration>> PALM_TREE_F = FEATURES.register("palm_tree", () -> new PalmTreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> BANANA_TREE_F = FEATURES.register("banana_tree", () -> new BananaTreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> DRAGONFRUIT_TREE_F = FEATURES.register("dragonfruit_tree", () -> new DragonfruitTreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> LYCHEE_TREE_F = FEATURES.register("lychee_tree", () -> new LycheeTreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> MANGO_TREE_F = FEATURES.register("mango_tree", () -> new MangoTreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> ORANGE_TREE_F = FEATURES.register("orange_tree", () -> new OrangeTreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> PEAR_TREE_F = FEATURES.register("pear_tree", () -> new PearTreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> POMEGRANATE_TREE_F = FEATURES.register("pomegranate_tree", () -> new PomegranateTreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> MULBERRY_TREE_F = FEATURES.register("mulberry_tree", () -> new MulberryTreeFeature(TreeConfiguration.CODEC));
}