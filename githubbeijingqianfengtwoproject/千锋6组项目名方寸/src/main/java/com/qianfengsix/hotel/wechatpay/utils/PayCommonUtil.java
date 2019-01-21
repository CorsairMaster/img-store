package com.qianfengsix.hotel.wechatpay.utils;/**
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

import ch.qos.logback.core.joran.spi.XMLUtil;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Shane Lau on 2018/11/06.
 */
public class PayCommonUtil {
    /**
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     * @return boolean
     */public static boolean isTenpaySign(String characterEncoding, SortedMap<Object,
            Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if(!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + API_KEY);
//算出摘要
        String mysign = Md5Util.MD5Encode(sb.toString(),
                characterEncoding).toLowerCase();
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();
//System.out.println(tenpaySign + " " + mysign);
        return tenpaySign.equals(mysign);
    }
    /**
     * @author
     * @date 2016-4-22
     * @Description： sign签名
     * @param characterEncoding
     * 编码格式
     * 请求参数
     * @return
     */
    public static String createSign(String characterEncoding, SortedMap<Object,
            Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) &&
                    !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + API_KEY);String sign = Md5Util.MD5Encode(sb.toString(),
                characterEncoding).toUpperCase();
        return sign;
    }
    /**
     * @author
     * @date 2016-4-22
     * @Description：将请求参数转换为xml格式的string
     * @param parameters
     * 请求参数
     * @return
     */
    public static String getRequestXml(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) ||
                    "sign".equalsIgnoreCase(k)) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }
    /**
     * 取出⼀个指定⻓度⼤⼩的随机正整数.
     *
     * @param length
     * int 设定所取出随机数的⻓度。 length⼩于11
     * @return int 返回⽣成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }return (int) ((random * num));
    }
    /**
     * 获取当前时间 yyyyMMddHHmmss
     *
     * @return String
     */
    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }
    /**
     * 统⼀下单,获取⼆维码字符串
     * @param order_price 价格
     * @param body 商品描述
     * @param out_trade_no 订单号
     * @return
     * @throws Exception
     */
    public static String weixin_pay( String order_price,String body,String
            out_trade_no) throws Exception {
// 账号信息
        String appid = PayConfigUtil.APP_ID; // appid
//String appsecret = PayConfigUtil.APP_SECRET; // appsecret
        String mch_id = PayConfigUtil.MCH_ID; // 商业号
        String key = PayConfigUtil.API_KEY; // key
        String currTime = PayCommonUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayCommonUtil.buildRandom(4) + "";
        String nonce_str = strTime + strRandom;
/* String order_price = "1"; // 价格 注意：价格的单位是分
String body = "goodssssss"; // 商品名称
String out_trade_no = "11111338"; // 订单号*/
// 获取发起电脑 ip
        String spbill_create_ip = PayConfigUtil.CREATE_IP;
// 回调接⼝
        String notify_url = PayConfigUtil.NOTIFY_URL;
        String trade_type = "NATIVE";
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", mch_id);
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", body);
        packageParams.put("out_trade_no", out_trade_no);
        packageParams.put("total_fee", order_price);
        packageParams.put("spbill_create_ip", spbill_create_ip);
        packageParams.put("notify_url", notify_url);
        packageParams.put("trade_type", trade_type);
        String sign = PayCommonUtil.createSign("UTF-8", packageParams,key);
        packageParams.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(packageParams);
        System.out.println(requestXML);
        String resXml = HttpUtil.postData(PayConfigUtil.UFDOOER_URL, requestXML);
        System.out.println("res:"+resXml);
        Map map = XmlUtil.doXMLParse(resXml);
//String return_code = (String) map.get("return_code");
//String prepay_id = (String) map.get("prepay_id");
        String urlCode = (String) map.get("code_url");
        return urlCode;
    }
}
