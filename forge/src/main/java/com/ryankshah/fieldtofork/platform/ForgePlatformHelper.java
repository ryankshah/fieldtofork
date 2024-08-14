package com.ryankshah.fieldtofork.platform;

import com.ryankshah.fieldtofork.gui.menu.ChurnMenu;
import com.ryankshah.fieldtofork.gui.menu.SilkwormHabitatMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ForgePlatformHelper implements Services {

    @Override
    public String getPlatformName() {
        return "Forge";
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
        return FieldToForkForge.BLOCKS.register(id, block);
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return FieldToForkForge.BLOCK_ENTITIES.register(id, blockEntityType);
    }

    @Override
    public <T extends BlockItem> Supplier<T> registerBlockItem(String id, Supplier<T> block) {
        return FieldToForkForge.ITEMS.register(id, block);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return FieldToForkForge.ITEMS.register(id, item);
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab) {
        return FieldToForkForge.CREATIVE_TABS.register(id, tab);
    }


    @Override
    public MenuType<ChurnMenu> registerChurnMenu() {
        return IForgeMenuType.create(ChurnMenu::new);
    }
    @Override
    public MenuType<SilkwormHabitatMenu> registerSilkwormHabitatMenu() {
        return IForgeMenuType.create(SilkwormHabitatMenu::new);
    }

    @Override
    public void openMenu(ServerPlayer serverPlayer, MenuProvider provider, Consumer<FriendlyByteBuf> buf) {
        serverPlayer.openMenu(provider);
    }

    @Override
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }
}
