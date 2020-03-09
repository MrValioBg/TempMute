package me.mrvaliobg.tempmute.utils;

import java.util.Date;

public class DatesUtils {

    private DatesUtils() {

    }
   //Adds the mute time to the current date.
    public static Date getMuteEndDate(int time, String format) {
        int multiplier = 1;
        if (format.equals("d")) {
            multiplier = 1440;
        }
        if (format.equals("h")) {
            multiplier = 60;
        }
        Date targetTime = new Date();
        targetTime = org.apache.commons.lang.time.DateUtils.addMinutes(targetTime, time * multiplier);
        return targetTime;
    }

}
