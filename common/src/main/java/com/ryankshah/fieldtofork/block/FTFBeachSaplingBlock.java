package com.ryankshah.fieldtofork.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class FTFBeachSaplingBlock extends SaplingBlock
{
    public FTFBeachSaplingBlock(TreeGrower p_304782_, Properties p_55979_) {
        super(p_304782_, p_55979_);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(BlockTags.DIRT) || pState.is(Blocks.FARMLAND) || pState.is(Blocks.SAND);
    }
}
