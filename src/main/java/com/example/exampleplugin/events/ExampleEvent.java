package com.example.exampleplugin.events;

import com.example.exampleplugin.manager.*;
import com.example.exampleplugin.utils.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

@SuppressWarnings("ALL")
public class ExampleEvent implements Listener {

    private final PluginManager pluginManager;

    public ExampleEvent(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    /**
     * @name ExampleEvent
     * @desc When player join set join message to [+] PlayerName
     * @param event
     * @code {@link com.example.exampleplugin.events.ExampleEvent}
     */

    @EventHandler(priority = EventPriority.LOW)
    public void onExampleEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(Format.color("&7[&a+&7] &a" + player.getName()));
    }

}
