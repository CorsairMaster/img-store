package com.qianfengsix.hotel.order.service;

import com.qianfengsix.hotel.order.pojo.Order;

import java.util.ArrayList;

/**
 * Created by Shane Lau on 2018/11/12.
 */
public interface OrderService {
    public void addOrder(Order order);

    ArrayList<Order> getOrderByUserid(Integer user_id);

    Order getOrderByOrderid(String orderid);

    void updateOrderStatus(String out_trade_no);
}
