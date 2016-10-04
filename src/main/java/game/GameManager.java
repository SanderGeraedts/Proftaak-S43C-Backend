package game;

import java.util.LinkedList;

/**
 * Created by Sander on 28-9-2016.
 */
public class GameManager {

    private LinkedList tasks;

    public GameManager(LinkedList tasks) {
        this.tasks = tasks;
    }

    public void setTasks(LinkedList tasks) {
        this.tasks = tasks;
    }

    public LinkedList getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
    }
}
