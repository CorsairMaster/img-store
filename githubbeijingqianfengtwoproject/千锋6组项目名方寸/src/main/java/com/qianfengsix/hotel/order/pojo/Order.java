package com.qianfengsix.hotel.order.pojo;/**
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

import com.qianfengsix.hotel.user.pojo.User;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Shane Lau on 2018/11/06.
 */
public class Order {
    private int order_userid;
    private String order_id;
    @NotNull
    private int order_itemid;
    @NotNull
    private int order_itemType;

    public int getOrder_userid() {
        return order_userid;
    }



    public int getOrder_itemid() {
        return order_itemid;
    }

    public int getOrder_itemType() {
        return order_itemType;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public double getOrder_price() {
        return order_price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public int getOrder_status() {
        return order_status;
    }

    @NotNull

    private int order_quantity;
    private double order_price;
    private Date order_date;
    private int order_status;

    public void setOrder_userid(int order_userid) {
        this.order_userid = order_userid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setOrder_itemid(int order_itemid) {
        this.order_itemid = order_itemid;
    }

    public void setOrder_itemType(int order_itemType) {
        this.order_itemType = order_itemType;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }


}
