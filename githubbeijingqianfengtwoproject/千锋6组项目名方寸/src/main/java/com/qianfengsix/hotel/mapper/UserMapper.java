package com.qianfengsix.hotel.mapper;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.qianfengsix.hotel.user.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 2:48
 */
public interface UserMapper {
    void addUser(User user);
    User findUserByUserMobile(String user_mobile);

//    向数据库中存储上传头像的地址.
    void updateUser_img(@Param("user_img") String user_img,@Param("user_mobile") String user_mobile);

//    修改昵称
    void updateUser_nickname(@Param("user_nickname") String user_nickname,@Param("user_mobile") String user_mobile);

//    修改绑定数据的手机号,登陆用户id作为条件
    void updateUser_mobile(@Param("user_mobile") String user_mobile,@Param("user_id") int user_id);

//    实现身份信息的添加
    void addUser_identify(@Param("user_identify") String user_identify,@Param("user_mobile") String user_mobile);
}
