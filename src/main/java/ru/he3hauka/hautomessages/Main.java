package ru.he3hauka.hautomessages;

import org.bukkit.plugin.java.JavaPlugin;
import ru.he3hauka.hautomessages.command.CommandHandler;
import ru.he3hauka.hautomessages.config.Config;
import ru.he3hauka.hautomessages.manager.MessagesManager;
import ru.he3hauka.hautomessages.utils.Localization;

public final class Main extends JavaPlugin {
    private Localization localization;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        Config config = new Config(this);
        config.init();

        MessagesManager messagesManager = new MessagesManager(config, this);

        localization = new Localization(config.locale);

        getCommand("hautomessages").setExecutor(new CommandHandler(messagesManager, config, config.locale));
        getCommand("hautomessages").setTabCompleter(new CommandHandler(messagesManager, config,config.locale));

        getLogger().info(localization.get("plugin_started", getDescription().getVersion()));
        getLogger().info(localization.get("developer_contact"));

        messagesManager.start();

        new ru.he3hauka.hautomessages.utils.Metrics(this, 24935);
    }
    @Override
    public void onDisable() {
        getLogger().info(localization.get("plugin_stopped", getDescription().getVersion()));
        getLogger().info(localization.get("developer_contact"));
    }
}