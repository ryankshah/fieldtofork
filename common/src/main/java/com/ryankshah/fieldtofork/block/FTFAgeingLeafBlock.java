package com.ryankshah.fieldtofork.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class FTFAgeingLeafBlock extends LeavesBlock implements BonemealableBlock
{
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE;
    private Supplier<Item> drop;

    public FTFAgeingLeafBlock(Properties p_54422_, Supplier<Item> drop) {
        super(p_54422_);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(AGE, 0).setValue(DISTANCE, 7).setValue(PERSISTENT, false).setValue(WATERLOGGED, false));

        this.drop = drop;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{AGE, DISTANCE, PERSISTENT, WATERLOGGED});
    }

    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(drop.get());
    }

    protected boolean isRandomlyTicking(BlockState pState) {
        return (Integer)pState.getValue(AGE) < 3; //&& (Integer)pState.getValue(DISTANCE) == 7 && !(Boolean)pState.getValue(PERSISTENT);
    }

    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int i = (Integer)pState.getValue(AGE);
        if (i < 3 && pRandom.nextInt(5) == 0 && pLevel.getRawBrightness(pPos.above(), 0) >= 9) {
            BlockState blockstate = (BlockState)pState.setValue(AGE, i + 1);
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
        }

    }

    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        int i = (Integer)pState.getValue(AGE);
        boolean flag = i == 3;
        return !flag && pStack.is(Items.BONE_MEAL) ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION : super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        int i = (Integer)pState.getValue(AGE);
        boolean flag = i == 3;
        if (i > 1) {
            int j = 1 + pLevel.random.nextInt(2);
            popResource(pLevel, pPos, new ItemStack(drop.get(), j + (flag ? 1 : 0)));
            pLevel.playSound((Player)null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
            BlockState blockstate = (BlockState)pState.setValue(AGE, 1);
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
        }
    }

    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return (Integer)pState.getValue(AGE) < 3;
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    static {
        AGE = BlockStateProperties.AGE_3;
    }

    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        int i = Math.min(3, (Integer)pState.getValue(AGE) + 1);
        pLevel.setBlock(pPos, (BlockState)pState.setValue(AGE, i), 2);
    }
}
