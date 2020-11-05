package main.gui;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class Mainmenu {
    JFrame frame;
    JPanel jPanel1;
    JPanel jPanel2;

    JButton homeButton;
    JButton taskButton;
    JButton projectButton;
    JButton test;

    JLabel projectList;

    Container container;


    public Mainmenu(){

        frame = new JFrame();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        initial();





    }


    public void initial(){
        //设置主窗口
        frame.setTitle("Todo List");
        frame.setSize(1000,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //增加标签
        projectList=new JLabel("Project List: ", JLabel.CENTER);

        //创建按钮
        taskButton = new JButton("+Add Task");
        projectButton = new JButton("+Add Project");
        homeButton = new JButton("Home");

        //设置按钮参数
        taskButton.setFont(new Font("Arial", Font.PLAIN, 13));
        projectButton.setFont(new Font("Arial", Font.PLAIN, 13));
        homeButton.setFont(new Font("Arial", Font.PLAIN, 13));

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

        //设置Label
        projectList.setFont(new Font("Arial", Font.BOLD, 15));

        //背景颜色
        jPanel1.setBackground(Color.red);
        jPanel2.setBackground(Color.green);


        //分割窗口
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false, jPanel1, jPanel2);
        jSplitPane.setDividerLocation(200); //分割线的位置  也就是初始位置
        jSplitPane.setOneTouchExpandable(false); //是否可展开或收起，在这里没用
        jSplitPane.setDividerSize(2);//设置分割线的宽度 像素为单位
        jSplitPane.setEnabled(false); //设置分割线不可拖动！！
        frame.add(jSplitPane);  //加入到面板中就好了



    }






    public static void main(String[] args){

        Mainmenu mainmenu = new Mainmenu();
    }
}
