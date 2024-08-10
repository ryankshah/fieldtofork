package com.ryankshah.fieldtofork.block.sign;

import com.ryankshah.fieldtofork.block.sign.entity.PomegranateHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class PomegranateHangingSignBlock extends CeilingHangingSignBlock
{
    public PomegranateHangingSignBlock(WoodType p_248716_, Properties p_250481_) {
        super(p_248716_, p_250481_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PomegranateHangingSignBlockEntity(pPos, pState);
    }
}
