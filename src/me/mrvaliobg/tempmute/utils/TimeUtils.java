package me.mrvaliobg.tempmute.utils;

import java.util.concurrent.TimeUnit;

class TimeUtils {

    private TimeUtils() {
        //do no remove me
    }

    //Displays the time between 2 dates in cool format
    static String calculateTime(Long timeIn) {
        int day = (int) TimeUnit.MILLISECONDS.toDays(timeIn);
        long hours = TimeUnit.MILLISECONDS.toHours(timeIn) - (day * 24);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeIn) - (TimeUnit.MILLISECONDS.toHours(timeIn) * 60);

        String time = hours + "h" + minutes + "m";
        String time1 = day + "d" + hours + "h" + minutes + "m";

        if ((day != 0)) {
            return time1;
        }
        return time;

    }

}
