package com.gustavorickli.fps_arena.commands.shop_commands.demoman;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DemomanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            try {

                FileWriter criadorDeArquivo = new FileWriter("C:\\Users\\pc\\Documents\\SPIGOT\\servers\\test-1.12\\plugins\\arquivologs.txt", true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivo);
                PrintWriter escritorDeArquivo = new PrintWriter(buffer);

                String log = "Jogador " + player.getName() + " utilizou o comando Demoman";

                escritorDeArquivo.println(log);

                player.sendMessage(log);

            } catch (Exception e) {
                e.printStackTrace();
            }

            Merchant merchant = Bukkit.createMerchant("SHOP");

            List<MerchantRecipe> recipes = new ArrayList<>();
            // Add our diamond recipe to this list
            recipes.add(getDemomanMine());
            // Add this list of recipes to our merchant
            merchant.setRecipes(recipes);
            // Open this merchant inventory to the player
            player.openMerchant(merchant, true);

            // ProcessPurchaseOfStoreItems.processPurchaseRod(player);

        }

        return true;
    }

    private MerchantRecipe getDemomanMine() {
        ItemStack rodResult = new ItemStack(Material.GOLD_PLATE);
        ItemMeta meta = rodResult.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "DEMOMAN BOMB");
        rodResult.setItemMeta(meta);
        MerchantRecipe recipe = new MerchantRecipe(rodResult, 2);
        recipe.addIngredient(new ItemStack(Material.EMERALD, 15));
        return recipe;
    }

}