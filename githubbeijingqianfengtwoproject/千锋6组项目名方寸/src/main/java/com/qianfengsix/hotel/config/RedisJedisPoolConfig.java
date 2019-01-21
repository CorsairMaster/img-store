package com.qianfengsix.hotel.config;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 02
 * 星期五 <-> 上午 10:34
 */
@Configuration
public class RedisJedisPoolConfig {
    @Value(("${spring.redis.host}"))
    private String host;
    @Value(("${spring.redis.port}"))
    private int port;
    @Value(("${spring.redis.password}"))
    private String password;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxIdle(100);
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host ,port ,5000 ,password);
        return jedisPool;
    }
}
