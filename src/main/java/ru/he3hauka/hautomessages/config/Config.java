package ru.he3hauka.hautomessages.config;

import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public class Config {
    private final JavaPlugin plugin;
    private YamlConfiguration config;

    public String settings_format;
    public int settings_interval;

    public Config(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void init() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        this.config = YamlConfiguration.loadConfiguration(configFile);

        this.settings_format = config.getString("settings.format", "RANDOM");
        this.settings_interval = config.getInt("settings.interval", 180);
    }

    public YamlConfiguration getConfig() {
        return config;
    }
}
