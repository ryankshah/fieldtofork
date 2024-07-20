package com.ryankshah.fieldtofork.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

public class FTFButtonBlock extends FaceAttachedHorizontalDirectionalBlock
{
    public static final MapCodec<FTFButtonBlock> CODEC = RecordCodecBuilder.mapCodec((p_308803_) -> {
        return p_308803_.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter((p_304607_) -> {
            return p_304607_.type;
        }), Codec.intRange(1, 1024).fieldOf("ticks_to_stay_pressed").forGetter((p_304953_) -> {
            return p_304953_.ticksToStayPressed;
        }), propertiesCodec()).apply(p_308803_, FTFButtonBlock::new);
    });
    public static final BooleanProperty POWERED;
    private static final int PRESSED_DEPTH = 1;
    private static final int UNPRESSED_DEPTH = 2;
    protected static final int HALF_AABB_HEIGHT = 2;
    protected static final int HALF_AABB_WIDTH = 3;
    protected static final VoxelShape CEILING_AABB_X;
    protected static final VoxelShape CEILING_AABB_Z;
    protected static final VoxelShape FLOOR_AABB_X;
    protected static final VoxelShape FLOOR_AABB_Z;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape EAST_AABB;
    protected static final VoxelShape PRESSED_CEILING_AABB_X;
    protected static final VoxelShape PRESSED_CEILING_AABB_Z;
    protected static final VoxelShape PRESSED_FLOOR_AABB_X;
    protected static final VoxelShape PRESSED_FLOOR_AABB_Z;
    protected static final VoxelShape PRESSED_NORTH_AABB;
    protected static final VoxelShape PRESSED_SOUTH_AABB;
    protected static final VoxelShape PRESSED_WEST_AABB;
    protected static final VoxelShape PRESSED_EAST_AABB;
    private final BlockSetType type;
    private final int ticksToStayPressed;

    public MapCodec<FTFButtonBlock> codec() {
        return CODEC;
    }

    public FTFButtonBlock(BlockSetType p_273462_, int p_273212_, BlockBehaviour.Properties p_273290_) {
        super(p_273290_.sound(p_273462_.soundType()));
        this.type = p_273462_;
        this.registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(POWERED, false)).setValue(FACE, AttachFace.WALL));
        this.ticksToStayPressed = p_273212_;
    }

    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = (Direction) pState.getValue(FACING);
        boolean flag = (Boolean) pState.getValue(POWERED);
        switch ((AttachFace) pState.getValue(FACE)) {
            case FLOOR:
                if (direction.getAxis() == Direction.Axis.X) {
                    return flag ? PRESSED_FLOOR_AABB_X : FLOOR_AABB_X;
                }

                return flag ? PRESSED_FLOOR_AABB_Z : FLOOR_AABB_Z;
            case WALL:
                VoxelShape var10000;
                switch (direction) {
                    case EAST:
                        var10000 = flag ? PRESSED_EAST_AABB : EAST_AABB;
                        break;
                    case WEST:
                        var10000 = flag ? PRESSED_WEST_AABB : WEST_AABB;
                        break;
                    case SOUTH:
                        var10000 = flag ? PRESSED_SOUTH_AABB : SOUTH_AABB;
                        break;
                    case NORTH:
                    case UP:
                    case DOWN:
                        var10000 = flag ? PRESSED_NORTH_AABB : NORTH_AABB;
                        break;
                    default:
                        throw new MatchException((String) null, (Throwable) null);
                }

                return var10000;
            case CEILING:
            default:
                if (direction.getAxis() == Direction.Axis.X) {
                    return flag ? PRESSED_CEILING_AABB_X : CEILING_AABB_X;
                } else {
                    return flag ? PRESSED_CEILING_AABB_Z : CEILING_AABB_Z;
                }
        }
    }

    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if ((Boolean) pState.getValue(POWERED)) {
            return InteractionResult.CONSUME;
        } else {
            this.press(pState, pLevel, pPos, pPlayer);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
    }

    protected void onExplosionHit(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion, BiConsumer<ItemStack, BlockPos> pDropConsumer) {
        if (pExplosion.canTriggerBlocks() && !(Boolean) pState.getValue(POWERED)) {
            this.press(pState, pLevel, pPos, (Player) null);
        }

        super.onExplosionHit(pState, pLevel, pPos, pExplosion, pDropConsumer);
    }

    public void press(BlockState pState, Level pLevel, BlockPos pPos, @Nullable Player pPlayer) {
        pLevel.setBlock(pPos, (BlockState) pState.setValue(POWERED, true), 3);
        this.updateNeighbours(pState, pLevel, pPos);
        pLevel.scheduleTick(pPos, this, this.ticksToStayPressed);
        this.playSound(pPlayer, pLevel, pPos, true);
        pLevel.gameEvent(pPlayer, GameEvent.BLOCK_ACTIVATE, pPos);
    }

    protected void playSound(@Nullable Player pPlayer, LevelAccessor pLevel, BlockPos pPos, boolean pHitByArrow) {
        pLevel.playSound(pHitByArrow ? pPlayer : null, pPos, this.getSound(pHitByArrow), SoundSource.BLOCKS);
    }

    protected SoundEvent getSound(boolean pIsOn) {
        return pIsOn ? this.type.buttonClickOn() : this.type.buttonClickOff();
    }

    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pIsMoving && !pState.is(pNewState.getBlock())) {
            if ((Boolean) pState.getValue(POWERED)) {
                this.updateNeighbours(pState, pLevel, pPos);
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }

    }

    /**
     * @deprecated
     */
    protected int getSignal(BlockState pBlockState, BlockGetter pBlockAccess, BlockPos pPos, Direction pSide) {
        return (Boolean) pBlockState.getValue(POWERED) ? 15 : 0;
    }

    /**
     * @deprecated
     */
    protected int getDirectSignal(BlockState pBlockState, BlockGetter pBlockAccess, BlockPos pPos, Direction pSide) {
        return (Boolean) pBlockState.getValue(POWERED) && getConnectedDirection(pBlockState) == pSide ? 15 : 0;
    }

    /**
     * @deprecated
     */
    protected boolean isSignalSource(BlockState pState) {
        return true;
    }

    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if ((Boolean) pState.getValue(POWERED)) {
            this.checkPressed(pState, pLevel, pPos);
        }

    }

    protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pLevel.isClientSide && this.type.canButtonBeActivatedByArrows() && !(Boolean) pState.getValue(POWERED)) {
            this.checkPressed(pState, pLevel, pPos);
        }

    }

    protected void checkPressed(BlockState pState, Level pLevel, BlockPos pPos) {
        AbstractArrow abstractarrow = this.type.canButtonBeActivatedByArrows() ? (AbstractArrow) pLevel.getEntitiesOfClass(AbstractArrow.class, pState.getShape(pLevel, pPos).bounds().move(pPos)).stream().findFirst().orElse((AbstractArrow) null) : null;
        boolean flag = abstractarrow != null;
        boolean flag1 = (Boolean) pState.getValue(POWERED);
        if (flag != flag1) {
            pLevel.setBlock(pPos, (BlockState) pState.setValue(POWERED, flag), 3);
            this.updateNeighbours(pState, pLevel, pPos);
            this.playSound((Player) null, pLevel, pPos, flag);
            pLevel.gameEvent(abstractarrow, flag ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pPos);
        }

        if (flag) {
            pLevel.scheduleTick(new BlockPos(pPos), this, this.ticksToStayPressed);
        }

    }

    private void updateNeighbours(BlockState pState, Level pLevel, BlockPos pPos) {
        pLevel.updateNeighborsAt(pPos, this);
        pLevel.updateNeighborsAt(pPos.relative(getConnectedDirection(pState).getOpposite()), this);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING, POWERED, FACE});
    }

    static {
        POWERED = BlockStateProperties.POWERED;
        CEILING_AABB_X = Block.box(6.0, 14.0, 5.0, 10.0, 16.0, 11.0);
        CEILING_AABB_Z = Block.box(5.0, 14.0, 6.0, 11.0, 16.0, 10.0);
        FLOOR_AABB_X = Block.box(6.0, 0.0, 5.0, 10.0, 2.0, 11.0);
        FLOOR_AABB_Z = Block.box(5.0, 0.0, 6.0, 11.0, 2.0, 10.0);
        NORTH_AABB = Block.box(5.0, 6.0, 14.0, 11.0, 10.0, 16.0);
        SOUTH_AABB = Block.box(5.0, 6.0, 0.0, 11.0, 10.0, 2.0);
        WEST_AABB = Block.box(14.0, 6.0, 5.0, 16.0, 10.0, 11.0);
        EAST_AABB = Block.box(0.0, 6.0, 5.0, 2.0, 10.0, 11.0);
        PRESSED_CEILING_AABB_X = Block.box(6.0, 15.0, 5.0, 10.0, 16.0, 11.0);
        PRESSED_CEILING_AABB_Z = Block.box(5.0, 15.0, 6.0, 11.0, 16.0, 10.0);
        PRESSED_FLOOR_AABB_X = Block.box(6.0, 0.0, 5.0, 10.0, 1.0, 11.0);
        PRESSED_FLOOR_AABB_Z = Block.box(5.0, 0.0, 6.0, 11.0, 1.0, 10.0);
        PRESSED_NORTH_AABB = Block.box(5.0, 6.0, 15.0, 11.0, 10.0, 16.0);
        PRESSED_SOUTH_AABB = Block.box(5.0, 6.0, 0.0, 11.0, 10.0, 1.0);
        PRESSED_WEST_AABB = Block.box(15.0, 6.0, 5.0, 16.0, 10.0, 11.0);
        PRESSED_EAST_AABB = Block.box(0.0, 6.0, 5.0, 1.0, 10.0, 11.0);
    }
}