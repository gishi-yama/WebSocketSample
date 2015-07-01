package cist.webchat;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class Chat {

	@OnMessage
	public void onMessage(String message, Session onSession) {
		onSession.getOpenSessions()
				.stream()
				.forEach(s -> s.getAsyncRemote().sendText(message));
	}
}
