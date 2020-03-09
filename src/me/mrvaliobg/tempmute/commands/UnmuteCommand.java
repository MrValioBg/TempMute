package me.mrvaliobg.tempmute.commands;

import me.mrvaliobg.tempmute.utils.MessageUtils;
import me.mrvaliobg.tempmute.utils.MuteUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class UnmuteCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if ((sender instanceof ConsoleCommandSender) || !sender.isOp()) return true;
        if (args.length != 1) {
            MessageUtils.sendHelpMessage(sender);
            return true;
        }
        if (Bukkit.getPlayer(args[0]) != null) {
            MuteUtils.unmutePlayerRequest(Bukkit.getPlayer(args[0]), sender);
            return true;
        }
        return false;
    }
}
