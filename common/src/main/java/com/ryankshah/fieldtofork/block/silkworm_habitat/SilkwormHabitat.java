package com.ryankshah.fieldtofork.block.silkworm_habitat;

import com.mojang.serialization.MapCodec;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.gui.menu.ChurnMenu;
import com.ryankshah.fieldtofork.gui.menu.SilkwormHabitatMenu;
import com.ryankshah.fieldtofork.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class SilkwormHabitat extends BaseEntityBlock
{
    public static final MapCodec<SilkwormHabitat> CODEC = simpleCodec(SilkwormHabitat::new);

    public static final BooleanProperty HAS_LEAVES;
    public static final BooleanProperty HAS_WORMS;
    public static final BooleanProperty PRODUCING;

    public static final Component CONTAINER_TITLE = Component.translatable(Constants.MOD_ID + ".container.silkworm_habitat");

    public SilkwormHabitat(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(HAS_LEAVES, false).setValue(HAS_WORMS, false).setValue(PRODUCING, false));
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createHabitatTicker(pLevel, pBlockEntityType, BlockEntityRegistry.SILKWORM_HABITAT.get());
    }


    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createHabitatTicker(Level pLevel, BlockEntityType<T> pServerType, BlockEntityType<? extends SilkwormHabitatBlockEntity> pClientType) {
        return pLevel.isClientSide ? null : createTickerHelper(pServerType, pClientType, SilkwormHabitatBlockEntity::serverTick);
    }

    public MapCodec<? extends SilkwormHabitat> codec() {
        return CODEC;
    }

    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SilkwormHabitatBlockEntity(pPos, pState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{HAS_LEAVES, HAS_WORMS, PRODUCING});
    }

    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof SilkwormHabitatBlockEntity) {
                if (pLevel instanceof ServerLevel) {
                    Containers.dropContents(pLevel, pPos, (SilkwormHabitatBlockEntity)blockentity);
                    ((SilkwormHabitatBlockEntity)blockentity).getRecipesToAwardAndPopExperience((ServerLevel)pLevel, Vec3.atCenterOf(pPos));
                }

                super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            } else {
                super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
            }
        }
    }

    protected boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    protected int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pPos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(pLevel.getBlockEntity(pPos));
    }

    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    static {
        HAS_LEAVES = BooleanProperty.create("has_leaves");
        HAS_WORMS = BooleanProperty.create("has_worms");
        PRODUCING = BooleanProperty.create("producing");
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            FieldToForkCommon.COMMON_PLATFORM.openMenu((ServerPlayer) player, state.getMenuProvider(level, pos), buf -> ((FriendlyByteBuf)buf).writeBlockPos(pos));
            return InteractionResult.CONSUME;
        }
    }

    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inventory, player) -> {
            return new SilkwormHabitatMenu(i, inventory, ContainerLevelAccess.create(level, pos));
        }, CONTAINER_TITLE);
    }
}