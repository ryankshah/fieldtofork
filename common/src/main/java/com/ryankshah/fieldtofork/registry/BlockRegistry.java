package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.block.FTFDoorBlock;
import com.ryankshah.fieldtofork.block.FTFTrapdoorBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Supplier;

public class BlockRegistry
{
    public static void init() {}

    public static final Supplier<RotatedPillarBlock> PALM_LOG = registerBlock("palm_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> PALM_PLANKS = registerBlock("palm_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFDoorBlock> PALM_DOOR = registerBlock("palm_door", () -> new FTFDoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor", () -> new FTFTrapdoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));

//    public static final Supplier<BlockItem> PALM_DOOR_ITEM = registerBlockItem("palm_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.PALM_DOOR.get(), new Item.Properties())));

    private static <T extends BlockItem> Supplier<T> registerBlockItem(String id, Supplier<T> blockitem) {
        return FieldToForkCommon.COMMON_PLATFORM.registerBlockItem(id, blockitem);
    }

    private static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return FieldToForkCommon.COMMON_PLATFORM.registerBlock(id, block);
    }

    public static final Supplier<CreativeModeTab> BLOCKS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_blocks", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".blocks"))
            .icon(() -> new ItemStack(BlockRegistry.PALM_LOG.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(new ItemStack(BlockRegistry.PALM_LOG.get())); //asItem?
                entries.accept(new ItemStack(BlockRegistry.PALM_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_TRAPDOOR.get()));
            })
            .build());
}