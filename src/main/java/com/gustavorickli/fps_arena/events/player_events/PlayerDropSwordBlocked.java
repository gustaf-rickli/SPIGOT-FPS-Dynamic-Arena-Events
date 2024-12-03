package com.gustavorickli.fps_arena.events.player_events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDropSwordBlocked implements Listener {

    @EventHandler
    public void onPlayerDropSwordBlockItem(PlayerDropItemEvent event) {

        ItemStack itemOnHand = event.getItemDrop().getItemStack();

        final String SWORD = "SWORD";

        if (itemOnHand.getType().toString().contains(SWORD)) {
            event.setCancelled(true);
        }

    }


}
