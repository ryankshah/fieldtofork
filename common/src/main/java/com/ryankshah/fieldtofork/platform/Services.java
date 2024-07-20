package com.ryankshah.fieldtofork.platform;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.platform.services.IPlatformHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ServiceLoader;
import java.util.function.Supplier;

public interface Services
{
    String getPlatformName();

    boolean isModLoaded(String modId);

    boolean isDevelopmentEnvironment();

    <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block);
    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType);
    <T extends BlockItem> Supplier<T> registerBlockItem(String id, Supplier<T> block);
    <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item);
    <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab);

    CreativeModeTab.Builder newCreativeTabBuilder();

    IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}