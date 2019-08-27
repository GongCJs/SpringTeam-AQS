package team.spring.aqs.controller;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocketController {
	private static Session session;
	
	/**
	 * 连接建立成功调用的方法*/
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("开启了");
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		System.out.println("关闭了");
	}
	
	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 * @throws IOException */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		sendMessage(message);
		System.out.println("来自客户端的消息:" + message);
	}
	
	public void sendMessage(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }
	
}