package ru.job4j.gui;

import javax.swing.*;
import java.awt.*;

public class Animation {
    JFrame frame;
    int x = 0;
    int y = 0;

    public static void main(String[] args) {
        Animation animation = new Animation();
        animation.go();
    }
    public void go() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//JButton button = new JButton("Move Circle");

        MyDrawPanel drawPanel = new MyDrawPanel();

        // frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(900, 900);
        frame.setVisible(true);

        for (int i = 0; i < 100; i++) {
            x++;
            y++;

            drawPanel.repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.magenta);
            g.fillOval(x, y, 100, 100);

        }
    }

}
