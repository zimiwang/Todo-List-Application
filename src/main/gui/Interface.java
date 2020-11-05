package main.gui;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class Interface extends JFrame{

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {


                JButton homeButton = new JButton("Home");
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
                panel.setLayout(new GridLayout());
                panel.add(homeButton);

                MainFrame mainFrame = new MainFrame();
                mainFrame.setTitle("Todo List");
                mainFrame.setSize(1000, 600);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setVisible(true);

            }
        });

    }
}
