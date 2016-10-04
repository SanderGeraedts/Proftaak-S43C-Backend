package connection;

/**
 * Created by Sander Geraedts on 14-9-16.
 */

/**
 *
 */
class Client {
    private int id;
    private String username;

    public Client(int id) {
        this.id = id;
    }

    public void addUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
