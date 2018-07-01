package br.com.WebSocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Singleton;
import javax.websocket.Session;


public class Sessions {
	
		private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
		
		private Sessions() { }
		
		public static Set<Session> getSessions() {
			return sessions;
		}
	

}
