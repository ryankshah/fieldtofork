package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.block.FTFAgeingLeafBlock;
import com.ryankshah.fieldtofork.block.FTFPressurePlateBlock;
import com.ryankshah.fieldtofork.block.silkworm_habitat.SilkwormHabitat;
import com.ryankshah.fieldtofork.block.crop.FTFCropBlock;
import com.ryankshah.fieldtofork.block.crop.TwoHighCropBlock;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FTFBlockStateProvider extends BlockStateProvider
{
    public FTFBlockStateProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.VILLAGER_SCARECROW_BLOCK.get(), models().getExistingFile(modLoc("block/villager_scarecrow")));
        simpleBlockItem(BlockRegistry.VILLAGER_SCARECROW_BLOCK.get(), models().getExistingFile(modLoc("villager_scarecrow")));

        simpleBlock(BlockRegistry.CHURN.get(), models().getExistingFile(modLoc("block/churn")));
        simpleBlockItem(BlockRegistry.CHURN.get(), models().getExistingFile(modLoc("churn")));

        silkwormHabitat(BlockRegistry.SILKWORM_HABITAT.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_leaves")); // models().getExistingFile(modLoc("block/silkworm_habitat")));
//        simpleBlockItem(BlockRegistry.SILKWORM_HABITAT.get(), models().getExistingFile(modLoc("silkworm_habitat")));

        saplingBlock(BlockRegistry.PALM_SAPLING.get());
        itemModels().basicItem(BlockRegistry.PALM_SAPLING.get().asItem());
        doorBlockWithRenderType(BlockRegistry.PALM_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.PALM_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.PALM_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.PALM_TRAPDOOR.get(), models().getExistingFile(modLoc("palm_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.PALM_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_leaves_full"));
        simpleBlockWithItem(BlockRegistry.DENSE_PALM_LEAVES.get(), cubeAll(BlockRegistry.DENSE_PALM_LEAVES.get()));
        logBlock(BlockRegistry.PALM_LOG.get());
        simpleBlockItem(BlockRegistry.PALM_LOG.get(), models().getExistingFile(modLoc("palm_log")));
        simpleBlockWithItem(BlockRegistry.PALM_PLANKS.get(), cubeAll(BlockRegistry.PALM_PLANKS.get()));
        slabBlock(BlockRegistry.PALM_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"));
        simpleBlockItem(BlockRegistry.PALM_SLAB.get(), models().getExistingFile(modLoc("palm_slab")));
        stairsBlock(BlockRegistry.PALM_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"));
        simpleBlockItem(BlockRegistry.PALM_STAIRS.get(), models().getExistingFile(modLoc("palm_stairs")));
        fenceBlock(BlockRegistry.PALM_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"));
        simpleBlockItem(BlockRegistry.PALM_FENCE.get(), models().fenceInventory("palm_fence", modLoc("block/palm_planks")));
        fenceGateBlock(BlockRegistry.PALM_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"));
        simpleBlockItem(BlockRegistry.PALM_FENCE_GATE.get(), models().fenceGate("palm_fence_gate", modLoc("block/palm_planks")));
        signBlock(BlockRegistry.PALM_SIGN.get(), BlockRegistry.PALM_WALL_SIGN.get(), blockTexture(BlockRegistry.PALM_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.PALM_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.PALM_HANGING_SIGN.get(), BlockRegistry.PALM_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.PALM_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.PALM_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.PALM_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"));
        itemModels().buttonInventory("palm_button", modLoc("block/palm_planks"));
        pressurePlateBlock(BlockRegistry.PALM_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"));
        simpleBlockItem(BlockRegistry.PALM_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("palm_pressure_plate")));

        saplingBlock(BlockRegistry.MULBERRY_SAPLING.get());
        itemModels().basicItem(BlockRegistry.MULBERRY_SAPLING.get().asItem());
        logBlock(BlockRegistry.MULBERRY_LOG.get());
        simpleBlockItem(BlockRegistry.MULBERRY_LOG.get(), models().getExistingFile(modLoc("mulberry_log")));
        simpleBlockWithItem(BlockRegistry.MULBERRY_PLANKS.get(), cubeAll(BlockRegistry.MULBERRY_PLANKS.get()));
        doorBlockWithRenderType(BlockRegistry.MULBERRY_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.MULBERRY_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.MULBERRY_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.MULBERRY_TRAPDOOR.get(), models().getExistingFile(modLoc("mulberry_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.MULBERRY_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_leaves_full"));
        slabBlock(BlockRegistry.MULBERRY_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_planks"));
        simpleBlockItem(BlockRegistry.MULBERRY_SLAB.get(), models().getExistingFile(modLoc("mulberry_slab")));
        stairsBlock(BlockRegistry.MULBERRY_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_planks"));
        simpleBlockItem(BlockRegistry.MULBERRY_STAIRS.get(), models().getExistingFile(modLoc("mulberry_stairs")));
        fenceBlock(BlockRegistry.MULBERRY_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_planks"));
        simpleBlockItem(BlockRegistry.MULBERRY_FENCE.get(), models().fenceInventory("mulberry_fence", modLoc("block/mulberry_planks")));
        fenceGateBlock(BlockRegistry.MULBERRY_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_planks"));
        simpleBlockItem(BlockRegistry.MULBERRY_FENCE_GATE.get(), models().fenceGate("mulberry_fence_gate", modLoc("block/mulberry_planks")));
        signBlock(BlockRegistry.MULBERRY_SIGN.get(), BlockRegistry.MULBERRY_WALL_SIGN.get(), blockTexture(BlockRegistry.MULBERRY_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.MULBERRY_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.MULBERRY_HANGING_SIGN.get(), BlockRegistry.MULBERRY_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.MULBERRY_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.MULBERRY_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.MULBERRY_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_planks"));
        itemModels().buttonInventory("mulberry_button", modLoc("block/mulberry_planks"));
        pressurePlateBlock(BlockRegistry.MULBERRY_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mulberry_planks"));
        simpleBlockItem(BlockRegistry.MULBERRY_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("mulberry_pressure_plate")));

        saplingBlock(BlockRegistry.BANANA_SAPLING.get());
        itemModels().basicItem(BlockRegistry.BANANA_SAPLING.get().asItem());
        logBlock(BlockRegistry.BANANA_TREE_LOG.get());
        simpleBlockItem(BlockRegistry.BANANA_TREE_LOG.get(), models().getExistingFile(modLoc("banana_tree_log")));
        simpleBlockWithItem(BlockRegistry.BANANA_TREE_PLANKS.get(), cubeAll(BlockRegistry.BANANA_TREE_PLANKS.get()));
        doorBlockWithRenderType(BlockRegistry.BANANA_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.BANANA_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.BANANA_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.BANANA_TRAPDOOR.get(), models().getExistingFile(modLoc("banana_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.BANANA_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_leaves_full"));
        slabBlock(BlockRegistry.BANANA_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_tree_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_tree_planks"));
        simpleBlockItem(BlockRegistry.BANANA_SLAB.get(), models().getExistingFile(modLoc("banana_slab")));
        stairsBlock(BlockRegistry.BANANA_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_tree_planks"));
        simpleBlockItem(BlockRegistry.BANANA_STAIRS.get(), models().getExistingFile(modLoc("banana_stairs")));
        fenceBlock(BlockRegistry.BANANA_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_tree_planks"));
        simpleBlockItem(BlockRegistry.BANANA_FENCE.get(), models().fenceInventory("banana_fence", modLoc("block/banana_tree_planks")));
        fenceGateBlock(BlockRegistry.BANANA_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_tree_planks"));
        simpleBlockItem(BlockRegistry.BANANA_FENCE_GATE.get(), models().fenceGate("banana_fence_gate", modLoc("block/banana_tree_planks")));
        signBlock(BlockRegistry.BANANA_SIGN.get(), BlockRegistry.BANANA_WALL_SIGN.get(), blockTexture(BlockRegistry.BANANA_TREE_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.BANANA_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.BANANA_HANGING_SIGN.get(), BlockRegistry.BANANA_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.BANANA_TREE_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.BANANA_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.BANANA_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_tree_planks"));
        itemModels().buttonInventory("banana_button", modLoc("block/banana_tree_planks"));
        pressurePlateBlock(BlockRegistry.BANANA_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/banana_tree_planks"));
        simpleBlockItem(BlockRegistry.BANANA_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("banana_pressure_plate")));

        saplingBlock(BlockRegistry.DRAGONFRUIT_SAPLING.get());
        itemModels().basicItem(BlockRegistry.DRAGONFRUIT_SAPLING.get().asItem());
        logBlock(BlockRegistry.DRAGONFRUIT_TREE_LOG.get());
        simpleBlockItem(BlockRegistry.DRAGONFRUIT_TREE_LOG.get(), models().getExistingFile(modLoc("dragonfruit_tree_log")));
        simpleBlockWithItem(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get(), cubeAll(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()));
        //        saplingBlock(BlockRegistry.DRAGONFRUIT_SAPLING.get());
        doorBlockWithRenderType(BlockRegistry.DRAGONFRUIT_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.DRAGONFRUIT_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get(), models().getExistingFile(modLoc("dragonfruit_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.DRAGONFRUIT_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_leaves_full"));
        slabBlock(BlockRegistry.DRAGONFRUIT_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_tree_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_tree_planks"));
        simpleBlockItem(BlockRegistry.DRAGONFRUIT_SLAB.get(), models().getExistingFile(modLoc("dragonfruit_slab")));
        stairsBlock(BlockRegistry.DRAGONFRUIT_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_tree_planks"));
        simpleBlockItem(BlockRegistry.DRAGONFRUIT_STAIRS.get(), models().getExistingFile(modLoc("dragonfruit_stairs")));
        fenceBlock(BlockRegistry.DRAGONFRUIT_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_tree_planks"));
        simpleBlockItem(BlockRegistry.DRAGONFRUIT_FENCE.get(), models().fenceInventory("dragonfruit_fence", modLoc("block/dragonfruit_tree_planks")));
        fenceGateBlock(BlockRegistry.DRAGONFRUIT_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_tree_planks"));
//        simpleBlockItem(BlockRegistry.DRAGONFRUIT_FENCE_GATE.get(), models().getExistingFile(modLoc("dragonfruit_fence_gate_wall")));
        simpleBlockItem(BlockRegistry.DRAGONFRUIT_FENCE_GATE.get(), models().fenceGate("dragonfruit_fence_gate", modLoc("block/dragonfruit_tree_planks")));
        signBlock(BlockRegistry.DRAGONFRUIT_SIGN.get(), BlockRegistry.DRAGONFRUIT_WALL_SIGN.get(), blockTexture(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()));
//        simpleBlockItem(BlockRegistry.DRAGONFRUIT_SIGN.get(), models().sign("dragonfruit_sign", modLoc("block/dragonfruit_tree_planks")));
        itemModels().basicItem(BlockRegistry.DRAGONFRUIT_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get(), BlockRegistry.DRAGONFRUIT_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()));
//        simpleBlockItem(BlockRegistry.DRAGONFRUIT_SIGN.get(), models().sign("dragonfruit_sign", modLoc("block/dragonfruit_tree_planks")));
        itemModels().basicItem(BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.DRAGONFRUIT_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_tree_planks"));
        itemModels().buttonInventory("dragonfruit_button", modLoc("block/dragonfruit_tree_planks"));
        pressurePlateBlock(BlockRegistry.DRAGONFRUIT_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/dragonfruit_tree_planks"));
        simpleBlockItem(BlockRegistry.DRAGONFRUIT_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("dragonfruit_pressure_plate")));

        saplingBlock(BlockRegistry.LYCHEE_SAPLING.get());
        itemModels().basicItem(BlockRegistry.LYCHEE_SAPLING.get().asItem());
        logBlock(BlockRegistry.LYCHEE_TREE_LOG.get());
        simpleBlockItem(BlockRegistry.LYCHEE_TREE_LOG.get(), models().getExistingFile(modLoc("lychee_tree_log")));
        simpleBlockWithItem(BlockRegistry.LYCHEE_TREE_PLANKS.get(), cubeAll(BlockRegistry.LYCHEE_TREE_PLANKS.get()));
        doorBlockWithRenderType(BlockRegistry.LYCHEE_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.LYCHEE_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.LYCHEE_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.LYCHEE_TRAPDOOR.get(), models().getExistingFile(modLoc("lychee_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.LYCHEE_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_leaves_full"));
        slabBlock(BlockRegistry.LYCHEE_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_tree_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_tree_planks"));
        simpleBlockItem(BlockRegistry.LYCHEE_SLAB.get(), models().getExistingFile(modLoc("lychee_slab")));
        stairsBlock(BlockRegistry.LYCHEE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_tree_planks"));
        simpleBlockItem(BlockRegistry.LYCHEE_STAIRS.get(), models().getExistingFile(modLoc("lychee_stairs")));
        fenceBlock(BlockRegistry.LYCHEE_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_tree_planks"));
        simpleBlockItem(BlockRegistry.LYCHEE_FENCE.get(), models().fenceInventory("lychee_fence", modLoc("block/lychee_tree_planks")));
        fenceGateBlock(BlockRegistry.LYCHEE_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_tree_planks"));
        simpleBlockItem(BlockRegistry.LYCHEE_FENCE_GATE.get(), models().fenceGate("lychee_fence_gate", modLoc("block/lychee_tree_planks")));
        signBlock(BlockRegistry.LYCHEE_SIGN.get(), BlockRegistry.LYCHEE_WALL_SIGN.get(), blockTexture(BlockRegistry.LYCHEE_TREE_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.LYCHEE_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.LYCHEE_HANGING_SIGN.get(), BlockRegistry.LYCHEE_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.LYCHEE_TREE_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.LYCHEE_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.LYCHEE_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_tree_planks"));
        itemModels().buttonInventory("lychee_button", modLoc("block/lychee_tree_planks"));
        pressurePlateBlock(BlockRegistry.LYCHEE_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/lychee_tree_planks"));
        simpleBlockItem(BlockRegistry.LYCHEE_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("lychee_pressure_plate")));

        logBlock(BlockRegistry.MANGO_LOG.get());
        simpleBlockItem(BlockRegistry.MANGO_LOG.get(), models().getExistingFile(modLoc("mango_log")));
        simpleBlockWithItem(BlockRegistry.MANGO_PLANKS.get(), cubeAll(BlockRegistry.MANGO_PLANKS.get()));
        saplingBlock(BlockRegistry.MANGO_SAPLING.get());
        itemModels().basicItem(BlockRegistry.MANGO_SAPLING.get().asItem());
        doorBlockWithRenderType(BlockRegistry.MANGO_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.MANGO_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.MANGO_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.MANGO_TRAPDOOR.get(), models().getExistingFile(modLoc("mango_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.MANGO_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_leaves_full"));
        slabBlock(BlockRegistry.MANGO_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_planks"));
        simpleBlockItem(BlockRegistry.MANGO_SLAB.get(), models().getExistingFile(modLoc("mango_slab")));
        stairsBlock(BlockRegistry.MANGO_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_planks"));
        simpleBlockItem(BlockRegistry.MANGO_STAIRS.get(), models().getExistingFile(modLoc("mango_stairs")));
        fenceBlock(BlockRegistry.MANGO_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_planks"));
        simpleBlockItem(BlockRegistry.MANGO_FENCE.get(), models().fenceInventory("mango_fence", modLoc("block/mango_planks")));
        fenceGateBlock(BlockRegistry.MANGO_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_planks"));
        simpleBlockItem(BlockRegistry.MANGO_FENCE_GATE.get(), models().fenceGate("mango_fence_gate", modLoc("block/mango_planks")));
        signBlock(BlockRegistry.MANGO_SIGN.get(), BlockRegistry.MANGO_WALL_SIGN.get(), blockTexture(BlockRegistry.MANGO_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.MANGO_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.MANGO_HANGING_SIGN.get(), BlockRegistry.MANGO_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.MANGO_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.MANGO_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.MANGO_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_planks"));
        itemModels().buttonInventory("mango_button", modLoc("block/mango_planks"));
        pressurePlateBlock(BlockRegistry.MANGO_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/mango_planks"));
        simpleBlockItem(BlockRegistry.MANGO_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("mango_pressure_plate")));


        logBlock(BlockRegistry.ORANGE_LOG.get());
        simpleBlockItem(BlockRegistry.ORANGE_LOG.get(), models().getExistingFile(modLoc("orange_log")));
        simpleBlockWithItem(BlockRegistry.ORANGE_PLANKS.get(), cubeAll(BlockRegistry.ORANGE_PLANKS.get()));
        saplingBlock(BlockRegistry.ORANGE_SAPLING.get());
        itemModels().basicItem(BlockRegistry.ORANGE_SAPLING.get().asItem());
        doorBlockWithRenderType(BlockRegistry.ORANGE_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.ORANGE_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.ORANGE_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.ORANGE_TRAPDOOR.get(), models().getExistingFile(modLoc("orange_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.ORANGE_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_leaves_full"));
        slabBlock(BlockRegistry.ORANGE_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_planks"));
        simpleBlockItem(BlockRegistry.ORANGE_SLAB.get(), models().getExistingFile(modLoc("orange_slab")));
        stairsBlock(BlockRegistry.ORANGE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_planks"));
        simpleBlockItem(BlockRegistry.ORANGE_STAIRS.get(), models().getExistingFile(modLoc("orange_stairs")));
        fenceBlock(BlockRegistry.ORANGE_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_planks"));
        simpleBlockItem(BlockRegistry.ORANGE_FENCE.get(), models().fenceInventory("orange_fence", modLoc("block/orange_planks")));
        fenceGateBlock(BlockRegistry.ORANGE_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_planks"));
        simpleBlockItem(BlockRegistry.ORANGE_FENCE_GATE.get(), models().fenceGate("orange_fence_gate", modLoc("block/orange_planks")));
        signBlock(BlockRegistry.ORANGE_SIGN.get(), BlockRegistry.ORANGE_WALL_SIGN.get(), blockTexture(BlockRegistry.ORANGE_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.ORANGE_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.ORANGE_HANGING_SIGN.get(), BlockRegistry.ORANGE_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.ORANGE_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.ORANGE_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.ORANGE_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_planks"));
        itemModels().buttonInventory("orange_button", modLoc("block/orange_planks"));
        pressurePlateBlock(BlockRegistry.ORANGE_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/orange_planks"));
        simpleBlockItem(BlockRegistry.ORANGE_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("orange_pressure_plate")));

        logBlock(BlockRegistry.PEAR_LOG.get());
        simpleBlockItem(BlockRegistry.PEAR_LOG.get(), models().getExistingFile(modLoc("pear_log")));
        simpleBlockWithItem(BlockRegistry.PEAR_PLANKS.get(), cubeAll(BlockRegistry.PEAR_PLANKS.get()));
        saplingBlock(BlockRegistry.PEAR_SAPLING.get());
        itemModels().basicItem(BlockRegistry.PEAR_SAPLING.get().asItem());
        doorBlockWithRenderType(BlockRegistry.PEAR_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.PEAR_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.PEAR_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.PEAR_TRAPDOOR.get(), models().getExistingFile(modLoc("pear_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.PEAR_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_leaves_full"));
        slabBlock(BlockRegistry.PEAR_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_planks"));
        simpleBlockItem(BlockRegistry.PEAR_SLAB.get(), models().getExistingFile(modLoc("pear_slab")));
        stairsBlock(BlockRegistry.PEAR_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_planks"));
        simpleBlockItem(BlockRegistry.PEAR_STAIRS.get(), models().getExistingFile(modLoc("pear_stairs")));
        fenceBlock(BlockRegistry.PEAR_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_planks"));
        simpleBlockItem(BlockRegistry.PEAR_FENCE.get(), models().fenceInventory("pear_fence", modLoc("block/pear_planks")));
        fenceGateBlock(BlockRegistry.PEAR_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_planks"));
        simpleBlockItem(BlockRegistry.PEAR_FENCE_GATE.get(), models().fenceGate("pear_fence_gate", modLoc("block/pear_planks")));
        signBlock(BlockRegistry.PEAR_SIGN.get(), BlockRegistry.PEAR_WALL_SIGN.get(), blockTexture(BlockRegistry.PEAR_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.PEAR_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.PEAR_HANGING_SIGN.get(), BlockRegistry.PEAR_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.PEAR_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.PEAR_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.PEAR_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_planks"));
        itemModels().buttonInventory("pear_button", modLoc("block/pear_planks"));
        pressurePlateBlock(BlockRegistry.PEAR_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pear_planks"));
        simpleBlockItem(BlockRegistry.PEAR_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("pear_pressure_plate")));

        logBlock(BlockRegistry.POMEGRANATE_LOG.get());
        simpleBlockItem(BlockRegistry.POMEGRANATE_LOG.get(), models().getExistingFile(modLoc("pomegranate_log")));
        simpleBlockWithItem(BlockRegistry.POMEGRANATE_PLANKS.get(), cubeAll(BlockRegistry.POMEGRANATE_PLANKS.get()));
        saplingBlock(BlockRegistry.POMEGRANATE_SAPLING.get());
        itemModels().basicItem(BlockRegistry.POMEGRANATE_SAPLING.get().asItem());
        doorBlockWithRenderType(BlockRegistry.POMEGRANATE_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_door_top"), ResourceLocation.tryParse("cutout"));
        itemModels().basicItem(BlockRegistry.POMEGRANATE_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.POMEGRANATE_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_trapdoor"), true, ResourceLocation.tryParse("cutout"));
        simpleBlockItem(BlockRegistry.POMEGRANATE_TRAPDOOR.get(), models().getExistingFile(modLoc("pomegranate_trapdoor_bottom")));
        ageingLeafblockWithItem(BlockRegistry.POMEGRANATE_LEAVES.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_leaves"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_leaves_full"));
        slabBlock(BlockRegistry.POMEGRANATE_SLAB.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_planks"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_planks"));
        simpleBlockItem(BlockRegistry.POMEGRANATE_SLAB.get(), models().getExistingFile(modLoc("pomegranate_slab")));
        stairsBlock(BlockRegistry.POMEGRANATE_STAIRS.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_planks"));
        simpleBlockItem(BlockRegistry.POMEGRANATE_STAIRS.get(), models().getExistingFile(modLoc("pomegranate_stairs")));
        fenceBlock(BlockRegistry.POMEGRANATE_FENCE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_planks"));
        simpleBlockItem(BlockRegistry.POMEGRANATE_FENCE.get(), models().fenceInventory("pomegranate_fence", modLoc("block/pomegranate_planks")));
        fenceGateBlock(BlockRegistry.POMEGRANATE_FENCE_GATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_planks"));
        simpleBlockItem(BlockRegistry.POMEGRANATE_FENCE_GATE.get(), models().fenceGate("pomegranate_fence_gate", modLoc("block/pomegranate_planks")));
        signBlock(BlockRegistry.POMEGRANATE_SIGN.get(), BlockRegistry.POMEGRANATE_WALL_SIGN.get(), blockTexture(BlockRegistry.POMEGRANATE_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.POMEGRANATE_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.POMEGRANATE_HANGING_SIGN.get(), BlockRegistry.POMEGRANATE_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.POMEGRANATE_PLANKS.get()));
        itemModels().basicItem(BlockRegistry.POMEGRANATE_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.POMEGRANATE_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_planks"));
        itemModels().buttonInventory("pomegranate_button", modLoc("block/pomegranate_planks"));
        pressurePlateBlock(BlockRegistry.POMEGRANATE_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/pomegranate_planks"));
        simpleBlockItem(BlockRegistry.POMEGRANATE_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("pomegranate_pressure_plate")));

        //Crops
        doubleHighCropBlock(BlockRegistry.GRAPE_CROP.get());
        threeStageCrop(BlockRegistry.SWEET_POTATO_CROP.get());
        threeStageCrop(BlockRegistry.RADISH_CROP.get());
        threeStageCrop(BlockRegistry.CHILLI_CROP.get());
        threeStageCrop(BlockRegistry.ASPARAGUS_CROP.get());
        threeStageCrop(BlockRegistry.LEEK_CROP.get());
        threeStageCrop(BlockRegistry.EGGPLANT_CROP.get());
        threeStageCrop(BlockRegistry.BELL_PEPPER_CROP.get());
        threeStageCrop(BlockRegistry.ZUCCHINI_CROP.get());
        doubleHighCropBlock(BlockRegistry.PASSIONFRUIT_CROP.get());
        threeStageCrop(BlockRegistry.STRAWBERRY_CROP.get());
        sevenStageCrop(BlockRegistry.DURUM_WHEAT_CROP.get());
        threeStageCrop(BlockRegistry.GINGER_CROP.get());
    }


    public void pressurePlateBlock(FTFPressurePlateBlock block, ResourceLocation texture) {
        ModelFile pressurePlate = this.models().pressurePlate(this.name(block), texture);
        ModelFile pressurePlateDown = this.models().pressurePlateDown(this.name(block) + "_down", texture);
        this.pressurePlateBlock(block, pressurePlate, pressurePlateDown);
    }
    public void pressurePlateBlock(FTFPressurePlateBlock block, ModelFile pressurePlate, ModelFile pressurePlateDown) {
        this.getVariantBuilder(block).partialState().with(PressurePlateBlock.POWERED, true).addModels(new ConfiguredModel[]{new ConfiguredModel(pressurePlateDown)}).partialState().with(PressurePlateBlock.POWERED, false).addModels(new ConfiguredModel[]{new ConfiguredModel(pressurePlate)});
    }

    public void hangingSignBlock(CeilingHangingSignBlock signBlock, WallHangingSignBlock wallSignBlock, ResourceLocation texture) {
        ModelFile sign = this.models().sign(this.name(signBlock), texture);
        this.hangingSignBlock(signBlock, wallSignBlock, (ModelFile)sign);
    }

    public void hangingSignBlock(CeilingHangingSignBlock signBlock, WallHangingSignBlock wallSignBlock, ModelFile sign) {
        this.simpleBlock(signBlock, (ModelFile)sign);
        this.simpleBlock(wallSignBlock, (ModelFile)sign);
    }

    private void saplingBlock(Block block) {
        simpleBlock(block,
                models().cross(this.name(block), blockTexture(block)).renderType("cutout"));
    }

    public void ageingLeafblockWithItem(FTFAgeingLeafBlock block, ResourceLocation texture, ResourceLocation agedTexture) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            int age = state.getValue(FTFAgeingLeafBlock.AGE);

            ModelFile leaf = this.models().cubeAll(this.name(block), texture);
//            ModelFile leaf_age_1 = this.models().buttonPressed(this.name(block) + "_age_1", texture);
            ModelFile leaf_age_2 = this.models().cubeAll(this.name(block) + "_full", agedTexture);

            this.simpleBlockItem(block, leaf);
            this.simpleBlockItem(block, leaf_age_2);

            return ConfiguredModel.builder().modelFile(
                    age <= 1 ? leaf : leaf_age_2).build();
        });
    }

    public void silkwormHabitat(SilkwormHabitat block, ResourceLocation texture) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            boolean hasLeaves = state.getValue(SilkwormHabitat.HAS_LEAVES);
            boolean hasWorms = state.getValue(SilkwormHabitat.HAS_WORMS);

            ModelFile empty = this.models().getExistingFile(modLoc("block/"+this.name(block)));
            ModelFile leaves_only = this.models().getExistingFile(modLoc("block/"+this.name(block) + "_leaves"));
            ModelFile leaves_worms = this.models().getExistingFile(modLoc("block/"+this.name(block) + "_leaves_worms"));

            this.simpleBlockItem(block, empty);
            this.simpleBlockItem(block, leaves_only);
            this.simpleBlockItem(block, leaves_worms);

            if(hasLeaves && !hasWorms)
                return ConfiguredModel.builder().modelFile(leaves_only).build();
            else if(hasLeaves && hasWorms)
                return ConfiguredModel.builder().modelFile(leaves_worms).build();
            else
                return ConfiguredModel.builder().modelFile(empty).build();
        });
    }

    public void doubleHighCropBlock(TwoHighCropBlock block) {
        ModelFile stage0_bottom = models().getBuilder(key(block) + "_bottom_0")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross")))
                .texture("cross", modLoc("block/crops/" + name(block) + "_bottom_0"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_bottom_0"));
        ModelFile stage0_top = models().getBuilder(key(block) + "_top_0")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross")))
                .texture("cross", modLoc("block/crops/" + name(block) + "_top_0"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_top_0"));
        ModelFile stage1_bottom = models().getBuilder(name(block) + "_bottom_1")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross")))
                .texture("cross", modLoc("block/crops/" + name(block) + "_bottom_1"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_bottom_1"));
        ModelFile stage1_top = models().getBuilder(key(block) + "_top_1")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross")))
                .texture("cross", modLoc("block/crops/" + name(block) + "_top_1"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_top_1"));
        ModelFile stage2_bottom = models().getBuilder(key(block) + "_bottom_2")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross")))
                .texture("cross", modLoc("block/crops/" + name(block) + "_bottom_2"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_bottom_2"));
        ModelFile stage2_top = models().getBuilder(key(block) + "_top_2")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross")))
                .texture("cross", modLoc("block/crops/" + name(block) + "_top_2"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_top_2"));
        ModelFile stage3_bottom = models().getBuilder(key(block) + "_bottom_3")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross")))
                .texture("cross", modLoc("block/crops/" + name(block) + "_bottom_3"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_bottom_3"));
        ModelFile stage3_top = models().getBuilder(key(block) + "_top_3")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross")))
                .texture("cross", modLoc("block/crops/" + name(block) + "_top_3"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_top_3"));

        getVariantBuilder(block).forAllStatesExcept(state ->
        {
            int age = state.getValue(TwoHighCropBlock.AGE);
            DoubleBlockHalf half = state.getValue(TwoHighCropBlock.HALF);
            ModelFile mf = switch (age)
            {
                case 2, 3 -> half == DoubleBlockHalf.LOWER ? stage1_bottom : stage1_top;
                case 4, 5 -> half == DoubleBlockHalf.LOWER ? stage2_bottom : stage2_top;
                case 6, 7 -> half == DoubleBlockHalf.LOWER ? stage3_bottom : stage3_top;
                default -> half == DoubleBlockHalf.LOWER ? stage0_bottom : stage0_top;
            };
            return ConfiguredModel.builder()
                    .modelFile(mf)
                    .build();
        });
    }

    public void flowerBlock(Block block) {
        ResourceLocation blockKey = key(block);
        String path = blockKey.getPath();

        simpleBlock(block, models().getBuilder(blockKey.toString()).parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cross"))).texture("cross", modLoc("block/"+path)).renderType("cutout"));
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + path)));
    }

    public void crop(Block block) {
        ResourceLocation blockKey = key(block);
        String path = blockKey.getPath();

        this.getVariantBuilder(block)
                .forAllStates(state ->
                        ConfiguredModel.builder()
                                .modelFile(
                                        models().crop(
                                                path, modLoc("block/crops/" + name(block) + "_stage" + state.getValue(((FTFCropBlock) block).getAgeProperty()))
                                        )
                                )
                                .build()
                );
    }
    public void threeStageCrop(Block block) {
        ResourceLocation blockKey = key(block);
        String path = blockKey.getPath();

        ModelFile stage0 = models().getBuilder(key(block) + "_stage0")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage0"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage0"));
        ModelFile stage1 = models().getBuilder(name(block) + "_stage1")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage1"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage1"));
        ModelFile stage2 = models().getBuilder(key(block) + "_stage2")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage2"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage2"));
        ModelFile stage3 = models().getBuilder(key(block) + "_stage3")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage3"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage3"));

        getVariantBuilder(block).forAllStatesExcept(state ->
        {
            ModelFile mf = switch (state.getValue(CropBlock.AGE))
            {
                case 0,1 -> stage0;
                case 2,3 -> stage1;
                case 4,5,6 -> stage2;
                case 7 -> stage3;
                default -> stage0;
            };
            return ConfiguredModel.builder()
                    .modelFile(mf)
                    .build();
        });
    }
    public void sevenStageCrop(Block block) {
        ResourceLocation blockKey = key(block);
        String path = blockKey.getPath();

        ModelFile stage0 = models().getBuilder(key(block) + "_stage0")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage0"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage0"));
        ModelFile stage1 = models().getBuilder(name(block) + "_stage1")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage1"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage1"));
        ModelFile stage2 = models().getBuilder(key(block) + "_stage2")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage2"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage2"));
        ModelFile stage3 = models().getBuilder(key(block) + "_stage3")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage3"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage3"));
        ModelFile stage4 = models().getBuilder(key(block) + "_stage4")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage4"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage4"));
        ModelFile stage5 = models().getBuilder(key(block) + "_stage5")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage5"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage5"));
        ModelFile stage6 = models().getBuilder(key(block) + "_stage6")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage6"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage6"));
        ModelFile stage7 = models().getBuilder(key(block) + "_stage7")
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/crop")))
                .texture("crop", modLoc("block/crops/" + name(block) + "_stage7"))
                .renderType("cutout")
                .texture("particle", modLoc("block/crops/" + name(block) + "_stage7"));

        getVariantBuilder(block).forAllStatesExcept(state ->
        {
            ModelFile mf = switch (state.getValue(CropBlock.AGE))
            {
                case 0 -> stage0;
                case 1 -> stage1;
                case 2 -> stage2;
                case 3 -> stage3;
                case 4 -> stage4;
                case 5 -> stage5;
                case 6 -> stage6;
                case 7 -> stage7;
                default -> stage0;
            };
            return ConfiguredModel.builder()
                    .modelFile(mf)
                    .build();
        });
    }

    private String name(Block block) {
        return this.key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}