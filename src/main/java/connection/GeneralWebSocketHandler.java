package connection;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;

/**
 * Created by Sander Geraedts on 4-10-16.
 */
public class GeneralWebSocketHandler implements IWebSocketHandler {

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {

    }

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        Server.createConnection();
    }

    @OnWebSocketMessage
    public void onMessage(Session session, Object message) {

    }

    public void broadCastObject(Object object) {

    }
}
