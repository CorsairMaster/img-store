package com.qianfengsix.hotel.websocket;/**
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
import org.springframework.web.server.WebFilter;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Shane Lau on 2018/11/07.
 */
public class WSHandler extends TextWebSocketHandler {
    private static Map<String ,WebSocketSession> clientMap;
static {
    clientMap=new ConcurrentHashMap<>();
}
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        ObjectMapper mapper=new ObjectMapper();
//        Map map = mapper.readValue(message.asBytes(), Map.class);
//        String toUser=(String)map.get("toUser");
//        String toMessage=(String) map.get("toMessage");
//        String orderid= (String) session.getAttributes().get(WebSocketConfig.ATTRIBUTE_NAME);
//
//        String content=new String(WebSocketConfig.ATTRIBUTE_NAME+"="+orderid+" toUser="+toUser+" "+toMessage);
//        //System.out.println(content);
//        TextMessage toTextMessage=new TextMessage(content);
//        sendMessage(toUser,toTextMessage);
//    }
    public static void sendMessage(String toUser,TextMessage message) throws IOException {
        WebSocketSession webSocketSession = clientMap.get(toUser);
        if (webSocketSession!=null&&webSocketSession.isOpen()){
            webSocketSession.sendMessage(message);
        }

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String orderid= (String) session.getAttributes().get(WebSocketConfig.ATTRIBUTE_NAME);
      //  System.out.println(orderid==null);
        if (orderid!=null){
            clientMap.put(orderid,session);
          //  System.err.println("Websocket "+orderid+"加入Map");
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }
}
