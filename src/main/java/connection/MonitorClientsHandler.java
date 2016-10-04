package connection;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;

/**
 * Created by Sander Geraedts on 21-9-16.
 */
public class MonitorClientsHandler implements IWebSocketHandler {

    private String url;
    private Monitor monitor;

    public MonitorClientsHandler(String url) {
        this.url = url;
        this.monitor = new Monitor();
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {

    }

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {

    }

    @OnWebSocketMessage
    public void onMessage(Session session, Object message) {

    }

    public void broadCastObject(Object object) {

    }


}
