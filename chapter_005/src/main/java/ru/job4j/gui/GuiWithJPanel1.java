package ru.job4j.gui;

import javax.swing.*;

public class GuiWithJPanel1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyDrawPanel2 panel2 = new MyDrawPanel2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel2);
        frame.setSize(500, 500);
        frame.setVisible(true);
        /**
         * ничего не сработает
         */
    }


}
