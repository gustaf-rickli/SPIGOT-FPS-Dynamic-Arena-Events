package com.gustavorickli.fps_arena.arena_events.simple_block_events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JumpStonePlateEvent implements Listener {

    @EventHandler
    public void onPlayerWalkOnStonePlate(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        Location blockWhichPlayerWalkedLocation = player.getLocation();
        Location underBlockWhichPlayerWalkedLocation = new Location(
                player.getWorld(),
                player.getLocation().getX(),
                player.getLocation().getY() - 1,
                player.getLocation().getZ()
        );

        if (blockWhichPlayerWalkedLocation
                .getBlock().getType().equals(Material.STONE_PLATE) ) {

            // Longer
            if ( underBlockWhichPlayerWalkedLocation
                            .getBlock().getType().equals(Material.REDSTONE_BLOCK)   ) {
                player.setVelocity(player.getLocation()
                        .getDirection().multiply(3)
                        .setY(3)
                );

                giveResistanceInPlayer(player, 9);
            }

            // Medium
            if ( underBlockWhichPlayerWalkedLocation
                    .getBlock().getType().equals(Material.LAPIS_BLOCK)   ) {
                player.setVelocity(player.getLocation()
                        .getDirection().multiply(3)
                        .setY(2)
                );

                giveResistanceInPlayer(player, 4);
            }

            // Short
            if ( underBlockWhichPlayerWalkedLocation
                    .getBlock().getType().equals(Material.EMERALD_BLOCK)   ) {
                player.setVelocity(player.getLocation()
                        .getDirection().multiply(1)
                        .setY(1)
                );

                giveResistanceInPlayer(player, 3);
            }

        }



    }

    private void giveResistanceInPlayer(Player player, int seconds) {
        final int SECONDS = seconds * 10;
        final int MAX_RESISTENCE_VALUE = 255;

        player.addPotionEffect(new PotionEffect(
                PotionEffectType.DAMAGE_RESISTANCE,
                SECONDS,
                MAX_RESISTENCE_VALUE
        ));
    }

}
