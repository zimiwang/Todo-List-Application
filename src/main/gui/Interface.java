package main.gui;

import main.engine.Todo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.ref.Cleaner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Flow;

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
    JButton test;

    JLabel projectList;

    JSplitPane jSplitPane;


    // 点击project打开新的页面
    ArrayList<JButton> buttonArray;

    public Interface() {
        todo = new Todo();

        frame = new JFrame();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();

        buttonArray = new ArrayList<>();
//        jPanel3 = new JPanel();
//        jPanel4 = new JPanel();

        initialize();
    }


    public void initialize() {
        //设置主窗口
        frame.setTitle("Todo List");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //增加标签
        projectList = new JLabel("Project List: ", JLabel.CENTER);

        //创建按钮
        taskButton = new JButton("+Add Task");
        projectButton = new JButton("+Add Project");
        homeButton = new JButton("Home");

//        test = new JButton("Test!!!!!!!!");

        //设置按钮参数
        taskButton.setFont(new Font("Arial", Font.BOLD, 16));
        projectButton.setFont(new Font("Arial", Font.BOLD, 16));
        homeButton.setFont(new Font("Arial", Font.BOLD, 16));

        //取消文字附近的边框
        taskButton.setFocusPainted(false);
        projectButton.setFocusPainted(false);
        homeButton.setFocusPainted(false);

        //取消按钮边框
        taskButton.setBorderPainted(false);
        projectButton.setBorderPainted(false);
        homeButton.setBorderPainted(false);


        //添加按钮到JPanel
        jPanel1.setLayout(new GridLayout(10, 1, 1, 1));
        jPanel2.setLayout(new GridLayout(10, 1, 1, 1));

        jPanel1.add(homeButton);
        jPanel1.add(taskButton);
        jPanel1.add(projectButton);
        jPanel1.add(projectList);   // Label

//        jPanel2.add(test);

        //设置Label
        projectList.setFont(new Font("Arial", Font.BOLD, 16));

        //背景颜色
        jPanel1.setBackground(Color.red);
        jPanel2.setBackground(Color.green);


        //分割窗口
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, jPanel1, jPanel2);
        jSplitPane.setDividerLocation(200); //分割线的位置  也就是初始位置
        jSplitPane.setOneTouchExpandable(false); //是否可展开或收起，在这里没用
        jSplitPane.setDividerSize(2);//设置分割线的宽度 像素为单位
        jSplitPane.setEnabled(false); //设置分割线不可拖动！！
        frame.add(jSplitPane);  //加入到面板中就好了

        home();
        addTask(taskButton, frame);
        addProject();
        projectItem();
    }

    public void home(){
        homeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.invalidate();
                frame.validate();
            }
        });

    }


    public void addTask(JButton task, JFrame frame) {

        //为按钮设置时间监听
        task.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // frame.dispose();
                //创建一个新的frame用来添加task信息
                JFrame taskFrame = new JFrame();
                taskFrame.setLocation(100, 50);
                taskFrame.setSize(400, 200);
                taskFrame.setLocationRelativeTo(null);
                taskFrame.setVisible(true);
                taskFrame.setBackground(Color.BLACK);

                //创建jPanel3，4
                JPanel jPanel3 = new JPanel();
                JPanel jPanel4 = new JPanel();

                //创建确认和取消按钮
                JButton confirmButton = new JButton("Confirm");
                JButton cancelButton = new JButton("Cancel");

                //取消文字附近的边框
                confirmButton.setFocusPainted(false);
                cancelButton.setFocusPainted(false);

                //设置jPanel3
                jPanel3.setLayout(new GridLayout(2, 1, 8, 1));

                //设置jPanel4
                jPanel4.setLayout(new GridLayout(1, 10, 8, 1));

                //添加按钮到jPanel4
                jPanel4.add(confirmButton);
                jPanel4.add(cancelButton);

                confirmButton.setBackground(Color.red);

                jPanel3.setBackground(Color.red);
                jPanel4.setBackground(Color.green);

                taskFrame.add(jPanel4);
                //分割窗口
                JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, jPanel3, jPanel4);
                jSplitPane2.setDividerLocation(120); //分割线的位置  也就是初始位置
                jSplitPane2.setOneTouchExpandable(false); //是否可展开或收起，在这里没用
                jSplitPane2.setDividerSize(2);//设置分割线的宽度 像素为单位
                jSplitPane2.setEnabled(false); //设置分割线不可拖动！！
                taskFrame.add(jSplitPane2);  //加入到面板中就好了

                //创建下拉列表
                JComboBox cmb = new JComboBox();    //创建JComboBox
                cmb.addItem("Please select a due date");    //向下拉列表中添加一项
                cmb.addItem("1");
                cmb.addItem("2");
                cmb.addItem("3");
                cmb.addItem("4");
                cmb.addItem("5");
                cmb.addItem("6");
                cmb.addItem("7");

                //创建单行文本框
                JTextField taskTxt = new JTextField(28);
                taskTxt.setFont(new Font("Arial", Font.PLAIN, 14));
                taskTxt.setText("Please input your task: ");

                //添加到jPanel3
                jPanel3.add(taskTxt);
                jPanel3.add(cmb);

                // For confirm button
                confirmCancel(confirmButton, cancelButton, taskTxt, cmb, taskFrame, jPanel2, frame, jSplitPane);

                // For cancel button


                //和Logic part 联动
                todo.addTask(taskTxt.getText(), counter, (String) cmb.getSelectedItem());


            }
        });
    }

    public void confirmCancel(JButton confirmButton,JButton cancelButton, JTextField taskTxt, JComboBox cmb, JFrame fm1,
                              JPanel jp, JFrame fm2, JSplitPane jSplitPane){
        confirmButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建jPanel，创建task到frame中

                String date = taskTxt.getText();
                String name = cmb.getName();
                String varName = (String) cmb.getSelectedItem();

                // 创建新的list
                JRadioButton newTask=new JRadioButton("          Task "+ counter + ": " + date + "                   Time Left: " + varName + " days");
                newTask.setBackground(Color.white);
                newTask.setFont(new Font("Arial", Font.PLAIN, 16));
                newTask.setFocusPainted(false);


                jp.add(newTask);

                //动态刷新组件
                jp.revalidate();

                //添加到jSplitPane中，然后再添加到frame中
                fm2.add(jSplitPane);

                //counter
                counter++;
                //关闭窗口
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

    public void addProject() {

        //为按钮设置时间监听
        projectButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // frame.dispose();
                //创建一个新的frame用来添加task信息
                JFrame projectFrame = new JFrame();
                projectFrame.setLocation(100, 50);
                projectFrame.setSize(400, 200);
                projectFrame.setLocationRelativeTo(null);
                projectFrame.setVisible(true);
                projectFrame.setBackground(Color.BLACK);

                //创建jPanel5，6
                JPanel jPanel5 = new JPanel();
                JPanel jPanel6 = new JPanel();

                //创建确认和取消按钮
                JButton confirmButton = new JButton("Confirm");
                JButton cancelButton = new JButton("Cancel");

                //设置jPanel3
                jPanel5.setLayout(new GridLayout(2, 1, 8, 1));

                //设置jPanel4
                jPanel6.setLayout(new GridLayout(1, 10, 8, 1));

                //添加按钮到jPanel4
                jPanel6.add(confirmButton);
                jPanel6.add(cancelButton);

                confirmButton.setBackground(Color.red);

                jPanel5.setBackground(Color.red);
                jPanel6.setBackground(Color.green);

                projectFrame.add(jPanel5);
                //分割窗口
                JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, jPanel5, jPanel6);
                jSplitPane2.setDividerLocation(120); //分割线的位置  也就是初始位置
                jSplitPane2.setOneTouchExpandable(false); //是否可展开或收起，在这里没用
                jSplitPane2.setDividerSize(2);//设置分割线的宽度 像素为单位
                jSplitPane2.setEnabled(false); //设置分割线不可拖动！！
                projectFrame.add(jSplitPane2);  //加入到面板中就好了

                //创建下拉列表
                JComboBox cmb = new JComboBox();    //创建JComboBox
                cmb.addItem("Please select a due date");    //向下拉列表中添加一项
                cmb.addItem("1");
                cmb.addItem("2");
                cmb.addItem("3");
                cmb.addItem("4");
                cmb.addItem("5");
                cmb.addItem("6");
                cmb.addItem("7");

                //创建单行文本框
                JTextField projectTxt = new JTextField(28);
                projectTxt.setFont(new Font("Arial", Font.PLAIN, 14));
                projectTxt.setText("Please input your project: ");

                //添加到jPanel3
                jPanel5.add(projectTxt);
                jPanel5.add(cmb);

                // For confirm button, 按一下就会出现新的project
                confirmButton.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //先获取参数
                        String data = projectTxt.getText();
                        String name = (String) cmb.getSelectedItem();

                        //创建项目的button
                        JButton newProject = new JButton("Project " + number + "  Due: " + name + " days");
                        newProject.setFocusPainted(false);
                        newProject.setFont(new Font("Arial", Font.PLAIN, 12));

                        jPanel1.add(newProject);
                        jPanel1.revalidate();

                        frame.add(jSplitPane);

                        //存储button到array中
                        buttonArray.add(newProject);

                        //为每一个newProject创建一个frame
                        newProject.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //创建project的frame
                                JFrame projectFrame = new JFrame();
                                projectFrame.setLocation(100, 50);
                                projectFrame.setSize(900, 500);
                                projectFrame.setLocationRelativeTo(null);
                                projectFrame.setVisible(true);
                                projectFrame.setBackground(Color.BLACK);

                                //创建两个jpanel来装东西
                                JPanel jPanel_project_1 = new JPanel();
                                JPanel jPanel_project_2 = new JPanel();

                                jPanel_project_1.setLayout(new GridLayout(10,1,1,1));
                                jPanel_project_2.setLayout(new GridLayout(10,1,2,2));

                                //创建按钮
                                JButton newTask = new JButton("Add Task");
                                //调整参数

                                //添加按钮
                                jPanel_project_1.add(newTask);

                                //将frame分隔开
                                JSplitPane jSplitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, jPanel_project_1, jPanel_project_2);
                                jSplitPane3.setDividerLocation(120); //分割线的位置  也就是初始位置
                                jSplitPane3.setOneTouchExpandable(false); //是否可展开或收起，在这里没用
                                jSplitPane3.setDividerSize(2);//设置分割线的宽度 像素为单位
                                jSplitPane3.setEnabled(false); //设置分割线不可拖动！！
                                projectFrame.add(jSplitPane3);  //加入到面板中就好了

                                newTask.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // frame.dispose();
                                        //创建一个新的frame用来添加task信息
                                        JFrame taskFrame = new JFrame();
                                        taskFrame.setLocation(100, 50);
                                        taskFrame.setSize(400, 200);
                                        taskFrame.setLocationRelativeTo(null);
                                        taskFrame.setVisible(true);
                                        taskFrame.setBackground(Color.BLACK);

                                        //创建jPanel3，4
                                        JPanel jPanel3 = new JPanel();
                                        JPanel jPanel4 = new JPanel();

                                        //创建确认和取消按钮
                                        JButton confirmButton = new JButton("Confirm");
                                        JButton cancelButton = new JButton("Cancel");

                                        //取消文字附近的边框
                                        confirmButton.setFocusPainted(false);
                                        cancelButton.setFocusPainted(false);

                                        //设置jPanel3
                                        jPanel3.setLayout(new GridLayout(2, 1, 8, 1));

                                        //设置jPanel4
                                        jPanel4.setLayout(new GridLayout(1, 10, 8, 1));

                                        //添加按钮到jPanel4
                                        jPanel4.add(confirmButton);
                                        jPanel4.add(cancelButton);

                                        confirmButton.setBackground(Color.red);

                                        jPanel3.setBackground(Color.red);
                                        jPanel4.setBackground(Color.green);

                                        taskFrame.add(jPanel4);
                                        //分割窗口
                                        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, jPanel3, jPanel4);
                                        jSplitPane2.setDividerLocation(120); //分割线的位置  也就是初始位置
                                        jSplitPane2.setOneTouchExpandable(false); //是否可展开或收起，在这里没用
                                        jSplitPane2.setDividerSize(2);//设置分割线的宽度 像素为单位
                                        jSplitPane2.setEnabled(false); //设置分割线不可拖动！！
                                        taskFrame.add(jSplitPane2);  //加入到面板中就好了

                                        //创建下拉列表
                                        JComboBox cmb = new JComboBox();    //创建JComboBox
                                        cmb.addItem("Please select a due date");    //向下拉列表中添加一项
                                        cmb.addItem("1");
                                        cmb.addItem("2");
                                        cmb.addItem("3");
                                        cmb.addItem("4");
                                        cmb.addItem("5");
                                        cmb.addItem("6");
                                        cmb.addItem("7");

                                        //创建单行文本框
                                        JTextField taskTxt = new JTextField(28);
                                        taskTxt.setFont(new Font("Arial", Font.PLAIN, 14));
                                        taskTxt.setText("Please input your task: ");

                                        //添加到jPanel3
                                        jPanel3.add(taskTxt);
                                        jPanel3.add(cmb);

                                        // For confirm button
                                        confirmCancel(confirmButton, cancelButton, taskTxt, cmb, taskFrame, jPanel_project_2, projectFrame, jSplitPane3);

                                        // For cancel button

                                    }
                                });




                                jPanel_project_1.setBackground(Color.red);
                                jPanel_project_2.setBackground(Color.green);
                            }
                        });

                        //number加一
                        number++;
                        //关闭窗口
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

    public void projectFrame(){

        for (int i = 0; i < buttonArray.size(); i++){

            buttonArray.get(i).addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {



                }
            });

        }
    }

    public void projectItem(){

        for (int i = 0; i < buttonArray.size(); i++){



        }
    }


    public static void main (String[] args){
        Interface menu = new Interface();
    }
}
