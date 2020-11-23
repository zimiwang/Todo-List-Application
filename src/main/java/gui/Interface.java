package gui;

import engine.Todo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.ref.Cleaner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Flow;

/**
 * This class contains all the gui parts in java swing. Output the To-do list in the form of a graphical interface.
 *
 * @author Ziming Wang
 * @version 1.0
 */
public class Interface {

    Todo todo;

    int counter = 1;
    int number = 1;
    JFrame frame;

    JPanel jPanel1;
    JPanel jPanel2;

    // For main frame
    JButton homeButton;
    JButton taskButton;
    JButton projectButton;

    JLabel projectList;

    JSplitPane jSplitPane;


    public Interface() {
        todo = Todo.getInstance();

        frame = new JFrame();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();

        initialize();
    }

    /**
     * This method is included in the constructor, so whenever an object is created, a gui interface is created directly.
     * This main interface contains Home, addTask, and AddProject buttons. They are used to refresh the interface, add tasks and add projects.
     *
     */
    public void initialize() {

        //Set the main window
        frame.setTitle("Todo List");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Add label
        projectList = new JLabel("Project List: ", JLabel.CENTER);

        //Create buttons
        taskButton = new JButton("+Add Task");
        projectButton = new JButton("+Add Project");
        homeButton = new JButton("Home");

        //Set button parameters
        taskButton.setFont(new Font("Arial", Font.BOLD, 16));
        projectButton.setFont(new Font("Arial", Font.BOLD, 16));
        homeButton.setFont(new Font("Arial", Font.BOLD, 16));

        //Remove the border around the text in the button
        taskButton.setFocusPainted(false);
        projectButton.setFocusPainted(false);
        homeButton.setFocusPainted(false);

        //Remove button border
        taskButton.setBorderPainted(false);
        projectButton.setBorderPainted(false);
        homeButton.setBorderPainted(false);


        //Add button to JPanel
        jPanel1.setLayout(new GridLayout(10, 1, 1, 1));
        jPanel2.setLayout(new GridLayout(10, 1, 1, 1));

        jPanel1.add(homeButton);
        jPanel1.add(taskButton);
        jPanel1.add(projectButton);
        jPanel1.add(projectList);   // Label

        //Set up Label
        projectList.setFont(new Font("Arial", Font.BOLD, 16));

        //background color
        jPanel1.setBackground(Color.LIGHT_GRAY);
        jPanel2.setBackground(Color.GRAY);


        //Split window
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, jPanel1, jPanel2);
        jSplitPane.setDividerLocation(200); //The position of the dividing line
        jSplitPane.setOneTouchExpandable(false); //Can be expanded or collapsed
        jSplitPane.setDividerSize(2);//Set the width of the dividing line
        jSplitPane.setEnabled(false); //Set the dividing line to not drag！
        frame.add(jSplitPane);  //Add to frame

        home();
        addTask(taskButton, frame);
        addProject();
    }

    /**
     * This method contains an action listener for the Home button, and the main interface will be refreshed every time it is pressed.
     *
     */
    public void home(){
        homeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.invalidate();
                frame.validate();
            }
        });

    }

    /**
     * This method sets up an action listener that allows the add task button to pop up a window,
     * which is used to collect the data of the task to be created.
     *
     * @param task A button of type JButton with "add task" written in the gui.
     * @param frame The frame where the button task sits.
     */
    public void addTask(JButton task, JFrame frame) {

        //Set the action listener for the button
        task.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Create a new frame to add task information
                JFrame taskFrame = new JFrame();
                taskFrame.setLocation(100, 50);
                taskFrame.setSize(400, 200);
                taskFrame.setLocationRelativeTo(null);
                taskFrame.setVisible(true);
                taskFrame.setBackground(Color.BLACK);

                //Create jPanel3, 4
                JPanel jPanel3 = new JPanel();
                JPanel jPanel4 = new JPanel();

                //Create confirmation and cancel buttons
                JButton confirmButton = new JButton("Confirm");
                JButton cancelButton = new JButton("Cancel");

                //Remove the border around the text
                confirmButton.setFocusPainted(false);
                cancelButton.setFocusPainted(false);

                //Set up jPanel3
                jPanel3.setLayout(new GridLayout(2, 1, 8, 1));

                //Set up jPanel4
                jPanel4.setLayout(new GridLayout(1, 10, 8, 1));

                //Add button to jPanel4
                jPanel4.add(confirmButton);
                jPanel4.add(cancelButton);

                confirmButton.setBackground(Color.red);

                jPanel3.setBackground(Color.LIGHT_GRAY);
                jPanel4.setBackground(Color.GRAY);

                taskFrame.add(jPanel4);

                //Split window
                JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, jPanel3, jPanel4);
                jSplitPane2.setDividerLocation(120); //The position of the dividing line
                jSplitPane2.setOneTouchExpandable(false); //Can be expanded or collapsed
                jSplitPane2.setDividerSize(2);//Set the width of the dividing line
                jSplitPane2.setEnabled(false); //Set the dividing line to not drag！
                taskFrame.add(jSplitPane2);  //Add to frame

                //Create drop-down list
                JComboBox cmb = new JComboBox();    //Create JComboBox
                cmb.addItem("Please select a due date");    //Add an item to the drop-down list
                cmb.addItem("1");
                cmb.addItem("2");
                cmb.addItem("3");
                cmb.addItem("4");
                cmb.addItem("5");
                cmb.addItem("6");
                cmb.addItem("7");

                //Create a single-line text box
                JTextField taskTxt = new JTextField(28);
                taskTxt.setFont(new Font("Arial", Font.PLAIN, 14));
                taskTxt.setText("Please input your task: ");

                //Add to jPanel3
                jPanel3.add(taskTxt);
                jPanel3.add(cmb);

                // For confirm button
                confirmCancel(confirmButton, cancelButton, taskTxt, cmb, taskFrame, jPanel2, frame, jSplitPane);

                //Use To-do class to add task
                todo.addTask(taskTxt.getText(), counter, (String) cmb.getSelectedItem());

            }
        });
    }

    /**
     * This method is used to add action listener to confirm button and cancel button. When the confirm button is pressed,
     * this method will create a task on the main interface based on the data obtained from the addTask method. It has name, due date and id.
     * The Cancel button can close the window popped up by the addTask method.
     *
     * @param confirmButton This is a JButton type button, it is called "Confirm".
     * @param cancelButton This is a JButton type button, it is called "Cancel".
     * @param taskTxt The text data obtained in the task button. Its meaning is the name of the task.
     * @param cmb JComboBox type data obtained in the task button. Its meaning is due_data of task.
     * @param fm1 The frame used in the addTask method.
     * @param jp The JPanel type data in the main interface is used to store the generated task and display it to the user.
     * @param fm2 The frame used by the main interface.
     * @param jSplitPane JSplitPane type data is used to divide the main interface into two.
     */
    public void confirmCancel(JButton confirmButton,JButton cancelButton, JTextField taskTxt, JComboBox cmb, JFrame fm1,
                              JPanel jp, JFrame fm2, JSplitPane jSplitPane){
        confirmButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create jPanel, create task to frame

                String date = taskTxt.getText();
                String name = cmb.getName();
                String varName = (String) cmb.getSelectedItem();

                // Create a new list
                JRadioButton newTask=new JRadioButton("          Task "+ counter + ": " + date + "                   Time Left: " + varName + " days");
                newTask.setBackground(Color.white);
                newTask.setFont(new Font("Arial", Font.PLAIN, 16));
                newTask.setFocusPainted(false);


                jp.add(newTask);

                //Dynamically refresh components
                jp.revalidate();

                //Add to jSplitPane, and then add to the frame
                fm2.add(jSplitPane);

                //Code part, create a task or insert task into project
                if (taskTxt.getText() == "Please input your task: "){
                    todo.addTask(taskTxt.getText(), counter, (String) cmb.getSelectedItem());
                }
                else if ( taskTxt.getText() == "Please input your project: "){
                    todo.addTaskToProject(todo.getTask(counter), number);
                }

                //counter
                counter++;
                //close the window
                fm1.dispose();
            }
        });

        cancelButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fm1.dispose();
            }
        });
    }

    /**
     *
     * This method is to set the action listener for the add project button.
     * Its function is to pop up a new window to collect the information needed to create a project.
     * It also has a confirm button and a cancel button.
     * When the confirm button is clicked, a project button will be created in the main interface, and there will be a detailed project data on it.
     * Since it is a button, when the project button is clicked again, a project window will be generated.
     * In this window, you can use the "add task" button again to add tasks. But this time add task to the project window instead of the main interface.
     * This means that the project window contains tasks belonging to the project.
     *
     */
    public void addProject() {

        //Set the action listener for the button
        projectButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Create a new frame to add task information
                JFrame projectFrame = new JFrame();
                projectFrame.setLocation(100, 50);
                projectFrame.setSize(400, 200);
                projectFrame.setLocationRelativeTo(null);
                projectFrame.setVisible(true);
                projectFrame.setBackground(Color.BLACK);

                //Create jPanel5, 6
                JPanel jPanel5 = new JPanel();
                JPanel jPanel6 = new JPanel();

                //Create confirmation and cancel buttons
                JButton confirmButton = new JButton("Confirm");
                JButton cancelButton = new JButton("Cancel");

                //Set up jPanel5
                jPanel5.setLayout(new GridLayout(2, 1, 8, 1));

                //Set up jPanel6
                jPanel6.setLayout(new GridLayout(1, 10, 8, 1));

                //Add button to jPanel6
                jPanel6.add(confirmButton);
                jPanel6.add(cancelButton);

                confirmButton.setBackground(Color.red);

                jPanel5.setBackground(Color.LIGHT_GRAY);
                jPanel6.setBackground(Color.GRAY);

                projectFrame.add(jPanel5);
                //Split window
                JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, jPanel5, jPanel6);
                jSplitPane2.setDividerLocation(120); //The position of the dividing line
                jSplitPane2.setOneTouchExpandable(false); //Can be expanded or collapsed
                jSplitPane2.setDividerSize(2);//Set the width of the dividing line
                jSplitPane2.setEnabled(false); //Set the dividing line to not drag！
                projectFrame.add(jSplitPane2);  //Add to frame

                //Create drop-down list
                JComboBox cmb = new JComboBox();    //Create JComboBox
                cmb.addItem("Please select a due date");    //Add an item to the drop-down list
                cmb.addItem("1");
                cmb.addItem("2");
                cmb.addItem("3");
                cmb.addItem("4");
                cmb.addItem("5");
                cmb.addItem("6");
                cmb.addItem("7");

                //Create a single-line text box
                JTextField projectTxt = new JTextField(28);
                projectTxt.setFont(new Font("Arial", Font.PLAIN, 14));
                projectTxt.setText("Please input your project: ");

                //Add to jPanel5
                jPanel5.add(projectTxt);
                jPanel5.add(cmb);

                //Code part, create a project
                todo.addProject(projectTxt.getText(), number, (String) cmb.getSelectedItem());

                // For confirm button, click and a new project will appear
                confirmButton.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Get the parameters first
                        String data = projectTxt.getText();
                        String name = (String) cmb.getSelectedItem();

                        //Create project button
                        JButton newProject = new JButton("Project " + number + "  Due: " + name + " days");
                        newProject.setFocusPainted(false);
                        newProject.setFont(new Font("Arial", Font.PLAIN, 12));

                        jPanel1.add(newProject);
                        jPanel1.revalidate();

                        frame.add(jSplitPane);


                        //Code part, generate a project
                        todo.addProject(projectTxt.getText(), number, (String) cmb.getSelectedItem());

                        //Create a frame for each newProject
                        newProject.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Create the project frame
                                JFrame projectFrame = new JFrame();
                                projectFrame.setLocation(100, 50);
                                projectFrame.setSize(900, 500);
                                projectFrame.setLocationRelativeTo(null);
                                projectFrame.setVisible(true);
                                projectFrame.setBackground(Color.BLACK);

                                //Create two Jpanels to install things
                                JPanel jPanel_project_1 = new JPanel();
                                JPanel jPanel_project_2 = new JPanel();

                                jPanel_project_1.setLayout(new GridLayout(10,1,1,1));
                                jPanel_project_2.setLayout(new GridLayout(10,1,2,2));

                                //Create button
                                JButton newTask = new JButton("Add Task");

                                //Add button
                                jPanel_project_1.add(newTask);

                                //Separate the frame
                                JSplitPane jSplitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, jPanel_project_1, jPanel_project_2);
                                jSplitPane3.setDividerLocation(120); //The position of the dividing line
                                jSplitPane3.setOneTouchExpandable(false); //Can be expanded or collapsed
                                jSplitPane3.setDividerSize(2);  //Set the width of the dividing line
                                jSplitPane3.setEnabled(false); //Set the dividing line to not drag！
                                projectFrame.add(jSplitPane3);  //Add to frame

                                newTask.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Create a new frame to add task information
                                        JFrame taskFrame = new JFrame();
                                        taskFrame.setLocation(100, 50);
                                        taskFrame.setSize(400, 200);
                                        taskFrame.setLocationRelativeTo(null);
                                        taskFrame.setVisible(true);
                                        taskFrame.setBackground(Color.BLACK);

                                        //Create jPanel3, 4
                                        JPanel jPanel3 = new JPanel();
                                        JPanel jPanel4 = new JPanel();

                                        //Create confirmation and cancel buttons
                                        JButton confirmButton = new JButton("Confirm");
                                        JButton cancelButton = new JButton("Cancel");

                                        //Remove the border around the text
                                        confirmButton.setFocusPainted(false);
                                        cancelButton.setFocusPainted(false);

                                        //Set up jPanel3
                                        jPanel3.setLayout(new GridLayout(2, 1, 8, 1));

                                        //Set up jPanel4
                                        jPanel4.setLayout(new GridLayout(1, 10, 8, 1));

                                        //Add button to jPanel4
                                        jPanel4.add(confirmButton);
                                        jPanel4.add(cancelButton);

                                        confirmButton.setBackground(Color.red);

                                        jPanel3.setBackground(Color.LIGHT_GRAY);
                                        jPanel4.setBackground(Color.GRAY);

                                        taskFrame.add(jPanel4);
                                        //Split window
                                        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, jPanel3, jPanel4);
                                        jSplitPane2.setDividerLocation(120); //The position of the dividing line
                                        jSplitPane2.setOneTouchExpandable(false); //Can be expanded or collapsed
                                        jSplitPane2.setDividerSize(2);//Set the width of the dividing line
                                        jSplitPane2.setEnabled(false); //Set the dividing line to not drag！
                                        taskFrame.add(jSplitPane2);  //Add to frame

                                        //Create drop-down list
                                        JComboBox cmb = new JComboBox();    //Create JComboBox
                                        cmb.addItem("Please select a due date");    //Add an item to the drop-down list
                                        cmb.addItem("1");
                                        cmb.addItem("2");
                                        cmb.addItem("3");
                                        cmb.addItem("4");
                                        cmb.addItem("5");
                                        cmb.addItem("6");
                                        cmb.addItem("7");

                                        //Create a single-line text box
                                        JTextField taskTxt = new JTextField(28);
                                        taskTxt.setFont(new Font("Arial", Font.PLAIN, 14));
                                        taskTxt.setText("Please input your task: ");

                                        //Add to jPanel3
                                        jPanel3.add(taskTxt);
                                        jPanel3.add(cmb);

                                        // For confirm button
                                        confirmCancel(confirmButton, cancelButton, taskTxt, cmb, taskFrame, jPanel_project_2, projectFrame, jSplitPane3);

                                    }
                                });

                                jPanel_project_1.setBackground(Color.LIGHT_GRAY);
                                jPanel_project_2.setBackground(Color.GRAY);
                            }
                        });

                        //number plus one
                        number++;
                        //close the window
                        projectFrame.dispose();
                    }
                });
                // For cancel button
                cancelButton.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        projectFrame.dispose();
                    }
                });
            }
        });
    }

    /**
     * This method demonstrates Interface().
     * @param args Unused
     */
    public static void main (String[] args){
        Interface menu = new Interface();
    }
}
