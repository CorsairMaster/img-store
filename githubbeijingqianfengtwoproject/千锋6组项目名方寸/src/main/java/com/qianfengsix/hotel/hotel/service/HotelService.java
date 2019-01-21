package com.qianfengsix.hotel.hotel.service;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.qianfengsix.hotel.bean.ResultBean;
import com.qianfengsix.hotel.hotel.pojo.Hotel;

import java.util.List;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 7:21
 */
public interface HotelService {
    void addHotel(Hotel hotel);

    List<Hotel> findHotel(Hotel hotel,int pagenum,int pagesize);

    List<Hotel> findHotelByType(String s);

    ResultBean getAllHotel(Integer pageSize, Integer pageNum);
}
