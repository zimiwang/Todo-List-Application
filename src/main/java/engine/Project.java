package engine;

import java.util.LinkedList;


/**
 * This class can create a project based on name, id and due date. This project can also be a linked list which can save other tasks.
 * @author Ziming Wang
 * @version 1.0
 */
public class Project {

    // Instance variables
    private String name;
    private int id;
    private boolean status;
    private String due_date;
    private LinkedList<Task> project;

    // Constructor
    public Project(String name, int id, String due_date) {
        this.name = name;
        this.due_date = due_date;
        this.id = id;
        status = false;
        project = new LinkedList<>();
    }

    //-------------getter--------------
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getDue_date(){
        return due_date;
    }
    public boolean getStatus(){
        return status;
    }
    public LinkedList<Task> getProject(){
        return project;
    }

    //---------------setter--------------
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public void setDue_date(String due_date){
        this.due_date = due_date;
    }

    /**
     *  Add a task to the project.
     * @param t t is a task that has been created, it has all the contents of a task。
     */
    public void addTask(Task t){
        project.add(t);
    }

    /**
     * According to the id of the task, it can be accurately found from the project and removed from it.
     * @param id The id of the task to be removed.
     * @throws IllegalArgumentException on input error
     */
    public void removeTask(int id){

        for (int i = 0; i < project.size(); i++){
            if (project.get(i).getId() == id){
                project.remove(i);
            }
            else{
                throw new IllegalArgumentException("There is no this task!");
            }
        }

    }

    /**
     * This method is used to change the status of the project to true, which means that the project has been completed.
     */
    public void changeStatus(){
        status = true;
    }
}
