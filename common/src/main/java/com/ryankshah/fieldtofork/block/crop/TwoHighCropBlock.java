package com.ryankshah.fieldtofork.block.crop;

import com.mojang.serialization.MapCodec;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class TwoHighCropBlock extends DoublePlantBlock implements BonemealableBlock
{
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE;
    private Supplier<Item> seed;

    public static final MapCodec<TwoHighCropBlock> CODEC = simpleCodec(TwoHighCropBlock::new);

    public TwoHighCropBlock(BlockBehaviour.Properties p_52247_) {
        super(p_52247_);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(this.getAgeProperty(), 0));
        this.seed = ItemRegistry.GRAPE_SEEDS;
    }

    public TwoHighCropBlock(BlockBehaviour.Properties p_52247_, Supplier<Item> seed) {
        super(p_52247_);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(this.getAgeProperty(), 0));
        this.seed = seed;
    }

    @Override
    protected VoxelShape getVisualShape(BlockState p_309057_, BlockGetter p_308936_, BlockPos p_308956_, CollisionContext p_309006_) {
        return Shapes.empty();
    }

    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        DoubleBlockHalf doubleblockhalf = (DoubleBlockHalf)pState.getValue(HALF);
        if (pFacing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (pFacing == Direction.UP) || pFacingState.is(this) && pFacingState.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    public int getAge(BlockState pState) {
        return (Integer)pState.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int pAge) {
        return (BlockState)this.defaultBlockState().setValue(this.getAgeProperty(), pAge);
    }

    public final boolean isMaxAge(BlockState pState) {
        return this.getAge(pState) >= this.getMaxAge();
    }

    protected boolean isRandomlyTicking(BlockState pState) {
        return !this.isMaxAge(pState);
    }

    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getRawBrightness(pPos, 0) >= 9) {
            int i = this.getAge(pState);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, pLevel, pPos);
                if (pRandom.nextInt((int)(25.0F / f) + 1) == 0) {
                    pLevel.setBlock(pPos, this.getStateForAge(i + 1), 2);
                }
            }
        }

    }

    public void growCrops(Level pLevel, BlockPos pPos, BlockState pState) {
        int i = this.getAge(pState) + this.getBonemealAgeIncrease(pLevel);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        BlockState newState = this.getStateForAge(i);
        pLevel.setBlock(pPos, newState.setValue(HALF, DoubleBlockHalf.LOWER), 2);
        pLevel.setBlock(pPos.above(), newState.setValue(HALF, DoubleBlockHalf.UPPER), 2);
    }

    protected int getBonemealAgeIncrease(Level pLevel) {
        return Mth.nextInt(pLevel.random, 2, 5);
    }

    protected static float getGrowthSpeed(Block pBlock, BlockGetter pLevel, BlockPos pPos) {
        float f = 1.0F;
        BlockPos blockpos = pPos.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = pLevel.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.is(Blocks.FARMLAND)) {
                    f1 = 1.0F;
                    if ((Integer)blockstate.getValue(FarmBlock.MOISTURE) > 0) {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pPos.north();
        BlockPos blockpos2 = pPos.south();
        BlockPos blockpos3 = pPos.west();
        BlockPos blockpos4 = pPos.east();
        boolean flag = pLevel.getBlockState(blockpos3).is(pBlock) || pLevel.getBlockState(blockpos4).is(pBlock);
        boolean flag1 = pLevel.getBlockState(blockpos1).is(pBlock) || pLevel.getBlockState(blockpos2).is(pBlock);
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = pLevel.getBlockState(blockpos3.north()).is(pBlock) || pLevel.getBlockState(blockpos4.north()).is(pBlock) || pLevel.getBlockState(blockpos4.south()).is(pBlock) || pLevel.getBlockState(blockpos3.south()).is(pBlock);
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }

    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return hasSufficientLight(pLevel, pPos) && super.canSurvive(pState, pLevel, pPos);
    }

    protected static boolean hasSufficientLight(LevelReader pLevel, BlockPos pPos) {
        return pLevel.getRawBrightness(pPos, 0) >= 8;
    }

    protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof Ravager && pLevel.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            pLevel.destroyBlock(pPos, true, pEntity);
        }

        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(this.getBaseSeedId());
    }

    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return !this.isMaxAge(pState);
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        BlockPos basePos = pState.getValue(HALF) == DoubleBlockHalf.LOWER ? pPos : pPos.below();
        BlockState baseState = pLevel.getBlockState(basePos);

        if (baseState.getBlock() instanceof TwoHighCropBlock) {
            this.growCrops(pLevel, basePos, baseState);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(pContext) ? super.getStateForPlacement(pContext) : null;
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        BlockPos blockpos = pPos.above();
        pLevel.setBlock(blockpos, copyWaterloggedFrom(pLevel, blockpos, (BlockState)this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)), 3);
    }

    public static BlockState copyWaterloggedFrom(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return pState.hasProperty(BlockStateProperties.WATERLOGGED) ? (BlockState)pState.setValue(BlockStateProperties.WATERLOGGED, pLevel.isWaterAt(pPos)) : pState;
    }

    protected ItemLike getBaseSeedId() {
        return seed.get();
    }

    @Override
    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }

    @Override
    protected float getShadeBrightness(BlockState p_308911_, BlockGetter p_308952_, BlockPos p_308918_) {
        return 1.0F;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState p_309084_, BlockGetter p_309133_, BlockPos p_309097_) {
        return true;
    }

    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide) {
            if (pPlayer.isCreative()) {
                preventDropFromBottomPart(pLevel, pPos, pState, pPlayer);
            } else {
                dropResources(pState, pLevel, pPos, (BlockEntity)null, pPlayer, pPlayer.getMainHandItem());
            }
        }

        return super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pTe, ItemStack pStack) {
        super.playerDestroy(pLevel, pPlayer, pPos, Blocks.AIR.defaultBlockState(), pTe, pStack);
    }

    protected static void preventDropFromBottomPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        DoubleBlockHalf doubleblockhalf = (DoubleBlockHalf)pState.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pPos.below();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (blockstate.is(pState.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                pLevel.setBlock(blockpos, blockstate1, 35);
                pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
            }
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{AGE,HALF});
    }

    protected long getSeed(BlockState pState, BlockPos pPos) {
        return Mth.getSeed(pPos.getX(), pPos.below(pState.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pPos.getZ());
    }

    static {
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
        AGE = BlockStateProperties.AGE_7;
    }
}