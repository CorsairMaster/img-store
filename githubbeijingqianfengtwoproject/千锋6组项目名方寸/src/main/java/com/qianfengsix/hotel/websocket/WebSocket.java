//package com.qianfengsix.hotel.websocket;/**
//*                                                                      : ,
//*                                  +7?==?O$~                           :7?,, :~=,
//*                                +Z~       +Z~,                        :I+IIO+++
//*                              ,7=,          7:,                       :?:~Z8=
//*                              :I,            7,                       +?~IZ,
//*                             ,I:   ?     ?    ?                  ,~+Z+ :~+
//*                              $,              I,             ,:~77~, ,I7=
//*                             :Z                ?:   :~~+?Z$7I+: ,,,~7+
//*                              $,                7Z7I+::         :?$+,
//*                             ,?+                           ,+7I=
//*                              ,7:                   ,:,=N?~,
//*                             :7$,                   IZI$?
//*                           ?$+: ,                    ++
//*                         ~$ ,                        ,:I~
//*    ,                   7=                              :I$~
//*   ,O+               =I7$7, , ,     ,                      ,77:,
//*   ,I7,            =$?, ,,O~  ~+O$#4=                        :=7~
//*~II$:+$= ,,,:++?I7?,     :I:OZ+, :~7I,,,                    ,:??7+ ,
//*+D77$$?+I?~,,,      ,,:+O$ ,        :+I=:,,               =8I~ ,,,Z+
//*     =Z7=+++++==+7TMO~                  ~$+,            :?=,,,,,,,,:?,
//*                                           :O?,      :, ?:, ,,,,,,,,,$:
//*                                             ,+I:,    ,?+,, ,,,,,,,,,,7=
//*                                                :I77~ :Z, ,,,,,,,,,,,,,,?=
//*                                                  ,,I= I,,,,,,,,,,,,,,,,,?+
//*                                                     :~,                 :=
//*                     哪错了？             错哪了？              我是谁？
//*/
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * Created by Shane Lau on 2018/11/07.
// */
//@ServerEndpoint("/websocket/{name}")
//public class WebSocket {
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Session getSession() {
//        return session;
//    }
//
//    public void setSession(Session session) {
//        this.session = session;
//    }
//
//    private Session session;
//    private static Map<String ,WebSocket> clientMap=new ConcurrentHashMap<>();
//    @OnOpen
//    public void onOpen(@PathParam("name") String name,Session session){
//        this.name=name;
//        this.session=session;
//        clientMap.put(name,this);
//    }
//    @OnMessage
//    public void onMessage(Session session,String message) throws IOException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        Map messageMap = objectMapper.readValue(message, Map.class);
//        String to= (String) messageMap.get("toUser");
//        String toMessage= (String) messageMap.get("toMessage");
//        WebSocket toSocket = clientMap.get(to);
//        if (toSocket!=null){
//            Session toSession = toSocket.getSession();
//            if (toSession.isOpen()){
//                toSession.getAsyncRemote().sendText(toMessage);
//            }
//        }else {
//            session.getAsyncRemote().sendText("对方不在线");
//        }
//
//    }
//    @OnError
//    public void onError(Session session,Throwable throwable){
//
//    }
//    @OnClose
//    public void onClose(Session session){
//
//    }
//}
