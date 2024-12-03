package com.gustavorickli.fps_arena.arena_events.custom_blocks_events.events;

import com.gustavorickli.fps_arena.arena_events.custom_blocks_events.Totem;
import com.gustavorickli.fps_arena.managers.GameManagerFPSArena;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SoupTotemEvent implements Listener {

    private static Totem firstTotem;

    @EventHandler
    public void onClickFirstTotem(PlayerInteractEvent event) {

        Block clickedBlock = event.getClickedBlock();

        if (firstTotem == null &&
            clickedBlock.getLocation().getX() == 1104 &&
            clickedBlock.getLocation().getY() == 7 &&
            clickedBlock.getLocation().getZ() == -1206 &&
        clickedBlock.getType().equals(Material.WORKBENCH)) {

            firstTotem = new Totem(clickedBlock.getLocation());

            event.getPlayer().sendMessage("Totem criado nas coords: "
                    + clickedBlock.getLocation().getX() + " "
                    + clickedBlock.getLocation().getY() + " "
                    + clickedBlock.getLocation().getZ()
            );
        }

        if (clickedBlock.getType().equals(firstTotem.getMaterial()) &&
                clickedBlock.getLocation().getX() == firstTotem.getLocation().getX() &&
                clickedBlock.getLocation().getY() == firstTotem.getLocation().getY() &&
                clickedBlock.getLocation().getZ() == firstTotem.getLocation().getZ() &&
                clickedBlock.getType().equals(Material.WORKBENCH) &&
                firstTotem.isUnlocked()) {

            firstTotem.nextCounter();

            event.getPlayer().closeInventory();

            event.getPlayer().sendMessage("" + firstTotem.getCounter());

            GameManagerFPSArena.getInstance().addSoupAllsSlotsInventory(event.getPlayer());
        }

    }

    // First totem
    // 1104 7 -1206

}
