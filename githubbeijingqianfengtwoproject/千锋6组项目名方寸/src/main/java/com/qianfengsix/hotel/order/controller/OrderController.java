package com.qianfengsix.hotel.order.controller;/**
 * : ,
 * +7?==?O$~                           :7?,, :~=,
 * +Z~       +Z~,                        :I+IIO+++
 * ,7=,          7:,                       :?:~Z8=
 * :I,            7,                       +?~IZ,
 * ,I:   ?     ?    ?                  ,~+Z+ :~+
 * $,              I,             ,:~77~, ,I7=
 * :Z                ?:   :~~+?Z$7I+: ,,,~7+
 * $,                7Z7I+::         :?$+,
 * ,?+                           ,+7I=
 * ,7:                   ,:,=N?~,
 * :7$,                   IZI$?
 * ?$+: ,                    ++
 * ~$ ,                        ,:I~
 * ,                   7=                              :I$~
 * ,O+               =I7$7, , ,     ,                      ,77:,
 * ,I7,            =$?, ,,O~  ~+O$#4=                        :=7~
 * ~II$:+$= ,,,:++?I7?,     :I:OZ+, :~7I,,,                    ,:??7+ ,
 * +D77$$?+I?~,,,      ,,:+O$ ,        :+I=:,,               =8I~ ,,,Z+
 * =Z7=+++++==+7TMO~                  ~$+,            :?=,,,,,,,,:?,
 * :O?,      :, ?:, ,,,,,,,,,$:
 * ,+I:,    ,?+,, ,,,,,,,,,,7=
 * :I77~ :Z, ,,,,,,,,,,,,,,?=
 * ,,I= I,,,,,,,,,,,,,,,,,?+
 * :~,                 :=
 * 哪错了？             错哪了？              我是谁？
 */

import com.qianfengsix.hotel.bean.ResultBean;
import com.qianfengsix.hotel.order.pojo.Order;
import com.qianfengsix.hotel.order.service.OrderService;
import com.qianfengsix.hotel.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Shane Lau on 2018/11/12.
 */
@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @RequestMapping("/addorder")
    public void createOrder(@Valid Order order, BindingResult bindingResult, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println(allError.getDefaultMessage());
            }
            response.sendRedirect("/error.html");
            return;
        }
//        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
//        order.setOrder_userid(user.getUser_id());
        order.setOrder_userid(1);
        order.setOrder_date(new Date());

        order.setOrder_id(StringUtils.getRandomString(16));
        // System.out.println(order);
        service.addOrder(order);
        request.setAttribute("order", order);

        request.getRequestDispatcher("/pay").forward(request, response);
    }

    @RequestMapping("/getorderbyuserid")
    public ResultBean getOrderByUserid() {
       // User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        //Integer user_id = user.getUser_id();
        int user_id=1;
        ArrayList<Order> orders = service.getOrderByUserid(user_id);
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(100);
        resultBean.setMessage("Success");
        resultBean.setData(orders);
        return resultBean;
    }

    @RequestMapping("/getorderbyorderid")
    public ResultBean getOrderByOrderid(String orderid){
        Order order = service.getOrderByOrderid(orderid);
        ResultBean result=null;
        if (order!=null){
            result = ResultBean.setOk(100, "Success", order);
        }else {
            result = ResultBean.setError(null);
        }
        return result;
    }
}
