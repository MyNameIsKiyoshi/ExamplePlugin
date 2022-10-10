package com.example.exampleplugin.utils;

import com.example.exampleplugin.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@SuppressWarnings("ALL")
public class Message {
    public static File lang_en = new File(Main.getInstance().getDataFolder() + "/lang/en_US.yml");
    public static FileConfiguration lang_en_config;
    public static String lang;


    public static String lang(){
        return Main.getInstance().getConfig().getString("Lang");
    }
    public static String ExampleMessageEN(){
        return lang.equals("EN") ? Format.color(lang_en_config.getString("ExampleLang.ExampleMessage")) : "";
    }

    static {
        lang_en_config = YamlConfiguration.loadConfiguration(lang_en);
        lang = Main.getInstance().getConfig().getString("Lang");
    }
}
