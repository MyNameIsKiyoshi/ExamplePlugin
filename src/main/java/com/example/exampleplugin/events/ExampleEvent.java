package com.example.exampleplugin.events;

import com.example.exampleplugin.utils.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class ExampleEvent implements Listener {

    /**
     * @name ExampleEvent
     * @desc When player join set join message to [+] PlayerName
     * @param event
     * @code {@link com.example.exampleplugin.events.ExampleEvent}
     */
    @SuppressWarnings("ALL")
    @EventHandler(priority = EventPriority.LOW)
    public void onExampleEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(Format.color("&7[&a+&7] &a" + player.getName()));
    }

}
