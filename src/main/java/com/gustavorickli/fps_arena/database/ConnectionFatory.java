package com.gustavorickli.fps_arena.database;

import org.bukkit.ChatColor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFatory {


    private ConnectionFatory() {
    }

    public static Connection getConnection(String url, String user, String password) {

        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println(ChatColor.GREEN + "Conexao realizada (MySQL)");

            return connection;

        } catch (SQLException sqlException) {
            System.out.println(ChatColor.RED + "Erro ao conectar (MySQL)");

            sqlException.printStackTrace();
        }

        return null;

    }


}
