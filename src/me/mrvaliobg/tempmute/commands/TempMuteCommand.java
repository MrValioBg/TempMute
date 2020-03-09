package me.mrvaliobg.tempmute.commands;

import me.mrvaliobg.tempmute.utils.DatesUtils;
import me.mrvaliobg.tempmute.utils.MessageUtils;
import me.mrvaliobg.tempmute.utils.MuteUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class TempMuteCommand implements CommandExecutor {

    //Checks if it is int
    private boolean isInt(String s) {
        try {
            Float.parseFloat(s);
        } catch (Exception ex) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if ((sender instanceof ConsoleCommandSender) || !sender.isOp()) return true;
        if (args.length != 3 || isInt(args[1])) {
            MessageUtils.sendHelpMessage(sender);
            return true;
        }
        String ars = args[0].trim();
        if (ars.equals("d") || ars.equals("h") || ars.equals("m")) {
            MessageUtils.sendHelpMessage(sender);
            return true;
        }
        if (Bukkit.getPlayer(args[0]) == null) return true;
        Player p = Bukkit.getPlayer(args[0]);
        MuteUtils.mutePlayer(p, DatesUtils.getMuteEndDate(Integer.parseInt(args[1]), args[2]), sender);
        return true;
    }
}