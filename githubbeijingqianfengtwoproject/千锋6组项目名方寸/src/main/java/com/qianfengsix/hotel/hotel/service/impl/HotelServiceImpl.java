package com.qianfengsix.hotel.hotel.service.impl;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfengsix.hotel.bean.ResultBean;
import com.qianfengsix.hotel.hotel.pojo.Hotel;
import com.qianfengsix.hotel.hotel.service.HotelService;
import com.qianfengsix.hotel.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 7:37
 */
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelMapper hotelMapper;
    @Override
    public void addHotel(Hotel hotel) {
            hotelMapper.addHotel(hotel);
    }

    @Override
    public List<Hotel> findHotel(Hotel hotel,int pagenum,int pagesize) {
        PageHelper.startPage(pagenum<=0?1:pagenum, pagesize<=0?1:pagesize);
        List<Hotel> list=hotelMapper.findHotel(hotel);
        for (Hotel hotel1 : list) {
            System.out.println(hotel.getHotel_name());
        }
        PageInfo<Hotel> pageInfo=new PageInfo<>(list);
        return list;
    }

    @Override
    public List<Hotel> findHotelByType(String s) {
        return hotelMapper.findHotelByType(s);
    }

    @Override
    public ResultBean getAllHotel(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<Hotel> hotels = hotelMapper.getAllHotel();
        PageInfo<Hotel> pageInfo = new PageInfo<>(hotels);
        return ResultBean.setOk(100,"success" ,hotels);
    }
}
