package connection;

import java.util.HashSet;
import static spark.Spark.*;

/**
 * Created by Sander Geraedts on 21-9-16.
 */
public class Monitor {
    private String url;
    private HashSet<Client> clients;

    public Monitor(String url) {
        this.url = url;
        this.clients = new HashSet<Client>();
    }

    public void setUpConnection() {
        get("/monitor/" + url, (req, res) -> getStaticFiles());
    }

    public void getStaticFiles() {
        staticFiles("/public");
    }
}
