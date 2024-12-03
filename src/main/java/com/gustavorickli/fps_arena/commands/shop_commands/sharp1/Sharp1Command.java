package com.gustavorickli.fps_arena.commands.shop_commands.sharp1;

import com.gustavorickli.fps_arena.arena_events.mob_arena_event.boss.iron_golem_turtur.IronGolemTurturFactoring;
import com.gustavorickli.fps_arena.arena_events.mob_arena_event.normal.slime_viadinho.SlimeViadinhoFactoring;
import com.gustavorickli.fps_arena.arena_events.mob_arena_event.normal.zombie_ladraozinho.ZombieLadraozinhoFactoring;
import com.gustavorickli.fps_arena.arena_events.mob_arena_event.normal.zombie_tank.ZombieTankFactoring;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Sharp1Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {



        if (sender instanceof Player) {

            Location loc = ((Player) sender).getLocation();

            IronGolemTurturFactoring.summonIronGolemTurtur(loc);
            IronGolemTurturFactoring.summonIronGolemTurtur(loc);

            SlimeViadinhoFactoring.summonSlimeViadinho(loc);
            SlimeViadinhoFactoring.summonSlimeViadinho(loc);
            SlimeViadinhoFactoring.summonSlimeViadinho(loc);
            SlimeViadinhoFactoring.summonSlimeViadinho(loc);
            SlimeViadinhoFactoring.summonSlimeViadinho(loc);

            ZombieLadraozinhoFactoring.summonZombieLadraozinho(loc);
            ZombieLadraozinhoFactoring.summonZombieLadraozinho(loc);
            ZombieLadraozinhoFactoring.summonZombieLadraozinho(loc);
            ZombieLadraozinhoFactoring.summonZombieLadraozinho(loc);
            ZombieLadraozinhoFactoring.summonZombieLadraozinho(loc);

            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);
            ZombieTankFactoring.summonZombieTank(loc);

            Player player = (Player) sender;

            Merchant merchant = Bukkit.createMerchant("teste");

            List<MerchantRecipe> recipes = new ArrayList<>();
            // Add our diamond recipe to this list
            recipes.add(getSwordWithSharp1());
            // Add this list of recipes to our merchant
            merchant.setRecipes(recipes);
            // Open this merchant inventory to the player
            player.openMerchant(merchant, true);

            // ProcessPurchaseOfStoreItems.processPurchaseRod(player);

        }

        return true;
    }


    private MerchantRecipe getSwordWithSharp1() {
        ItemStack swordResult = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = swordResult.getItemMeta();
        meta.setDisplayName(" &aSHARP 1 ");
        swordResult.setItemMeta(meta);

        swordResult.addEnchantment(Enchantment.DAMAGE_ALL, 1);

        MerchantRecipe recipe = new MerchantRecipe(swordResult, 1);
        recipe.addIngredient(new ItemStack(Material.EMERALD, 12));
        return recipe;
    }
}