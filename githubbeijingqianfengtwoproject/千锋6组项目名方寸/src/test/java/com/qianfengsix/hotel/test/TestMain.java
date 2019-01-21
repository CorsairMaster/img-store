package com.qianfengsix.hotel.test;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 06
 * 星期二 <-> 下午 12:05
 */
public class TestMain {
    @Test
    public void test01() {
        Map<String, String> haspMap = new ConcurrentHashMap<String, String>();
        haspMap.put("zhangsan", "lisi");
        Set<Map.Entry<String, String>> entries = haspMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "--" + value);
        }

////        测试封装类
//        User user = new User();
//        user.setUser_mobile("123123");
//        user.setUser_identify("1234565678");
//        user.setUser_img("123123");
//        user.setUser_password("5678");
//        user.setUser_salt("8797");
//        user.setUser_name("26354862348723");
//        Map<String, String> map = ShowObjectFiledVOUtils.showObjectByShowAnno(user);
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + "------->" + entry.getValue() + "=====");
//        }
    }

//    @Test
//    public void test02(){
//        String time = "2018-09-21 12:21:34";
//        Date date = TimeFormatUtils.StrToDate(time);
//        System.out.println(date);
//        String s = TimeFormatUtils.DateToStr(date);
//        System.out.println(s);
//    }


    @Test
    public void test03() throws JsonProcessingException {
        String[] string = new String[3];
        for (int i = 0; i < string.length; i++) {
            string[i] = i + "asd";
        }
        List<Map<String, String>> list = new ArrayList<>();

        for (String s : string) {
            Map<String, String> map = new HashMap<>();
            map.put("values", s);
            list.add(map);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(list);
        System.out.println(s);

    }
}