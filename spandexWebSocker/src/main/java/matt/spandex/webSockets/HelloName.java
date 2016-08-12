package matt.spandex.webSockets;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/helloName")
public class HelloName {

	@OnMessage
	public String sayHello(final String name){
		System.out.println("Say hello to " + name);
		return "Hello "+ name;
	}
	
	@OnOpen
	public void helloOnOpen(final Session session) {
		System.out.println("Web Socket opened" + session.getId());
	}
	
	@OnClose
	public void helloOnClose(final CloseReason reason){
		System.out.println("Closing a WebSocker due to " + reason.getReasonPhrase());
	}
}
