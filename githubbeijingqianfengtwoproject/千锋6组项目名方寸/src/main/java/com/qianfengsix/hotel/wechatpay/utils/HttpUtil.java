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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Shane Lau on 2018/11/06.
 */
public class HttpUtil {
    private final static int CONNECT_TIMEOUT = 5000; // in milliseconds
    private final static String DEFAULT_ENCODING = "UTF-8";
    public static String postData(String urlStr, String data){
        return postData(urlStr, data, null);
    }
    public static String postData(String urlStr, String data, String contentType){
        BufferedReader reader = null;
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(CONNECT_TIMEOUT);
            if(contentType != null)
                conn.setRequestProperty("content-type", contentType);
            OutputStreamWriter writer = new
                    OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);
            if(data == null)
                data = "";
            writer.write(data);
            writer.flush();
            writer.close();
            reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            return sb.toString();
        } catch (IOException e) {
            System.err.println("Error connecting to " + urlStr + ": " +
                    e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
            }
        }
        return null;
    }
}
