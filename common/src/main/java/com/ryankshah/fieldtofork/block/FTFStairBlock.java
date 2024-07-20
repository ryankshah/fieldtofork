package com.ryankshah.fieldtofork.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class FTFStairBlock extends StairBlock
{
    public static final MapCodec<FTFStairBlock> CODEC = RecordCodecBuilder.mapCodec((p_308839_) -> {
        return p_308839_.group(BlockState.CODEC.fieldOf("base_state").forGetter((p_304378_) -> {
            return p_304378_.baseState;
        }), propertiesCodec()).apply(p_308839_, FTFStairBlock::new);
    });
    public static final DirectionProperty FACING;
    public static final EnumProperty<Half> HALF;
    public static final EnumProperty<StairsShape> SHAPE;
    public static final BooleanProperty WATERLOGGED;
    protected static final VoxelShape TOP_AABB;
    protected static final VoxelShape BOTTOM_AABB;
    protected static final VoxelShape OCTET_NNN;
    protected static final VoxelShape OCTET_NNP;
    protected static final VoxelShape OCTET_NPN;
    protected static final VoxelShape OCTET_NPP;
    protected static final VoxelShape OCTET_PNN;
    protected static final VoxelShape OCTET_PNP;
    protected static final VoxelShape OCTET_PPN;
    protected static final VoxelShape OCTET_PPP;
    protected static final VoxelShape[] TOP_SHAPES;
    protected static final VoxelShape[] BOTTOM_SHAPES;
    private static final int[] SHAPE_BY_STATE;
    private final Block base;
    protected final BlockState baseState;

    public MapCodec<? extends FTFStairBlock> codec() {
        return CODEC;
    }

    private static VoxelShape[] makeShapes(VoxelShape pSlabShape, VoxelShape pNwCorner, VoxelShape pNeCorner, VoxelShape pSwCorner, VoxelShape pSeCorner) {
        return (VoxelShape[]) IntStream.range(0, 16).mapToObj((p_56945_) -> {
            return makeStairShape(p_56945_, pSlabShape, pNwCorner, pNeCorner, pSwCorner, pSeCorner);
        }).toArray((x$0) -> {
            return new VoxelShape[x$0];
        });
    }

    private static VoxelShape makeStairShape(int pBitfield, VoxelShape pSlabShape, VoxelShape pNwCorner, VoxelShape pNeCorner, VoxelShape pSwCorner, VoxelShape pSeCorner) {
        VoxelShape voxelshape = pSlabShape;
        if ((pBitfield & 1) != 0) {
            voxelshape = Shapes.or(pSlabShape, pNwCorner);
        }

        if ((pBitfield & 2) != 0) {
            voxelshape = Shapes.or(voxelshape, pNeCorner);
        }

        if ((pBitfield & 4) != 0) {
            voxelshape = Shapes.or(voxelshape, pSwCorner);
        }

        if ((pBitfield & 8) != 0) {
            voxelshape = Shapes.or(voxelshape, pSeCorner);
        }

        return voxelshape;
    }

    public FTFStairBlock(BlockState p_56862_, BlockBehaviour.Properties p_56863_) {
        super(p_56862_, p_56863_);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(HALF, Half.BOTTOM)).setValue(SHAPE, StairsShape.STRAIGHT)).setValue(WATERLOGGED, false));
        this.base = p_56862_.getBlock();
        this.baseState = p_56862_;
    }

    protected boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return (pState.getValue(HALF) == Half.TOP ? TOP_SHAPES : BOTTOM_SHAPES)[SHAPE_BY_STATE[this.getShapeIndex(pState)]];
    }

    private int getShapeIndex(BlockState pState) {
        return ((StairsShape)pState.getValue(SHAPE)).ordinal() * 4 + ((Direction)pState.getValue(FACING)).get2DDataValue();
    }

    public float getExplosionResistance() {
        return this.base.getExplosionResistance();
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockPos blockpos = pContext.getClickedPos();
        FluidState fluidstate = pContext.getLevel().getFluidState(blockpos);
        BlockState blockstate = (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection())).setValue(HALF, direction == Direction.DOWN || direction != Direction.UP && pContext.getClickLocation().y - (double)blockpos.getY() > 0.5 ? Half.TOP : Half.BOTTOM)).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        return (BlockState)blockstate.setValue(SHAPE, getStairsShape(blockstate, pContext.getLevel(), blockpos));
    }

    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if ((Boolean)pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return pFacing.getAxis().isHorizontal() ? (BlockState)pState.setValue(SHAPE, getStairsShape(pState, pLevel, pCurrentPos)) : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    private static StairsShape getStairsShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        Direction direction = (Direction)pState.getValue(FACING);
        BlockState blockstate = pLevel.getBlockState(pPos.relative(direction));
        if (isStairs(blockstate) && pState.getValue(HALF) == blockstate.getValue(HALF)) {
            Direction direction1 = (Direction)blockstate.getValue(FACING);
            if (direction1.getAxis() != ((Direction)pState.getValue(FACING)).getAxis() && canTakeShape(pState, pLevel, pPos, direction1.getOpposite())) {
                if (direction1 == direction.getCounterClockWise()) {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState blockstate1 = pLevel.getBlockState(pPos.relative(direction.getOpposite()));
        if (isStairs(blockstate1) && pState.getValue(HALF) == blockstate1.getValue(HALF)) {
            Direction direction2 = (Direction)blockstate1.getValue(FACING);
            if (direction2.getAxis() != ((Direction)pState.getValue(FACING)).getAxis() && canTakeShape(pState, pLevel, pPos, direction2)) {
                if (direction2 == direction.getCounterClockWise()) {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }

        return StairsShape.STRAIGHT;
    }

    private static boolean canTakeShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pFace) {
        BlockState blockstate = pLevel.getBlockState(pPos.relative(pFace));
        return !isStairs(blockstate) || blockstate.getValue(FACING) != pState.getValue(FACING) || blockstate.getValue(HALF) != pState.getValue(HALF);
    }

    public static boolean isStairs(BlockState pState) {
        return pState.getBlock() instanceof StairBlock;
    }

    /** @deprecated */
    protected BlockState rotate(BlockState pState, Rotation pRot) {
        return (BlockState)pState.setValue(FACING, pRot.rotate((Direction)pState.getValue(FACING)));
    }

    /** @deprecated */
    protected BlockState mirror(BlockState pState, Mirror pMirror) {
        Direction direction = (Direction)pState.getValue(FACING);
        StairsShape stairsshape = (StairsShape)pState.getValue(SHAPE);
        switch (pMirror) {
            case LEFT_RIGHT:
                if (direction.getAxis() == Axis.Z) {
                    switch (stairsshape) {
                        case INNER_LEFT:
                            return (BlockState)pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        case INNER_RIGHT:
                            return (BlockState)pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        case OUTER_LEFT:
                            return (BlockState)pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return (BlockState)pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        default:
                            return pState.rotate(Rotation.CLOCKWISE_180);
                    }
                }
                break;
            case FRONT_BACK:
                if (direction.getAxis() == Axis.X) {
                    switch (stairsshape) {
                        case INNER_LEFT:
                            return (BlockState)pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        case INNER_RIGHT:
                            return (BlockState)pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        case OUTER_LEFT:
                            return (BlockState)pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return (BlockState)pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        case STRAIGHT:
                            return pState.rotate(Rotation.CLOCKWISE_180);
                    }
                }
        }

        return super.mirror(pState, pMirror);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING, HALF, SHAPE, WATERLOGGED});
    }

    protected FluidState getFluidState(BlockState pState) {
        return (Boolean)pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    protected boolean isPathfindable(BlockState pState, PathComputationType pPathComputationType) {
        return false;
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        HALF = BlockStateProperties.HALF;
        SHAPE = BlockStateProperties.STAIRS_SHAPE;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        TOP_AABB = Block.box(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);
        BOTTOM_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
        OCTET_NNN = Block.box(0.0, 0.0, 0.0, 8.0, 8.0, 8.0);
        OCTET_NNP = Block.box(0.0, 0.0, 8.0, 8.0, 8.0, 16.0);
        OCTET_NPN = Block.box(0.0, 8.0, 0.0, 8.0, 16.0, 8.0);
        OCTET_NPP = Block.box(0.0, 8.0, 8.0, 8.0, 16.0, 16.0);
        OCTET_PNN = Block.box(8.0, 0.0, 0.0, 16.0, 8.0, 8.0);
        OCTET_PNP = Block.box(8.0, 0.0, 8.0, 16.0, 8.0, 16.0);
        OCTET_PPN = Block.box(8.0, 8.0, 0.0, 16.0, 16.0, 8.0);
        OCTET_PPP = Block.box(8.0, 8.0, 8.0, 16.0, 16.0, 16.0);
        TOP_SHAPES = makeShapes(TOP_AABB, OCTET_NNN, OCTET_PNN, OCTET_NNP, OCTET_PNP);
        BOTTOM_SHAPES = makeShapes(BOTTOM_AABB, OCTET_NPN, OCTET_PPN, OCTET_NPP, OCTET_PPP);
        SHAPE_BY_STATE = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};
    }
}
