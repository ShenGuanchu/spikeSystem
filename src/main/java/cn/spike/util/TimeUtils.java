package cn.spike.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeUtils {
    public static String dateToString(Date time){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime = formatter.format(time);
        return ctime;
    }

    public static String dateToString() {
        return dateToString(new Date());
    }
}
