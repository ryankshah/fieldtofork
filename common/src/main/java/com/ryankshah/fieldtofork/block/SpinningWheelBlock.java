package com.ryankshah.fieldtofork.block;

import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpinningWheelBlock extends Block
{
    public SpinningWheelBlock(Properties p_54422_) {
        super(p_54422_);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if(itemstack.is(ItemRegistry.UNWOVEN_SILK.get())) {
            itemstack.consume(1, pPlayer);
            pPlayer.addItem(new ItemStack(ItemRegistry.SILK_STRING.get()));
            return ItemInteractionResult.CONSUME;
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Block.box(0, 0, 0, 16, 16, 16);
    }
}
