package com.qianfengsix.hotel.user.service;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.qianfengsix.hotel.bean.ResultBean;
import com.qianfengsix.hotel.user.pojo.User;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 2:44
 */
public interface UserService {
    ResultBean Login(String user_mobile, String code);
    void addUser(User user);

    //    实现用户头像的修改.
    void updateUser_img(String user_img);

    //    实现用户昵称的修改
    void updateUser_nickname(String user_nickname);

    //    实现用户手机号的修改
    ResultBean updateUser_mobile(String newUser_mobile,String code);

    //     实现用户身份信息的添加
    void addUser_identify(String user_identify);

}
