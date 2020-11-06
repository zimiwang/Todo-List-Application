package main.engine;

import java.util.LinkedList;

public class Task {
    // instance 变量
    private String name;
    private int id;
    private boolean status;
    private String due_date;

    // 构造函数
    public Task(String name, int id, String due_date) {
        this.name = name;
        this.id = id;
        this.due_date = due_date;
        status = false;
    }
    //----------getter-----------
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

    // ----------setter---------
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


    public void changeStatus(){
        status = true;
    }

}
