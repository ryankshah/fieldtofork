package com.ryankshah.fieldtofork.data.provider;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.block.FTFButtonBlock;
import com.ryankshah.fieldtofork.block.FTFPressurePlateBlock;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import net.minecraft.client.gui.screens.inventory.SignEditScreen;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.AttachFace;
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
        doorBlockWithRenderType(BlockRegistry.PALM_DOOR.get(),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_door_bottom"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_door_top"), ResourceLocation.withDefaultNamespace("cutout"));
        itemModels().basicItem(BlockRegistry.PALM_DOOR.get().asItem());
        trapdoorBlockWithRenderType(BlockRegistry.PALM_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_trapdoor"), true, ResourceLocation.withDefaultNamespace("cutout"));
        simpleBlockItem(BlockRegistry.PALM_TRAPDOOR.get(), models().getExistingFile(modLoc("palm_trapdoor_bottom")));
        simpleBlockWithItem(BlockRegistry.PALM_LEAVES.get(), cubeAll(BlockRegistry.PALM_LEAVES.get()));// models().withExistingParent("block/palm_leaves", "item/generated").texture("layer0", "block/palm_leaves"));
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
//        simpleBlockItem(BlockRegistry.PALM_FENCE_GATE.get(), models().getExistingFile(modLoc("palm_fence_gate_wall")));
        simpleBlockItem(BlockRegistry.PALM_FENCE_GATE.get(), models().fenceGate("palm_fence_gate", modLoc("block/palm_planks")));
        signBlock(BlockRegistry.PALM_SIGN.get(), BlockRegistry.PALM_WALL_SIGN.get(), blockTexture(BlockRegistry.PALM_PLANKS.get()));
//        simpleBlockItem(BlockRegistry.PALM_SIGN.get(), models().sign("palm_sign", modLoc("block/palm_planks")));
        itemModels().basicItem(BlockRegistry.PALM_SIGN.get().asItem());
        hangingSignBlock(BlockRegistry.PALM_HANGING_SIGN.get(), BlockRegistry.PALM_WALL_HANGING_SIGN.get(), blockTexture(BlockRegistry.PALM_PLANKS.get()));
//        simpleBlockItem(BlockRegistry.PALM_SIGN.get(), models().sign("palm_sign", modLoc("block/palm_planks")));
        itemModels().basicItem(BlockRegistry.PALM_HANGING_SIGN.get().asItem());
        buttonBlock(BlockRegistry.PALM_BUTTON.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"));
        simpleBlockItem(BlockRegistry.PALM_BUTTON.get(), models().buttonInventory("palm_button", modLoc("block/palm_planks")));
        pressurePlateBlock(BlockRegistry.PALM_PRESSURE_PLATE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/palm_planks"));
        simpleBlockItem(BlockRegistry.PALM_PRESSURE_PLATE.get(), models().getExistingFile(modLoc("palm_pressure_plate")));

        logBlock(BlockRegistry.BANANA_TREE_LOG.get());
        simpleBlockItem(BlockRegistry.BANANA_TREE_LOG.get(), models().getExistingFile(modLoc("banana_tree_log")));
        simpleBlockWithItem(BlockRegistry.BANANA_TREE_PLANKS.get(), cubeAll(BlockRegistry.BANANA_TREE_PLANKS.get()));

        logBlock(BlockRegistry.DRAGONFRUIT_TREE_LOG.get());
        simpleBlockItem(BlockRegistry.DRAGONFRUIT_TREE_LOG.get(), models().getExistingFile(modLoc("dragonfruit_tree_log")));
        simpleBlockWithItem(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get(), cubeAll(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get()));

        logBlock(BlockRegistry.LYCHEE_TREE_LOG.get());
        simpleBlockItem(BlockRegistry.LYCHEE_TREE_LOG.get(), models().getExistingFile(modLoc("lychee_tree_log")));
        simpleBlockWithItem(BlockRegistry.LYCHEE_TREE_PLANKS.get(), cubeAll(BlockRegistry.LYCHEE_TREE_PLANKS.get()));

        logBlock(BlockRegistry.MANGO_LOG.get());
        simpleBlockItem(BlockRegistry.MANGO_LOG.get(), models().getExistingFile(modLoc("mango_log")));
        simpleBlockWithItem(BlockRegistry.MANGO_PLANKS.get(), cubeAll(BlockRegistry.MANGO_PLANKS.get()));

        logBlock(BlockRegistry.ORANGE_LOG.get());
        simpleBlockItem(BlockRegistry.ORANGE_LOG.get(), models().getExistingFile(modLoc("orange_log")));
        simpleBlockWithItem(BlockRegistry.ORANGE_PLANKS.get(), cubeAll(BlockRegistry.ORANGE_PLANKS.get()));

        logBlock(BlockRegistry.PEAR_LOG.get());
        simpleBlockItem(BlockRegistry.PEAR_LOG.get(), models().getExistingFile(modLoc("pear_log")));
        simpleBlockWithItem(BlockRegistry.PEAR_PLANKS.get(), cubeAll(BlockRegistry.PEAR_PLANKS.get()));

        logBlock(BlockRegistry.POMEGRANATE_LOG.get());
        simpleBlockItem(BlockRegistry.POMEGRANATE_LOG.get(), models().getExistingFile(modLoc("pomegranate_log")));
        simpleBlockWithItem(BlockRegistry.POMEGRANATE_PLANKS.get(), cubeAll(BlockRegistry.POMEGRANATE_PLANKS.get()));
    }


    public void pressurePlateBlock(FTFPressurePlateBlock block, ResourceLocation texture) {
        ModelFile pressurePlate = this.models().pressurePlate(this.name(block), texture);
        ModelFile pressurePlateDown = this.models().pressurePlateDown(this.name(block) + "_down", texture);
        this.pressurePlateBlock(block, pressurePlate, pressurePlateDown);
    }
    public void pressurePlateBlock(FTFPressurePlateBlock block, ModelFile pressurePlate, ModelFile pressurePlateDown) {
        this.getVariantBuilder(block).partialState().with(PressurePlateBlock.POWERED, true).addModels(new ConfiguredModel[]{new ConfiguredModel(pressurePlateDown)}).partialState().with(PressurePlateBlock.POWERED, false).addModels(new ConfiguredModel[]{new ConfiguredModel(pressurePlate)});
    }

    public void buttonBlock(FTFButtonBlock block, ResourceLocation texture) {
        ModelFile button = this.models().button(this.name(block), texture);
        ModelFile buttonPressed = this.models().buttonPressed(this.name(block) + "_pressed", texture);
        this.buttonBlock(block, button, buttonPressed);
    }
    public void buttonBlock(FTFButtonBlock block, ModelFile button, ModelFile buttonPressed) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            Direction facing = (Direction)state.getValue(ButtonBlock.FACING);
            AttachFace face = (AttachFace)state.getValue(ButtonBlock.FACE);
            boolean powered = (Boolean)state.getValue(ButtonBlock.POWERED);
            return ConfiguredModel.builder().modelFile(powered ? buttonPressed : button).rotationX(face == AttachFace.FLOOR ? 0 : (face == AttachFace.WALL ? 90 : 180)).rotationY((int)(face == AttachFace.CEILING ? facing : facing.getOpposite()).toYRot()).uvLock(face == AttachFace.WALL).build();
        });
    }

    public void hangingSignBlock(CeilingHangingSignBlock signBlock, WallHangingSignBlock wallSignBlock, ResourceLocation texture) {
        ModelFile sign = this.models().sign(this.name(signBlock), texture);
        this.hangingSignBlock(signBlock, wallSignBlock, (ModelFile)sign);
    }

    public void hangingSignBlock(CeilingHangingSignBlock signBlock, WallHangingSignBlock wallSignBlock, ModelFile sign) {
        this.simpleBlock(signBlock, (ModelFile)sign);
        this.simpleBlock(wallSignBlock, (ModelFile)sign);
    }

    private String name(Block block) {
        return this.key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}