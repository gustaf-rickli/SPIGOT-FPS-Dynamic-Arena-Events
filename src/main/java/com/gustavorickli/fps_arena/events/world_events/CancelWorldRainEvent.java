package com.gustavorickli.fps_arena.events.world_events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class CancelWorldRainEvent implements Listener {

    @EventHandler
    public void onRainStartCancel(WeatherChangeEvent event) {
        if ( event.toWeatherState() )
            event.setCancelled(true);

    }


}
