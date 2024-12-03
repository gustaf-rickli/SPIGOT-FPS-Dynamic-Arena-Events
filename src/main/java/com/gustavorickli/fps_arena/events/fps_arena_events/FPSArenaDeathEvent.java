package com.gustavorickli.fps_arena.events.fps_arena_events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class FPSArenaDeathEvent implements Listener {


    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        event.getDrops().clear();
    }

}
