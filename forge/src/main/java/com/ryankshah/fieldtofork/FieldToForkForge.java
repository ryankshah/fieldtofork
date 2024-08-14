package com.ryankshah.fieldtofork;

import com.ryankshah.fieldtofork.gui.screen.ChurnScreen;
import com.ryankshah.fieldtofork.gui.screen.SilkwormHabitatScreen;
import com.ryankshah.fieldtofork.registry.EntityRegistry;
import com.ryankshah.fieldtofork.registry.MenuRegistry;
import com.ryankshah.fieldtofork.registry.RecipeRegistry;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

@Mod(Constants.MOD_ID)
public final class FieldToForkForge
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Constants.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Constants.MOD_ID);

    public FieldToForkForge() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        ENTITIES.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
        ITEMS.register(modEventBus);
        modEventBus.<EntityAttributeCreationEvent>addListener(event -> EntityRegistry.registerEntityAttributes(event::put));

        FieldToForkCommon.init();

        modEventBus.addListener(FieldToForkForge::commonSetup);
//        modEventBus.addListener(FieldToForkForge::registerScreens);
        modEventBus.addListener(FieldToForkForge::registerRecipeBookCategories);
    }

    private static void registerRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
        event.registerRecipeCategoryFinder(RecipeRegistry.CHURN_RECIPE_TYPE.get(), holder -> RecipeBookCategories.CRAFTING_MISC);
        event.registerRecipeCategoryFinder(RecipeRegistry.SILKWORM_HABITAT.get(), holder -> RecipeBookCategories.CRAFTING_MISC);
    }

    private static void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(FieldToForkCommon::setupTerraBlender);
    }
}