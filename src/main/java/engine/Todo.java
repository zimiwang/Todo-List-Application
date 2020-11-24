package engine;

import io.DataManager;

import java.util.LinkedList;

/**
 * This class is a main class, which contains all the operations that can be performed in the class.
 * If other classes need to use the methods of other classes, they can be implemented directly by using this class.
 * @author Ziming Wang
 * @version 1.0
 */
public class Todo {

    // Instance Variables
    private OperationManager operationManager;
    private static final Todo instance = new Todo();

    private final DataManager dataManager;

    // Constructor
    public Todo(){
        operationManager = new OperationManager();
        dataManager = new DataManager();
    }
    // Singleton
    public static Todo getInstance(){
        return instance;
    }

    public OperationManager getOperationManager(){
        return operationManager;
    }

    /**
     *  Find the task with the same id as the input from the task set, and return it.
     * @param id The id of the task to find.
     * @return A task to be found.
     * @throws IllegalArgumentException on input error
     */
    public Task getTask(int id){

        return operationManager.getTask(id);

    }

    /**
     *  Find the project with the same id as the input from the project set, and return it.
     * @param id The id of the project to find.
     * @return A project to be found.
     * @throws IllegalArgumentException on input error
     */
    public Project getProject(int id){

        return operationManager.getProject(id);

    }

    public LinkedList<Task> getTasks() {
        return operationManager.getTasks();
    }

    public LinkedList<Project> getProjects() {
        return operationManager.getProjects();
    }

    /**
     *  This method can add a task to tasks.
     * @param t t is a task that has been created.
     */
    public void addTask(Task t){
        operationManager.addTask(t);
    }

    /**
     *  This method will create a task based on the input name, id and due date and add it to tasks.
     * @param name The name of the task.
     * @param id The id of the task.
     * @param due_date The due date of the task.
     */
    public void addTask(String name, int id, String due_date){

        operationManager.addTask(name, id, due_date);
    }

    /**
     *  This method can add an already created project to the projects.
     * @param p p is a project that has been created.
     */
    public void addProject(Project p){

        operationManager.addProject(p);

    }

    /**
     * This method creates a project based on the input name, id and due date, and adds the project to the projects.
     * @param name The name of the project.
     * @param id The id of the project.
     * @param due_date The due date of the project.
     */
    public void addProject(String name, int id, String due_date){
        operationManager.addProject(name, id, due_date);
    }

    /**
     *  This method can find the task according to the id and change the status of this task to true.
     * @param id The id of the task whose status is to be changed.
     * @throws IllegalArgumentException on input error
     */
    public void taskStatus(int id){

        operationManager.taskStatus(id);

    }

    /**
     *  This method can find the project according to the id and change the status of this task to true.
     * @param id The id of the project whose status is to be changed.
     * @throws IllegalArgumentException on input error
     */
    public void projectStatus(int id){

        operationManager.projectStatus(id);

    }

    /**
     *  This method can insert a task into the specified project.
     * @param task Task to be added into project.
     * @param idProject The id of the project.
     * @throws IllegalArgumentException on input error
     */
    public void addTaskToProject(Task task, int idProject){

        operationManager.addTaskToProject(task, idProject);

    }

    /**
     *  This method can delete the task with the specified id from the specified project.
     * @param idTask The id of the task to be deleted.
     * @param idProject The id of the project where this task is located.
     * @throws IllegalArgumentException on input error
     */
    public void deleteTaskFromProject(int idTask, int idProject){

        operationManager.deleteTaskFromProject(idTask, idProject);

    }

    public void saveData(OperationManager todo){

        dataManager.saveAllData(todo);

    }

    /**
     * This method can read the data in the .json file and return it as OperationManager
     * @return Return the data in the .json file as OperationManager type
     */
    public OperationManager loadData(){

        return dataManager.loadAllData();

    }
}
