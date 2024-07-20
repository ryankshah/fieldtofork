package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.block.*;
import com.ryankshah.fieldtofork.block.sign.PalmHangingSignBlock;
import com.ryankshah.fieldtofork.block.sign.PalmStandingSignBlock;
import com.ryankshah.fieldtofork.block.sign.PalmWallHangingSignBlock;
import com.ryankshah.fieldtofork.block.sign.PalmWallSignBlock;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class BlockRegistry
{
    public static void init() {}

    public static final BlockSetType TYPE_PALM = BlockSetType.register(new BlockSetType("palm"));
    public static final BlockSetType TYPE_BANANA = BlockSetType.register(new BlockSetType("banana"));
    public static final BlockSetType TYPE_DRAGONFRUIT = BlockSetType.register(new BlockSetType("dragonfruit"));
    public static final BlockSetType TYPE_LYCHEE = BlockSetType.register(new BlockSetType("lychee"));
    public static final BlockSetType TYPE_MANGO = BlockSetType.register(new BlockSetType("mango"));
    public static final BlockSetType TYPE_ORANGE = BlockSetType.register(new BlockSetType("orange"));
    public static final BlockSetType TYPE_PEAR = BlockSetType.register(new BlockSetType("pear"));
    public static final BlockSetType TYPE_POMEGRANATE = BlockSetType.register(new BlockSetType("pomegranate"));

    public static final WoodType PALM = WoodType.register(new WoodType("palm", TYPE_PALM));
    public static final WoodType BANANA = WoodType.register(new WoodType("palm", TYPE_BANANA));
    public static final WoodType DRAGONFRUIT = WoodType.register(new WoodType("palm", TYPE_DRAGONFRUIT));
    public static final WoodType LYCHEE = WoodType.register(new WoodType("palm", TYPE_LYCHEE));
    public static final WoodType MANGO = WoodType.register(new WoodType("palm", TYPE_MANGO));
    public static final WoodType ORANGE = WoodType.register(new WoodType("palm", TYPE_ORANGE));
    public static final WoodType PEAR = WoodType.register(new WoodType("palm", TYPE_PEAR));
    public static final WoodType POMEGRANATE = WoodType.register(new WoodType("palm", TYPE_POMEGRANATE));

//    Sheets.addWoodType(PALM);

    public static final Supplier<RotatedPillarBlock> PALM_LOG = registerBlock("palm_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> PALM_PLANKS = registerBlock("palm_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> PALM_LEAVES = registerBlock("palm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final Supplier<Block> DENSE_PALM_LEAVES = registerBlock("dense_palm_leaves", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
//    public static final Supplier<SaplingBlock> PALM_SAPLING = registerBlock("palm_sapling", () -> new SaplingBlock(new TreeGrower(....), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING)))
    public static final Supplier<FTFDoorBlock> PALM_DOOR = registerBlock("palm_door", () -> new FTFDoorBlock(TYPE_PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor", () -> new FTFTrapdoorBlock(TYPE_PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> PALM_SLAB = registerBlock("palm_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> PALM_STAIRS = registerBlock("palm_stairs", () -> new FTFStairBlock(PALM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));
    public static final Supplier<FenceBlock> PALM_FENCE = registerBlock("palm_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));
    public static final Supplier<FenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate", () -> new FenceGateBlock(PALM, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));
    public static final Supplier<FTFButtonBlock> PALM_BUTTON = registerBlock("palm_button", () -> new FTFButtonBlock(TYPE_PALM, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<PalmStandingSignBlock> PALM_SIGN = registerBlock("palm_sign", () -> new PalmStandingSignBlock(PALM, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<PalmWallSignBlock> PALM_WALL_SIGN = registerBlock("palm_wall_sign", () -> new PalmWallSignBlock(PALM, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(PALM_SIGN.get()).ignitedByLava()));
    public static final Supplier<PalmHangingSignBlock> PALM_HANGING_SIGN = registerBlock("palm_hanging_sign", () -> new PalmHangingSignBlock(PALM, BlockBehaviour.Properties.of().mapColor(PALM_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<PalmWallHangingSignBlock> PALM_WALL_HANGING_SIGN = registerBlock("palm_wall_hanging_sign", () -> new PalmWallHangingSignBlock(PALM, BlockBehaviour.Properties.of().mapColor(PALM_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_PALM, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));
    // sapling item
    public static final Supplier<BlockItem> PALM_LOG_ITEM = registerBlockItem("palm_log", () -> new BlockItem(PALM_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_LEAVES_ITEM = registerBlockItem("palm_leaves", () -> new BlockItem(PALM_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DENSE_PALM_LEAVES_ITEM = registerBlockItem("dense_palm_leaves", () -> new BlockItem(DENSE_PALM_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_PLANKS_ITEM = registerBlockItem("palm_planks", () -> new BlockItem(PALM_PLANKS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_DOOR_ITEM = registerBlockItem("palm_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.PALM_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> PALM_TRAPDOOR_ITEM = registerBlockItem("palm_trapdoor", () -> new BlockItem(PALM_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_SLAB_ITEM = registerBlockItem("palm_slab", () -> new BlockItem(PALM_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_STAIRS_ITEM = registerBlockItem("palm_stairs", () -> new BlockItem(PALM_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_BUTTON_ITEM = registerBlockItem("palm_button", () -> new BlockItem(PALM_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_FENCE_ITEM = registerBlockItem("palm_fence", () -> new BlockItem(PALM_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_FENCE_GATE_ITEM = registerBlockItem("palm_fence_gate", () -> new BlockItem(PALM_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PALM_SIGN_ITEM = registerBlockItem("palm_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), PALM_SIGN.get(), PALM_WALL_SIGN.get()));
    public static final Supplier<BlockItem> PALM_HANGING_SIGN_ITEM = registerBlockItem("palm_hanging_sign", () -> new HangingSignItem(PALM_HANGING_SIGN.get(), PALM_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> PALM_PRESSURE_PLATE_ITEM = registerBlockItem("palm_pressure_plate", () -> new BlockItem(PALM_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> BANANA_TREE_LOG = registerBlock("banana_tree_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> BANANA_TREE_PLANKS = registerBlock("banana_tree_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> BANANA_TREE_LOG_ITEM = registerBlockItem("banana_tree_log", () -> new BlockItem(BANANA_TREE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_TREE_PLANKS_ITEM = registerBlockItem("banana_tree_planks", () -> new BlockItem(BANANA_TREE_PLANKS.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> DRAGONFRUIT_TREE_LOG = registerBlock("dragonfruit_tree_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> DRAGONFRUIT_TREE_PLANKS = registerBlock("dragonfruit_tree_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> DRAGONFRUIT_TREE_LOG_ITEM = registerBlockItem("dragonfruit_tree_log", () -> new BlockItem(DRAGONFRUIT_TREE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_TREE_PLANKS_ITEM = registerBlockItem("dragonfruit_tree_planks", () -> new BlockItem(DRAGONFRUIT_TREE_PLANKS.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> LYCHEE_TREE_LOG = registerBlock("lychee_tree_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> LYCHEE_TREE_PLANKS = registerBlock("lychee_tree_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> LYCHEE_TREE_LOG_ITEM = registerBlockItem("lychee_tree_log", () -> new BlockItem(LYCHEE_TREE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_TREE_PLANKS_ITEM = registerBlockItem("lychee_tree_planks", () -> new BlockItem(LYCHEE_TREE_PLANKS.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> MANGO_LOG = registerBlock("mango_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> MANGO_PLANKS = registerBlock("mango_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> MANGO_LOG_ITEM = registerBlockItem("mango_log", () -> new BlockItem(MANGO_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_PLANKS_ITEM = registerBlockItem("mango_planks", () -> new BlockItem(MANGO_PLANKS.get(), new Item.Properties()));
    
    public static final Supplier<RotatedPillarBlock> ORANGE_LOG = registerBlock("orange_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> ORANGE_PLANKS = registerBlock("orange_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> ORANGE_LOG_ITEM = registerBlockItem("orange_log", () -> new BlockItem(ORANGE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_PLANKS_ITEM = registerBlockItem("orange_planks", () -> new BlockItem(ORANGE_PLANKS.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> PEAR_LOG = registerBlock("pear_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> PEAR_PLANKS = registerBlock("pear_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> PEAR_LOG_ITEM = registerBlockItem("pear_log", () -> new BlockItem(PEAR_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_PLANKS_ITEM = registerBlockItem("pear_planks", () -> new BlockItem(PEAR_PLANKS.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> POMEGRANATE_LOG = registerBlock("pomegranate_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> POMEGRANATE_PLANKS = registerBlock("pomegranate_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> POMEGRANATE_LOG_ITEM = registerBlockItem("pomegranate_log", () -> new BlockItem(POMEGRANATE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_PLANKS_ITEM = registerBlockItem("pomegranate_planks", () -> new BlockItem(POMEGRANATE_PLANKS.get(), new Item.Properties()));
    
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
                entries.accept(new ItemStack(BlockRegistry.PALM_LOG.get()));
                //sapling?
                entries.accept(new ItemStack(BlockRegistry.PALM_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.DENSE_PALM_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_PRESSURE_PLATE.get()));

                entries.accept(new ItemStack(BlockRegistry.BANANA_TREE_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_TREE_PLANKS.get()));

                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_TREE_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()));

                entries.accept(new ItemStack(BlockRegistry.LYCHEE_TREE_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_TREE_PLANKS.get()));

                entries.accept(new ItemStack(BlockRegistry.MANGO_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_PLANKS.get()));

                entries.accept(new ItemStack(BlockRegistry.ORANGE_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_PLANKS.get()));

                entries.accept(new ItemStack(BlockRegistry.PEAR_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_PLANKS.get()));

                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_PLANKS.get()));
            })
            .build());
}