package com.gustavorickli.fps_arena.arena_events.mob_arena_event.boss.iron_golem_turtur.events;

import com.gustavorickli.fps_arena.arena_events.mob_arena_event.mobs_utils.MobNameTag;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import java.util.Random;

public class IronGolemTurturAttacksEvent implements Listener {

    @EventHandler
    public void onIronGolemAttackPlayer(EntityDamageByEntityEvent event) {

        Player whoWasHit = (Player) event.getEntity(); // Quem recebeu o ataque
        IronGolem whoHit = (IronGolem) event.getDamager(); // Quem Atacou

        Random rand = new Random();

        if (event.getEntity() instanceof Player || event.getDamager() instanceof IronGolem) {

            if (whoHit.getCustomName().contains(MobNameTag.TURTUR.getName())) {

                int value = rand.nextInt(1);

                whoWasHit.setHealth(whoWasHit.getHealth() - (0.5 + value));

                int damage = (4 + rand.nextInt(2));

                if (whoWasHit.getHealth() - damage >= 0) {
                    whoWasHit.setHealth(whoWasHit.getHealth() - damage);
                } else {
                    whoWasHit.setHealth(0);
                }

                if (rand.nextInt(10) < 5) {
                    Vector direction = whoHit.getEyeLocation().getDirection();
                    Fireball fireball = whoHit.launchProjectile(Fireball.class, direction);
                    fireball.getLocation().add(fireball.getVelocity().normalize().multiply(3));
                }

            }
        } // end if

    } // end method @EventHandler


}