package com.gustavorickli.fps_arena.events.fps_arena_events;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class FPSArenaJoinEvent implements Listener {


    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {

        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack leg = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

        sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);

        Player p = event.getPlayer();

        p.getInventory().setItemInMainHand(sword);

        p.getInventory().setHelmet(helmet);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(leg);
        p.getInventory().setBoots(boots);

    }


}
