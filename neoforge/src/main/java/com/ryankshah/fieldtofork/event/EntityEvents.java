package com.ryankshah.fieldtofork.event;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class EntityEvents
{
    @SubscribeEvent
    public static void entityRightClickEvent(PlayerInteractEvent.EntityInteract event) {
        if(event.getTarget() instanceof Camel camel) {
            Player player = event.getEntity();
            ItemStack itemstack = player.getItemInHand(event.getHand());
            if (itemstack.is(Items.BUCKET) && !camel.isBaby()) {
                event.setCanceled(true);
                ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, ItemRegistry.CAMEL_MILK_BUCKET.get().getDefaultInstance());
                player.setItemInHand(event.getHand(), itemstack1);
            }
        }
    }
}