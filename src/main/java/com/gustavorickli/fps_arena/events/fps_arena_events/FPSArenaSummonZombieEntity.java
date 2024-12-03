package com.gustavorickli.fps_arena.events.fps_arena_events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FPSArenaSummonZombieEntity implements Listener {

    @EventHandler
    public void onSummonZombieEntity(PlayerInteractEvent event) {

        if (event.getClickedBlock().getType().equals(Material.DIAMOND_BLOCK) ) {

            World w = event.getPlayer().getWorld();

            Zombie zombie = (Zombie) w.spawnEntity(event.getClickedBlock().getLocation(), EntityType.ZOMBIE);

            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_BLOCK));
            zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));

            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 1));
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 4));

            zombie.setCustomNameVisible(false);
            zombie.setCustomName("Dinnerbone");

            ItemStack opSword = new ItemStack(Material.DIAMOND_SWORD);

            opSword.addEnchantment(Enchantment.DAMAGE_ALL, 5 );
            opSword.addEnchantment(Enchantment.FIRE_ASPECT, 1 );

            zombie.getEquipment().setItemInMainHand(opSword);

        }

        if (event.getClickedBlock().getType().equals(Material.GOLD_BLOCK) ) {

            World w = event.getPlayer().getWorld();

            Zombie zombie = (Zombie) w.spawnEntity(event.getClickedBlock().getLocation(), EntityType.ZOMBIE);

            zombie.getEquipment().setHelmet(new ItemStack(Material.GOLD_BLOCK));
            zombie.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS));

            zombie.setHealth(10d);

            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 3));

            zombie.setCustomNameVisible(false);
            zombie.setCustomName("Ladraozinho");

            zombie.setBaby(true);

            ItemStack opSword = new ItemStack(Material.DIAMOND_SWORD);

            opSword.addEnchantment(Enchantment.DAMAGE_ALL, 5 );
            opSword.addEnchantment(Enchantment.FIRE_ASPECT, 1 );

            zombie.getEquipment().setItemInMainHand(opSword);

        }

        if (event.getClickedBlock().getType().equals(Material.EMERALD_BLOCK) ) {

            World w = event.getPlayer().getWorld();

            Slime slime = (Slime) w.spawnEntity(event.getClickedBlock().getLocation(), EntityType.SLIME);
            slime.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 15));
            slime.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 6));
            //slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1));
            slime.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 25));

            slime.setSize(6);

            slime.setCustomName("Viadinho");
            slime.setCustomNameVisible(false);

        }

        if (event.getClickedBlock().getType().equals(Material.EMERALD_ORE) ) {

            World w = event.getPlayer().getWorld();

            IronGolem ironGolem = (IronGolem) w.spawnEntity(event.getClickedBlock().getLocation(), EntityType.IRON_GOLEM);
            ironGolem.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1));
            ironGolem.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 12));
            ironGolem.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1));
            //slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1));

            ironGolem.setCustomName(ChatColor.DARK_RED + "Turtur");
            ironGolem.setCustomNameVisible(true);

            Bukkit.broadcastMessage(ChatColor.RED + "Turtur" + ChatColor.YELLOW + " Acabou de Sumonar");

        }

        if (event.getClickedBlock().getType().equals(Material.ENDER_STONE) ) {

            World w = event.getPlayer().getWorld();

            Enderman enderman = (Enderman) w.spawnEntity(event.getClickedBlock().getLocation(), EntityType.ENDERMAN);
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 3));
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 3));
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1));
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 2));
            //slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1));

            enderman.setCustomName("Mlundbuyvev");
            enderman.setCustomNameVisible(true);

            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "Mlundbuyvev" + ChatColor.YELLOW + " Acabou de Sumonar");

        }

        if (event.getClickedBlock().getType().equals(Material.GLOWSTONE) ) {


            World w = event.getPlayer().getWorld();

            Creeper creeper = (Creeper) w.spawnEntity(event.getClickedBlock().getLocation(), EntityType.CREEPER);

            creeper.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_BLOCK));

            creeper.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2000, 7));
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 7));
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 5));

            creeper.setCustomNameVisible(false);
            creeper.setCustomName("Dinnerbone");

            creeper.setPowered(true);
            creeper.setHealth(4);

        }

        if (event.getClickedBlock().getType().equals(Material.REDSTONE_BLOCK) ) {


            World w = event.getPlayer().getWorld();

            Creeper creeper = (Creeper) w.spawnEntity(event.getClickedBlock().getLocation(), EntityType.CREEPER);

            creeper.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_BLOCK));

            creeper.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 250, 20));
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 750, 1));
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1000, 0));
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1000, 7));
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 900, 10));

            creeper.setCustomNameVisible(true);
            creeper.setCustomName(ChatColor.GREEN + "GabGordo xD");

        }

    }

}
