package me.mrvaliobg.tempmute.listeners;

import me.mrvaliobg.tempmute.data.DataConfiguration;
import me.mrvaliobg.tempmute.utils.MuteUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.text.ParseException;


public class PlayerListener implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSpeak(AsyncPlayerChatEvent e) throws ParseException {
        if(!DataConfiguration.INSTANCE.getData().contains("Data." + e.getPlayer().getUniqueId())) return;
       e.setCancelled(MuteUtils.muteCheck(e.getPlayer()));
    }
}
