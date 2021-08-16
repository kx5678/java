package com.inker.common.socket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;


@Component
@ServerEndpoint("/websocket/{userName}")
public class WebSocket {

	 private Session session;
	    
	    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
	    private static Map<String,Session> sessionPool = new HashMap<String,Session>();
	    
	    @OnOpen
	    public void onOpen(Session session, @PathParam(value="userName")String userName) {
	        this.session = session;
	        webSockets.add(this);
	        sessionPool.put(userName, session);
	        for (WebSocket webSocket : webSockets) {
				System.out.println("-----------------set-----"+webSocket.toString());
			}
	        System.out.println("login-username---:"+userName+"-------------now-webSize----:"+webSockets.size());
	    }
	    
	    @OnClose
	    public void onClose() {
	        webSockets.remove(this);
	        System.out.println("websocket----------send----"+webSockets.size());
	    }
	    
	    @OnMessage
	    public void onMessage(String message) {
	        System.out.println("收到客户端消息------------------------------"+message);
	    }
	    
	    // ��Ϊ�㲥��Ϣ
	    public void sendAllMessage(String message) {
	        for(WebSocket webSocket : webSockets) {
	            System.out.println("广播消息--------------------------"+message);
	            try {
	                webSocket.session.getAsyncRemote().sendText(message);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    
	    public void sendOneMessage(String userName, String message) {
	    	 System.out.println("单点消息----------------------"+message);
	    	 System.out.println("send-message-time"+new Date());
	        Session session = sessionPool.get(userName);
	        if (session != null) {
	            try {
	                session.getAsyncRemote().sendText(message);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
}


	
