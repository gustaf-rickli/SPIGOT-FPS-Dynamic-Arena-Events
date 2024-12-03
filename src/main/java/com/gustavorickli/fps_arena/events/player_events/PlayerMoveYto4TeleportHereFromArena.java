package com.gustavorickli.fps_arena.events.player_events;

import com.gustavorickli.fps_arena.events.player_events.utils.RandomTeleport;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveYto4TeleportHereFromArena implements Listener {

    @EventHandler
    public void onPlayerMoveYto4TeleportFromArena(PlayerMoveEvent event) {
        double yCoord = event.getPlayer().getLocation().getY();

        if (yCoord == 4) {
            event.getPlayer().teleport( RandomTeleport.teleportPlayer(event.getPlayer()) );
        }
    }

}
