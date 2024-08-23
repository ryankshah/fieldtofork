package com.ryankshah.fieldtofork.platform;

import com.ryankshah.fieldtofork.FieldToForkNeo;
import com.ryankshah.fieldtofork.gui.menu.ChurnMenu;
import com.ryankshah.fieldtofork.gui.menu.SilkwormHabitatMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class NeoForgePlatformHelper implements Services {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return FieldToForkNeo.BLOCKS.register(id, block);
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return FieldToForkNeo.BLOCK_ENTITIES.register(id, blockEntityType);
    }

    @Override
    public <T extends BlockItem> Supplier<T> registerBlockItem(String id, Supplier<T> block) {
        return FieldToForkNeo.ITEMS.register(id, block);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return FieldToForkNeo.ITEMS.register(id, item);
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab) {
        return FieldToForkNeo.CREATIVE_TABS.register(id, tab);
    }

    @Override
    public MenuType<ChurnMenu> registerChurnMenu() {
        return IMenuTypeExtension.create(ChurnMenu::new);
    }
    @Override
    public MenuType<SilkwormHabitatMenu> registerSilkwormHabitatMenu() {
        return new MenuType<>(SilkwormHabitatMenu::new, FeatureFlags.DEFAULT_FLAGS); //IMenuTypeExtension.create(SilkwormHabitatMenu::new);
    }

    @Override
    public void openMenu(ServerPlayer serverPlayer, MenuProvider provider, Consumer<RegistryFriendlyByteBuf> buf) {
        serverPlayer.openMenu(provider, buf);
    }

    @Override
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }
}