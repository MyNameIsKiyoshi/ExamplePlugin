package com.example.exampleplugin;

import com.example.exampleplugin.commands.*;
import com.example.exampleplugin.events.*;
import com.example.exampleplugin.manager.*;
import com.example.exampleplugin.utils.*;
import org.bukkit.*;
import org.bukkit.configuration.file.*;
import org.bukkit.plugin.java.*;
/**
 * #      ______                           __        ____  __            _
 * #     / ____/  ______ _____ ___  ____  / /__     / __ \/ /_  ______ _(_)___
 * #    / __/ | |/_/ __ `/ __ `__ \/ __ \/ / _ \   / /_/ / / / / / __ `/ / __ \
 * #   / /____>  </ /_/ / / / / / / /_/ / /  __/  / ____/ / /_/ / /_/ / / / / /
 * #  /_____/_/|_|\__,_/_/ /_/ /_/ .___/_/\___/  /_/   /_/\__,_/\__, /_/_/ /_/
 * #                            /_/                            /____/
 * # By MyNameIsKiyoshi
 * @code {@link com.example.exampleplugin.Main}
 */

import java.io.*;

@SuppressWarnings("ALL")
public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance(){
        return instance;
    }

    private PluginManager pluginManager;

    public void Initialize(){
        saveDefaultConfig();
        getConfig().options().parseComments(true); // use .options().copyHeader(true); in 1.16<
        getConfig().options().copyDefaults(true); // prevent overwrite config save with getConfig().saveConfig();
        instance = this;
    }

    public void Commands(){
        getCommand("examplecommand").setExecutor(new ExampleCommand(pluginManager));
    }

    public void Events(){
        getServer().getPluginManager().registerEvents(new ExampleEvent(pluginManager), this);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void Config(){
        File lang = new File(this.getDataFolder(), "lang");
        File lang_en = new File(this.getDataFolder() + "/lang/en_US.yml");
        if (!lang.exists()) {
            lang.mkdir();
        }
        FileConfiguration lang_en_config = YamlConfiguration.loadConfiguration(lang_en);
        if (!lang_en.exists()) {
            try {
                lang_en.createNewFile();
                lang_en_config.createSection("ExampleLang");
                lang_en_config.set("ExampleLang.ExampleMessage", " &9I Like Kiyoshi ");
                lang_en_config.save(lang_en);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @desc Here register all (Plugin Start)
     * @code {@link com.example.exampleplugin.Main}
     */
    @Override
    public void onEnable(){
        Initialize();
        Config();
        Commands();
        Events();
        Bukkit.getLogger().info(Format.color("&a[ExamplePlugin] Enabled."));
        //todo: code here
    }


    /**
     * @desc Here register all (Plugin Stop)
     * @code {@link com.example.exampleplugin.Main}
     */
    @Override
    public void onDisable(){
        Bukkit.getLogger().info(Format.color("&a[ExamplePlugin] Disabling."));
        // code here
    }

    /**
     * @desc Here register all (Plugin Load)
     * @code {@link com.example.exampleplugin.Main}
     */
    @Override
    public void onLoad(){
        // code here
    }


}
