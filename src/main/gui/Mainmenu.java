package main.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.ref.Cleaner;
import java.util.concurrent.Flow;

public class Mainmenu {
    int counter = 1;
    JFrame frame;
//    JFrame taskFrame;
//    JFrame projectFrame;
    JPanel jPanel1;
    JPanel jPanel2;
//    JPanel jPanel3;
//    JPanel jPanel4;

    // For main frame
    JButton homeButton;
    JButton taskButton;
    JButton projectButton;
    JButton test;

    JLabel projectList;

    JSplitPane jSplitPane;

    // For taskFrame
//    JButton confirmButton;
//    JButton cancelButton;
//    JTextField taskTxt;


    Container container;


    public Mainmenu() {

        frame = new JFrame();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
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
        addTask();
        addProject();
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


    public void addTask() {

        //为按钮设置时间监听
        taskButton.addActionListener(new AbstractAction() {
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


                        jPanel2.add(newTask);

                        //动态刷新组件
                        jPanel2.revalidate();

                        //添加到jSplitPane中，然后再添加到frame中
                        frame.add(jSplitPane);

                        //counter
                        counter++;
                        //关闭窗口
                        taskFrame.dispose();
                    }
                });

                // For cancel button
                cancelButton.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        taskFrame.dispose();
                    }
                });
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

                // For confirm button
                confirmButton.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

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
    public static void main (String[] args){
        Mainmenu mainmenu = new Mainmenu();
    }
}
