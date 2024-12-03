package com.gustavorickli.fps_arena.commands.shop_commands.rod;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FishermanRodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Merchant merchant = Bukkit.createMerchant("SHOP");

            List<MerchantRecipe> recipes = new ArrayList<>();
            // Add our diamond recipe to this list
            recipes.add(getRod());
            // Add this list of recipes to our merchant
            merchant.setRecipes(recipes);
            // Open this merchant inventory to the player
            player.openMerchant(merchant, true);

            // ProcessPurchaseOfStoreItems.processPurchaseRod(player);

        }

        return true;
    }


    private MerchantRecipe getRod() {
        ItemStack rodResult = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = rodResult.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "FISHERMAN");
        rodResult.setItemMeta(meta);
        MerchantRecipe recipe = new MerchantRecipe(rodResult, 1);
        recipe.addIngredient(new ItemStack(Material.EMERALD, 5));
        return recipe;
    }
}
