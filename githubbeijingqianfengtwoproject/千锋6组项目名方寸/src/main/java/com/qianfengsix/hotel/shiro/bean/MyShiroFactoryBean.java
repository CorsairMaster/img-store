package com.qianfengsix.hotel.shiro.bean;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 5:12
 */
public class MyShiroFactoryBean extends ShiroFilterFactoryBean {
    @PostConstruct
    public void init(){
        setLoginUrl("/login.html");
        Map<String, String> perms = new LinkedHashMap<>();
        setUnauthorizedUrl("/error.html");
        perms.put("/**","anon" );
        setFilterChainDefinitionMap(perms);//设置权限

        //        设置登录
//        setLoginUrl("/login.html");
//        Map<String, String> perms = new LinkedHashMap<>();
//        setUnauthorizedUrl("/error.html");
//        perms.put("/user/login", "anon");
//        perms.put("/index.html", "anon");
//        List<Map<String, String>> allPerms = permsMapper.getAllPerms();
//        if(allPerms!=null){
//            for (Map<String, String> entry : allPerms) {
//                perms.put(entry.get("permsvalue"), "perms["+entry.get("permsvalue")+"]");
//            }
//        }
////        perms.put("/**","authc" );
//        perms.put("/msg/savemsg", "anon");
    }
}
