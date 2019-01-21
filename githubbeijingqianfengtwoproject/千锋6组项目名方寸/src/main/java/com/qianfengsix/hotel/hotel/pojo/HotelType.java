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
 * 2018 - 11 - 12
 * 星期一 <-> 下午 3:16
 */
public class HotelType {
    private String htype_id;
    private String htype_name;
    private List<Hotel> hotel;

    public String getHtype_id() {
        return htype_id;
    }

    public void setHtype_id(String htype_id) {
        this.htype_id = htype_id;
    }

    public String getHtype_name() {
        return htype_name;
    }

    public void setHtype_name(String htype_name) {
        this.htype_name = htype_name;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }
}
