package main.engine;

import java.util.LinkedList;

/**
 * This class is a main class, which contains all the operations that can be performed in the class.
 * If other classes need to use the methods of other classes, they can be implemented directly by using this class.
 * @author Ziming Wang
 * @version 1.0
 */
public class Todo {

    // Instance Variables
    private Task task;
    private Project project;
    private OperationManager operationManager;
    private LinkedList<Task> tasks;
    private LinkedList<Project> projects;
    private static Todo UniqueInstance = new Todo();

    // Constructor
    public Todo(){
        tasks = new LinkedList<>();
        projects = new LinkedList<>();
        operationManager = new OperationManager();
    }
    // Singleton
    public static Todo getInstance(){
        return UniqueInstance;
    }

    /**
     *  Find the task with the same id as the input from the task set, and return it.
     * @param id The id of the task to find.
     * @return A task to be found.
     * @throws IllegalArgumentException on input error
     */
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

    /**
     *  Find the project with the same id as the input from the project set, and return it.
     * @param id The id of the project to find.
     * @return A project to be found.
     * @throws IllegalArgumentException on input error
     */
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

    /**
     *  This method can add a task to tasks.
     * @param t t is a task that has been created.
     */
    public void addTask(Task t){
        tasks.add(t);
    }

    /**
     *  This method will create a task based on the input name, id and due date and add it to tasks.
     * @param name The name of the task.
     * @param id The id of the task.
     * @param due_date The due date of the task.
     */
    public void addTask(String name, int id, String due_date){

        Task task = new Task(name, id, due_date);
        tasks.add(task);
    }

    /**
     *  This method can add an already created project to the projects.
     * @param p p is a project that has been created.
     */
    public void addProject(Project p){
        projects.add(p);
    }

    /**
     * This method creates a project based on the input name, id and due date, and adds the project to the projects.
     * @param name The name of the project.
     * @param id The id of the project.
     * @param due_date The due date of the project.
     */
    public void addProject(String name, int id, String due_date){

        Project project = new Project(name, id, due_date);
        projects.add(project);
    }

    /**
     *  This method can find the task according to the id and change the status of this task to true.
     * @param id The id of the task whose status is to be changed.
     * @throws IllegalArgumentException on input error
     */
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

    /**
     *  This method can find the project according to the id and change the status of this task to true.
     * @param id The id of the project whose status is to be changed.
     * @throws IllegalArgumentException on input error
     */
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

    /**
     *  This method can insert a task into the specified project.
     * @param task Task to be added into project.
     * @param idProject The id of the project.
     * @throws IllegalArgumentException on input error
     */
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

    /**
     *  This method can delete the task with the specified id from the specified project.
     * @param idTask The id of the task to be deleted.
     * @param idProject The id of the project where this task is located.
     * @throws IllegalArgumentException on input error
     */
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
