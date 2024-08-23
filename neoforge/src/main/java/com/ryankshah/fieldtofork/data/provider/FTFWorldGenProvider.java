package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.FTFTags;
import com.ryankshah.fieldtofork.registry.WorldGenRegistry;
import com.ryankshah.fieldtofork.worldgen.CommonSpawning;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FTFWorldGenProvider extends DatapackBuiltinEntriesProvider
{
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, FTFWorldGenProvider::configuredFeature)
            .add(Registries.PLACED_FEATURE, FTFWorldGenProvider::placedFeatures)
            .add(Registries.BIOME, FTFWorldGenProvider::biomes)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FTFWorldGenProvider::spawns);

    private static final ResourceKey<BiomeModifier> OVERWORLD = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "overworld_ftf_spawns"));

    public FTFWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(Constants.MOD_ID));
    }

    public static void spawns(BootstrapContext<BiomeModifier> context) {
        context.register(OVERWORLD,
                new BiomeModifiers.AddSpawnsBiomeModifier(HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(WorldGenRegistry.MULBERRY_GROVE)), CommonSpawning.MULBERRY_GROVE_SPAWNS)
        );
    }

    public static void configuredFeature(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(WorldGenRegistry.PALM_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.PALM_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.PALM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.PALM_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
        context.register(WorldGenRegistry.BANANA_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.BANANA_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.BANANA_TREE_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.BANANA_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
        context.register(WorldGenRegistry.DRAGONFRUIT_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.DRAGONFRUIT_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.DRAGONFRUIT_TREE_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.DRAGONFRUIT_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
        context.register(WorldGenRegistry.LYCHEE_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.LYCHEE_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.LYCHEE_TREE_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.LYCHEE_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
        context.register(WorldGenRegistry.MANGO_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.MANGO_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.MANGO_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.MANGO_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
        context.register(WorldGenRegistry.ORANGE_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.ORANGE_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.ORANGE_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.ORANGE_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
        context.register(WorldGenRegistry.PEAR_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.PEAR_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.PEAR_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.PEAR_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
        context.register(WorldGenRegistry.POMEGRANATE_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.POMEGRANATE_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.POMEGRANATE_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.POMEGRANATE_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
        context.register(WorldGenRegistry.MULBERRY_TREE_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.MULBERRY_TREE_F.get(),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.MULBERRY_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.MULBERRY_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));

        context.register(WorldGenRegistry.FLOWERS_CF_RK, new ConfiguredFeature<>(
                WorldGenRegistry.FLOWERS_F.get(),
                new RandomPatchConfiguration(32, 3, 3,
                PlacementUtils.onlyWhenEmpty(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                new NoiseProvider(
                                        2345L,
                                        new NormalNoise.NoiseParameters(0, 1.0),
                                        0.020833334F,
                                        List.of(
                                                BlockRegistry.IRIS_FLOWER.get().defaultBlockState(),
                                                BlockRegistry.CROCUS_VERNUS.get().defaultBlockState(),
                                                BlockRegistry.CROCUS_FLAVUS.get().defaultBlockState(),
                                                BlockRegistry.DAFFODIL.get().defaultBlockState()
                                        )
                                )
                        )))));
    }

    public static void placedFeatures(BootstrapContext<PlacedFeature> context) {
        context.register(WorldGenRegistry.PALM_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.PALM_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.PALM_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
        context.register(WorldGenRegistry.BANANA_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.BANANA_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.BANANA_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
        context.register(WorldGenRegistry.DRAGONFRUIT_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.DRAGONFRUIT_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.DRAGONFRUIT_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
        context.register(WorldGenRegistry.LYCHEE_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.LYCHEE_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.LYCHEE_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
        context.register(WorldGenRegistry.MANGO_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.MANGO_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.MANGO_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
        context.register(WorldGenRegistry.ORANGE_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.ORANGE_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.ORANGE_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
        context.register(WorldGenRegistry.PEAR_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.PEAR_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.PEAR_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
        context.register(WorldGenRegistry.POMEGRANATE_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.POMEGRANATE_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.POMEGRANATE_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
        context.register(WorldGenRegistry.MULBERRY_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.MULBERRY_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(3), 3)
                                        .add(ConstantInt.of(4), 7)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.MULBERRY_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );

        context.register(WorldGenRegistry.FLOWERS_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(WorldGenRegistry.FLOWERS_CF_RK).get(),
                List.of(
                        RarityFilter.onAverageOnceEvery(24),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                )
        ));
    }

    public static void biomes(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder pbBuilder = new MobSpawnSettings.Builder();
        context.register(WorldGenRegistry.PALM_BEACH,
                new Biome.BiomeBuilder()
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .skyColor(7907327)
                                        .fogColor(12638463)
                                        .waterColor(4159204)
                                        .waterFogColor(329011)
                                        .build()
                        )
                        .hasPrecipitation(false)
                        .temperature(2F)
                        .downfall(0F)
                        .mobSpawnSettings(
                                pbBuilder.build()
                        )
                        .generationSettings(
                                palmBeachSettings(context)
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.PALM_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.FREEZE_TOP_LAYER).get()).build()
                        ).build()
        );

        MobSpawnSettings.Builder ffBuilder = new MobSpawnSettings.Builder();
        context.register(WorldGenRegistry.FRUIT_FOREST,
                new Biome.BiomeBuilder()
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .skyColor(8103167)
                                        .fogColor(12638463)
                                        .waterColor(6141935)
                                        .waterFogColor(6141935)
                                        .grassColorOverride(11983713)
                                        .foliageColorOverride(11983713)
                                        .build()
                        )
                        .hasPrecipitation(true)
                        .temperature(0.5F)
                        .downfall(0.8F)
                        .mobSpawnSettings(
                                ffBuilder.build()
                        )
                        .generationSettings(
                                baseSettings(context)
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.BANANA_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.DRAGONFRUIT_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.LYCHEE_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.MANGO_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.ORANGE_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.PEAR_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.POMEGRANATE_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.FLOWERS_RK).get())
                                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.FREEZE_TOP_LAYER).get()).build()
                        ).build()
        );

        MobSpawnSettings.Builder mbBuilder = new MobSpawnSettings.Builder();
        CommonSpawning.MULBERRY_GROVE_SPAWNS.forEach(spawnerData -> mbBuilder.addSpawn(MobCategory.CREATURE, spawnerData)); //mbBuilder.addSpawn(MobCategory.CREATURE, CommonSpawning.MULBERRY_GROVE_SPAWNS.);
        context.register(WorldGenRegistry.MULBERRY_GROVE,
                new Biome.BiomeBuilder()
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .skyColor(8103167)
                                        .fogColor(12638463)
                                        .waterColor(6141935)
                                        .waterFogColor(6141935)
                                        .grassColorOverride(11983713)
                                        .foliageColorOverride(11983713)
                                        .build()
                        )
                        .hasPrecipitation(true)
                        .temperature(0.5F)
                        .downfall(0.8F)
                        .mobSpawnSettings(
                                mbBuilder.build()
                        )
                        .generationSettings(
                                baseSettings(context)
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.MULBERRY_TREE_RK).get())
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(WorldGenRegistry.FLOWERS_RK).get())
                                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.FREEZE_TOP_LAYER).get()).build()
                        ).build()
        );
    }

    protected static int calculateSkyColor(float pTemperature) {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    public static BiomeGenerationSettings.PlainBuilder baseSettings(BootstrapContext<Biome> context) {
        return new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                .addFeature(GenerationStep.Decoration.LAKES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND).get())
                .addFeature(GenerationStep.Decoration.LAKES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.LAKE_LAVA_SURFACE).get())
                .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, context.lookup(Registries.PLACED_FEATURE).get(CavePlacements.AMETHYST_GEODE).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIRT).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GRAVEL).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GRANITE_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GRANITE_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIORITE_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIORITE_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_ANDESITE_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_ANDESITE_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_TUFF).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_COAL_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_COAL_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_IRON_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_IRON_MIDDLE).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_IRON_SMALL).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GOLD).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GOLD_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_REDSTONE).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_REDSTONE_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIAMOND).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIAMOND_LARGE).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIAMOND_BURIED).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_LAPIS).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_LAPIS_BURIED).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_COPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(CavePlacements.UNDERWATER_MAGMA).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.DISK_SAND).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.DISK_CLAY).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.DISK_GRAVEL).get())
                .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.SPRING_WATER).get())
                .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.SPRING_LAVA).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(CavePlacements.GLOW_LICHEN).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(VegetationPlacements.FOREST_FLOWERS).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(VegetationPlacements.FLOWER_DEFAULT).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(VegetationPlacements.PATCH_GRASS_FOREST).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(VegetationPlacements.BROWN_MUSHROOM_NORMAL).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(VegetationPlacements.RED_MUSHROOM_NORMAL).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(VegetationPlacements.PATCH_SUGAR_CANE).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(VegetationPlacements.PATCH_PUMPKIN).get());
    }

    public static BiomeGenerationSettings.PlainBuilder palmBeachSettings(BootstrapContext<Biome> context) {
        return new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                .addFeature(GenerationStep.Decoration.LAKES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND).get())
                .addFeature(GenerationStep.Decoration.LAKES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.LAKE_LAVA_SURFACE).get())
                .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, context.lookup(Registries.PLACED_FEATURE).get(CavePlacements.AMETHYST_GEODE).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIRT).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GRAVEL).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GRANITE_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GRANITE_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIORITE_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIORITE_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_ANDESITE_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_ANDESITE_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_TUFF).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_COAL_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_COAL_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_IRON_UPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_IRON_MIDDLE).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_IRON_SMALL).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GOLD).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_GOLD_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_REDSTONE).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_REDSTONE_LOWER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIAMOND).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIAMOND_LARGE).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_DIAMOND_BURIED).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_LAPIS).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_LAPIS_BURIED).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(OrePlacements.ORE_COPPER).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(CavePlacements.UNDERWATER_MAGMA).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.DISK_SAND).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.DISK_CLAY).get())
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.DISK_GRAVEL).get())
                .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.SPRING_WATER).get())
                .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.SPRING_LAVA).get())
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(VegetationPlacements.PATCH_GRASS_BADLANDS).get());
    }
}