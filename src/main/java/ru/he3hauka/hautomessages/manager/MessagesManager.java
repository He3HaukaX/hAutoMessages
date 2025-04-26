package ru.he3hauka.hautomessages.manager;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.he3hauka.hautomessages.config.Config;
import ru.he3hauka.hautomessages.utils.Format;
import ru.he3hauka.hautomessages.utils.HexSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MessagesManager {
    private BukkitRunnable task;
    public int currentIndex = 0;
    public final List<MessageGroup> allMessages = new ArrayList<>();
    private final JavaPlugin plugin;
    private final Config config;

    private static final Pattern HOVER_PATTERN = Pattern.compile("\\{HoverText:cmd (.*?), text: (.*?)}");

    private static class MessageGroup {
        List<String> messages;
        String permission;
        List<String> blacklistedWorlds;
        String clickUrl;
        String sound;

        public MessageGroup(List<String> messages, String permission, List<String> blacklistedWorlds, String clickUrl, String sound) {
            this.messages = messages;
            this.permission = permission;
            this.blacklistedWorlds = blacklistedWorlds;
            this.clickUrl = clickUrl;
            this.sound = sound;
        }
    }

    public MessagesManager(Config config, JavaPlugin plugin) {
        this.config = config;
        this.plugin = plugin;
    }

    public void start() {
        if (task != null && !task.isCancelled()) {
            return;
        }

        String format = config.settings_format;
        int interval = config.settings_interval * 20;

        for (int i = 1; config.getConfig().contains("list." + i); i++) {
            List<String> messages = config.getConfig().getStringList("list." + i + ".messages");
            String permission = config.getConfig().getString("list." + i + ".permission", "");
            List<String> blacklistedWorlds = config.getConfig().getStringList("list." + i + ".blacklisted_worlds");
            String clickUrl = config.getConfig().getString("list." + i + ".click-url", "");
            String sound = config.getConfig().getString("list." + i + ".sound", "");

            List<String> coloredMessages = messages.stream()
                    .map(HexSupport::format)
                    .collect(Collectors.toList());

            allMessages.add(new MessageGroup(coloredMessages, permission, blacklistedWorlds, clickUrl, sound));
        }

        task = new BukkitRunnable() {
            @Override
            public void run() {
                if (allMessages.isEmpty()) {
                    Bukkit.getLogger().severe("No messages to send!");
                    return;
                }

                MessageGroup messageGroup;
                if (Format.valueOf(format) == Format.RANDOM) {
                    int randomIndex = new Random().nextInt(allMessages.size());
                    messageGroup = allMessages.get(randomIndex);
                } else {
                    messageGroup = allMessages.get(currentIndex);
                }

                for (String rawMessage : messageGroup.messages) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        String processedMessage = PlaceholderAPI.setPlaceholders(player, rawMessage);

                        Matcher hoverMatcher = HOVER_PATTERN.matcher(processedMessage);
                        if (hoverMatcher.find()) {
                            String cmd = hoverMatcher.group(1).trim();
                            String hoverText = hoverMatcher.group(2).trim();

                            processedMessage = processedMessage.substring(0, hoverMatcher.start()) + processedMessage.substring(hoverMatcher.end());

                            TextComponent message = LegacyComponentSerializer.legacySection().deserialize(processedMessage)
                                    .hoverEvent(HoverEvent.showText(LegacyComponentSerializer.legacySection().deserialize(hoverText)))
                                    .clickEvent(ClickEvent.runCommand(cmd));

                            Bukkit.broadcast(message);
                        } else {
                            TextComponent component = LegacyComponentSerializer.legacySection().deserialize(processedMessage);

                            if (!messageGroup.clickUrl.isEmpty()) {
                                component = component.clickEvent(ClickEvent.openUrl(messageGroup.clickUrl));
                            }

                            Bukkit.broadcast(component);
                        }
                    }
                }

                    try {
                        if (!messageGroup.sound.isEmpty()) {
                            String[] soundParams = messageGroup.sound.split(":");
                            if (soundParams.length == 3) {
                                String soundName = soundParams[0];
                                float volume = Float.parseFloat(soundParams[1]);
                                float pitch = Float.parseFloat(soundParams[2]);

                                for (Player player : Bukkit.getOnlinePlayers()) {
                                    player.playSound(player.getLocation(), soundName, volume, pitch);
                                }
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        Bukkit.getLogger().info("Некорректный тип звука или параметры звука в конфигурации");
                }

                if (Format.valueOf(format) == Format.LIST) {
                    currentIndex = (currentIndex + 1) % allMessages.size();
                }
            }
        };
        task.runTaskTimerAsynchronously(plugin, interval, interval);
    }

    public void stop() {
        if (task != null && !task.isCancelled()) {
            task.cancel();
            task = null;
        }
    }
}
