package com.ryankshah.fieldtofork.platform;

import com.ryankshah.fieldtofork.FieldToForkNeo;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

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
        DeferredHolder<Block, T> blockSupplier = FieldToForkNeo.BLOCKS.register(id, block);
        FieldToForkNeo.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
        return blockSupplier;
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
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }
}