package com.ryankshah.fieldtofork.block.sign;

import com.ryankshah.fieldtofork.block.sign.entity.BananaHangingSignBlockEntity;
import com.ryankshah.fieldtofork.block.sign.entity.PalmHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BananaHangingSignBlock extends CeilingHangingSignBlock
{
    public BananaHangingSignBlock(WoodType p_248716_, Properties p_250481_) {
        super(p_248716_, p_250481_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BananaHangingSignBlockEntity(pPos, pState);
    }
}
