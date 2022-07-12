package me.mrvaliobg.tempmute.utils;

public final class GeneralUtils {

    private GeneralUtils() {}
  
    private boolean isInt(String s) {
        try {
            Float.parseFloat(s);
        } catch (Exception ex) {
            return true;
        }
        return false;
    }

}
