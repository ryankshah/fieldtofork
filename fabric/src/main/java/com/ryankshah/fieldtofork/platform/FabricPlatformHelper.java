package com.ryankshah.fieldtofork.platform;

import com.ryankshah.fieldtofork.Constants;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Supplier;

public class FabricPlatformHelper implements Services {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        Supplier<T> blockSupplier = registerSupplier(BuiltInRegistries.BLOCK, id, block);
        registerBlockItem(id, () -> new BlockItem(block.get(), new Item.Properties()));
        return blockSupplier;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return registerSupplier(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, blockEntityType);
    }

    @Override
    public <T extends BlockItem> Supplier<T> registerBlockItem(String id, Supplier<T> block) {
        return registerSupplier(BuiltInRegistries.ITEM, id, block);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return registerSupplier(BuiltInRegistries.ITEM, id, item);
    }

    /**
     * Quick wrapper to make the individual registration lines cleaner but still return the multiloader-compatible supplier
     */
    private static <T, R extends Registry<? super T>> Supplier<T> registerSupplier(R registry, String id, Supplier<T> object) {
        final T registeredObject = Registry.register((Registry<T>)registry, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id), object.get());

        return () -> registeredObject;
    }

    /**
     * Quick wrapper to make the individual registration lines cleaner but still return the multiloader-compatible supplier
     */
    private static <T, R extends Registry<? super T>> Holder<T> registerHolder(R registry, String id, Supplier<T> object) {
        return Registry.registerForHolder((Registry<T>)registry, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id), object.get());
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab) {
        return registerSupplier(BuiltInRegistries.CREATIVE_MODE_TAB, id, tab);
    }

    @Override
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return FabricItemGroup.builder();
    }
}
