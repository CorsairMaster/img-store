package com.qianfengsix.hotel.config;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.


import com.qianfengsix.hotel.utils.FastDfsUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 02
 * 星期五 <-> 下午 3:34
 */
@Configuration
public class FastDfsConfig {
    @Bean
    public FastDfsUtils getFastDfsUtils()throws Exception{
        return new FastDfsUtils("classpath:confads.properties");
    }
}
