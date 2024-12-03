package com.gustavorickli.fps_arena.events.player_events;

import com.gustavorickli.fps_arena.FPSArena;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerDeathDropEmeraldEvent implements Listener {

    private FPSArena plugin;

    public PlayerDeathDropEmeraldEvent(FPSArena plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeathDrop1Emerald(PlayerDeathEvent event) {
        event.getDrops().clear();

        event.getDrops().add(new ItemStack(Material.EMERALD));

        new BukkitRunnable() {

            @Override
            public void run() {
                event.getDrops().add(new ItemStack(Material.EMERALD));
                /*event.getEntity()
                        .spawnParticle(
                            Particle.VILLAGER_HAPPY,
                            event.getEntity().getLocation(),
                            20
                        ); */
            }

        }.runTaskLater(plugin, 20L);

    }


}
