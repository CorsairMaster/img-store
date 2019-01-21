package com.qianfengsix.hotel.hotel.pojo;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.


import java.util.List;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 7:12
 */
public class Hotel {
//   酒店 id
    private int hotel_city;

    private Integer hotel_id;
//    酒店名称
//    @NotNull(message = "酒店名称不能为空")
    private String hotel_name;
//    酒店描述

    private String hotel_msg;
//    酒店图片
    private String hotel_img;
//    酒店类型

    private String hotel_type;
//    酒店位置

    private String hotel_local;
//    酒店 标签
    private String hotel_tag;
//    酒店价格

    private String hotel_price;
//    酒店可用房间数
    private String hotel_available_num;

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_msg() {
        return hotel_msg;
    }

    public void setHotel_msg(String hotel_msg) {
        this.hotel_msg = hotel_msg;
    }

    public String getHotel_img() {
        return hotel_img;
    }

    public void setHotel_img(String hotel_img) {
        this.hotel_img = hotel_img;
    }

    public String getHotel_type() {
        return hotel_type;
    }

    public void setHotel_type(String hotel_type) {
        this.hotel_type = hotel_type;
    }

    public String getHotel_local() {
        return hotel_local;
    }

    public void setHotel_local(String hotel_local) {
        this.hotel_local = hotel_local;
    }

    public String getHotel_tag() {
        return hotel_tag;
    }

    public void setHotel_tag(String hotel_tag) {
        this.hotel_tag = hotel_tag;
    }

    public String getHotel_price() {
        return hotel_price;
    }

    public void setHotel_price(String hotel_price) {
        this.hotel_price = hotel_price;
    }

    public String getHotel_available_num() {
        return hotel_available_num;
    }

    public void setHotel_available_num(String hotel_available_num) {
        this.hotel_available_num = hotel_available_num;
    }


    public void setHotel_city(int hotel_city) {
        this.hotel_city = hotel_city;
    }

    public int getHotel_city() {
        return hotel_city;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_city=" + hotel_city +
                ", hotel_id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_msg='" + hotel_msg + '\'' +
                ", hotel_img='" + hotel_img + '\'' +
                ", hotel_type='" + hotel_type + '\'' +
                ", hotel_local='" + hotel_local + '\'' +
                ", hotel_tag='" + hotel_tag + '\'' +
                ", hotel_price='" + hotel_price + '\'' +
                ", hotel_available_num='" + hotel_available_num + '\'' +
                '}';
    }
}
