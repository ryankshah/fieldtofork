package com.ryankshah.fieldtofork.item;

import com.ryankshah.fieldtofork.block.crop.FTFCropBlock;
import com.ryankshah.fieldtofork.block.crop.TwoHighCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class Scythe extends TieredItem
{
    public Scythe(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.swing(pUsedHand);

        if (!pLevel.isClientSide) {
            if (pPlayer != null) {
                // Player's look direction
                Vec3 playerLookVec = pPlayer.getLookAngle();
                // Angle increment for the cone (in radians)
                double angleIncrement = Math.PI / 8;
                // Radius of the cone
                double radius; // Extended range
                switch(getTier()) {
                    case Tiers.STONE:
                        radius = 3.0f;
                        break;
                    case Tiers.IRON:
                        radius = 4.0f;
                        break;
                    case Tiers.GOLD:
                        radius = 5.0f;
                        break;
                    case Tiers.DIAMOND:
                        radius = 6.0f;
                        break;
                    case Tiers.NETHERITE:
                        radius = 7.0f;
                        break;
                    default:
                        radius = 2.0f;
                        break;
                }

                // Iterate over the cone's sectors
                for (int i = -2; i <= 2; i++) {
                    // Calculate the angle for the current sector
                    double angle = angleIncrement * i;
                    // Calculate the direction vector for the current sector
                    Vec3 aimVec = new Vec3(
                            playerLookVec.x * Math.cos(angle) - playerLookVec.z * Math.sin(angle),
                            playerLookVec.y,
                            playerLookVec.z * Math.cos(angle) + playerLookVec.x * Math.sin(angle)
                    );

                    // Iterate over the blocks within the radius of the current sector
                    for (double r = 0.4; r <= radius; r += 0.4) {
                        int x = (int) (pPlayer.position().x + r * aimVec.x);
                        int y = (int) (pPlayer.position().y + 1.5 + r * aimVec.y); // Adjusted height
                        int z = (int) (pPlayer.position().z + r * aimVec.z);

                        BlockPos blockPos = new BlockPos(x, y, z);
                        BlockState state = pLevel.getBlockState(blockPos);

                        // Check if the block is a crop and destroy it
                        if (state.is(BlockTags.CROPS) || state.getBlock() instanceof FTFCropBlock || state.getBlock() instanceof TwoHighCropBlock) {
                            pLevel.destroyBlock(blockPos, true);
                            pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pUsedHand));
                        }
                    }
                }

                return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
            }
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
