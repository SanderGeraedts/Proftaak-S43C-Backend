package connection;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;

/**
 * Created by sander on 14-9-16.
 */
@WebSocket
public interface IConnectionHandler {

    /**
     * OnWebSocketClose eventhandler. Triggers when the connection closes
     *
     * @param session
     * @param statusCode The statuscode i.e. 401 for Unauthorized use
     * @param reason Human readable reason.
     */
    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason);

    /**
     * OnWebSocketConnect eventhandler. Triggers on connect
     *
     * @param session
     * @throws Exception
     */
    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception;

    /**
     * OnWebsocketMessage eventhandler. Triggers when the client sends a message to the websocket
     *
     * @param session
     * @param message
     */
    @OnWebSocketMessage
    public void onMessage(Session session, Object message);

    public void broadCastObject(Object object);
}
