package com.example.exampleplugin.utils;

import org.bukkit.*;

import java.awt.Color;

public class Format {

    public static String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String rgb(Integer red, Integer green, Integer blue, String text){
        return net.md_5.bungee.api.ChatColor.of(new Color(red, green, blue)) + color(text);
    }

}
