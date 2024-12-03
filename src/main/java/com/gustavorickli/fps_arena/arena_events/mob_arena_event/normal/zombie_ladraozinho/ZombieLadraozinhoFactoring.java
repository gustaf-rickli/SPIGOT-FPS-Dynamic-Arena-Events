package com.gustavorickli.fps_arena.arena_events.mob_arena_event.normal.zombie_ladraozinho;

import com.gustavorickli.fps_arena.arena_events.mob_arena_event.mobs_utils.MobNameTag;
import com.gustavorickli.fps_arena.utils.rapid_instance_tools.Armour;
import com.gustavorickli.fps_arena.utils.rapid_instance_tools.ArmourUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ZombieLadraozinhoFactoring {

    private ZombieLadraozinhoFactoring() {
    }

    public static void summonZombieLadraozinho(Location location) {
        Zombie zombie = (Zombie) location.getWorld()
                .spawnEntity(location, EntityType.ZOMBIE);

        zombie.getEquipment().setHelmet(new ItemStack(Material.GOLD_BLOCK));
        zombie.getEquipment().setChestplate( ArmourUtils.getArmour(Armour.GOLD_CHEST) );
        zombie.getEquipment().setLeggings( ArmourUtils.getArmour(Armour.GOLD_LEGS) );
        zombie.getEquipment().setBoots( ArmourUtils.getArmour(Armour.GOLD_BOOTS) );

        zombie.setHealth(10d);

        zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 3));

        zombie.setCustomNameVisible(false);
        zombie.setCustomName(MobNameTag.LADRAOZINHO.getName());

        zombie.setBaby(true);

        ItemStack opSword = new ItemStack(Material.DIAMOND_SWORD);

        zombie.getEquipment().setItemInMainHand(opSword);
    }


}
