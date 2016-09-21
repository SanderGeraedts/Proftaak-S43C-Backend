package connection;

import org.eclipse.jetty.websocket.api.Session;

/**
 * Created by Sander Geraedts on 21-9-16.
 */
public class MonitorClientsHandler implements IWebSocketHandler {

    private Monitor monitor;

    public void onClose(Session session, int statusCode, String reason) {

    }

    public void onConnect(Session session) throws Exception {

    }

    public void onMessage(Session session, Object message) {

    }

    public void broadCastObject(Object object) {

    }
}
