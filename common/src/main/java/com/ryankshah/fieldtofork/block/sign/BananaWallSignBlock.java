package com.ryankshah.fieldtofork.block.sign;

import com.ryankshah.fieldtofork.block.sign.entity.BananaSignBlockEntity;
import com.ryankshah.fieldtofork.block.sign.entity.PalmSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BananaWallSignBlock extends WallSignBlock
{
    public BananaWallSignBlock(WoodType pType, Properties pProperties) {
        super(pType, pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BananaSignBlockEntity(pPos, pState);
    }
}