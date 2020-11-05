package main.gui;

import main.engine.Todo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AddPanel extends JPanel {

    private MainFrame frame;
    private Todo todo;



    public AddPanel(MainFrame frame){
        this.frame = frame;
        todo = frame.todo;
//        Border innerBorder

        JPanel leftPanel = new JPanel(new BorderLayout());



    }
}
