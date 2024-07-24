package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.worldgen.PalmTreeFeature;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FossilFeature;
import net.minecraft.world.level.levelgen.feature.FossilFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FTFWorldGenProvider extends DatapackBuiltinEntriesProvider
{
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FTFWorldGenProvider::spawns)
            .add(Registries.CONFIGURED_FEATURE, FTFWorldGenProvider::configuredFeature)
            .add(Registries.PLACED_FEATURE, FTFWorldGenProvider::placedFeatures)
            .add(Registries.BIOME, FTFWorldGenProvider::biomes);
    private static final ResourceKey<BiomeModifier> OVERWORLD = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "overworld_ftf_spawns"));


    public FTFWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(Constants.MOD_ID));
    }

    public static void spawns(BootstrapContext<BiomeModifier> context) {
//        context.register(OVERWORLD,
//                new BiomeModifiers.AddSpawnsBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_OVERWORLD), CommonSpawning.OVERWORLD_SPAWNS)
//        );
    }

    public static void configuredFeature(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(FieldToForkCommon.PALM_TREE_CF_RK, new ConfiguredFeature<>(
                new PalmTreeFeature(TreeConfiguration.CODEC),
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockRegistry.PALM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        new ForkingTrunkPlacer(5, 2, 4),
                        BlockStateProvider.simple(BlockRegistry.PALM_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//                    new TwoLayersFeatureSize(1, 0, 2)
                        new ThreeLayersFeatureSize(4, 4, 1, 1, 2, OptionalInt.of(3))
                ).build()
        ));
    }

    public static void placedFeatures(BootstrapContext<PlacedFeature> context) {
        context.register(FieldToForkCommon.PALM_TREE_RK, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).get(FieldToForkCommon.PALM_TREE_CF_RK).get(),
                        List.of(
                                CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(10), 9)
                                        .add(ConstantInt.of(11), 1)
                                        .build())),
                                InSquarePlacement.spread(),
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                                BiomeFilter.biome(),
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BlockRegistry.PALM_SAPLING.get().defaultBlockState(), Vec3i.ZERO))
                        )
                )
        );
    }

    public static void biomes(BootstrapContext<Biome> context) {
//        MobSpawnSettings.Builder sOFBuilder = new MobSpawnSettings.Builder();
//        context.register(CommonClass.SPOOKY_OAK_FOREST,
//                new Biome.BiomeBuilder()
//                        .specialEffects(
//                                new BiomeSpecialEffects.Builder()
//                                        .skyColor(11826993)
//                                        .fogColor(14126598)
//                                        .waterColor(11948056)
//                                        .waterFogColor(11948056)
//                                        .grassColorOverride(15237409)
//                                        .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.DARK_FOREST)
//                                        .build()
//                        )
//                        .hasPrecipitation(true)
//                        .temperature(0.7F)
//                        .downfall(0.8F)
//                        .mobSpawnSettings(
//                                sOFBuilder.build()
//                        )
//                        .generationSettings(
//                                baseSettings(context)
//                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(CommonClass.SPOOKY_OAK_TREE).get()).build()
//                        ).build()
//        );
//        MobSpawnSettings.Builder pFBuilder = new MobSpawnSettings.Builder();
//        CommonSpawning.WHITE_PINE_FOREST_SPAWNS.forEach(spawnerData -> pFBuilder.addSpawn(MobCategory.MONSTER, spawnerData));
//        context.register(CommonClass.CHRISTMAS_FOREST,
//                new Biome.BiomeBuilder()
//                        .specialEffects(
//                                new BiomeSpecialEffects.Builder()
//                                        .skyColor(calculateSkyColor(-0.5f))
//                                        .fogColor(12638463)
//                                        .waterColor(4020182)
//                                        .waterFogColor(329011)
//                                        .grassColorOverride(1668352)
//                                        .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
//                                        .build()
//                        )
//                        .hasPrecipitation(true)
//                        .temperature(-0.5F)
//                        .downfall(1.0F)
//                        .mobSpawnSettings(
//                                pFBuilder.build()
//                        )
//                        .generationSettings(
//                                baseSettings(context)
//                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(CommonClass.WHITE_PINE_TREE).get())
//                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(CommonClass.DECORATED_WHITE_PINE_TREE).get())
//                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(CommonClass.DECORATED_MEGA_WHITE_PINE_TREE).get())
//                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE).get(CommonClass.MEGA_WHITE_PINE_TREE).get())
//                                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, context.lookup(Registries.PLACED_FEATURE).get(MiscOverworldPlacements.FREEZE_TOP_LAYER).get()).build()
//                        ).build()
//        );
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
}