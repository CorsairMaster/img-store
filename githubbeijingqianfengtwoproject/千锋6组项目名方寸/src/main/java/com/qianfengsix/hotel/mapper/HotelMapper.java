package com.qianfengsix.hotel.mapper;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.qianfengsix.hotel.hotel.pojo.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 7:40
 */
@Component
public interface HotelMapper {
    void addHotel(Hotel hotel);
    List<Hotel> findHotel(Hotel hotel);
    List<Hotel> findHotelByType(String hotel_type);
    List<Hotel> getAllHotel();
}
