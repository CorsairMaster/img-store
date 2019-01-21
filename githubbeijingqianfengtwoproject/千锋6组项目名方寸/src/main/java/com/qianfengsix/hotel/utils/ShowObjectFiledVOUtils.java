package com.qianfengsix.hotel.utils;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.qianfengsix.hotel.anno.ShowVOAnno;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 06
 * 星期二 <-> 上午 11:52
 */
/**
 *
 *  显示在页面中的类的属性的值  比如 显示用户名 就在用户名上加个注解  ShowVOAnno
 * */
public class ShowObjectFiledVOUtils {
//    进行处理类的显示属性
    public static Map<String,String> showObjectByShowAnno(Object object){
//        key 是属性  value 是值
        Map<String,String> map = new HashMap<>();
//        得到类
        Class<?> aClass = object.getClass();
//        根据类 得到属性
        Field[] fields = aClass.getDeclaredFields();
//        遍历属性  看是否上面存在 注解
        for (Field field : fields) {
//            进行判断
            ShowVOAnno annotation = field.getAnnotation(ShowVOAnno.class);
            if(annotation!=null){
//                说明存在此 注解  可以显示  根据 属性 得到值
                try {
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),aClass);
//                    得到读取属性的值的方法
                    Method readMethod = propertyDescriptor.getReadMethod();
//                    判断此get 方法
                    if(readMethod!=null){
                        String invoke = (String)readMethod.invoke(object);
//                    放到map中
                        map.put(field.getName(),invoke);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }
}
