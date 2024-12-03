package com.gustavorickli.fps_arena.arena_events.mob_arena_event.normal.slime_viadinho;

import com.gustavorickli.fps_arena.arena_events.mob_arena_event.mobs_utils.MobNameTag;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlimeViadinhoFactoring {

    private SlimeViadinhoFactoring() {
    }


    /***
     *
     * @param location
     * @param slimeSize 6 tamanho gradinho, 2 muito pequeno
     *
     */
    public static void summonSlimeViadinho(Location location, int slimeSize) {
        Slime slime = (Slime) location.getWorld().spawnEntity(location, EntityType.SLIME);

        slime.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 15));
        slime.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 6));
        //slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1));
        slime.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 30));

        // 6 tamanho gradinho, 2 muito pequeno
        slime.setSize(slimeSize);

        slime.setCustomName(MobNameTag.VIADINHO.getName());
        slime.setCustomNameVisible(false);

    }

    public static void summonSlimeViadinho(Location location) {
        Slime slime = (Slime) location.getWorld().spawnEntity(location, EntityType.SLIME);

        slime.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 20));
        slime.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 6));
        //slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1));
        slime.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 25));

        // 6 tamanho gradinho, 2 muito pequeno
        slime.setSize(6);

        slime.setCustomName(MobNameTag.VIADINHO.getName());
        slime.setCustomNameVisible(false);

    }

}
