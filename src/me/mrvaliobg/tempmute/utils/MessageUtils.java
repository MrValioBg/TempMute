package me.mrvaliobg.tempmute.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class MessageUtils {

    private MessageUtils() {

    }

    public static void sendHelpMessage(CommandSender sender) {
        sender.sendMessage(colorize("&cPlease, use /tempmute <player> <time> <format [d,h,m]> to mute and /unmute <player> to unmute!"));
    }

    static void announce(String text) {
        Bukkit.broadcastMessage(colorize(text));
    }

    static String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
