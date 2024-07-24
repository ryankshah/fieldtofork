package com.ryankshah.fieldtofork.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.ryankshah.fieldtofork.registry.WorldGenRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import javax.annotation.Nullable;

public class LocProcessor extends StructureProcessor
{
    public static final Codec<LocProcessor> CODEC = RuleTest.CODEC.xmap(LocProcessor::new, LocProcessor::getLocPredicate).stable();
    public static final MapCodec<LocProcessor> MAP_CODEC = RuleTest.CODEC.fieldOf("loc").xmap(LocProcessor::new, LocProcessor::getLocPredicate).stable();

    public static final LocProcessor REQUIRE_AIR = new LocProcessor(new BlockMatchTest(Blocks.AIR));

    private final RuleTest locPredicate;

    public LocProcessor(RuleTest locPredicate) {
        this.locPredicate = locPredicate;
    }

    public RuleTest getLocPredicate() {
        return locPredicate;
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader pLevel, BlockPos pOffset, BlockPos pPos, StructureTemplate.StructureBlockInfo pBlockInfo, StructureTemplate.StructureBlockInfo pRelativeBlockInfo, StructurePlaceSettings pSettings) {
        RandomSource random = pSettings.getRandom(pRelativeBlockInfo.pos());
        BlockState blockState = pLevel.getBlockState(pRelativeBlockInfo.pos());
        // only process the block if the existing block at this location passes the rule test
        if (locPredicate.test(blockState, random)) {
            return pRelativeBlockInfo;
        }
        return null;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return WorldGenRegistry.LOC_PROCESSOR.get();
    }
}