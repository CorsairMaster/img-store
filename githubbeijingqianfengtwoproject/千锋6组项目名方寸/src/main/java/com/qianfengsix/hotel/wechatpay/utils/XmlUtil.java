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

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Shane Lau on 2018/11/06.
 */
public class XmlUtil {
    /**
     * 解析xml,返回第⼀级元素键值对。如果第⼀级元素有⼦节点，则此节点的值是⼦节点的xml数
     据。
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map doXMLParse(String strxml) throws JDOMException, IOException
    {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
        if(null == strxml || "".equals(strxml)) {
            return null;
        }Map m = new HashMap();
        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if(children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = XmlUtil.getChildrenText(children);
            }
            m.put(k, v);
        }
//关闭流
        in.close();
        return m;
    }
    /**
     * 获取⼦结点的xml
     * @param children
     * @return String
     */
    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()) {
            Iterator it = children.iterator();
            while(it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()) {
                    sb.append(XmlUtil.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }
        return sb.toString();
    }
}
