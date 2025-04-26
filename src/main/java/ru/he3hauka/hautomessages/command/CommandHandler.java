package ru.he3hauka.hautomessages.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.he3hauka.hautomessages.config.Config;
import ru.he3hauka.hautomessages.manager.MessagesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandHandler implements CommandExecutor, TabCompleter {
    private final MessagesManager messagesManager;
    private final Config config;

    public CommandHandler(MessagesManager messagesManager,
                          Config config) {
        this.messagesManager = messagesManager;
        this.config = config;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!sender.hasPermission("hautomessages.admin") || !sender.hasPermission("*") || !sender.isOp()) {
            sender.sendMessage("§7[§x§F§B§9§C§0§8hAutoMessages§7] §fYou don't have enough rights!");
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage("§x§F§B§9§C§0§8╔");
            sender.sendMessage("§x§F§B§9§C§0§8╠ §f/" + label + " reload §7(§x§F§B§9§C§0§8Plugin reload§7)");
            sender.sendMessage("§x§F§B§9§C§0§8╠ §f/" + label + " start §7(§x§F§B§9§C§0§8Start automessage task§7)");
            sender.sendMessage("§x§F§B§9§C§0§8╠ §f/" + label + " stop §7(§x§F§B§9§C§0§8Stop automessage task§7)");
            sender.sendMessage("§x§F§B§9§C§0§8╚");
            return true;
        }

        String arg = args[0].toLowerCase();
        switch (arg) {
            case "reload":
            case "reboot": {
                sender.sendMessage("§7[§x§F§B§9§C§0§8hAutoMessages§7] §fAn attempt to §x§F§B§9§C§0§8restart§f the plugin...!");
                long startTime = System.currentTimeMillis();
                messagesManager.stop();
                messagesManager.allMessages.clear();
                messagesManager.currentIndex = 0;
                config.init();
                messagesManager.start();
                long reloadTime = System.currentTimeMillis() - startTime;
                sender.sendMessage("§7[§x§F§B§9§C§0§8hAutoMessages§7] §fPlugin refreshed in §x§F§B§9§C§0§8" + reloadTime + "§f ms!");
                return true;
            }
            case "start": {
                sender.sendMessage("§7[§x§F§B§9§C§0§8hAutoMessages§7] §fAn attempt to §x§F§B§9§C§0§8start §ftask...!");
                messagesManager.allMessages.clear();
                messagesManager.currentIndex = 0;
                messagesManager.stop();
                messagesManager.start();
                sender.sendMessage("§7[§x§F§B§9§C§0§8hAutoMessages§7] §fNew task is §x§F§B§9§C§0§8successful§f working!");
                return true;
            }
            case "stop": {
                sender.sendMessage("§7[§x§F§B§9§C§0§8hAutoMessages§7] §fAn attempt to §x§F§B§9§C§0§8stop §ftask...!");
                messagesManager.allMessages.clear();
                messagesManager.currentIndex = 0;
                messagesManager.stop();
                sender.sendMessage("§7[§x§F§B§9§C§0§8hAutoMessages§7] §fThis task §x§F§B§9§C§0§8successful§f stopped!");
                return true;
            }
            default:
                sender.sendMessage("§x§F§B§9§C§0§8╔");
                sender.sendMessage("§x§F§B§9§C§0§8╠ §f/" + label + " reload §7(§x§F§B§9§C§0§8Plugin reload§7)");
                sender.sendMessage("§x§F§B§9§C§0§8╠ §f/" + label + " start §7(§x§F§B§9§C§0§8Start automessage task§7)");
                sender.sendMessage("§x§F§B§9§C§0§8╠ §f/" + label + " stop §7(§x§F§B§9§C§0§8Stop automessage task§7)");
                sender.sendMessage("§x§F§B§9§C§0§8╚");
                return true;
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return Stream.of("reload", "start", "stop", "reboot")
                    .filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
