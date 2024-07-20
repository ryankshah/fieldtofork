package com.ryankshah.fieldtofork;


import com.mojang.serialization.MapCodec;
import com.ryankshah.fieldtofork.data.provider.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@Mod(Constants.MOD_ID)
public class FieldToForkNeo
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Constants.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MOD_ID);
    public static DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddTableLootModifier>> ADD_TABLE_LOOT_MODIFIER_TYPE;

    public FieldToForkNeo(IEventBus eventBus) {
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(eventBus);
        ADD_TABLE_LOOT_MODIFIER_TYPE = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("add_table", () -> AddTableLootModifier.CODEC);

        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
        ITEMS.register(eventBus);
        CREATIVE_TABS.register(eventBus);

        FieldToForkCommon.init();

        eventBus.addListener(FieldToForkNeo::gatherData);
    }

    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            generator.addProvider(true, new FTFLangProvider(output, Constants.MOD_ID, "en_us"));
            generator.addProvider(true,  new FTFItemModelProvider(output, existingFileHelper));
            generator.addProvider(true, new FTFBlockStateProvider(output, Constants.MOD_ID, existingFileHelper));
            generator.addProvider(true, new FTFBlockTagsProvider(output, event.getLookupProvider(), Constants.MOD_ID, existingFileHelper));
            generator.addProvider(true, new FTFLootTables(output, event.getLookupProvider()));
            generator.addProvider(true, new FTFRecipeProvider(output, event.getLookupProvider()));
            generator.addProvider(true, new FTFLootModifierProvider(output, event.getLookupProvider(), Constants.MOD_ID));
        } catch (RuntimeException e) {
            Constants.LOG.error("Failed to generate data", e);
        }
    }
//    @SubscribeEvent
//    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
//        // Is this the tab we want to add to?
//        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
//            event.accept(ItemRegistry.MY_ITEM.get());
//            // Accepts an ItemLike. This assumes that MY_BLOCK has a corresponding item.
//            event.accept(BlockRegistry.PINEAPPLE_BLOCK.get());
//        }
//    }
}