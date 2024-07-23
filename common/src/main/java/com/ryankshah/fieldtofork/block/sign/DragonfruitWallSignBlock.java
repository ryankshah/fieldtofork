package com.ryankshah.fieldtofork.block.sign;

import com.ryankshah.fieldtofork.block.sign.entity.BananaSignBlockEntity;
import com.ryankshah.fieldtofork.block.sign.entity.DragonfruitSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DragonfruitWallSignBlock extends WallSignBlock
{
    public DragonfruitWallSignBlock(WoodType pType, Properties pProperties) {
        super(pType, pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DragonfruitSignBlockEntity(pPos, pState);
    }
}