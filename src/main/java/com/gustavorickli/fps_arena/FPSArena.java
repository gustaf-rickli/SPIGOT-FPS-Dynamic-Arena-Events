package com.gustavorickli.fps_arena;

import com.gustavorickli.fps_arena.arena_events.mob_arena_event.normal.slime_viadinho.events.SlimeViadinhoSplitEvent;
import com.gustavorickli.fps_arena.commands.shop_commands.demoman.DemomanCommand;
import com.gustavorickli.fps_arena.commands.shop_commands.demoman.events.DemomanEvent;
import com.gustavorickli.fps_arena.commands.shop_commands.rod.FishermanRodCommand;
import com.gustavorickli.fps_arena.commands.shop_commands.rod.events.FishermanEvent;
import com.gustavorickli.fps_arena.commands.shop_commands.sharp1.Sharp1Command;
import com.gustavorickli.fps_arena.commands.shop_commands.shop.ShopCommand;
import com.gustavorickli.fps_arena.events.blocks_arena_events.AnchorObsianEvent;
import com.gustavorickli.fps_arena.events.blocks_arena_events.BlockNotExplodeEvent;
import com.gustavorickli.fps_arena.events.world_events.CancelWorldRainEvent;
import com.gustavorickli.fps_arena.arena_events.custom_blocks_events.events.SoupTotemEvent;
import com.gustavorickli.fps_arena.arena_events.simple_block_events.SpongeJumpEvent;
import com.gustavorickli.fps_arena.managers.GameManagerFPSArena;
import com.gustavorickli.fps_arena.arena_events.simple_block_events.JumpStonePlateEvent;
import com.gustavorickli.fps_arena.arena_events.mob_arena_event.boss.iron_golem_turtur.events.IronGolemTurturAttacksEvent;
import com.gustavorickli.fps_arena.events.player_events.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class FPSArena extends JavaPlugin {

    public static FPSArena instanceFpsArena;

    public static GameManagerFPSArena gameManager;

    @Override
    public void onEnable() {

        super.onEnable();
        // Plugin startup logic

        // Instance of FPSArena
        instanceFpsArena = this;

        // Create mini game
        gameManager = new GameManagerFPSArena();

        // Player Events
        getServer().getPluginManager().registerEvents(new PlayerDeathDropEmeraldEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnSetItemsEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropSwordBlocked(), this);


        // Outros eventos
        getServer().getPluginManager().registerEvents(new FishermanEvent(), this);
        getServer().getPluginManager().registerEvents(new SoupListenerEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockNotExplodeEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveYto4TeleportHereFromArena(), this);


        // Slime
        getServer().getPluginManager().registerEvents(new SlimeViadinhoSplitEvent(), this);

        // Iron Golem
        getServer().getPluginManager().registerEvents(new IronGolemTurturAttacksEvent(), this);

        // World Events
        getServer().getPluginManager().registerEvents(new CancelWorldRainEvent(), this);

        // Blocks
        getServer().getPluginManager().registerEvents(new JumpStonePlateEvent(), this);
        getServer().getPluginManager().registerEvents(new SpongeJumpEvent(), this);
        getServer().getPluginManager().registerEvents(new AnchorObsianEvent(), this);
        getServer().getPluginManager().registerEvents(new DemomanEvent(), this);

        getServer().getPluginManager().registerEvents(new SoupTotemEvent(), this);
        getServer().getPluginManager().registerEvents(new IronGolemTurturAttacksEvent(), this);

        // Commands
        getCommand("rod").setExecutor(new FishermanRodCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("sharp1").setExecutor(new Sharp1Command());
        getCommand("demoman").setExecutor(new DemomanCommand());


        System.out.println("Plugin iniciado com Sucesso xD !! Obrigado Jesus <3");


    }

    @Override
    public void onDisable() {
        super.onDisable();
    }



}
