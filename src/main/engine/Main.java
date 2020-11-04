package main.engine;

public class Main {
    private Task task;
    private Project project;

    public Main(){

    }

    public void addTask(String name, int id, String due_date){
        task = new Task(name, id, due_date);
    }

    public void addProject(String name, int id, String due_date){

        project = new Project(name, id, due_date);
    }

    public void taskStatus(){

        task.setStatus(true);
    }

    public void projectStatus(){
        project.setStatus(true);
    }

    public void addTask(Task task){
        project.addTask(task);
    }

    public void deleteTask(int number){
        while(true){
            if (project.getProject().getFirst().getId() == number){
                project.getProject().removeFirst();
                break;
            }
            else{
                project.getProject().addLast(project.getProject().getFirst());
                project.getProject().removeFirst();
            }
        }
    }
}
