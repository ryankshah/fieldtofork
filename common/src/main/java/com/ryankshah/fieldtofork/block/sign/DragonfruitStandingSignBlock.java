package com.ryankshah.fieldtofork.block.sign;

import com.ryankshah.fieldtofork.block.sign.entity.BananaSignBlockEntity;
import com.ryankshah.fieldtofork.block.sign.entity.DragonfruitSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DragonfruitStandingSignBlock extends StandingSignBlock
{
    public DragonfruitStandingSignBlock(WoodType p_56991_, Properties p_56990_) {
        super(p_56991_, p_56990_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DragonfruitSignBlockEntity(pPos, pState);
    }
}
