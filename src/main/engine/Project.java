package main.engine;

import java.util.LinkedList;

public class Project {
    private String name;
    private int id;
    private boolean status;
    private String due_date;
    private LinkedList<Task> project;

    // 构造函数
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


    public void addTask(Task t){
        project.add(t);
    }

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

    public void changeStatus(){
        status = true;
    }
}
