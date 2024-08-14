package com.ryankshah.fieldtofork.worldgen.feature;

import com.mojang.serialization.Codec;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.worldgen.processor.LocProcessor;
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

public class BananaTreeFeature extends Feature<TreeConfiguration>
{
    private static final ResourceLocation[] TREES = {
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "trees/banana_tree_1"),
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "trees/banana_tree_2")
    };

    public BananaTreeFeature(final Codec<TreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
        // rotation / mirror
        Mirror mirror = Mirror.NONE;
        Rotation rotation = Rotation.getRandom(context.random());

        // template for tree
        final StructureTemplateManager manager = context.level().getLevel().getStructureManager();
        final StructureTemplate template = manager.getOrCreate(Util.getRandom(TREES, context.random()));

        // position for tree
        final BlockPos offset = new BlockPos(-3, 0, -1);
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