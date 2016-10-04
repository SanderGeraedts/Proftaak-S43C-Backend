package connection;

import static spark.Spark.*;
import org.eclipse.jetty.websocket.api.*;

import java.util.HashMap;

/**
 * Created by Sander Geraedts on 4-10-16.
 */
public class Server {
    public static ConnectionCreation connections = new ConnectionCreation();
    public static HashMap<String, IWebSocketHandler> handlers = new HashMap<String, IWebSocketHandler>();


    public Server() {
        staticFiles.location("/public");
        webSocket("/general", GeneralWebSocketHandler.class);
        init();
    }

    public static void createConnection() {

        String url = connections.addConnectionURL();

        MonitorClientsHandler handler = new MonitorClientsHandler(url);
        Server.handlers.put(url, handler);

        webSocket(url, MonitorClientsHandler.class);
        init();
    }

    public static IWebSocketHandler getHandler(String url) {
        return handlers.get(url);
    }
}
