package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import com.ryankshah.fieldtofork.worldgen.LocProcessor;
import com.ryankshah.fieldtofork.worldgen.PalmTreeFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

import java.util.function.Supplier;

public class WorldGenRegistry
{
    public static void init() {}

    public static final RegistrationProvider<Feature<?>> FEATURES = RegistrationProvider.get(Registries.FEATURE, Constants.MOD_ID);
    public static final RegistrationProvider<StructureProcessorType<?>> STRUCTURE_PROCESSOR_TYPES = RegistrationProvider.get(Registries.STRUCTURE_PROCESSOR, Constants.MOD_ID);

    public static final Supplier<StructureProcessorType<?>> LOC_PROCESSOR = STRUCTURE_PROCESSOR_TYPES.register("loc_processor",
            () -> StructureProcessorType.register(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "loc_processor").toString(), LocProcessor.MAP_CODEC));

    public static final Supplier<Feature<?>> PALM_TREE_F = FEATURES.register("palm_tree_f", () -> new PalmTreeFeature(TreeConfiguration.CODEC));
}