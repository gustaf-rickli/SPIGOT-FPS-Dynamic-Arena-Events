package com.gustavorickli.fps_arena.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BossBarThreadInterface extends Thread {

    @Override
    public void run() {
        super.run();

        BossBar bossBar = Bukkit.createBossBar(
                ChatColor.DARK_PURPLE + "Começou o Evento " + ChatColor.LIGHT_PURPLE
                        + GameManagerFPSArena.getInstance().getGameState().name(),
                BarColor.PURPLE,
                BarStyle.SOLID);

        for (Player player : Bukkit.getOnlinePlayers()) {
            bossBar.addPlayer(player);
        }

        final int TIME = 15000; // 15 seconds

        try {
            Thread.sleep(TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bossBar.removeAll();

    }
}
