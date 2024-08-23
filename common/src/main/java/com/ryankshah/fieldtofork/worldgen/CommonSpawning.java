package com.ryankshah.fieldtofork.worldgen;

import com.ryankshah.fieldtofork.registry.EntityRegistry;
import net.minecraft.world.level.biome.MobSpawnSettings;

import java.util.List;

public class CommonSpawning
{
    public static List<MobSpawnSettings.SpawnerData> MULBERRY_GROVE_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(EntityRegistry.SILKMOTH.get(), 100, 2, 3)
    );
}