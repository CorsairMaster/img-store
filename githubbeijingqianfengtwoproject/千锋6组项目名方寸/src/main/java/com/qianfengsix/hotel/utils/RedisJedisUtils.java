package com.qianfengsix.hotel.utils;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import redis.clients.jedis.Jedis;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 06
 * 星期二 <-> 上午 11:16
 */
public class RedisJedisUtils {
    //    方法
    public static void hSetObject(String key, Object object, Jedis jedis) {
//    根据类  进行反射
        Class<?> aClass = object.getClass();
//        得到所有的属性
        Field[] declaredFields = aClass.getDeclaredFields();
//        遍历属性
        for (Field declaredField : declaredFields) {
//            得到属性名
            String name = declaredField.getName();
//            根据用户名进行反射得到里面的值   参数  属性名称 和 类
            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, aClass);
//                得到 类方法  read方法
                Method readMethod = propertyDescriptor.getReadMethod();
//                得到值 根据对象
                Object invoke = readMethod.invoke(object);
//                  判断值
                if (invoke != null) {
//                    放到缓存中  是  String类型
                    jedis.hset(key, name, invoke.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
