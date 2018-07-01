package br.com.WebSocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
public class Server {
//	  ListSession userSessions = new ListSession();
	@OnOpen
	public void onOpen(Session userSession) {
		 
		//this.userSessions.add(userSession);
//		userSessions.addSession(userSession);
		Sessions.getSessions().add(userSession);
		
		System.out.println(
				"New session is open : " + userSession.getId() + "\n Total of Sessions : " + Sessions.getSessions().size());
		
		
	}

	@OnClose
	public void onClose(Session userSession) {
		Sessions.getSessions().remove(userSession);
		
		
		System.out.println(
				"Session " + userSession.getId() + "is being closed !\n Total of Sessions : "+ Sessions.getSessions().size());
		//userSessions.remove(userSession);
	}

	@OnMessage
	public void onMessage(Session userSession, String msg) {
		System.out.println("Message recived : " + userSession.getId() + " " + msg);
	
		
		for (Session session : Sessions.getSessions()) {
			if(session.isOpen()) {
			System.out.println("Send to : " + session.getId());
			session.getAsyncRemote().sendText(msg);// assíncrono msg
			}
		}
		
		
	}

}
