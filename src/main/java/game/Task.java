package game;

import jdk.Exported;

import java.util.HashMap;

/**
 * Created by Sander on 28-9-2016.
 */
public class Task {

    private String task;
    private HashMap<User, Integer> hashMap;

    public Task(String task, HashMap<User, Integer> hashMap) {
        this.task = task;
        this.hashMap = hashMap;
    }

    public String getTask() {
        return task;
    }

    public HashMap<User, Integer> getHasMap() {
        return hashMap;
    }

    public void assignTime(User user, Integer time){
        hashMap.put(user, time);
    }
}
