package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.gui.menu.ChurnMenu;
import com.ryankshah.fieldtofork.gui.menu.SilkwormHabitatMenu;
import com.ryankshah.fieldtofork.platform.Services;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import com.ryankshah.fieldtofork.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class MenuRegistry
{
    public static void init() {}

    public static final RegistrationProvider<MenuType<?>> MENU_TYPES = RegistrationProvider.get(Registries.MENU, Constants.MOD_ID);
    public static final RegistryObject<MenuType<?>, MenuType<ChurnMenu>> CHURN_MENU = MENU_TYPES.register("churn", FieldToForkCommon.COMMON_PLATFORM::registerChurnMenu); //(new MenuType<>(ChurnMenu::new, FeatureFlags.DEFAULT_FLAGS))); // MenuType.register("churn", ChurnMenu::new));
    public static final RegistryObject<MenuType<?>, MenuType<SilkwormHabitatMenu>> SILKWORM_HABITAT = MENU_TYPES.register("silkworm_habitat", FieldToForkCommon.COMMON_PLATFORM::registerSilkwormHabitatMenu); //(new MenuType<>(ChurnMenu::new, FeatureFlags.DEFAULT_FLAGS))); // MenuType.register("churn", ChurnMenu::new));

}