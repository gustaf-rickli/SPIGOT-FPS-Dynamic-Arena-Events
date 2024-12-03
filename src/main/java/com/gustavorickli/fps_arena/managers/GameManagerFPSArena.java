package com.gustavorickli.fps_arena.managers;

import com.gustavorickli.fps_arena.FPSArena;
import com.gustavorickli.fps_arena.managers.utils.GameState;
import com.gustavorickli.fps_arena.utils.rapid_instance_tools.Armour;
import com.gustavorickli.fps_arena.utils.rapid_instance_tools.ArmourUtils;
import com.gustavorickli.fps_arena.utils.rapid_instance_tools.Sword;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

public class GameManagerFPSArena {

    private GameState gameState = GameState.FPS;

    public GameManagerFPSArena() {

        gameLoop();

    }

    public static GameManagerFPSArena getInstance() {
        return FPSArena.gameManager;
    }

    public void gameLoop() {

        final int DOZE_MINUTOS = 1200 * 12;

        new BukkitRunnable() {

            @Override
            public void run() {

                // ---

                setGameState(nextGameState());

                clearInventoryAllsPlayers();
                clearEffectsAllsPlayers();

                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.closeInventory();
                }

                setItemsOfAllsPlayers();

                createBossBarInterface();

                // Loop para summons monsters

                // Bukkit.broadcastMessage(ChatColor.GREEN + "Começou o Evento " + ChatColor.LIGHT_PURPLE + getGameState().name());

            }

        }.runTaskTimer(FPSArena.instanceFpsArena, 0, 4800); // 200 = 10 segs | 4800 = 4min.
        // antes era async

    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void clearInventoryAllsPlayers() {
        for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {

            onlinePlayer.getInventory().clear();

        }
    }

    public void clearEffectsAllsPlayers() {
        for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {
            for (PotionEffect effect : onlinePlayer.getActivePotionEffects()) {
                // onlinePlayer.getActivePotionEffects().clear();

                onlinePlayer.removePotionEffect(effect.getType());
            }
        }
    }

    public void createBossBarInterface() {
        BossBarThreadInterface bossBarThread = new BossBarThreadInterface();

        bossBarThread.start();

    }

    public void setItemsOfAllsPlayers() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {

            setItemsPlayer(onlinePlayer, getGameState());

        }

    }

    public void setItemsPlayer(Player player, GameState gameState) {
        // LOW_SOUP, FPS, RAGE, SHARP2, MAIN, EARLY_HG, POT_PVP

        addSoupAllsSlotsInventory(player);

        if (gameState.equals(GameState.LOW_SOUP)) {
            player.getInventory().setHelmet(ArmourUtils.getArmour(Armour.IRON_HELMET));
            player.getInventory().setChestplate(ArmourUtils.getArmour(Armour.IRON_CHEST));
            player.getInventory().setLeggings(ArmourUtils.getArmour(Armour.IRON_LEGS));
            player.getInventory().setBoots(ArmourUtils.getArmour(Armour.IRON_BOOTS));

            player.getInventory().setItem(0, ArmourUtils.getSword(Sword.DIAMOND));
        }

        if (gameState.equals(GameState.FPS)) {
            player.getInventory().setHelmet(ArmourUtils.getArmour(Armour.IRON_HELMET));
            player.getInventory().setChestplate(ArmourUtils.getArmour(Armour.IRON_CHEST));
            player.getInventory().setLeggings(ArmourUtils.getArmour(Armour.IRON_LEGS));
            player.getInventory().setBoots(ArmourUtils.getArmour(Armour.IRON_BOOTS));

            player.getInventory().setItem(0, ArmourUtils.getSword(Sword.DIAMOND_SHARP1));

            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
        }

        if (gameState.equals(GameState.RAGE)) {


            player.getInventory().setItem(0, ArmourUtils.getSword(Sword.DIAMOND_SHARP1));

            // player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 1));
        }

        if (gameState.equals(GameState.SHARP2)) {
            player.getInventory().setHelmet(ArmourUtils.getArmour(Armour.IRON_HELMET));
            player.getInventory().setChestplate(ArmourUtils.getArmour(Armour.IRON_CHEST));
            player.getInventory().setLeggings(ArmourUtils.getArmour(Armour.IRON_LEGS));
            player.getInventory().setBoots(ArmourUtils.getArmour(Armour.IRON_BOOTS));

            player.getInventory().setItem(0, ArmourUtils.getSword(Sword.DIAMOND_SHARP2));
        }

        if (gameState.equals(GameState.EARLY_HG)) {

            player.getInventory().setItem(0, ArmourUtils.getSword(Sword.STONE_SHARP1));
        }

        if (gameState.equals(GameState.POT_PVP)) {
            player.getInventory().setHelmet(ArmourUtils.getArmour(Armour.DIAMOND_HELMET));
            player.getInventory().setChestplate(ArmourUtils.getArmour(Armour.DIAMOND_CHEST));
            player.getInventory().setLeggings(ArmourUtils.getArmour(Armour.DIAMOND_LEGS));
            player.getInventory().setBoots(ArmourUtils.getArmour(Armour.DIAMOND_BOOTS));

            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1));

            player.getInventory().setItem(0, ArmourUtils.getSword(Sword.DIAMOND_SHARP5));

            ItemStack enderPearls = new ItemStack(Material.ENDER_PEARL);
            enderPearls.setAmount(5);

            player.getInventory().setItem(1, enderPearls);
        }

    }

    public GameState nextGameState() {

        // LOW_SOUP, FPS, RAGE, SHARP2, EARLY_HG

        if (gameState.equals(GameState.LOW_SOUP)) {
            return GameState.FPS;
        }

        if (gameState.equals(GameState.FPS)) {
            return GameState.RAGE;
        }

        if (gameState.equals(GameState.RAGE)) {
            return GameState.SHARP2;
        }

        if (gameState.equals(GameState.SHARP2)) {
            return GameState.EARLY_HG;
        }

        if (gameState.equals(GameState.EARLY_HG)) {
            return GameState.POT_PVP;
        }

        return GameState.LOW_SOUP;


    }

    public void addSoupAllsSlotsInventory(Player player) {
        for (int i = 0; i < 36; i++) {

            if (player.getInventory().getItem(i) == null) {

                if (getGameState().equals(GameState.POT_PVP)) {
                    ItemStack pot = new ItemStack(Material.SPLASH_POTION);
                    PotionMeta potionMeta = ((PotionMeta) pot.getItemMeta());
                    potionMeta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, true));
                    pot.setItemMeta(potionMeta);

                    player.getInventory().setItem(i, pot);

                    continue;
                }

                player.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
            }

        }
    }

    public static class ControllerArenaEvents {
    }
}
