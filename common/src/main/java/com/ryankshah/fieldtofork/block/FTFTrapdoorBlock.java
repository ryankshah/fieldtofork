package com.ryankshah.fieldtofork.block;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

public class FTFTrapdoorBlock extends TrapDoorBlock
{
    public static final MapCodec<FTFTrapdoorBlock> CODEC = RecordCodecBuilder.mapCodec((p_308843_) -> {
        return p_308843_.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter((p_304735_) -> {
            return p_304735_.type;
        }), propertiesCodec()).apply(p_308843_, FTFTrapdoorBlock::new);
    });
    public static final BooleanProperty OPEN;
    public static final EnumProperty<Half> HALF;
    public static final BooleanProperty POWERED;
    public static final BooleanProperty WATERLOGGED;
    protected static final int AABB_THICKNESS = 3;
    protected static final VoxelShape EAST_OPEN_AABB;
    protected static final VoxelShape WEST_OPEN_AABB;
    protected static final VoxelShape SOUTH_OPEN_AABB;
    protected static final VoxelShape NORTH_OPEN_AABB;
    protected static final VoxelShape BOTTOM_AABB;
    protected static final VoxelShape TOP_AABB;
    private final BlockSetType type;

    public MapCodec<? extends FTFTrapdoorBlock> codec() {
        return CODEC;
    }

    public FTFTrapdoorBlock(BlockSetType p_272964_, BlockBehaviour.Properties p_273079_) {
        super(p_272964_, p_273079_.sound(p_272964_.soundType()));
        this.type = p_272964_;
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(OPEN, false)).setValue(HALF, Half.BOTTOM)).setValue(POWERED, false)).setValue(WATERLOGGED, false));
    }

    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (!(Boolean)pState.getValue(OPEN)) {
            return pState.getValue(HALF) == Half.TOP ? TOP_AABB : BOTTOM_AABB;
        } else {
            switch ((Direction)pState.getValue(FACING)) {
                case NORTH:
                default:
                    return NORTH_OPEN_AABB;
                case SOUTH:
                    return SOUTH_OPEN_AABB;
                case WEST:
                    return WEST_OPEN_AABB;
                case EAST:
                    return EAST_OPEN_AABB;
            }
        }
    }

    protected boolean isPathfindable(BlockState pState, PathComputationType pPathComputationType) {
        switch (pPathComputationType) {
            case LAND:
                return (Boolean)pState.getValue(OPEN);
            case WATER:
                return (Boolean)pState.getValue(WATERLOGGED);
            case AIR:
                return (Boolean)pState.getValue(OPEN);
            default:
                return false;
        }
    }

    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (!this.type.canOpenByHand()) {
            return InteractionResult.PASS;
        } else {
            this.toggle(pState, pLevel, pPos, pPlayer);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
    }

    protected void onExplosionHit(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion, BiConsumer<ItemStack, BlockPos> pDropConsumer) {
        if (pExplosion.canTriggerBlocks() && this.type.canOpenByWindCharge() && !(Boolean)pState.getValue(POWERED)) {
            this.toggle(pState, pLevel, pPos, (Player)null);
        }

        super.onExplosionHit(pState, pLevel, pPos, pExplosion, pDropConsumer);
    }

    private void toggle(BlockState pState, Level pLevel, BlockPos pPos, @Nullable Player pPlayer) {
        BlockState blockstate = (BlockState)pState.cycle(OPEN);
        pLevel.setBlock(pPos, blockstate, 2);
        if ((Boolean)blockstate.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        this.playSound(pPlayer, pLevel, pPos, (Boolean)blockstate.getValue(OPEN));
    }

    protected void playSound(@Nullable Player pPlayer, Level pLevel, BlockPos pPos, boolean pIsOpened) {
        pLevel.playSound(pPlayer, pPos, pIsOpened ? this.type.trapdoorOpen() : this.type.trapdoorClose(), SoundSource.BLOCKS, 1.0F, pLevel.getRandom().nextFloat() * 0.1F + 0.9F);
        pLevel.gameEvent(pPlayer, pIsOpened ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
    }

    protected void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        if (!pLevel.isClientSide) {
            boolean flag = pLevel.hasNeighborSignal(pPos);
            if (flag != (Boolean)pState.getValue(POWERED)) {
                if ((Boolean)pState.getValue(OPEN) != flag) {
                    pState = (BlockState)pState.setValue(OPEN, flag);
                    this.playSound((Player)null, pLevel, pPos, flag);
                }

                pLevel.setBlock(pPos, (BlockState)pState.setValue(POWERED, flag), 2);
                if ((Boolean)pState.getValue(WATERLOGGED)) {
                    pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
                }
            }
        }

    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState blockstate = this.defaultBlockState();
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        Direction direction = pContext.getClickedFace();
        if (!pContext.replacingClickedOnBlock() && direction.getAxis().isHorizontal()) {
            blockstate = (BlockState)((BlockState)blockstate.setValue(FACING, direction)).setValue(HALF, pContext.getClickLocation().y - (double)pContext.getClickedPos().getY() > 0.5 ? Half.TOP : Half.BOTTOM);
        } else {
            blockstate = (BlockState)((BlockState)blockstate.setValue(FACING, pContext.getHorizontalDirection().getOpposite())).setValue(HALF, direction == Direction.UP ? Half.BOTTOM : Half.TOP);
        }

        if (pContext.getLevel().hasNeighborSignal(pContext.getClickedPos())) {
            blockstate = (BlockState)((BlockState)blockstate.setValue(OPEN, true)).setValue(POWERED, true);
        }

        return (BlockState)blockstate.setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING, OPEN, HALF, POWERED, WATERLOGGED});
    }

    protected FluidState getFluidState(BlockState pState) {
        return (Boolean)pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if ((Boolean)pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    protected BlockSetType getType() {
        return this.type;
    }

    static {
        OPEN = BlockStateProperties.OPEN;
        HALF = BlockStateProperties.HALF;
        POWERED = BlockStateProperties.POWERED;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        EAST_OPEN_AABB = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        WEST_OPEN_AABB = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        SOUTH_OPEN_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        NORTH_OPEN_AABB = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        BOTTOM_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);
        TOP_AABB = Block.box(0.0, 13.0, 0.0, 16.0, 16.0, 16.0);
    }
}