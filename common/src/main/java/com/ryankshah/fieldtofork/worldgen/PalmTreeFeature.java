package com.ryankshah.fieldtofork.worldgen;

import com.mojang.serialization.Codec;
import com.ryankshah.fieldtofork.Constants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class PalmTreeFeature extends Feature<TreeConfiguration>
{
    private static final ResourceLocation[] PALM_TREES = {
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "trees/palm_tree_0"),
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "trees/palm_tree_1"),
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "trees/palm_tree_2")
    };

    public PalmTreeFeature(final Codec<TreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
        // rotation / mirror
        Mirror mirror = Mirror.NONE;
        Rotation rotation = Rotation.getRandom(context.random());

        // template for tree
        final StructureTemplateManager manager = context.level().getLevel().getStructureManager();
        final StructureTemplate template = manager.getOrCreate(Util.getRandom(PALM_TREES, context.random()));

        // position for tree
        final BlockPos offset = new BlockPos(-3, 0, -3);
        BlockPos pos = context.origin().offset(offset.rotate(rotation));

        // placement settings
        BoundingBox mbb = new BoundingBox(pos.getX() - 8, pos.getY() - 16, pos.getZ() - 8, pos.getX() + 8, pos.getY() + 16, pos.getZ() + 8);
        StructurePlaceSettings placement = new StructurePlaceSettings()
                .setRotation(rotation).setMirror(mirror).setRandom(context.random()).setBoundingBox(mbb)
                .addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR)
                .addProcessor(LocProcessor.REQUIRE_AIR);
        // actually build using the template
        template.placeInWorld(context.level(), pos, pos, placement, context.random(), 2);
        return true;
    }
}