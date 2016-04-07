package com.kindp.market.servlet;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

public class MyWebSocketServlet extends WebSocketServlet{

	private Map<String,MyMessageInbound> connections = new ConcurrentHashMap<String,MyMessageInbound>(); 
	
	@Override
	protected StreamInbound createWebSocketInbound(String arg0,
			HttpServletRequest req) {
		return new MyMessageInbound(req.getSession().getId());
	}
	

		private class MyMessageInbound extends MessageInbound {
			WsOutbound myoutbound;
			private String sessionId ;
			private MyMessageInbound(String sessionId){
				this.sessionId = sessionId;
			}
			
			@Override
			public void onOpen(WsOutbound outbound) {
				try {
					System.out.println("Open Client.");
					this.myoutbound = outbound;
					if(connections.get(sessionId)==null){
						connections.put(sessionId, this);
						outbound.writeTextMessage(CharBuffer.wrap("Hello!"));
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onClose(int status) {
				System.out.println("Close Client.");
				connections.remove(sessionId);
			}

			@Override
			protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
				// TODO Auto-generated method stub

			}

			@Override
			protected void onTextMessage(CharBuffer message) throws IOException {
				// TODO Auto-generated method stub
				System.out.println("onText--->" + message.toString());
				for(String key:connections.keySet()){
					MyMessageInbound mmib = (MyMessageInbound) connections.get(key);
	                CharBuffer buffer = CharBuffer.wrap(message);
	                mmib.myoutbound.writeTextMessage(buffer);
	                mmib.myoutbound.flush();
	            }
				
			}
		}

		public static void main(String[] args) {
			Socket socket;
			String message = "haoning";
			String msg = "";
			try {
				// 向服务器利用Socket发送信息
				socket = new Socket("192.168.0.102", 5000);
				// socket = new Socket("127.0.0.1",5000);
				PrintWriter output = new PrintWriter(socket.getOutputStream());

				output.write(message.toString());
				output.flush();

				// 这里是接收到Server的信息
				DataInputStream input = new DataInputStream(socket.getInputStream());
				byte[] b = new byte[1024];
				input.read(b);
				// Server返回的信息
				msg = new String(b).trim();

				output.close();
				input.close();
				socket.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



