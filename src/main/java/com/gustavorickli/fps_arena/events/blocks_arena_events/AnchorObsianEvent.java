package com.gustavorickli.fps_arena.events.blocks_arena_events;

import com.gustavorickli.fps_arena.FPSArena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

public class AnchorObsianEvent implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (event.getEntity() instanceof Player) {
            final Player player = (Player) event.getEntity();

            Location playerBlockOut = player.getLocation();

            playerBlockOut.setY(playerBlockOut.getY() - 1);
            // playerBlockOut.getBlock().getType().equals(Material.OBSIDIAN)
            if (event.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK
                && playerBlockOut.getBlock().getType().equals(Material.OBSIDIAN)) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(FPSArena.instanceFpsArena, () ->
                        player.setVelocity(new Vector(0D, 0D, 0D)), 1L);
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            final Player player = (Player) event.getEntity();
            final Player damager = (Player) event.getDamager();

            Location playerBlockOut = player.getLocation();
            playerBlockOut.setY(playerBlockOut.getY() - 1);

            Location damagerBlockOut = player.getLocation();
            damagerBlockOut.setY(playerBlockOut.getY() - 1);
            // playerBlockOut.getBlock().getType().equals(Material.OBSIDIAN)

            if (playerBlockOut.getBlock().getType().equals(Material.OBSIDIAN) ||
                    damagerBlockOut.getBlock().getType().equals(Material.OBSIDIAN)) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(FPSArena.instanceFpsArena, () -> {
                    player.setVelocity(new Vector(0D, 0D, 0D));
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                    damager.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                }, 1L);
            }
        } else if (event.getEntity() instanceof Player) {
            final Player player = (Player) event.getEntity();

            Location playerBlockOut = player.getLocation();
            playerBlockOut.setY(playerBlockOut.getY() - 1);

            if (playerBlockOut.getBlock().getType().equals(Material.OBSIDIAN)) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(FPSArena.instanceFpsArena, () -> {
                    player.setVelocity(new Vector(0D, 0D, 0D));
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                }, 1L);
            }
        }
    }

}
