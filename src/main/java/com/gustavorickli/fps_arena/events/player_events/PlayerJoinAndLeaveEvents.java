package com.gustavorickli.fps_arena.events.player_events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;

public class PlayerJoinAndLeaveEvents implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GRAY + "Seja bem vindo " + ChatColor.GREEN + event.getPlayer().getName());

    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerKickEvent event) {
        event.setCancelled(true);
    }


}
