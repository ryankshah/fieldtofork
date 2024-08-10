package com.ryankshah.fieldtofork.item;

import com.ryankshah.fieldtofork.datacomponent.WateringCanFillLevelDataComponent;
import com.ryankshah.fieldtofork.registry.DataComponentRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;
import java.util.List;

public class WateringCan extends Item
{
    public static final float EMPTY = 0f;
    public static final float FULL = 8f;

    public WateringCan(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        int currentFillLevel = pStack.get(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get()).getCurrentFillLevel();
        int maxFillLevel = pStack.get(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get()).getMaxFillLevel();
        pTooltipComponents.add(Component.literal("Fill Level: " + currentFillLevel + "/" + maxFillLevel));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        WateringCanFillLevelDataComponent fillLevelData = itemstack.get(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get());
        int currentFillLevel = fillLevelData.getCurrentFillLevel();
        int maxFillLevel = 8; //fillLevelData.getMaxFillLevel();

        BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.SOURCE_ONLY);
        if (blockhitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else if (blockhitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            BlockPos blockpos = blockhitresult.getBlockPos();
            Direction direction = blockhitresult.getDirection();
            BlockPos blockpos1 = blockpos.relative(direction);

            if (pLevel.mayInteract(pPlayer, blockpos) && pPlayer.mayUseItemAt(blockpos1, direction, itemstack)) {
                BlockState blockstate = pLevel.getBlockState(blockpos);
                Block block = blockstate.getBlock();

                if (currentFillLevel == 0) {
                    if (block instanceof BucketPickup) {
                        BucketPickup bucketPickup = (BucketPickup) block;
                        ItemStack itemstack3 = bucketPickup.pickupBlock(pPlayer, pLevel, blockpos, blockstate);

                        if (!itemstack3.isEmpty()) {
                            pPlayer.awardStat(Stats.ITEM_USED.get(this));
                            bucketPickup.getPickupSound().ifPresent((sound) -> pPlayer.playSound(sound, 1.0F, 1.0F));
                            pLevel.gameEvent(pPlayer, GameEvent.FLUID_PICKUP, blockpos);

                            ItemStack stack2 = itemstack.copy();
                            stack2.set(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get(), new WateringCanFillLevelDataComponent(maxFillLevel, maxFillLevel));

                            if (!pLevel.isClientSide) {
                                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) pPlayer, itemstack3);
                            }

                            return InteractionResultHolder.sidedSuccess(stack2, pLevel.isClientSide());
                        }
                    }
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (blockstate.getFluidState().is(FluidTags.WATER)) {
                        ItemStack stack2 = itemstack.copy();
                        stack2.set(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get(), new WateringCanFillLevelDataComponent(maxFillLevel, maxFillLevel));
                        return InteractionResultHolder.sidedSuccess(stack2, pLevel.isClientSide());
                    } else {
                        BlockPos targetPos = blockstate.getBlock() instanceof LiquidBlockContainer ? blockpos : blockpos1;

                        if (this.emptyContents(pPlayer, pLevel, targetPos, blockhitresult)) {
                            this.checkExtraContent(pPlayer, pLevel, itemstack, targetPos);
                            if (pPlayer instanceof ServerPlayer) {
                                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) pPlayer, targetPos, itemstack);
                            }

                            pPlayer.awardStat(Stats.ITEM_USED.get(this));
                            ItemStack stack2 = itemstack.copy();
                            int newFillLevel = Math.max(currentFillLevel - 1, 0);  // Ensure fill level does not go below 0
                            stack2.set(DataComponentRegistry.WATERING_CAN_FILL_LEVEL.get(), new WateringCanFillLevelDataComponent(newFillLevel - 1, maxFillLevel));
                            return InteractionResultHolder.sidedSuccess(stack2, pLevel.isClientSide());
                        } else {
                            return InteractionResultHolder.fail(itemstack);
                        }
                    }
                }
            }

            return super.use(pLevel, pPlayer, pHand);
        }
    }

    public static ItemStack getEmptySuccessItem(ItemStack stack, Player pPlayer) {
        return !pPlayer.hasInfiniteMaterials() ? new ItemStack(ItemRegistry.WATERING_CAN.get()) : stack;
    }

    public void checkExtraContent(@Nullable Player pPlayer, Level pLevel, ItemStack pContainerStack, BlockPos pPos) {
    }

    public boolean emptyContents(@Nullable Player pPlayer, Level pLevel, BlockPos pPos, @Nullable BlockHitResult pResult) {
        FlowingFluid flowingfluid = Fluids.WATER;
        boolean $$8;
        BlockState blockstate;
        boolean flag2;
        Block $$7;
        label72: {
            label71: {
                blockstate = pLevel.getBlockState(pPos);
                $$7 = blockstate.getBlock();
                $$8 = blockstate.canBeReplaced(Fluids.WATER);
                if (!blockstate.isAir() && !$$8) {
                    if (!($$7 instanceof LiquidBlockContainer)) {
                        break label71;
                    }

                    LiquidBlockContainer liquidblockcontainer = (LiquidBlockContainer)$$7;
                    if (!liquidblockcontainer.canPlaceLiquid(pPlayer, pLevel, pPos, blockstate, Fluids.WATER)) {
                        break label71;
                    }
                }

                flag2 = true;
                break label72;
            }

            flag2 = false;
        }

        if (!flag2) {
            return pResult != null && this.emptyContents(pPlayer, pLevel, pResult.getBlockPos().relative(pResult.getDirection()), (BlockHitResult)null);
        } else if (pLevel.dimensionType().ultraWarm() && Fluids.WATER.is(FluidTags.WATER)) {
            int l = pPos.getX();
            int i = pPos.getY();
            int j = pPos.getZ();
            pLevel.playSound(pPlayer, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F + (pLevel.random.nextFloat() - pLevel.random.nextFloat()) * 0.8F);

            for(int k = 0; k < 8; ++k) {
                pLevel.addParticle(ParticleTypes.LARGE_SMOKE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0, 0.0, 0.0);
            }

            return true;
        } else {
            if ($$7 instanceof LiquidBlockContainer) {
                LiquidBlockContainer liquidblockcontainer1 = (LiquidBlockContainer)$$7;
                liquidblockcontainer1.placeLiquid(pLevel, pPos, blockstate, flowingfluid.getSource(false));
                this.playEmptySound(pPlayer, pLevel, pPos);
                return true;
            }

            if (!pLevel.isClientSide && $$8 && !blockstate.liquid()) {
                pLevel.destroyBlock(pPos, true);
            }

            if (!pLevel.setBlock(pPos, Fluids.WATER.defaultFluidState().createLegacyBlock(), 11) && !blockstate.getFluidState().isSource()) {
                return false;
            } else {
                this.playEmptySound(pPlayer, pLevel, pPos);
                return true;
            }
        }
    }

    protected void playEmptySound(@Nullable Player pPlayer, LevelAccessor pLevel, BlockPos pPos) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
        pLevel.gameEvent(pPlayer, GameEvent.FLUID_PLACE, pPos);
    }
}
