package com.gustavorickli.fps_arena.events.player_events.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomTeleport {

    public static Location teleportPlayer(Player player) {
        Random rand = new Random();

        World world = player.getWorld();

        Location location = player.getLocation();

        // location.setYaw(Float.valueOf(player.getLocation().getYaw()));

        int randomValue = rand.nextInt(50);

        if (randomValue > 0 && randomValue <= 10) {
            location = new Location(world, 1110, 8, -1220);
        }

        if (randomValue > 10 && randomValue <= 20) {
            location = new Location(world, 1060, 8, -1236);
        }

        if (randomValue > 20 && randomValue <= 30) {
            location = new Location(world, 1085, 8, -1240);
        }

        if (randomValue > 30 && randomValue <= 40) {
            location = new Location(world, 1087, 18, -1208);
        }

        if (randomValue > 40 && randomValue < 49) {
            location = new Location(world, 1085, 18, -1255);
        }

        return location;

    }

}
