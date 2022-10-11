package com.example.exampleplugin.manager;


import com.example.exampleplugin.*;

public class PluginManager {

    public static Main getPlugin() {
        return Main.getInstance();
    }

    private final Main plugin;

    public PluginManager(Main plugin){
        this.plugin = plugin;
    }
}
