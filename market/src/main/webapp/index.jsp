<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>Insert title here</title>  
</head>  
<script type="text/javascript">  
    var ws = null;
    function log(text) {
       document.getElementById("log").innerHTML = (new Date).getTime() + ": " + text +"<br>"+  document.getElementById("log").innerHTML;
    }  
    function startServer() {  
        var url = document.getElementById("serverip").value;// "ws://192.168.0.102:8887";  
        if ('WebSocket' in window) {  
            ws = new WebSocket(url);  
        } else if ('MozWebSocket' in window) {  
            ws = new MozWebSocket(url);  
        } else {  
            alert('浏览器不支持');  
            return;
        }  
        ws.onopen = function() {  
            alert('Opened!');  
        };  
        // 收到服务器发送的文本消息, event.data表示文本内容  
        ws.onmessage = function(event) {  
            //alert('Receive message: ' + event.data); 
            log('Receive message: ' + event.data); 
        };  
        ws.onclose = function() {  
          alert('Closed!');  
        }  
        document.getElementById("conbtn").disabled="true";
        document.getElementById("stopbtn").removeAttribute('disabled');
	}  
    //发送信息  
    function sendMessage(){  
        var textMessage=document.getElementById("textMessage").value;  
          
        if(ws!=null&&textMessage!=""){  
            ws.send(textMessage);  
              
        }  
    }  
    function stopconn(){
		ws.close();
    	document.getElementById("conbtn").removeAttribute('disabled');
    	document.getElementById("stopbtn").disabled="true";
    }
</script>  
<body onload="">  
		<input id="serverip" type="text"  size="20" value="ws://127.0.0.1:28080/market/websocket/test"/> 
		<input id="conbtn" type="button" onclick="startServer()" value="open" />
		<input id="stopbtn" type="button" onclick="stopconn()" value="stop" disabled="disabled"/>
		</br>
        <input id="textMessage" type="text"  size="20" />  
        <input type="button" onclick="sendMessage()" value="Send">  
        <div id="log"></div>
    </body>  
</html>  
