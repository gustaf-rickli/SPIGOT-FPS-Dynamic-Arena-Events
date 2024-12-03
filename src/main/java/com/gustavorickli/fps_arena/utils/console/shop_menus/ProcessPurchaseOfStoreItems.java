package com.gustavorickli.fps_arena.utils.console.shop_menus;

import com.gustavorickli.fps_arena.utils.rapid_instance_tools.Item;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ProcessPurchaseOfStoreItems {

    private ProcessPurchaseOfStoreItems() {
    }

    public static boolean processPurchaseRod(Player player) {

        final int VALUE_ROD = 5;

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType().equals(Material.EMERALD)) {
            if (item.getAmount() >= VALUE_ROD) {
                item.setAmount(item.getAmount() - VALUE_ROD);

                Location location = player.getLocation();

                location.getWorld().dropItem(location, Item.get(Material.FISHING_ROD));

                return true;
            }
        }

        return false;
    }

    public static boolean processPurchaseSharp1(Player player) {

        final int VALUE_SHARP1 = 12;

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType().equals(Material.EMERALD)) {
            if (item.getAmount() >= VALUE_SHARP1) {
                item.setAmount(item.getAmount() - VALUE_SHARP1);

                Location location = player.getLocation();
                ItemStack swordWithSharp1 = Item.get(Material.DIAMOND_SWORD);

                swordWithSharp1.addEnchantment(Enchantment.DAMAGE_ALL, 1);

                location.getWorld().dropItem(location, swordWithSharp1);

                return true;
            }
        }

        return false;
    }

}
