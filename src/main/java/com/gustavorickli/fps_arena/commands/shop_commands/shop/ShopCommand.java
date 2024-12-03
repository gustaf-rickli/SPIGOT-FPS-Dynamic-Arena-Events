package com.gustavorickli.fps_arena.commands.shop_commands.shop;

import com.gustavorickli.fps_arena.utils.console.shop_menus.ShopMenus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            ShopMenus.kitsShopMenu(player);
        }

        return true;
    }



}
