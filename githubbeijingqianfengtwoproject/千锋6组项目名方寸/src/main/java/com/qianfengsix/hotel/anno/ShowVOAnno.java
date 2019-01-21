package com.qianfengsix.hotel.anno;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 06
 * 星期二 <-> 上午 11:53
 */
//目标 资源，作用域是属性上
@Target(value = {ElementType.FIELD})
//运行时 执行，不写的话，找不到该注解
@Retention(RetentionPolicy.RUNTIME)
public @interface ShowVOAnno {
//   默认值是 ""
    String value() default "";
}
