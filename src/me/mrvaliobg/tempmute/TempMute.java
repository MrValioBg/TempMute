package me.mrvaliobg.tempmute;

import me.mrvaliobg.tempmute.commands.TempMuteCommand;
import me.mrvaliobg.tempmute.commands.UnmuteCommand;
import me.mrvaliobg.tempmute.data.DataConfiguration;
import me.mrvaliobg.tempmute.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TempMute extends JavaPlugin {


    @Override
    public void onEnable() {
        DataConfiguration.INSTANCE.init(this);
        DataConfiguration.INSTANCE.saveData();
        Bukkit.getPluginCommand("tempmute").setExecutor(new TempMuteCommand());
        Bukkit.getPluginCommand("unmute").setExecutor(new UnmuteCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
    }

    @Override
    public void onDisable() {
        DataConfiguration.INSTANCE.saveData();
    }

}
