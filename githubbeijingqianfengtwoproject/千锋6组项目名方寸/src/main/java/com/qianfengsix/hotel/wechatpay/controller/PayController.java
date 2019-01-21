package com.qianfengsix.hotel.wechatpay.controller;/**
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfengsix.hotel.order.pojo.Order;
import com.qianfengsix.hotel.order.service.OrderService;
import com.qianfengsix.hotel.websocket.WSHandler;
import com.qianfengsix.hotel.websocket.WebSocketConfig;
import com.qianfengsix.hotel.wechatpay.utils.PayCommonUtil;
import com.qianfengsix.hotel.wechatpay.utils.PayConfigUtil;
import com.qianfengsix.hotel.wechatpay.utils.XmlUtil;
import com.qianfengsix.hotel.wechatpay.utils.ZxingUtil;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

/**
 * Created by Shane Lau on 2018/11/06.
 */
@Controller
@RequestMapping("/")
public class PayController {
    @Autowired
    private OrderService service;
    @RequestMapping("/pay")
    public void pay(HttpServletResponse response,HttpServletRequest request) throws Exception {
        Order order= (Order) request.getAttribute("order");
        String price=String.valueOf((int)(order.getOrder_price()*100));
        String body=String.valueOf(order.getOrder_itemid());
        String orderid=order.getOrder_id();
        System.out.println(orderid);
        System.out.println(price);
        System.out.println(body);
        String url = PayCommonUtil.weixin_pay(price, body, orderid);
        BufferedImage image = ZxingUtil.createImage(url, 200, 200);
       //ImageIO.write(image,"jpg",response.getOutputStream());
        request.setAttribute("orderid",orderid);
        request.setAttribute("body",body);
        request.getSession().setAttribute("QR",image);
        System.out.println(orderid);
        System.out.println(url);
        request.getRequestDispatcher("pagepay.jsp").forward(request,response);
    }
    @RequestMapping("/getQR")
    public void getQR(HttpServletRequest request,HttpServletResponse response){
        BufferedImage image= (BufferedImage) request.getSession().getAttribute("QR");
        if (image!=null){
            try {
                ImageIO.write(image,"jpg",response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("/getpayinfo")
    public void getPayInfo(HttpServletResponse response, HttpServletRequest request) throws IOException, JDOMException {

//读取参数
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s ;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        while ((s = in.readLine()) != null){
            sb.append(s);
        }
        in.close();
        inputStream.close();
//解析xml成map
        Map<String, String> m = new HashMap<String, String>();
        m = XmlUtil.doXMLParse(sb.toString());
//过滤空 设置 TreeMap
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = m.get(parameter);
            String v = "";
            if(null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }
// 账号信息
        String key = PayConfigUtil.API_KEY; // key
      //  System.err.println(packageParams);
        String out_trade_no = (String)packageParams.get("out_trade_no");//订单号,实
       // 际开发中应该在下⾯的 IF 中,除⾮需要对每个订单的每次⽀付结果做记录
//判断签名是否正确
        if(PayCommonUtil.isTenpaySign("UTF-8", packageParams,key)) {
//------------------------------
//处理业务开始
//------------------------------
            String resXml = "";
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
// 这⾥是⽀付成功
//////////执⾏⾃⼰的业务逻辑////////////////
                String mch_id = (String)packageParams.get("mch_id");
                String openid = (String)packageParams.get("openid");
                String is_subscribe = (String)packageParams.get("is_subscribe");
// String out_trade_no = (String)packageParams.get("out_trade_no");
                String total_fee = (String)packageParams.get("total_fee");
//                System.err.println("mch_id:"+mch_id);
//                System.err.println("openid:"+openid);
//                System.err.println("is_subscribe:"+is_subscribe);
                //System.err.println("out_trade_no:"+out_trade_no);
//                System.err.println("total_fee:"+total_fee);
                String content="{\""+ WebSocketConfig.ATTRIBUTE_NAME+"\":\""+out_trade_no+"\",\"status\":\"success\"}";
               // System.err.println(content);
                service.updateOrderStatus(out_trade_no);
                WSHandler.sendMessage(out_trade_no,new TextMessage(content));
//////////执⾏⾃⼰的业务逻辑////////////////
                System.err.println("⽀付成功");

//通知微信.异步确认成功.必写.不然会⼀直通知后台.⼋次之后就认为交易失败
                //了.
                        resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            } else {

                System.err.println("订单"+out_trade_no+"⽀付失败,错误信息： " +
                        packageParams.get("err_code"));
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[报⽂为空]]></return_msg>" + "</xml>";
            }
//------------------------------
//处理业务完毕
//------------------------------
            BufferedOutputStream out = new BufferedOutputStream(
                    response.getOutputStream());

            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } else{

            System.err.println("通知签名验证失败");
        }

    }
    @RequestMapping("/result")
    public void handleResult(String data,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        ObjectMapper mapper=new ObjectMapper();
        Map map = mapper.readValue(data, Map.class);
        String orderid = (String) map.get(WebSocketConfig.ATTRIBUTE_NAME);
        request.setAttribute("orderid",orderid);
        request.getRequestDispatcher("paysuccess.jsp").forward(request,response);
    }
}

