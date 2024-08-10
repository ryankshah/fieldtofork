package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.block.*;
import com.ryankshah.fieldtofork.block.churn.ChurnBlock;
import com.ryankshah.fieldtofork.block.crop.FTFCropBlock;
import com.ryankshah.fieldtofork.block.crop.TwoHighCropBlock;
import com.ryankshah.fieldtofork.block.sign.*;
import com.ryankshah.fieldtofork.block.silkworm_habitat.SilkwormHabitat;
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
        WoodType.register(MULBERRY);

        BlockSetType.register(TYPE_PALM);
        BlockSetType.register(TYPE_BANANA);
        BlockSetType.register(TYPE_DRAGONFRUIT);
        BlockSetType.register(TYPE_LYCHEE);
        BlockSetType.register(TYPE_MANGO);
        BlockSetType.register(TYPE_ORANGE);
        BlockSetType.register(TYPE_PEAR);
        BlockSetType.register(TYPE_POMEGRANATE);
        BlockSetType.register(TYPE_MULBERRY);
    }

    public static final TreeGrower PALM_GROWER = new TreeGrower("palm",Optional.empty(), Optional.of(WorldGenRegistry.PALM_TREE_CF_RK), Optional.empty());
    public static final TreeGrower BANANA_GROWER = new TreeGrower("banana",Optional.empty(), Optional.of(WorldGenRegistry.BANANA_TREE_CF_RK), Optional.empty());
    public static final TreeGrower DRAGONFRUIT_GROWER = new TreeGrower("dragonfruit",Optional.empty(), Optional.of(WorldGenRegistry.DRAGONFRUIT_TREE_CF_RK), Optional.empty());
    public static final TreeGrower LYCHEE_GROWER = new TreeGrower("lychee",Optional.empty(), Optional.of(WorldGenRegistry.LYCHEE_TREE_CF_RK), Optional.empty());
    public static final TreeGrower ORANGE_GROWER = new TreeGrower("orange",Optional.empty(), Optional.of(WorldGenRegistry.ORANGE_TREE_CF_RK), Optional.empty());
    public static final TreeGrower MANGO_GROWER = new TreeGrower("mango",Optional.empty(), Optional.of(WorldGenRegistry.MANGO_TREE_CF_RK), Optional.empty());
    public static final TreeGrower PEAR_GROWER = new TreeGrower("pear",Optional.empty(), Optional.of(WorldGenRegistry.PEAR_TREE_CF_RK), Optional.empty());
    public static final TreeGrower POMEGRANATE_GROWER = new TreeGrower("pomegranate",Optional.empty(), Optional.of(WorldGenRegistry.POMEGRANATE_TREE_CF_RK), Optional.empty());
    public static final TreeGrower MULBERRY_GROWER = new TreeGrower("mulberry",Optional.empty(), Optional.of(WorldGenRegistry.MULBERRY_TREE_CF_RK), Optional.empty());

    public static final BlockSetType TYPE_PALM = new BlockSetType("palm");
    public static final BlockSetType TYPE_BANANA = new BlockSetType("banana");
    public static final BlockSetType TYPE_DRAGONFRUIT = new BlockSetType("dragonfruit");
    public static final BlockSetType TYPE_LYCHEE = new BlockSetType("lychee");
    public static final BlockSetType TYPE_MANGO = new BlockSetType("mango");
    public static final BlockSetType TYPE_ORANGE = new BlockSetType("orange");
    public static final BlockSetType TYPE_PEAR = new BlockSetType("pear");
    public static final BlockSetType TYPE_POMEGRANATE = new BlockSetType("pomegranate");
    public static final BlockSetType TYPE_MULBERRY = new BlockSetType("mulberry");

    public static final WoodType PALM = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "palm").toString(), TYPE_PALM);
    public static final WoodType BANANA = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "banana").toString(), TYPE_BANANA);
    public static final WoodType DRAGONFRUIT = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonfruit").toString(), TYPE_DRAGONFRUIT);
    public static final WoodType LYCHEE = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "lychee").toString(), TYPE_LYCHEE);
    public static final WoodType MANGO = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mango").toString(), TYPE_MANGO);
    public static final WoodType ORANGE = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orange").toString(), TYPE_ORANGE);
    public static final WoodType PEAR = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "pear").toString(), TYPE_PEAR);
    public static final WoodType POMEGRANATE = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "pomegranate").toString(), TYPE_POMEGRANATE);
    public static final WoodType MULBERRY = new WoodType(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mulberry").toString(), TYPE_MULBERRY);

    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MOD_ID);

    public static final Supplier<RotatedPillarBlock> PALM_LOG = registerBlock("palm_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> PALM_PLANKS = registerBlock("palm_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFAgeingLeafBlock> PALM_LEAVES = registerBlock("palm_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.COCONUT));
    public static final Supplier<Block> DENSE_PALM_LEAVES = registerBlock("dense_palm_leaves", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<FTFBeachSaplingBlock> PALM_SAPLING = registerBlock("palm_sapling", () -> new FTFBeachSaplingBlock(PALM_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<FTFDoorBlock> PALM_DOOR = registerBlock("palm_door", () -> new FTFDoorBlock(TYPE_PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor", () -> new FTFTrapdoorBlock(TYPE_PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> PALM_SLAB = registerBlock("palm_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> PALM_STAIRS = registerBlock("palm_stairs", () -> new FTFStairBlock(PALM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));
    public static final Supplier<FenceBlock> PALM_FENCE = registerBlock("palm_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));
    public static final Supplier<FenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate", () -> new FenceGateBlock(PALM, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));
    public static final Supplier<ButtonBlock> PALM_BUTTON = registerBlock("palm_button", () -> new ButtonBlock(TYPE_PALM, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
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
    public static final Supplier<FTFAgeingLeafBlock> BANANA_LEAVES = registerBlock("banana_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.BANANAS));
    public static final Supplier<FTFDoorBlock> BANANA_DOOR = registerBlock("banana_door", () -> new FTFDoorBlock(TYPE_BANANA, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> BANANA_TRAPDOOR = registerBlock("banana_trapdoor", () -> new FTFTrapdoorBlock(TYPE_BANANA, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> BANANA_SLAB = registerBlock("banana_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> BANANA_STAIRS = registerBlock("banana_stairs", () -> new FTFStairBlock(BANANA_TREE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BANANA_TREE_PLANKS.get())));
    public static final Supplier<FenceBlock> BANANA_FENCE = registerBlock("banana_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(BANANA_TREE_PLANKS.get())));
    public static final Supplier<FenceGateBlock> BANANA_FENCE_GATE = registerBlock("banana_fence_gate", () -> new FenceGateBlock(BANANA, BlockBehaviour.Properties.ofFullCopy(BANANA_TREE_PLANKS.get())));
    public static final Supplier<ButtonBlock> BANANA_BUTTON = registerBlock("banana_button", () -> new ButtonBlock(TYPE_BANANA, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<BananaStandingSignBlock> BANANA_SIGN = registerBlock("banana_sign", () -> new BananaStandingSignBlock(BANANA, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<BananaWallSignBlock> BANANA_WALL_SIGN = registerBlock("banana_wall_sign", () -> new BananaWallSignBlock(BANANA, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(BANANA_SIGN.get()).ignitedByLava()));
    public static final Supplier<BananaHangingSignBlock> BANANA_HANGING_SIGN = registerBlock("banana_hanging_sign", () -> new BananaHangingSignBlock(BANANA, BlockBehaviour.Properties.of().mapColor(BANANA_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<BananaWallHangingSignBlock> BANANA_WALL_HANGING_SIGN = registerBlock("banana_wall_hanging_sign", () -> new BananaWallHangingSignBlock(BANANA, BlockBehaviour.Properties.of().mapColor(BANANA_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> BANANA_PRESSURE_PLATE = registerBlock("banana_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_BANANA, BlockBehaviour.Properties.ofFullCopy(BANANA_TREE_PLANKS.get())));
    public static final Supplier<SaplingBlock> BANANA_SAPLING = registerBlock("banana_sapling", () -> new SaplingBlock(BANANA_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<BlockItem> BANANA_SAPLING_ITEM = registerBlockItem("banana_sapling", () -> new BlockItem(BANANA_SAPLING.get(), new Item.Properties()));
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
    public static final Supplier<FTFAgeingLeafBlock> DRAGONFRUIT_LEAVES = registerBlock("dragonfruit_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.DRAGONFRUIT));
    //    public static final Supplier<SaplingBlock> PALM_SAPLING = registerBlock("palm_sapling", () -> new SaplingBlock(PALM_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING)));
    public static final Supplier<FTFDoorBlock> DRAGONFRUIT_DOOR = registerBlock("dragonfruit_door", () -> new FTFDoorBlock(TYPE_DRAGONFRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> DRAGONFRUIT_TRAPDOOR = registerBlock("dragonfruit_trapdoor", () -> new FTFTrapdoorBlock(TYPE_DRAGONFRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> DRAGONFRUIT_SLAB = registerBlock("dragonfruit_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> DRAGONFRUIT_STAIRS = registerBlock("dragonfruit_stairs", () -> new FTFStairBlock(DRAGONFRUIT_TREE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DRAGONFRUIT_TREE_PLANKS.get())));
    public static final Supplier<FenceBlock> DRAGONFRUIT_FENCE = registerBlock("dragonfruit_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(DRAGONFRUIT_TREE_PLANKS.get())));
    public static final Supplier<FenceGateBlock> DRAGONFRUIT_FENCE_GATE = registerBlock("dragonfruit_fence_gate", () -> new FenceGateBlock(DRAGONFRUIT, BlockBehaviour.Properties.ofFullCopy(DRAGONFRUIT_TREE_PLANKS.get())));
    public static final Supplier<ButtonBlock> DRAGONFRUIT_BUTTON = registerBlock("dragonfruit_button", () -> new ButtonBlock(TYPE_DRAGONFRUIT, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<DragonfruitStandingSignBlock> DRAGONFRUIT_SIGN = registerBlock("dragonfruit_sign", () -> new DragonfruitStandingSignBlock(DRAGONFRUIT, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<DragonfruitWallSignBlock> DRAGONFRUIT_WALL_SIGN = registerBlock("dragonfruit_wall_sign", () -> new DragonfruitWallSignBlock(DRAGONFRUIT, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(DRAGONFRUIT_SIGN.get()).ignitedByLava()));
    public static final Supplier<DragonfruitHangingSignBlock> DRAGONFRUIT_HANGING_SIGN = registerBlock("dragonfruit_hanging_sign", () -> new DragonfruitHangingSignBlock(DRAGONFRUIT, BlockBehaviour.Properties.of().mapColor(DRAGONFRUIT_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<DragonfruitWallHangingSignBlock> DRAGONFRUIT_WALL_HANGING_SIGN = registerBlock("dragonfruit_wall_hanging_sign", () -> new DragonfruitWallHangingSignBlock(DRAGONFRUIT, BlockBehaviour.Properties.of().mapColor(DRAGONFRUIT_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> DRAGONFRUIT_PRESSURE_PLATE = registerBlock("dragonfruit_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_DRAGONFRUIT, BlockBehaviour.Properties.ofFullCopy(DRAGONFRUIT_TREE_PLANKS.get())));
    public static final Supplier<SaplingBlock> DRAGONFRUIT_SAPLING = registerBlock("dragonfruit_sapling", () -> new SaplingBlock(DRAGONFRUIT_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<BlockItem> DRAGONFRUIT_SAPLING_ITEM = registerBlockItem("dragonfruit_sapling", () -> new BlockItem(DRAGONFRUIT_SAPLING.get(), new Item.Properties()));
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
    public static final Supplier<FTFAgeingLeafBlock> LYCHEE_LEAVES = registerBlock("lychee_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.LYCHEE));
    //    public static final Supplier<SaplingBlock> PALM_SAPLING = registerBlock("palm_sapling", () -> new SaplingBlock(PALM_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING)));
    public static final Supplier<FTFDoorBlock> LYCHEE_DOOR = registerBlock("lychee_door", () -> new FTFDoorBlock(TYPE_LYCHEE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> LYCHEE_TRAPDOOR = registerBlock("lychee_trapdoor", () -> new FTFTrapdoorBlock(TYPE_LYCHEE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> LYCHEE_SLAB = registerBlock("lychee_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> LYCHEE_STAIRS = registerBlock("lychee_stairs", () -> new FTFStairBlock(LYCHEE_TREE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(LYCHEE_TREE_PLANKS.get())));
    public static final Supplier<FenceBlock> LYCHEE_FENCE = registerBlock("lychee_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(LYCHEE_TREE_PLANKS.get())));
    public static final Supplier<FenceGateBlock> LYCHEE_FENCE_GATE = registerBlock("lychee_fence_gate", () -> new FenceGateBlock(LYCHEE, BlockBehaviour.Properties.ofFullCopy(LYCHEE_TREE_PLANKS.get())));
    public static final Supplier<ButtonBlock> LYCHEE_BUTTON = registerBlock("lychee_button", () -> new ButtonBlock(TYPE_LYCHEE, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<LycheeStandingSignBlock> LYCHEE_SIGN = registerBlock("lychee_sign", () -> new LycheeStandingSignBlock(LYCHEE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<LycheeWallSignBlock> LYCHEE_WALL_SIGN = registerBlock("lychee_wall_sign", () -> new LycheeWallSignBlock(LYCHEE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(LYCHEE_SIGN.get()).ignitedByLava()));
    public static final Supplier<LycheeHangingSignBlock> LYCHEE_HANGING_SIGN = registerBlock("lychee_hanging_sign", () -> new LycheeHangingSignBlock(LYCHEE, BlockBehaviour.Properties.of().mapColor(LYCHEE_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<LycheeWallHangingSignBlock> LYCHEE_WALL_HANGING_SIGN = registerBlock("lychee_wall_hanging_sign", () -> new LycheeWallHangingSignBlock(LYCHEE, BlockBehaviour.Properties.of().mapColor(LYCHEE_TREE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> LYCHEE_PRESSURE_PLATE = registerBlock("lychee_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_LYCHEE, BlockBehaviour.Properties.ofFullCopy(LYCHEE_TREE_PLANKS.get())));
    public static final Supplier<SaplingBlock> LYCHEE_SAPLING = registerBlock("lychee_sapling", () -> new SaplingBlock(LYCHEE_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<BlockItem> LYCHEE_SAPLING_ITEM = registerBlockItem("lychee_sapling", () -> new BlockItem(LYCHEE_SAPLING.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_TREE_LOG_ITEM = registerBlockItem("lychee_tree_log", () -> new BlockItem(LYCHEE_TREE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_TREE_PLANKS_ITEM = registerBlockItem("lychee_tree_planks", () -> new BlockItem(LYCHEE_TREE_PLANKS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_LEAVES_ITEM = registerBlockItem("lychee_leaves", () -> new BlockItem(LYCHEE_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_DOOR_ITEM = registerBlockItem("lychee_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.LYCHEE_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> LYCHEE_TRAPDOOR_ITEM = registerBlockItem("lychee_trapdoor", () -> new BlockItem(LYCHEE_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_SLAB_ITEM = registerBlockItem("lychee_slab", () -> new BlockItem(LYCHEE_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_STAIRS_ITEM = registerBlockItem("lychee_stairs", () -> new BlockItem(LYCHEE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_BUTTON_ITEM = registerBlockItem("lychee_button", () -> new BlockItem(LYCHEE_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_FENCE_ITEM = registerBlockItem("lychee_fence", () -> new BlockItem(LYCHEE_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_FENCE_GATE_ITEM = registerBlockItem("lychee_fence_gate", () -> new BlockItem(LYCHEE_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> LYCHEE_SIGN_ITEM = registerBlockItem("lychee_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), LYCHEE_SIGN.get(), LYCHEE_WALL_SIGN.get()));
    public static final Supplier<BlockItem> LYCHEE_HANGING_SIGN_ITEM = registerBlockItem("lychee_hanging_sign", () -> new HangingSignItem(LYCHEE_HANGING_SIGN.get(), LYCHEE_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> LYCHEE_PRESSURE_PLATE_ITEM = registerBlockItem("lychee_pressure_plate", () -> new BlockItem(LYCHEE_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> MANGO_LOG = registerBlock("mango_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> MANGO_PLANKS = registerBlock("mango_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> MANGO_LOG_ITEM = registerBlockItem("mango_log", () -> new BlockItem(MANGO_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_PLANKS_ITEM = registerBlockItem("mango_planks", () -> new BlockItem(MANGO_PLANKS.get(), new Item.Properties()));
    public static final Supplier<FTFAgeingLeafBlock> MANGO_LEAVES = registerBlock("mango_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.MANGO));
    public static final Supplier<FTFDoorBlock> MANGO_DOOR = registerBlock("mango_door", () -> new FTFDoorBlock(TYPE_MANGO, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> MANGO_TRAPDOOR = registerBlock("mango_trapdoor", () -> new FTFTrapdoorBlock(TYPE_MANGO, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> MANGO_SLAB = registerBlock("mango_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> MANGO_STAIRS = registerBlock("mango_stairs", () -> new FTFStairBlock(MANGO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS.get())));
    public static final Supplier<FenceBlock> MANGO_FENCE = registerBlock("mango_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS.get())));
    public static final Supplier<FenceGateBlock> MANGO_FENCE_GATE = registerBlock("mango_fence_gate", () -> new FenceGateBlock(MANGO, BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS.get())));
    public static final Supplier<ButtonBlock> MANGO_BUTTON = registerBlock("mango_button", () -> new ButtonBlock(TYPE_MANGO, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<MangoStandingSignBlock> MANGO_SIGN = registerBlock("mango_sign", () -> new MangoStandingSignBlock(MANGO, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<MangoWallSignBlock> MANGO_WALL_SIGN = registerBlock("mango_wall_sign", () -> new MangoWallSignBlock(MANGO, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(MANGO_SIGN.get()).ignitedByLava()));
    public static final Supplier<MangoHangingSignBlock> MANGO_HANGING_SIGN = registerBlock("mango_hanging_sign", () -> new MangoHangingSignBlock(MANGO, BlockBehaviour.Properties.of().mapColor(MANGO_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<MangoWallHangingSignBlock> MANGO_WALL_HANGING_SIGN = registerBlock("mango_wall_hanging_sign", () -> new MangoWallHangingSignBlock(MANGO, BlockBehaviour.Properties.of().mapColor(MANGO_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_MANGO, BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS.get())));
    public static final Supplier<SaplingBlock> MANGO_SAPLING = registerBlock("mango_sapling", () -> new SaplingBlock(MANGO_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<BlockItem> MANGO_SAPLING_ITEM = registerBlockItem("mango_sapling", () -> new BlockItem(MANGO_SAPLING.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_LEAVES_ITEM = registerBlockItem("mango_leaves", () -> new BlockItem(MANGO_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_DOOR_ITEM = registerBlockItem("mango_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.MANGO_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> MANGO_TRAPDOOR_ITEM = registerBlockItem("mango_trapdoor", () -> new BlockItem(MANGO_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_SLAB_ITEM = registerBlockItem("mango_slab", () -> new BlockItem(MANGO_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_STAIRS_ITEM = registerBlockItem("mango_stairs", () -> new BlockItem(MANGO_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_BUTTON_ITEM = registerBlockItem("mango_button", () -> new BlockItem(MANGO_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_FENCE_ITEM = registerBlockItem("mango_fence", () -> new BlockItem(MANGO_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_FENCE_GATE_ITEM = registerBlockItem("mango_fence_gate", () -> new BlockItem(MANGO_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MANGO_SIGN_ITEM = registerBlockItem("mango_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MANGO_SIGN.get(), MANGO_WALL_SIGN.get()));
    public static final Supplier<BlockItem> MANGO_HANGING_SIGN_ITEM = registerBlockItem("mango_hanging_sign", () -> new HangingSignItem(MANGO_HANGING_SIGN.get(), MANGO_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> MANGO_PRESSURE_PLATE_ITEM = registerBlockItem("mango_pressure_plate", () -> new BlockItem(MANGO_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> ORANGE_LOG = registerBlock("orange_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> ORANGE_PLANKS = registerBlock("orange_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> ORANGE_LOG_ITEM = registerBlockItem("orange_log", () -> new BlockItem(ORANGE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_PLANKS_ITEM = registerBlockItem("orange_planks", () -> new BlockItem(ORANGE_PLANKS.get(), new Item.Properties()));
    public static final Supplier<FTFAgeingLeafBlock> ORANGE_LEAVES = registerBlock("orange_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.ORANGE));
    public static final Supplier<FTFDoorBlock> ORANGE_DOOR = registerBlock("orange_door", () -> new FTFDoorBlock(TYPE_ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> ORANGE_TRAPDOOR = registerBlock("orange_trapdoor", () -> new FTFTrapdoorBlock(TYPE_ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> ORANGE_SLAB = registerBlock("orange_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> ORANGE_STAIRS = registerBlock("orange_stairs", () -> new FTFStairBlock(ORANGE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ORANGE_PLANKS.get())));
    public static final Supplier<FenceBlock> ORANGE_FENCE = registerBlock("orange_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(ORANGE_PLANKS.get())));
    public static final Supplier<FenceGateBlock> ORANGE_FENCE_GATE = registerBlock("orange_fence_gate", () -> new FenceGateBlock(ORANGE, BlockBehaviour.Properties.ofFullCopy(ORANGE_PLANKS.get())));
    public static final Supplier<ButtonBlock> ORANGE_BUTTON = registerBlock("orange_button", () -> new ButtonBlock(TYPE_ORANGE, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<OrangeStandingSignBlock> ORANGE_SIGN = registerBlock("orange_sign", () -> new OrangeStandingSignBlock(ORANGE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<OrangeWallSignBlock> ORANGE_WALL_SIGN = registerBlock("orange_wall_sign", () -> new OrangeWallSignBlock(ORANGE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(ORANGE_SIGN.get()).ignitedByLava()));
    public static final Supplier<OrangeHangingSignBlock> ORANGE_HANGING_SIGN = registerBlock("orange_hanging_sign", () -> new OrangeHangingSignBlock(ORANGE, BlockBehaviour.Properties.of().mapColor(ORANGE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<OrangeWallHangingSignBlock> ORANGE_WALL_HANGING_SIGN = registerBlock("orange_wall_hanging_sign", () -> new OrangeWallHangingSignBlock(ORANGE, BlockBehaviour.Properties.of().mapColor(ORANGE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> ORANGE_PRESSURE_PLATE = registerBlock("orange_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_ORANGE, BlockBehaviour.Properties.ofFullCopy(ORANGE_PLANKS.get())));
    public static final Supplier<SaplingBlock> ORANGE_SAPLING = registerBlock("orange_sapling", () -> new SaplingBlock(ORANGE_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<BlockItem> ORANGE_SAPLING_ITEM = registerBlockItem("orange_sapling", () -> new BlockItem(ORANGE_SAPLING.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_LEAVES_ITEM = registerBlockItem("orange_leaves", () -> new BlockItem(ORANGE_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_DOOR_ITEM = registerBlockItem("orange_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.ORANGE_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> ORANGE_TRAPDOOR_ITEM = registerBlockItem("orange_trapdoor", () -> new BlockItem(ORANGE_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_SLAB_ITEM = registerBlockItem("orange_slab", () -> new BlockItem(ORANGE_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_STAIRS_ITEM = registerBlockItem("orange_stairs", () -> new BlockItem(ORANGE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_BUTTON_ITEM = registerBlockItem("orange_button", () -> new BlockItem(ORANGE_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_FENCE_ITEM = registerBlockItem("orange_fence", () -> new BlockItem(ORANGE_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_FENCE_GATE_ITEM = registerBlockItem("orange_fence_gate", () -> new BlockItem(ORANGE_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> ORANGE_SIGN_ITEM = registerBlockItem("orange_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), ORANGE_SIGN.get(), ORANGE_WALL_SIGN.get()));
    public static final Supplier<BlockItem> ORANGE_HANGING_SIGN_ITEM = registerBlockItem("orange_hanging_sign", () -> new HangingSignItem(ORANGE_HANGING_SIGN.get(), ORANGE_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> ORANGE_PRESSURE_PLATE_ITEM = registerBlockItem("orange_pressure_plate", () -> new BlockItem(ORANGE_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> PEAR_LOG = registerBlock("pear_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> PEAR_PLANKS = registerBlock("pear_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> PEAR_LOG_ITEM = registerBlockItem("pear_log", () -> new BlockItem(PEAR_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_PLANKS_ITEM = registerBlockItem("pear_planks", () -> new BlockItem(PEAR_PLANKS.get(), new Item.Properties()));
    public static final Supplier<FTFAgeingLeafBlock> PEAR_LEAVES = registerBlock("pear_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.PEAR));
    public static final Supplier<FTFDoorBlock> PEAR_DOOR = registerBlock("pear_door", () -> new FTFDoorBlock(TYPE_PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> PEAR_TRAPDOOR = registerBlock("pear_trapdoor", () -> new FTFTrapdoorBlock(TYPE_PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> PEAR_SLAB = registerBlock("pear_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> PEAR_STAIRS = registerBlock("pear_stairs", () -> new FTFStairBlock(PEAR_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get())));
    public static final Supplier<FenceBlock> PEAR_FENCE = registerBlock("pear_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get())));
    public static final Supplier<FenceGateBlock> PEAR_FENCE_GATE = registerBlock("pear_fence_gate", () -> new FenceGateBlock(PEAR, BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get())));
    public static final Supplier<ButtonBlock> PEAR_BUTTON = registerBlock("pear_button", () -> new ButtonBlock(TYPE_PEAR, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<PearStandingSignBlock> PEAR_SIGN = registerBlock("pear_sign", () -> new PearStandingSignBlock(PEAR, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<PearWallSignBlock> PEAR_WALL_SIGN = registerBlock("pear_wall_sign", () -> new PearWallSignBlock(PEAR, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(PEAR_SIGN.get()).ignitedByLava()));
    public static final Supplier<PearHangingSignBlock> PEAR_HANGING_SIGN = registerBlock("pear_hanging_sign", () -> new PearHangingSignBlock(PEAR, BlockBehaviour.Properties.of().mapColor(PEAR_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<PearWallHangingSignBlock> PEAR_WALL_HANGING_SIGN = registerBlock("pear_wall_hanging_sign", () -> new PearWallHangingSignBlock(PEAR, BlockBehaviour.Properties.of().mapColor(PEAR_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> PEAR_PRESSURE_PLATE = registerBlock("pear_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_PEAR, BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get())));
    public static final Supplier<SaplingBlock> PEAR_SAPLING = registerBlock("pear_sapling", () -> new SaplingBlock(PEAR_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<BlockItem> PEAR_SAPLING_ITEM = registerBlockItem("pear_sapling", () -> new BlockItem(PEAR_SAPLING.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_LEAVES_ITEM = registerBlockItem("pear_leaves", () -> new BlockItem(PEAR_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_DOOR_ITEM = registerBlockItem("pear_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.PEAR_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> PEAR_TRAPDOOR_ITEM = registerBlockItem("pear_trapdoor", () -> new BlockItem(PEAR_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_SLAB_ITEM = registerBlockItem("pear_slab", () -> new BlockItem(PEAR_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_STAIRS_ITEM = registerBlockItem("pear_stairs", () -> new BlockItem(PEAR_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_BUTTON_ITEM = registerBlockItem("pear_button", () -> new BlockItem(PEAR_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_FENCE_ITEM = registerBlockItem("pear_fence", () -> new BlockItem(PEAR_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_FENCE_GATE_ITEM = registerBlockItem("pear_fence_gate", () -> new BlockItem(PEAR_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> PEAR_SIGN_ITEM = registerBlockItem("pear_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), PEAR_SIGN.get(), PEAR_WALL_SIGN.get()));
    public static final Supplier<BlockItem> PEAR_HANGING_SIGN_ITEM = registerBlockItem("pear_hanging_sign", () -> new HangingSignItem(PEAR_HANGING_SIGN.get(), PEAR_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> PEAR_PRESSURE_PLATE_ITEM = registerBlockItem("pear_pressure_plate", () -> new BlockItem(PEAR_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> POMEGRANATE_LOG = registerBlock("pomegranate_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> POMEGRANATE_PLANKS = registerBlock("pomegranate_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> POMEGRANATE_LOG_ITEM = registerBlockItem("pomegranate_log", () -> new BlockItem(POMEGRANATE_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_PLANKS_ITEM = registerBlockItem("pomegranate_planks", () -> new BlockItem(POMEGRANATE_PLANKS.get(), new Item.Properties()));
    public static final Supplier<FTFAgeingLeafBlock> POMEGRANATE_LEAVES = registerBlock("pomegranate_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.POMEGRANATE));
    public static final Supplier<FTFDoorBlock> POMEGRANATE_DOOR = registerBlock("pomegranate_door", () -> new FTFDoorBlock(TYPE_POMEGRANATE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> POMEGRANATE_TRAPDOOR = registerBlock("pomegranate_trapdoor", () -> new FTFTrapdoorBlock(TYPE_POMEGRANATE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> POMEGRANATE_SLAB = registerBlock("pomegranate_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> POMEGRANATE_STAIRS = registerBlock("pomegranate_stairs", () -> new FTFStairBlock(POMEGRANATE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POMEGRANATE_PLANKS.get())));
    public static final Supplier<FenceBlock> POMEGRANATE_FENCE = registerBlock("pomegranate_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(POMEGRANATE_PLANKS.get())));
    public static final Supplier<FenceGateBlock> POMEGRANATE_FENCE_GATE = registerBlock("pomegranate_fence_gate", () -> new FenceGateBlock(POMEGRANATE, BlockBehaviour.Properties.ofFullCopy(POMEGRANATE_PLANKS.get())));
    public static final Supplier<ButtonBlock> POMEGRANATE_BUTTON = registerBlock("pomegranate_button", () -> new ButtonBlock(TYPE_POMEGRANATE, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<PomegranateStandingSignBlock> POMEGRANATE_SIGN = registerBlock("pomegranate_sign", () -> new PomegranateStandingSignBlock(POMEGRANATE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<PomegranateWallSignBlock> POMEGRANATE_WALL_SIGN = registerBlock("pomegranate_wall_sign", () -> new PomegranateWallSignBlock(POMEGRANATE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(POMEGRANATE_SIGN.get()).ignitedByLava()));
    public static final Supplier<PomegranateHangingSignBlock> POMEGRANATE_HANGING_SIGN = registerBlock("pomegranate_hanging_sign", () -> new PomegranateHangingSignBlock(POMEGRANATE, BlockBehaviour.Properties.of().mapColor(POMEGRANATE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<PomegranateWallHangingSignBlock> POMEGRANATE_WALL_HANGING_SIGN = registerBlock("pomegranate_wall_hanging_sign", () -> new PomegranateWallHangingSignBlock(POMEGRANATE, BlockBehaviour.Properties.of().mapColor(POMEGRANATE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> POMEGRANATE_PRESSURE_PLATE = registerBlock("pomegranate_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_POMEGRANATE, BlockBehaviour.Properties.ofFullCopy(POMEGRANATE_PLANKS.get())));
    public static final Supplier<SaplingBlock> POMEGRANATE_SAPLING = registerBlock("pomegranate_sapling", () -> new SaplingBlock(POMEGRANATE_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<BlockItem> POMEGRANATE_SAPLING_ITEM = registerBlockItem("pomegranate_sapling", () -> new BlockItem(POMEGRANATE_SAPLING.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_LEAVES_ITEM = registerBlockItem("pomegranate_leaves", () -> new BlockItem(POMEGRANATE_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_DOOR_ITEM = registerBlockItem("pomegranate_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.POMEGRANATE_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> POMEGRANATE_TRAPDOOR_ITEM = registerBlockItem("pomegranate_trapdoor", () -> new BlockItem(POMEGRANATE_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_SLAB_ITEM = registerBlockItem("pomegranate_slab", () -> new BlockItem(POMEGRANATE_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_STAIRS_ITEM = registerBlockItem("pomegranate_stairs", () -> new BlockItem(POMEGRANATE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_BUTTON_ITEM = registerBlockItem("pomegranate_button", () -> new BlockItem(POMEGRANATE_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_FENCE_ITEM = registerBlockItem("pomegranate_fence", () -> new BlockItem(POMEGRANATE_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_FENCE_GATE_ITEM = registerBlockItem("pomegranate_fence_gate", () -> new BlockItem(POMEGRANATE_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> POMEGRANATE_SIGN_ITEM = registerBlockItem("pomegranate_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), POMEGRANATE_SIGN.get(), POMEGRANATE_WALL_SIGN.get()));
    public static final Supplier<BlockItem> POMEGRANATE_HANGING_SIGN_ITEM = registerBlockItem("pomegranate_hanging_sign", () -> new HangingSignItem(POMEGRANATE_HANGING_SIGN.get(), POMEGRANATE_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> POMEGRANATE_PRESSURE_PLATE_ITEM = registerBlockItem("pomegranate_pressure_plate", () -> new BlockItem(POMEGRANATE_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final Supplier<RotatedPillarBlock> MULBERRY_LOG = registerBlock("mulberry_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> MULBERRY_PLANKS = registerBlock("mulberry_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<BlockItem> MULBERRY_LOG_ITEM = registerBlockItem("mulberry_log", () -> new BlockItem(MULBERRY_LOG.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_PLANKS_ITEM = registerBlockItem("mulberry_planks", () -> new BlockItem(MULBERRY_PLANKS.get(), new Item.Properties()));
    public static final Supplier<FTFAgeingLeafBlock> MULBERRY_LEAVES = registerBlock("mulberry_leaves", () -> new FTFAgeingLeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ItemRegistry.MULBERRY));
    public static final Supplier<FTFDoorBlock> MULBERRY_DOOR = registerBlock("mulberry_door", () -> new FTFDoorBlock(TYPE_MULBERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<FTFTrapdoorBlock> MULBERRY_TRAPDOOR = registerBlock("mulberry_trapdoor", () -> new FTFTrapdoorBlock(TYPE_MULBERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<SlabBlock> MULBERRY_SLAB = registerBlock("mulberry_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)));
    public static final Supplier<StairBlock> MULBERRY_STAIRS = registerBlock("mulberry_stairs", () -> new FTFStairBlock(MULBERRY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MULBERRY_PLANKS.get())));
    public static final Supplier<FenceBlock> MULBERRY_FENCE = registerBlock("mulberry_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(MULBERRY_PLANKS.get())));
    public static final Supplier<FenceGateBlock> MULBERRY_FENCE_GATE = registerBlock("mulberry_fence_gate", () -> new FenceGateBlock(MULBERRY, BlockBehaviour.Properties.ofFullCopy(MULBERRY_PLANKS.get())));
    public static final Supplier<ButtonBlock> MULBERRY_BUTTON = registerBlock("mulberry_button", () -> new ButtonBlock(TYPE_MULBERRY, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<MulberryStandingSignBlock> MULBERRY_SIGN = registerBlock("mulberry_sign", () -> new MulberryStandingSignBlock(MULBERRY, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<MulberryWallSignBlock> MULBERRY_WALL_SIGN = registerBlock("mulberry_wall_sign", () -> new MulberryWallSignBlock(MULBERRY, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(MULBERRY_SIGN.get()).ignitedByLava()));
    public static final Supplier<MulberryHangingSignBlock> MULBERRY_HANGING_SIGN = registerBlock("mulberry_hanging_sign", () -> new MulberryHangingSignBlock(MULBERRY, BlockBehaviour.Properties.of().mapColor(MULBERRY_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<MulberryWallHangingSignBlock> MULBERRY_WALL_HANGING_SIGN = registerBlock("mulberry_wall_hanging_sign", () -> new MulberryWallHangingSignBlock(MULBERRY, BlockBehaviour.Properties.of().mapColor(MULBERRY_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final Supplier<FTFPressurePlateBlock> MULBERRY_PRESSURE_PLATE = registerBlock("mulberry_pressure_plate", () -> new FTFPressurePlateBlock(TYPE_MULBERRY, BlockBehaviour.Properties.ofFullCopy(MULBERRY_PLANKS.get())));
    public static final Supplier<SaplingBlock> MULBERRY_SAPLING = registerBlock("mulberry_sapling", () -> new SaplingBlock(MULBERRY_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<BlockItem> MULBERRY_SAPLING_ITEM = registerBlockItem("mulberry_sapling", () -> new BlockItem(MULBERRY_SAPLING.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_LEAVES_ITEM = registerBlockItem("mulberry_leaves", () -> new BlockItem(MULBERRY_LEAVES.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_DOOR_ITEM = registerBlockItem("mulberry_door", () -> (BlockItem)(new DoubleHighBlockItem(BlockRegistry.MULBERRY_DOOR.get(), new Item.Properties())));
    public static final Supplier<BlockItem> MULBERRY_TRAPDOOR_ITEM = registerBlockItem("mulberry_trapdoor", () -> new BlockItem(MULBERRY_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_SLAB_ITEM = registerBlockItem("mulberry_slab", () -> new BlockItem(MULBERRY_SLAB.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_STAIRS_ITEM = registerBlockItem("mulberry_stairs", () -> new BlockItem(MULBERRY_STAIRS.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_BUTTON_ITEM = registerBlockItem("mulberry_button", () -> new BlockItem(MULBERRY_BUTTON.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_FENCE_ITEM = registerBlockItem("mulberry_fence", () -> new BlockItem(MULBERRY_FENCE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_FENCE_GATE_ITEM = registerBlockItem("mulberry_fence_gate", () -> new BlockItem(MULBERRY_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<BlockItem> MULBERRY_SIGN_ITEM = registerBlockItem("mulberry_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MULBERRY_SIGN.get(), MULBERRY_WALL_SIGN.get()));
    public static final Supplier<BlockItem> MULBERRY_HANGING_SIGN_ITEM = registerBlockItem("mulberry_hanging_sign", () -> new HangingSignItem(MULBERRY_HANGING_SIGN.get(), MULBERRY_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final Supplier<BlockItem> MULBERRY_PRESSURE_PLATE_ITEM = registerBlockItem("mulberry_pressure_plate", () -> new BlockItem(MULBERRY_PRESSURE_PLATE.get(), new Item.Properties()));


    public static final Supplier<TwoHighCropBlock> GRAPE_CROP = registerBlock("grape", () -> new TwoHighCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.GRAPE_SEEDS));
    public static final Supplier<CropBlock> SWEET_POTATO_CROP = registerBlock("sweet_potatoes", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.SWEET_POTATO_SLIPS));
    public static final Supplier<CropBlock> RADISH_CROP = registerBlock("radish", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.RADISH_SEEDS));
    public static final Supplier<CropBlock> CHILLI_CROP = registerBlock("chilli", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.CHILLI_SEEDS));
    public static final Supplier<CropBlock> ASPARAGUS_CROP = registerBlock("asparagus", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.ASPARAGUS_CROWNS));
    public static final Supplier<CropBlock> LEEK_CROP = registerBlock("leek", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.LEEK_SEEDS));
    public static final Supplier<CropBlock> EGGPLANT_CROP = registerBlock("eggplant", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.EGGPLANT_SEEDS));
    public static final Supplier<CropBlock> BELL_PEPPER_CROP = registerBlock("bell_pepper", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.BELL_PEPPER_SEEDS));
    public static final Supplier<CropBlock> ZUCCHINI_CROP = registerBlock("zucchini", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.ZUCCHINI_SEEDS));
    public static final Supplier<TwoHighCropBlock> PASSIONFRUIT_CROP = registerBlock("passionfruit", () -> new TwoHighCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.PASSIONFRUIT_SEEDS));
    public static final Supplier<FTFCropBlock> TOMATO_CROP = registerBlock("tomatoes", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.TOMATO_SEEDS));
    public static final Supplier<FTFCropBlock> GARLIC_CROP = registerBlock("garlic", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.GARLIC));
    public static final Supplier<FTFCropBlock> STRAWBERRY_CROP = registerBlock("strawberries", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.STRAWBERRY_SEEDS));
    public static final Supplier<FTFCropBlock> DURUM_WHEAT_CROP = registerBlock("durum_wheat", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.DURUM_WHEAT_SEEDS));
    public static final Supplier<FTFCropBlock> GINGER_CROP = registerBlock("ginger", () -> new FTFCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), ItemRegistry.GINGER_ROOT_SLIP));

    public static final Supplier<ScarecrowBlock> VILLAGER_SCARECROW_BLOCK = registerBlock("villager_scarecrow", () -> new ScarecrowBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<BlockItem> VILLAGER_SCARECROW_BLOCK_ITEM = registerBlockItem("villager_scarecrow", () -> new BlockItem(VILLAGER_SCARECROW_BLOCK.get(), new Item.Properties()));

    public static final Supplier<ChurnBlock> CHURN = registerBlock("churn", () -> new ChurnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<BlockItem> CHURN_ITEM = registerBlockItem("churn", () -> new BlockItem(CHURN.get(), new Item.Properties()));

    public static final Supplier<SilkwormHabitat> SILKWORM_HABITAT = registerBlock("silkworm_habitat", () -> new SilkwormHabitat(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<BlockItem> SILKWORM_HABITAT_ITEM = registerBlockItem("silkworm_habitat", () -> new BlockItem(SILKWORM_HABITAT.get(), new Item.Properties()));


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
                entries.accept(new ItemStack(BlockRegistry.VILLAGER_SCARECROW_BLOCK.get()));
                entries.accept(new ItemStack(BlockRegistry.CHURN.get()));
                entries.accept(new ItemStack(BlockRegistry.SILKWORM_HABITAT.get()));

                entries.accept(new ItemStack(BlockRegistry.PALM_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.PALM_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.DENSE_PALM_LEAVES.get()));
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
                entries.accept(new ItemStack(BlockRegistry.BANANA_SAPLING.get()));
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
                entries.accept(new ItemStack(BlockRegistry.DRAGONFRUIT_SAPLING.get()));
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
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_SAPLING.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.LYCHEE_PRESSURE_PLATE.get()));

                entries.accept(new ItemStack(BlockRegistry.MANGO_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_SAPLING.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.MANGO_PRESSURE_PLATE.get()));

                entries.accept(new ItemStack(BlockRegistry.ORANGE_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_SAPLING.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.ORANGE_PRESSURE_PLATE.get()));

                entries.accept(new ItemStack(BlockRegistry.PEAR_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_SAPLING.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.PEAR_PRESSURE_PLATE.get()));

                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_SAPLING.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.POMEGRANATE_PRESSURE_PLATE.get()));

                entries.accept(new ItemStack(BlockRegistry.MULBERRY_LOG.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_PLANKS.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_SAPLING.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_LEAVES.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_DOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_TRAPDOOR.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_SLAB.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_STAIRS.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_FENCE.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_FENCE_GATE.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_HANGING_SIGN.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_BUTTON.get()));
                entries.accept(new ItemStack(BlockRegistry.MULBERRY_PRESSURE_PLATE.get()));
            })
            .build());
}