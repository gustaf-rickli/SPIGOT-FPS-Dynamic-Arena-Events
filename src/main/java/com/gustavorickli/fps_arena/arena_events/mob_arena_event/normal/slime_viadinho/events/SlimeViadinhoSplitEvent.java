package com.gustavorickli.fps_arena.arena_events.mob_arena_event.normal.slime_viadinho.events;

import com.gustavorickli.fps_arena.arena_events.mob_arena_event.mobs_utils.MobNameTag;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SlimeSplitEvent;

public class SlimeViadinhoSplitEvent implements Listener {

    @EventHandler
    public void onSlimeViadinhoSlitEvent(SlimeSplitEvent event) {

        Slime slimeViadinho = event.getEntity();

        if (slimeViadinho.getCustomName().equals(MobNameTag.VIADINHO.getName())) {
            event.setCancelled(true);
        }

    }

}
