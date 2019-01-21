package com.qianfengsix.hotel.utils;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 06
 * 星期二 <-> 下午 2:18
 */
public class TimeFormatUtils {
//   时间 转换成 字符串
     public static String DateToStr(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
//    字符串转换成 时间
    public static Date StrToDate(String time){
       SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return time==null?null:simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
