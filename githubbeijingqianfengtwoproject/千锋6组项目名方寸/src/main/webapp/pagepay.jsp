<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/07
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
    var websocket = null;
    function connect() {
    var username ="${orderid}";
    if ('WebSocket' in window) {
    websocket = new WebSocket("ws://" + document.location.host + "/six/websocket/" + username);
        if (websocket!=null){
            alert(username+"连接成功");
        }

    } else {
    alert("不支持WebSocket");
    }
    websocket.onopen=function () {
    alert("连接成功");
    };
    websocket.onmessage=function (event) {
        alert(event.data);
        var json = JSON.parse(event.data);
        location.href="${pageContext.request.contextPath}/result?data="+encodeURI(event.data);
    };
    websocket.onclose=function () {
    alert("连接关闭")
    };
    websocket.onerror=function () {
    alert("连接出错")
    };
    window.onbeforeunload = function () {
    if(websocket!=null){
    websocket.close();
    }
    }
    }
    window.onload=connect();</script>

</head>
<body>
<img src="${pageContext.request.contextPath}/getQR">
</body>
</html>
