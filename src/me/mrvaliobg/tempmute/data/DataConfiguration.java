package me.mrvaliobg.tempmute.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public enum DataConfiguration {

    INSTANCE;

    private File dFile;
    private FileConfiguration dConfiguration;

//
    public void init(Plugin p)  {
        File dFolder = p.getDataFolder();
        if (!dFolder.exists()){
            p.getDataFolder().mkdirs();
        }
        dFile = new File(p.getDataFolder(), "data.yml");
        if (!dFile.exists()) {
            try {
                dFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dConfiguration = YamlConfiguration.loadConfiguration(dFile);
    }

    public FileConfiguration getData() {
        return dConfiguration;
    }

    public void saveData()  {
        try {
            dConfiguration.save(dFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
