package ru.job4j.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiGradientTwoCircles {
    JFrame frame;


    public static void main(String[] args) {
        GuiGradientTwoCircles gui = new GuiGradientTwoCircles();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton colorButton1 = new JButton("Change Circle 1");
        colorButton1.addActionListener(new ColorListener());

        JButton colorButton2 = new JButton("Change Circle 2");
        colorButton2.addActionListener(new ColorListener());

        DrawPanelGradient2 gradient1 = new DrawPanelGradient2();
        DrawPanelGradient2 gradient2 = new DrawPanelGradient2();

        frame.getContentPane().add(BorderLayout.WEST, gradient1);
        //frame.getContentPane().add(BorderLayout.EAST, gradient2);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton1);
      //  frame.getContentPane().add(BorderLayout.NORTH, colorButton2);

        frame.setSize(800, 800);
        frame.setVisible(true);

    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }
}
