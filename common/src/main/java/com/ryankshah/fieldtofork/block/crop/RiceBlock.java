package com.ryankshah.fieldtofork.block.crop;

import com.ryankshah.fieldtofork.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SeagrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Supplier;

public class RiceBlock extends CropBlock
{
    private Supplier<Item> seed;
    public RiceBlock(Properties p_52247_, Supplier<Item> seed) {
        super(p_52247_);
        this.seed = seed;
    }

//    @Override
//    protected boolean mayPlaceOn(BlockState p_154539_, BlockGetter p_154540_, BlockPos p_154541_) {
//        return p_154539_.isFaceSturdy(p_154540_, p_154541_, Direction.UP) && p_154539_.is(BlockRegistry.WATERLOGGED_SOIL.get());
//    }

    @Override
    protected ItemLike getBaseSeedId() {
        return seed.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return super.getAgeProperty();
    }
}