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
    public Boolean sound_enable;
    public String sound_type;
    public Float sound_volume;
    public Float sound_pitch;
    public String locale;
    public String prefix;

    public Config(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void init() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        this.config = YamlConfiguration.loadConfiguration(configFile);

        this.settings_format = config.getString("settings.format", "LIST");
        this.settings_interval = config.getInt("settings.interval", 5);

        this.sound_enable = config.getBoolean("sound.enable", true);
        this.sound_type = config.getString("sound.type", "entity.experience_orb.pickup");
        this.sound_volume = (float) config.getDouble("sound.volume", 0.5);
        this.sound_pitch = (float) config.getDouble("sound.pitch", 1);

        this.locale = config.getString("settings.locale", "ru");
        this.prefix = config.getString("settings.prefix", "&7[&#FB9C08https://t.me/hplugin&7]&f");
    }

    public YamlConfiguration getConfig() {
        return config;
    }
}
