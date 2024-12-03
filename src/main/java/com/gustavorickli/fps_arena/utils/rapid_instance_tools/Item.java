package com.gustavorickli.fps_arena.utils.rapid_instance_tools;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Item {

    private Item() {
    }

    public static ItemStack get(Material material) {
        return new ItemStack(material);
    }

}
