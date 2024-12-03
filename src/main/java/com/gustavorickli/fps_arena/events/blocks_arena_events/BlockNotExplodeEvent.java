package com.gustavorickli.fps_arena.events.blocks_arena_events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;


public class BlockNotExplodeEvent implements Listener {

    @EventHandler
    public void onBlockExplodeEvent(EntityExplodeEvent event) {

        event.blockList().clear();

    }

}
