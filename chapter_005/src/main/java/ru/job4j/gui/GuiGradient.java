package ru.job4j.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiGradient implements ActionListener{
    JFrame frame;

    public static void main(String[] args) {
        GuiGradient gr = new GuiGradient();
        gr.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change colors");
        button.addActionListener(this);

        DrawPanelGradient2 gradient2 = new DrawPanelGradient2();

        frame.getContentPane().add(BorderLayout.WEST, button);
        frame.getContentPane().add(BorderLayout.CENTER, gradient2);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}
