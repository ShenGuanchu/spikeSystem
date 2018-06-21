package cn.spike.util;

public class StringUtil {

    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0 && s != "";
    }
}
