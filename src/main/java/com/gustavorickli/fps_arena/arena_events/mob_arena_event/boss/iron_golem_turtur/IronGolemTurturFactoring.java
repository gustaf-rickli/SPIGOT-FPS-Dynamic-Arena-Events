package com.gustavorickli.fps_arena.arena_events.mob_arena_event.boss.iron_golem_turtur;

import com.gustavorickli.fps_arena.arena_events.mob_arena_event.mobs_utils.MobNameTag;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IronGolemTurturFactoring {

    private IronGolemTurturFactoring() {
    }

    public static void summonIronGolemTurtur(Location location) {

        IronGolem ironGolem = (IronGolem) location.getWorld().spawnEntity(location, EntityType.IRON_GOLEM);
        ironGolem.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 3));
        ironGolem.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 12));
        ironGolem.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 2));
        //slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1));

        ironGolem.setCustomName(ChatColor.DARK_RED + MobNameTag.TURTUR.getName());
        ironGolem.setCustomNameVisible(true);

    }

}
