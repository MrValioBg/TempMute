package me.mrvaliobg.tempmute.utils;

import me.mrvaliobg.tempmute.data.DataConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MuteUtils {

    private static final String DATA = "Data.";

    private MuteUtils() {
        // do no remove
    }

    //SimpleDateFormat is not thread safe if it is static itself, so lets make a method
    private static DateFormat getDateTimeFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    //Checks if the player's mute is expired, if not sends message with the time that he needs to wait to speak again
    public static boolean muteCheck(Player p) throws ParseException {
        Date dNow = new Date();
        Date endMuteDate = getDateTimeFormat().parse(DataConfiguration.INSTANCE.getData().getString(DATA + p.getUniqueId().toString()));

        int test = Objects.requireNonNull(endMuteDate).compareTo(dNow);
        if ((test == 0) || (test < 0)) {
            unmutePlayer(p);
            return false;
        }

        long timeIn = endMuteDate.getTime() - dNow.getTime();
        p.sendMessage(MessageUtils.colorize("&cYou are currently muted! Wait " + TimeUtils.calculateTime(timeIn)));
        return true;
    }

    //Checks if the player is muted if he is, the method unmutes the player
    public static void unmutePlayerRequest(Player p, CommandSender sender) {
        String uuid = p.getUniqueId().toString();
        if (DataConfiguration.INSTANCE.getData().contains(DATA + uuid)) {
            unmutePlayer(p);

            MessageUtils.announce("&e " + p.getName() + " was unmuted.");
            return;
        }
        sender.sendMessage(MessageUtils.colorize("&cThat player is not currently muted!"));
    }

  //unmutes the player
    private static void unmutePlayer(Player p) {
        String uuid = p.getUniqueId().toString();
        DataConfiguration.INSTANCE.getData().set(DATA + uuid, null);
    }

   //Temporary Muting the player
    public static void mutePlayer(Player p, Date date, CommandSender sender) {
        String uuid = p.getUniqueId().toString();
        if (!DataConfiguration.INSTANCE.getData().contains(DATA + uuid)) {
            Date dNow = new Date();
            long timeIn = date.getTime() - dNow.getTime();
            DataConfiguration.INSTANCE.getData().set(DATA + uuid, getDateTimeFormat().format(date));
            DataConfiguration.INSTANCE.saveData();

            MessageUtils.announce("&e " + p.getName() + " was muted for " + TimeUtils.calculateTime(timeIn));
            return;
        }
        sender.sendMessage(MessageUtils.colorize("&cThat player is already muted!"));
    }


}
