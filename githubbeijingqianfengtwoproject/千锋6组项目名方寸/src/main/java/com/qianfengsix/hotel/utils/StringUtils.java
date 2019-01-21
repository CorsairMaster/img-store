package com.qianfengsix.hotel.utils;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 01
 * 星期四 <-> 上午 10:08
 */
public class StringUtils {
    //    判断是否为空的工具类
    public static boolean IsEmpty(String source){
        return source == null||"".equalsIgnoreCase(source);
    }

    /**
     * 随机生成盐(字符串)
     * length 要生成的字符串的长度
     */
    public static String getRandomString(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        int count = 0;
        while (count <= length - 1) {
            int t = (int) (Math.random() * 123);//抽取的数值小于char类型的“z”（122）
            if ((t >= 48 & t <= 57) | (t >= 65 & t <= 90) | (t >= 97 & t <= 122)) {
                stringBuffer.append((char) t);
                count++;
            }
        }
        return stringBuffer.toString();
    }

    public static String RandomMobileString(int length){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<length;i++) {
            int q = new Random().nextInt(10);
            stringBuffer.append(q);
        }
        return stringBuffer.toString();
    }

//    验证手机号的合法性
public static boolean isMobile(String str) {
    Pattern p = null;
    Matcher m = null;
    boolean b = false;
    p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
    m = p.matcher(str);
    b = m.matches();
    return b;
}

    /**
     * 产生订单号
     * @return
     */
    public static String createOrderId() {
        return UUID.randomUUID().toString().replaceAll("-","").substring(0, 16);
    }
}
