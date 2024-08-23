package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.platform.Services;
import com.ryankshah.fieldtofork.registry.*;
import com.ryankshah.fieldtofork.worldgen.biome.FTFOverworldRegion;
import com.ryankshah.fieldtofork.worldgen.surface_rule.PalmBeachSurfaceRule;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.ServiceLoader;

/**
 * TODO:
 * - Fix Scarecrow and Churn models by making them into two separate half blocks to fix lighting issue
 * - Method for gathering salt - i.e. feature on beaches/desert??
 * - Fix biomes and potentially add more to make tree variants more sparse
 * - Wheelbarrow
 * - Birds for scarecrow to scare away
 * - Pasta/pizza using durum wheat
 * - Cucumber and plant
 * - Basil and plant
 * - Sweetcorn and Plant
 * - Broccoli and plant
 * - Lettuce and plant
 * - add more flowers
 */
public class FieldToForkCommon
{
    public static final Services COMMON_PLATFORM = ServiceLoader.load(Services.class).findFirst().orElseThrow();

    public static void init() {
        MenuRegistry.init();
        ItemRegistry.init();
        DataComponentRegistry.init();
        BlockRegistry.init();
        BlockEntityRegistry.init();
        EntityRegistry.init();
        RecipeRegistry.init();
        WorldGenRegistry.init();
        FTFTags.init();
    }

    public static void setupTerraBlender() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Constants.MOD_ID, PalmBeachSurfaceRule.makeRules());
        Regions.register(new FTFOverworldRegion(4)); //5
    }
}