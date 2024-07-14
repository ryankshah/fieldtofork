package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.platform.Services;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;

import java.util.ServiceLoader;

public class FieldToForkCommon
{
    public static final Services COMMON_PLATFORM = ServiceLoader.load(Services.class).findFirst().orElseThrow();

    public static void init() {
        BlockRegistry.init();
        ItemRegistry.init();
    }
}