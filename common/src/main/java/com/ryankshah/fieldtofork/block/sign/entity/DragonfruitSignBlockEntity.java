package com.ryankshah.fieldtofork.block.sign.entity;

import com.ryankshah.fieldtofork.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DragonfruitSignBlockEntity extends SignBlockEntity
{
    public DragonfruitSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BlockEntityRegistry.DRAGONFRUIT_SIGN.get();
    }
}
