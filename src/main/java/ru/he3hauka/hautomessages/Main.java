package ru.he3hauka.hautomessages;

import org.bukkit.plugin.java.JavaPlugin;
import ru.he3hauka.hautomessages.command.CommandHandler;
import ru.he3hauka.hautomessages.config.Config;
import ru.he3hauka.hautomessages.manager.MessagesManager;
import ru.he3hauka.hautomessages.update.UpdateChecker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        Config config = new Config(this);
        config.init();

        MessagesManager messagesManager = new MessagesManager(config, this);

        getCommand("hautomessages").setExecutor(new CommandHandler(messagesManager, config));
        getCommand("hautomessages").setTabCompleter(new CommandHandler(messagesManager, config));

        messagesManager.start();

        if (getConfig().getBoolean("settings.update", true)) {
            new UpdateChecker(this).checkForUpdates();
        }

        authorInfo();
    }
    @Override
    public void onDisable() {
    }

    public void authorInfo(){
        File file = new File(getDataFolder(), "info.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.copy(getResource("info.txt"), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}