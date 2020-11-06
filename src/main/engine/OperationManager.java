package main.engine;

import java.util.LinkedList;

public class OperationManager {
//    private Task task;
//    private Project project;

    private LinkedList<Task> tasks;
    private LinkedList<Project> projects;

    public OperationManager(){

        tasks = new LinkedList<>();
        projects = new LinkedList<>();
    }

    public Task getTask(int id){

        Task t = null;
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getId() == id){
                t = tasks.get(i);
            }
            else{
                throw new IllegalArgumentException("There is no this task!");
            }
        }
        return t;
    }

    public Project getProject(int id){

        Project p = null;
        for (int i = 0; i < projects.size(); i++){
            if (projects.get(i).getId() == id){
                p = projects.get(i);
            }
            else{
                throw new IllegalArgumentException("There is no this task!");
            }
        }
        return p;
    }

    public void addTask(Task t){
        tasks.add(t);
    }
    public void addTask(String name, int id, String due_date){

        Task task = new Task(name, id, due_date);
        tasks.add(task);
    }

    public void addProject(Project p){
        projects.add(p);
    }

    public void addProject(String name, int id, String due_date){

        Project project = new Project(name, id, due_date);
        projects.add(project);
    }

    public void taskStatus(int id){

        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getId() == id){
                tasks.get(i).setStatus(true);
            }
            else{
                throw new IllegalArgumentException("There is no this task!");
            }
        }
    }

    public void projectStatus(int id){

        for (int i = 0; i < projects.size(); i++){
            if (projects.get(i).getId() == id){
                projects.get(i).setStatus(true);
            }
            else{
                throw new IllegalArgumentException("There is no this project!");
            }
        }
    }

    public void addTaskToProject(Task task, int idProject){

        for (int i = 0; i < projects.size(); i++){
            if (projects.get(i).getId() == idProject){
                projects.get(i).addTask(task);
            }
            else{
                throw new IllegalArgumentException("There is no this project!");
            }
        }
    }

    public void deleteTaskFromProject(int idTask, int idProject){

        for (int i = 0; i < projects.size(); i++){
            if (projects.get(i).getId() == idProject){

                for (int j = 0; j < projects.get(i).getProject().size(); j++){

                    if (projects.get(i).getProject().get(j).getId() == idTask){
                        projects.get(i).getProject().remove(j);
                    }
                    else {
                        throw new IllegalArgumentException("There is no this task!");
                    }
                }
            }
            else{
                throw new IllegalArgumentException("There is no this project!");
            }
        }

    }
}
