package com.ryankshah.fieldtofork.block.churn;

import com.mojang.serialization.MapCodec;
import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.FieldToForkCommon;
import com.ryankshah.fieldtofork.gui.menu.ChurnMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChurnBlock extends Block
{
    public static final MapCodec<ChurnBlock> CODEC = simpleCodec(ChurnBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable(Constants.MOD_ID + ".container.churn");

    public MapCodec<? extends ChurnBlock> codec() {
        return CODEC;
    }

    public ChurnBlock(Properties p_49795_) {
        super(p_49795_);
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
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Block.box(2, 0, 2, 14, 28, 14);
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
            return new ChurnMenu(i, inventory, ContainerLevelAccess.create(level, pos));
        }, CONTAINER_TITLE);
    }
}