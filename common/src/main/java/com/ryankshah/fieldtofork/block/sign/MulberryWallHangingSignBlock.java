package com.ryankshah.fieldtofork.block.sign;

import com.ryankshah.fieldtofork.block.sign.entity.MulberryHangingSignBlockEntity;
import com.ryankshah.fieldtofork.block.sign.entity.PomegranateHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MulberryWallHangingSignBlock extends WallHangingSignBlock
{
    public MulberryWallHangingSignBlock(WoodType p_56991_, Properties p_56990_) {
        super(p_56991_, p_56990_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new MulberryHangingSignBlockEntity(pPos, pState);
    }
}
