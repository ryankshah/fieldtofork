package com.ryankshah.fieldtofork.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.registry.WorldGenRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.*;

import java.util.function.Consumer;

public class FTFOverworldRegion extends Region
{
    public static final ResourceLocation LOCATION = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "main_overworld");

    public FTFOverworldRegion(int weight) {
        super(LOCATION, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.WARM, ParameterUtils.Temperature.HOT))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.ARID))
                .continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.COAST, ParameterUtils.Continentalness.NEAR_INLAND))
                .erosion(ParameterUtils.Erosion.EROSION_1, ParameterUtils.Erosion.EROSION_5)
                .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.span(ParameterUtils.Weirdness.LOW_SLICE_NORMAL_DESCENDING, ParameterUtils.Weirdness.LOW_SLICE_VARIANT_ASCENDING))
                .build().forEach(point -> builder.add(point, WorldGenRegistry.PALM_BEACH));

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.NEUTRAL))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET))
                .continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.NEAR_INLAND, ParameterUtils.Continentalness.FAR_INLAND))
                .erosion(ParameterUtils.Erosion.EROSION_1, ParameterUtils.Erosion.EROSION_6)
                .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.VALLEY, ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING)
                .build().forEach(point -> builder.add(point, WorldGenRegistry.FRUIT_FOREST));

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.NEUTRAL))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET))
                .continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.NEAR_INLAND, ParameterUtils.Continentalness.FAR_INLAND))
                .erosion(ParameterUtils.Erosion.EROSION_1, ParameterUtils.Erosion.EROSION_6)
                .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.VALLEY, ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING)
                .build().forEach(point -> builder.add(point, WorldGenRegistry.MULBERRY_GROVE));

        // Add our points to the mapper
        builder.build().forEach(mapper);

//        ModifiedVanillaOverworldBuilder builder1 = new ModifiedVanillaOverworldBuilder();
//        addModifiedVanillaOverworldBiomes(mapper, b -> builder1.build());
    }
}