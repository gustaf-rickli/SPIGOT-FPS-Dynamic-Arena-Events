package com.gustavorickli.fps_arena.arena_events.mob_arena_event.normal.zombie_tank;

import com.gustavorickli.fps_arena.utils.rapid_instance_tools.Armour;
import com.gustavorickli.fps_arena.utils.rapid_instance_tools.ArmourUtils;
import com.gustavorickli.fps_arena.utils.rapid_instance_tools.Sword;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class ZombieTankFactoring {

    private ZombieTankFactoring() {
    }

    public static void summonZombieTank(Location location) {
        Zombie zombie = (Zombie) location.getWorld()
                .spawnEntity(location, EntityType.ZOMBIE);

        zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_BLOCK));
        zombie.getEquipment().setChestplate(ArmourUtils.getArmour(Armour.DIAMOND_CHEST));
        zombie.getEquipment().setLeggings(ArmourUtils.getArmour(Armour.DIAMOND_LEGS));
        zombie.getEquipment().setBoots(ArmourUtils.getArmour(Armour.DIAMOND_BOOTS));

        zombie.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 1));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 4));

        zombie.setCustomNameVisible(false);
        zombie.setCustomName("Dinnerbone");

        ItemStack opSword = ArmourUtils.getSword(Sword.DIAMOND_SHARP5);

        //opSword.addEnchantment(Enchantment.DAMAGE_ALL, 5 );
        //opSword.addEnchantment(Enchantment.FIRE_ASPECT, 1 );

        zombie.getEquipment().setItemInMainHand(opSword);
    }
}
