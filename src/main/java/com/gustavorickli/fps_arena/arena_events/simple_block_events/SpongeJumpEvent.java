package com.gustavorickli.fps_arena.arena_events.simple_block_events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpongeJumpEvent implements Listener {

    @EventHandler
    public void onPlayerJumpSponge(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        Location blockLocation = player.getLocation();

        blockLocation.setY(blockLocation.getY() - 1);

        if (blockLocation.getBlock().getType().equals(Material.SPONGE)) {

            player.setVelocity(player.getLocation().getDirection().multiply(2)
                    .setY(3).setX(0).setZ(0));
        }
    }
}
