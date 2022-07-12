package me.mrvaliobg.tempmute.utils;

public final class GeneralUtils {

    private GeneralUtils() {}
  
    public static boolean isInt(String s) {
        try {
            Float.parseFloat(s);
        } catch (Exception ex) {
            return true;
        }
        return false;
    }

}
