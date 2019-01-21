package com.qianfengsix.hotel.order.service.impl;
/**
*                                                                      : ,       
*                                  +7?==?O$~                           :7?,, :~=,
*                                +Z~       +Z~,                        :I+IIO+++ 
*                              ,7=,          7:,                       :?:~Z8=   
*                              :I,            7,                       +?~IZ,    
*                             ,I:   ?     ?    ?                  ,~+Z+ :~+      
*                              $,              I,             ,:~77~, ,I7=       
*                             :Z                ?:   :~~+?Z$7I+: ,,,~7+          
*                              $,                7Z7I+::         :?$+,            
*                             ,?+                           ,+7I=                 
*                              ,7:                   ,:,=N?~,                    
*                             :7$,                   IZI$?                       
*                           ?$+: ,                    ++                         
*                         ~$ ,                        ,:I~                       
*    ,                   7=                              :I$~                    
*   ,O+               =I7$7, , ,     ,                      ,77:,                
*   ,I7,            =$?, ,,O~  ~+O$#4=                        :=7~               
*~II$:+$= ,,,:++?I7?,     :I:OZ+, :~7I,,,                    ,:??7+ ,            
*+D77$$?+I?~,,,      ,,:+O$ ,        :+I=:,,               =8I~ ,,,Z+            
*     =Z7=+++++==+7TMO~                  ~$+,            :?=,,,,,,,,:?,          
*                                           :O?,      :, ?:, ,,,,,,,,,$:         
*                                             ,+I:,    ,?+,, ,,,,,,,,,,7=        
*                                                :I77~ :Z, ,,,,,,,,,,,,,,?=       
*                                                  ,,I= I,,,,,,,,,,,,,,,,,?+      
*                                                     :~,                 :=     
*                     哪错了？             错哪了？              我是谁？
*/

import com.qianfengsix.hotel.hotel.pojo.Hotel;
import com.qianfengsix.hotel.order.service.OrderService;
import org.springframework.stereotype.Service;
import com.qianfengsix.hotel.mapper.OrderMapper;
import com.qianfengsix.hotel.order.pojo.Order;
import com.qianfengsix.hotel.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shane Lau on 2018/11/12.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;


    @Override
    public void updateOrderStatus(String out_trade_no) {
        mapper.updateOrderStatus(out_trade_no);
    }

    @Override
    public Order getOrderByOrderid(String orderid) {
        return mapper.getOrderByOrderid(orderid);
    }

    @Override
    public ArrayList<Order> getOrderByUserid(Integer user_id) {
       return mapper.getOrderByUserid(user_id);
    }


    @Override
    public void addOrder(Order order) {
        mapper.addOrder(order);

    }
}
