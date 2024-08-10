package com.ryankshah.fieldtofork.block.crop;

import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Supplier;

public class FTFCropBlock extends CropBlock
{
    private Supplier<Item> seed;
    public FTFCropBlock(Properties p_52247_, Supplier<Item> seed) {
        super(p_52247_);
        this.seed = seed;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return seed.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return super.getAgeProperty();
    }
}