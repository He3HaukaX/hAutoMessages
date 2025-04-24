package ru.he3hauka.hautomessages.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.he3hauka.hautomessages.config.Config;
import ru.he3hauka.hautomessages.manager.MessagesManager;
import ru.he3hauka.hautomessages.utils.Localization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.he3hauka.hautomessages.utils.HexSupport.format;

public class CommandHandler implements CommandExecutor, TabCompleter {
    private final MessagesManager messagesManager;
    private final Config config;
    private String locale;
    private Localization localization;

    public CommandHandler(MessagesManager messagesManager, Config config, String locale) {
        this.messagesManager = messagesManager;
        this.config = config;
        this.locale = locale;
        this.localization = new Localization(locale);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length == 0) {
            sendMessage(sender, "§6/" + label + " reload§7|§6start§7|§6stop§7|§6reboot§7|§6index");
            return true;
        }

        if (!sender.hasPermission("hautomessages.admin") || !sender.hasPermission("*") || !sender.isOp()) {
            sendMessage(sender, localization.get("no_permission"));
            return false;
        }

        String arg = args[0].toLowerCase();
        switch (arg) {
            case "reload":
            case "reboot": {
                this.locale = config.locale;
                this.localization = new Localization(this.locale);
                sendMessage(sender, localization.get("reloading_plugin"));
                long startTime = System.currentTimeMillis();
                messagesManager.stop();
                messagesManager.allMessages.clear();
                messagesManager.currentIndex = 0;
                config.init();
                messagesManager.start();
                long reloadTime = System.currentTimeMillis() - startTime;
                sendMessage(sender, localization.get("plugin_reloaded", reloadTime));
                return true;
            }
            case "start": {
                sendMessage(sender, localization.get("starting_auto_messages"));
                messagesManager.allMessages.clear();
                messagesManager.currentIndex = 0;
                messagesManager.stop();
                messagesManager.start();
                sendMessage(sender, localization.get("auto_messages_started"));
                return true;
            }
            case "stop": {
                sendMessage(sender, localization.get("stopping_auto_messages"));
                messagesManager.allMessages.clear();
                messagesManager.currentIndex = 0;
                messagesManager.stop();
                sendMessage(sender, localization.get("auto_messages_stopped"));
                return true;
            }
            case "index": {
                messagesManager.allMessages.clear();
                messagesManager.currentIndex = 0;
                messagesManager.stop();
                sendMessage(sender, localization.get("current_index", messagesManager.currentIndex));
                return true;
            }
            default:
                sendMessage(sender, "§6/" + label + " reload§7|§6start§7|§6stop§7|§6reboot§7|§6index");
                return true;
        }
    }

    private void sendMessage(CommandSender sender, String message) {
        String prefixMessage = config.prefix.isEmpty() ? message : format(config.prefix + (config.prefix.endsWith(" ") ? "" : " ") + message);
        sender.sendMessage(prefixMessage);
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return Stream.of("reload", "start", "stop", "reboot", "index")
                    .filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
