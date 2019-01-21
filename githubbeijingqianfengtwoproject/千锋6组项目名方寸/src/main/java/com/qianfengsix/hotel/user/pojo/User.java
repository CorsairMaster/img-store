package com.qianfengsix.hotel.user.pojo;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.qianfengsix.hotel.anno.ShowVOAnno;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 1:56
 */
public class User {
//    用户id
    private Integer user_id;
//    用户真实姓名
    @ShowVOAnno
    private String user_name;
//    手机号
    @Pattern(regexp="^[1][3,4,5,8][0-9]{9}$",message="手机号格式不对")
    @ShowVOAnno
    private String user_mobile;
//    昵称
    @ShowVOAnno
    private String user_nickname;
//    身份证信息
    @ShowVOAnno
    @Size(min = 18,max = 18,message = "身份格式不对")
    private  String user_identify;
//   密码 盐
    private String user_salt;
//  用户头像
    @ShowVOAnno
    private String user_img;
//    交易密码
    @Size(min = 6,max = 6,message = "密码长度不对")
    private String user_password;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_identify() {
        return user_identify;
    }

    public void setUser_identify(String user_identify) {
        this.user_identify = user_identify;
    }

    public String getUser_salt() {
        return user_salt;
    }

    public void setUser_salt(String user_salt) {
        this.user_salt = user_salt;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

}
