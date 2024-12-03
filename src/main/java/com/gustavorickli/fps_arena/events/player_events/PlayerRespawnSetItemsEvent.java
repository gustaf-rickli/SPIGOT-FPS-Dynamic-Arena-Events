package com.gustavorickli.fps_arena.events.player_events;

import com.gustavorickli.fps_arena.FPSArena;
import com.gustavorickli.fps_arena.events.player_events.utils.RandomTeleport;
import com.gustavorickli.fps_arena.managers.GameManagerFPSArena;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnSetItemsEvent implements Listener {

    @EventHandler
    public void onPlayerRespawnSetItems(PlayerRespawnEvent event) {

        Player player = event.getPlayer();

        GameManagerFPSArena gameManager = GameManagerFPSArena.getInstance();

        gameManager.setItemsPlayer(player, gameManager.getGameState());

        gameManager.addSoupAllsSlotsInventory(player);

        // player.setBedSpawnLocation(RandomTeleport.teleportPlayer(player));

        Bukkit.getScheduler().runTaskLater(FPSArena.instanceFpsArena, () ->
                player.teleport(RandomTeleport.teleportPlayer(player)), 1L);

    }

}
