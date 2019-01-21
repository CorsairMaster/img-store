package com.qianfengsix.hotel.hotel.controller;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfengsix.hotel.bean.ResultBean;
import com.qianfengsix.hotel.hotel.pojo.Hotel;
import com.qianfengsix.hotel.hotel.service.HotelService;
import com.qianfengsix.hotel.utils.FastDfsUtils;
import com.qianfengsix.hotel.vo.HotelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 7:21
 */
@CrossOrigin
@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private FastDfsUtils fastDfsUtils;
    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/addhotel",method = {RequestMethod.POST})
    public ResultBean addHotel(@Valid HotelVo hotelvo, BindingResult bindingResult) {
//        先进行验证  输入的内容有没有错误
        boolean b = bindingResult.hasErrors();
        if(b){
//            如果有错误的话   遍历错误
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                String defaultMessage = allError.getDefaultMessage();
//                把错误信息返回
                return ResultBean.setError(200,defaultMessage,null);
            }
        }
//      根据图片数量 进行存贮照片
        MultipartFile[] files=hotelvo.getFiles();
        List<Map<String,String>> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            Map<String,String> map = new HashMap<>();
//            得到图片 名称
            String filename = file.getOriginalFilename();
//            得到 后缀名
            String ext_suffix1 = filename.substring(filename.lastIndexOf(".") + 1);
            try {
//                进行上传
                String upload = fastDfsUtils.fileUpload(file.getBytes(), ext_suffix1);
                map.put("files", upload);
//                加到数组中
                list.add(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        写成 json 格式存储到数据库中
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
//            得到 json 字符串
            Hotel hotel = new Hotel();
            json = objectMapper.writeValueAsString(list);
            System.out.println(json+"----->");
//            进行添加酒店
            hotel.setHotel_img(json);
            hotel.setHotel_local(hotelvo.getHotel_local());
            hotel.setHotel_name(hotelvo.getHotel_name());
            hotel.setHotel_msg(hotelvo.getHotel_msg());
            hotel.setHotel_price(hotelvo.getHotel_price());
            hotel.setHotel_type(hotelvo.getHotel_type());
            hotel.setHotel_tag(hotelvo.getHotel_tag()==null?null:hotelvo.getHotel_tag());
            hotel.setHotel_available_num(hotelvo.getHotel_available_num()==null?null:hotelvo.getHotel_available_num());
//        进行添加  Hotel
            hotelService.addHotel(hotel);
            return ResultBean.setOk(100,"success" ,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.setError(200,"fail","网络有问题，请检查您的网络");
        }
    }

//多条件搜索商户
    @RequestMapping("/findhotel")
    public ResultBean findHotel(Hotel hotel,int pagenum,int pagesize){
        try {
            List<Hotel> hotel1=hotelService.findHotel(hotel,pagenum,pagesize);
            return  ResultBean.setOk(100, "success", hotel1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.setError(200, "fail", "查询商户失败！");
        }
    }

    //根据主题类型，查询商户
    @RequestMapping("/findhotelbytype")
    public ResultBean findHotelByType(int type){
        try {
            List<Hotel> list= hotelService.findHotelByType(String.valueOf(type));
            return ResultBean.setOk(100, "success",list );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.setError(200, "fail", "根据主题类型查询商户失败");
        }
    }
    @RequestMapping("/getallhotel")
    public ResultBean getAllHotel(Integer pageSize,Integer pageNum){
        pageSize= pageSize==null?6:pageSize;
        pageNum = pageNum==null?1:pageNum;
      return   hotelService.getAllHotel(pageSize,pageNum);
    }
}
