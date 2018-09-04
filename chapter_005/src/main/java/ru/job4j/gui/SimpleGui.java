package ru.job4j.gui;

import javax.swing.*;

public class SimpleGui {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        JButton button1 = new JButton("BUTTON");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * добавится только кнопка BUTTON.
         * Почему-не понятно.
         *
         * Понятно. Все окно и есть кнопка.
         * Поэтому вторую туда запихнуть не получается.
         */
        frame.getContentPane().add(button);
         frame.getContentPane().add(button1);
         frame.setSize(500, 500);
         frame.setVisible(true);
    }
}
