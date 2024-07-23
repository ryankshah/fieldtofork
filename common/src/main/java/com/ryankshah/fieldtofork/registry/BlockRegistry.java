package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.block.*;
import com.ryankshah.fieldtofork.block.sign.*;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;
import java.util.function.Supplier;

public class BlockRegistry
{
    public static void init() {
        WoodType.register(PALM);
        WoodType.register(BANANA);
        WoodType.register(DRAGONFRUIT);
        WoodType.register(LYCHEE);
        WoodType.register(MANGO);
        WoodType.register(ORANGE);
        WoodType.register(PEAR);
        WoodType.register(POMEGRANATE);

        BlockSetType.register(TYPE_PALM);
        BlockSetType.register(TYPE_BANANA);
        BlockSetType.register(TYPE_DRAGONFRUIT);
        BlockSetType.register(TYPE_LYCHEE);
        BlockSetType.register(TYPE_MANGO);
        BlockSetType.register(TYPE_ORANGE);
        BlockSetType.register(TYPE_PEAR);
        BlockSetType.register(TYPE_POMEGRANATE);
    }

    // Replace with TreeFeatures PALM?
    public static final TreeGrower PALM_GROWER = new TreeGrower("palm",Optional.empty(), Optional.of(FieldToForkCommon.PALM_TREE_CF_RK), Optional.empty());

    public static final BlockSetType TYPE_PALM = new BlockSetType("palm");
    public static final BlockSetType TYPE_BANANA = new BlockSetType("banana");
    public static final BlockSetType TYPE_DRAGONFRUIT = new BlockSetType("dragonfruit");
    public static final BlockSetType TYPE_LYCHEE = new BlockSetType("lychee");
    public static final BlockSetType TYPE_MANGO = new BlockSetType("mango");
    public static final BlockSetType TYPE_ORANGE = new BlockSetType("orange");
    public static final BlockSetType TYPE_PEAR = new BlockSetType("pear");
    public static final BlockSetType TYPE_POMEGRANATE = new BlockSetType("pomegranate");

    public static final WoodType PALM = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "palm").toString(), TYPE_PALM);
    public static final WoodType BANANA = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "banana").toString(), TYPE_BANANA);
    public static final WoodType DRAGONFRUIT = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonfruit").toString(), TYPE_DRAGONFRUIT);
    public static final WoodType LYCHEE = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "lychee").toString(), TYPE_LYCHEE);
    public static final WoodType MANGO = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mango").toString(), TYPE_MANGO);
    public static final WoodType ORANGE = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orange").toString(), TYPE_ORANGE);
    public static final WoodType PEAR = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "pear").toString(), TYPE_PEAR);
    public static final WoodType POMEGRANATE = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "pomegranate").toString(), TYPE_POMEGRANATE);

    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MOD_ID);

    public static final Supplier<RotatedPillarBlock> PALM_LOG = registerBlock("palm_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> PALM_PLANKS = registerBlock("palm_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> PALM_LEAVES = registerBlock("palm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final Supplier<Block> DENSE_PALM_LEAVES = registerBlock("dense_palm_leaves", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<SaplingBlock> PALM_SAPLING = registerBlock("palm_sapling", () -> new SaplingBlock(PALM_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING)));
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
    public static final Supplier<BlockItem> PALM_SAPLING_ITEM = registerBlockItem("palm_sapling", () -> new BlockItem(PALM_SAPLING.get(), new Item.Properties()));
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
    public static final Supplier<Block> BANANA_LEAVES = registerBlock("banana_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final Supplier<FTFDoorBlock> BANANA_DOOR = registerBlock("banana_door", () -> new FTFDoorBlock(TYPE_BANANA, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> BANANA_TRAPDOOR = registerBlock("banana_trapdoor", () -> new FTFTrapdoorBlock(TYPE_BANANA, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> BANANA_SLAB = registerBlock("banana_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> BANANA_STAIRS = registerBlock("banana_stairs", () -> new FTFStairBlock(BANANA_TREE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BANANA_TREE_PLANKS.get())));
    public static final Supplier<FenceBlock> BANANA_FENCE = registerBlock("banana_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(BANANA_TREE_PLANKS.get())));
    public static final Supplier<FenceGateBlock> BANANA_FENCE_GATE = registerBlock("banana_fence_gate", () -> new FenceGateBlock(BANANA, BlockBehaviour.Properties.ofFullCopy(BANANA_TREE_PLANKS.get())));
    public static final Supplier<FTFButtonBlock> BANANA_BUTTON = registerBlock("banana_button", () -> new FTFButtonBlock(TYPE_BANANA, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<BananaStandingSignBlock> BANANA_SIGN = registerBlock("banana_sign", () -> new BananaStandingSignBlock(BANANA, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<BananaWallSignBlock> BANANA_WALL_SIGN = registerBlock("banana_wall_sign", () -> new BananaWallSignBlock(BANANA, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(BANANA_SIGN.get()).ignitedByLava()));
    public static final Supplier<BananaHangingSignBlock> BANANA_HANGING_SIGN = registerBlock("banana_hanging_sign", () -> new BananaHangingSignBlock(BANANA, BlockBehaviour.Properties.of().mapColor(BANANA_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<BananaWallHangingSignBlock> BANANA_WALL_HANGING_SIGN = registerBlock("banana_wall_hanging_sign", () -> new BananaWallHangingSignBlock(BANANA, BlockBehaviour.Properties.of().mapColor(BANANA_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> BANANA_PRESSURE_PLATE = registerBlock("banana_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_BANANA, BlockBehaviour.Properties.ofFullCopy(BANANA_TREE_PLANKS.get())));
    //    public static final Supplier<BlockItem> PALM_SAPLING_ITEM = registerBlockItem("palm_sapling", () -> new BlockItem(PALM_SAPLING.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_TREE_LOG_ITEM = registerBlockItem("banana_tree_log", () -> new BlockItem(BANANA_TREE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_TREE_PLANKS_ITEM = registerBlockItem("banana_tree_planks", () -> new BlockItem(BANANA_TREE_PLANKS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_LEAVES_ITEM = registerBlockItem("banana_leaves", () -> new BlockItem(BANANA_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_DOOR_ITEM = registerBlockItem("banana_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.BANANA_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> BANANA_TRAPDOOR_ITEM = registerBlockItem("banana_trapdoor", () -> new BlockItem(BANANA_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_SLAB_ITEM = registerBlockItem("banana_slab", () -> new BlockItem(BANANA_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_STAIRS_ITEM = registerBlockItem("banana_stairs", () -> new BlockItem(BANANA_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_BUTTON_ITEM = registerBlockItem("banana_button", () -> new BlockItem(BANANA_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_FENCE_ITEM = registerBlockItem("banana_fence", () -> new BlockItem(BANANA_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_FENCE_GATE_ITEM = registerBlockItem("banana_fence_gate", () -> new BlockItem(BANANA_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> BANANA_SIGN_ITEM = registerBlockItem("banana_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), BANANA_SIGN.get(), BANANA_WALL_SIGN.get()));
    public static final Supplier<BlockItem> BANANA_HANGING_SIGN_ITEM = registerBlockItem("banana_hanging_sign", () -> new HangingSignItem(BANANA_HANGING_SIGN.get(), BANANA_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> BANANA_PRESSURE_PLATE_ITEM = registerBlockItem("banana_pressure_plate", () -> new BlockItem(BANANA_PRESSURE_PLATE.get(), new Item.Properties()));


    public static final Supplier<RotatedPillarBlock> DRAGONFRUIT_TREE_LOG = registerBlock("dragonfruit_tree_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> DRAGONFRUIT_TREE_PLANKS = registerBlock("dragonfruit_tree_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> DRAGONFRUIT_LEAVES = registerBlock("dragonfruit_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    //    public static final Supplier<SaplingBlock> PALM_SAPLING = registerBlock("palm_sapling", () -> new SaplingBlock(PALM_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING)));
    public static final Supplier<FTFDoorBlock> DRAGONFRUIT_DOOR = registerBlock("dragonfruit_door", () -> new FTFDoorBlock(TYPE_DRAGONFRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> DRAGONFRUIT_TRAPDOOR = registerBlock("dragonfruit_trapdoor", () -> new FTFTrapdoorBlock(TYPE_DRAGONFRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> DRAGONFRUIT_SLAB = registerBlock("dragonfruit_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> DRAGONFRUIT_STAIRS = registerBlock("dragonfruit_stairs", () -> new FTFStairBlock(DRAGONFRUIT_TREE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DRAGONFRUIT_TREE_PLANKS.get())));
    public static final Supplier<FenceBlock> DRAGONFRUIT_FENCE = registerBlock("dragonfruit_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(DRAGONFRUIT_TREE_PLANKS.get())));
    public static final Supplier<FenceGateBlock> DRAGONFRUIT_FENCE_GATE = registerBlock("dragonfruit_fence_gate", () -> new FenceGateBlock(DRAGONFRUIT, BlockBehaviour.Properties.ofFullCopy(DRAGONFRUIT_TREE_PLANKS.get())));
    public static final Supplier<FTFButtonBlock> DRAGONFRUIT_BUTTON = registerBlock("dragonfruit_button", () -> new FTFButtonBlock(TYPE_DRAGONFRUIT, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<DragonfruitStandingSignBlock> DRAGONFRUIT_SIGN = registerBlock("dragonfruit_sign", () -> new DragonfruitStandingSignBlock(DRAGONFRUIT, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<DragonfruitWallSignBlock> DRAGONFRUIT_WALL_SIGN = registerBlock("dragonfruit_wall_sign", () -> new DragonfruitWallSignBlock(DRAGONFRUIT, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(DRAGONFRUIT_SIGN.get()).ignitedByLava()));
    public static final Supplier<DragonfruitHangingSignBlock> DRAGONFRUIT_HANGING_SIGN = registerBlock("dragonfruit_hanging_sign", () -> new DragonfruitHangingSignBlock(DRAGONFRUIT, BlockBehaviour.Properties.of().mapColor(DRAGONFRUIT_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<DragonfruitWallHangingSignBlock> DRAGONFRUIT_WALL_HANGING_SIGN = registerBlock("dragonfruit_wall_hanging_sign", () -> new DragonfruitWallHangingSignBlock(DRAGONFRUIT, BlockBehaviour.Properties.of().mapColor(DRAGONFRUIT_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> DRAGONFRUIT_PRESSURE_PLATE = registerBlock("dragonfruit_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_DRAGONFRUIT, BlockBehaviour.Properties.ofFullCopy(DRAGONFRUIT_TREE_PLANKS.get())));
    //    public static final Supplier<BlockItem> PALM_SAPLING_ITEM = registerBlockItem("palm_sapling", () -> new BlockItem(PALM_SAPLING.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_TREE_LOG_ITEM = registerBlockItem("dragonfruit_tree_log", () -> new BlockItem(DRAGONFRUIT_TREE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_TREE_PLANKS_ITEM = registerBlockItem("dragonfruit_tree_planks", () -> new BlockItem(DRAGONFRUIT_TREE_PLANKS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_LEAVES_ITEM = registerBlockItem("dragonfruit_leaves", () -> new BlockItem(DRAGONFRUIT_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_DOOR_ITEM = registerBlockItem("dragonfruit_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.DRAGONFRUIT_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> DRAGONFRUIT_TRAPDOOR_ITEM = registerBlockItem("dragonfruit_trapdoor", () -> new BlockItem(DRAGONFRUIT_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_SLAB_ITEM = registerBlockItem("dragonfruit_slab", () -> new BlockItem(DRAGONFRUIT_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_STAIRS_ITEM = registerBlockItem("dragonfruit_stairs", () -> new BlockItem(DRAGONFRUIT_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_BUTTON_ITEM = registerBlockItem("dragonfruit_button", () -> new BlockItem(DRAGONFRUIT_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_FENCE_ITEM = registerBlockItem("dragonfruit_fence", () -> new BlockItem(DRAGONFRUIT_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_FENCE_GATE_ITEM = registerBlockItem("dragonfruit_fence_gate", () -> new BlockItem(DRAGONFRUIT_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> DRAGONFRUIT_SIGN_ITEM = registerBlockItem("dragonfruit_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), DRAGONFRUIT_SIGN.get(), DRAGONFRUIT_WALL_SIGN.get()));
    public static final Supplier<BlockItem> DRAGONFRUIT_HANGING_SIGN_ITEM = registerBlockItem("dragonfruit_hanging_sign", () -> new HangingSignItem(DRAGONFRUIT_HANGING_SIGN.get(), DRAGONFRUIT_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> DRAGONFRUIT_PRESSURE_PLATE_ITEM = registerBlockItem("dragonfruit_pressure_plate", () -> new BlockItem(DRAGONFRUIT_PRESSURE_PLATE.get(), new Item.Properties()));
    
    
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
    
//    private static <T extends BlockItem> Supplier<T> registerBlockItem(String id, Supplier<T> blockitem) {
//        return FieldToForkCommon.COMMON_PLATFORM.registerBlockItem(id, blockitem);
//    }
//
//    private static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
//        return FieldToForkCommon.COMMON_PLATFORM.registerBlock(id, block);
//    }

    private static <T extends BlockItem> Supplier<T> registerBlockItem(String id, Supplier<T> blockitem) {
        return ItemRegistry.ITEMS.register(id, blockitem);
//        return FieldToForkCommon.COMMON_PLATFORM.registerBlockItem(id, blockitem);
    }

    private static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return BLOCKS.register(id, block);
    }

    public static final Supplier<CreativeModeTab> BLOCKS_TAB = FieldToForkCommon.COMMON_PLATFORM.registerCreativeModeTab("fieldtofork_blocks", () -> FieldToForkCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".blocks"))
            .icon(() -> new ItemStack(BlockRegistry.PALM_LOG.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(new ItemStack(BlockRegistry.PALM_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_SAPLING.get()));
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
                entries.accept(new ItemStack(BlockRegistry.BANANA_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.BANANA_PRESSURE_PLATE.get()));

                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_TREE_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_PRESSURE_PLATE.get()));

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