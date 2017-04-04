package matt.spandex.webSockets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/helloName")
public class HelloName {

    private static Map<String, String> sessions = new HashMap<>();
    
	@OnMessage
	public String sayHello(final String name, final Session session){
		System.out.println("Say hello to " + name);
		String additionalData;
		if(sessions.containsKey(session.getId())){
		    if(sessions.get(session.getId()) == null){
		        //First time in
		        sessions.put(session.getId(), name);
		        additionalData = "Hello " + name;
		    } else {
		        additionalData = "Welcome back " + sessions.get(session.getId());
		    }
		} else {
		    additionalData = "You shouldn't be here ";
		}
		return additionalData;
	}
	
	@OnOpen
	public void helloOnOpen(final Session session) {
	    sessions.put(session.getId(), null);
		System.out.println("Web Socket opened" + session.getId());
	}
	
	@OnClose
	public void helloOnClose(final CloseReason reason){
		System.out.println("Closing a WebSocker due to " + reason.getReasonPhrase());
	}
}
