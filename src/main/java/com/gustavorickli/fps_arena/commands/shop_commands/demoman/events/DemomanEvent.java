package com.gustavorickli.fps_arena.commands.shop_commands.demoman.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class DemomanEvent implements Listener {

    @EventHandler
    public void onPlayerUpMine(PlayerMoveEvent event) {

        Location blockWalked = event.getPlayer().getLocation();

        if (blockWalked.getBlock().getType().equals(Material.GOLD_PLATE)) {

            Player player = event.getPlayer();

            Location location = blockWalked.getBlock().getLocation();

            location.setY(location.getY() + 1);

            player.getWorld().createExplosion(
                    location.getX(),
                    location.getY(),
                    location.getZ(),
                    8, false, false
            );

            blockWalked.getBlock().setType(Material.AIR);

        }

    }

}
