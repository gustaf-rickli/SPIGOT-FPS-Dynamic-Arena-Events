package com.gustavorickli.fps_arena.utils.console.shop_menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ShopMenus {

    private ShopMenus() {
    }

    public static void kitsShopMenu(Player player) {

        player.sendMessage("");
        player.sendMessage(ChatColor.YELLOW + "/rod para pegar uma vara de pesca " + ChatColor.GREEN +
                "(5 Esmeraldas)");
        player.sendMessage(ChatColor.YELLOW + "/sharp1 para pegar Sharpness 1 na Espada " + ChatColor.GREEN +
                "(12 Esmeraldas)");
        player.sendMessage(ChatColor.YELLOW + "/demoman para pegar uma Demoman Bomb " + ChatColor.GREEN +
                "(15 Esmeraldas)");
        player.sendMessage("");

    }

}
