package com.gustavorickli.fps_arena.arena_events.custom_blocks_events;

import com.gustavorickli.fps_arena.FPSArena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

public class Totem {

    private Location location;
    private int counter = 0;
    private boolean unlocked = true;

    public Totem(Location location) {
        this.location = location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public Location getLocation() {
        return location;
    }

    public Material getMaterial() {
        return location.getBlock().getType();
    }

    public void nextCounter() {
        counter++;

        if (counter > 5) {
            unlocked = false;

            Location blockUpLocation = location;
            blockUpLocation.setY(blockUpLocation.getY() + 1);
            blockUpLocation.getBlock().setType(Material.REDSTONE_BLOCK);

            // await time blocked refill
            new BukkitRunnable() {

                @Override
                public void run() {
                    blockUpLocation.getBlock().setType(Material.EMERALD_BLOCK);

                    Bukkit.broadcastMessage("teste");

                    counter = 0;
                    unlocked = true;
                }

            }.runTaskLater(FPSArena.instanceFpsArena, 200);

        }
    }

    public int getCounter() {
        return counter;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    /*
    protected void setUnlocked() {

        Location blockUpLocation = location;
        blockUpLocation.setY(blockUpLocation.getY() + 1);
        blockUpLocation.getBlock().setType(Material.EMERALD_BLOCK);

        unlocked = true;
    }
    */

}
