package main.gui;

import com.sun.tools.javac.Main;
import main.engine.Todo;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    Container container;
    CardLayout cardLayout;
    AddPanel addPanel;
    TaskPanel taskPanel;
    Todo todo;


    public MainFrame(){

        taskPanel = new TaskPanel();
        addPanel = new AddPanel(this);
        todo = new Todo();


        container = getContentPane();
        container.setLayout(cardLayout);



    }
}
