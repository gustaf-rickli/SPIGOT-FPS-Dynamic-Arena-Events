package com.gustavorickli.fps_arena.commands.shop_commands.rod.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.HashMap;
import java.util.UUID;

public class FishermanEvent implements Listener {

    private static HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void fisherman(PlayerFishEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand()
                .getItemMeta().getDisplayName().contains("FISHERMAN") ) {

            Player fisher = event.getPlayer();

            if (event.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
                if (event.getCaught().getType() == EntityType.PLAYER) {

                    if (!cooldown.containsKey(player.getUniqueId())) {
                        cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    }

                    final int FIVE_SECONDS = 5000;

                    if ( (System.currentTimeMillis() - cooldown.get(player.getUniqueId()))
                            >= FIVE_SECONDS ) {

                        Player caught = (Player) event.getCaught();
                        World w = fisher.getLocation().getWorld();

                        double x = fisher.getLocation().getBlockX() + 0.5D;
                        double y = fisher.getLocation().getBlockY();
                        double z = fisher.getLocation().getBlockZ() + 0.5D;
                        float yaw = caught.getLocation().getYaw();
                        float pitch = caught.getLocation().getPitch();

                        Location location = new Location(w, x, y, z, yaw, pitch);

                        caught.teleport(location);

                        cooldown.put(
                                player.getUniqueId(),
                                System.currentTimeMillis()
                        );

                    } else {
                        player.sendMessage(
                        ChatColor.DARK_RED + "Aguarde "
                            + (int)((FIVE_SECONDS - (System.currentTimeMillis() - cooldown.get(player.getUniqueId()))) / 1000)
                            + " segundos"
                        );

                        event.setCancelled(true);
                    }
                }
            }
        }

    }

}
