package ru.job4j.gui;

import javax.swing.*;
import java.awt.*;

public class GradientAnimation {
    JFrame frame;
    int x = 0;
    int y = 0;

    public static void main(String[] args) {
       GradientAnimation gradientAnimation = new GradientAnimation();
       gradientAnimation.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DrawPanelGradient2 drawPanel = new DrawPanelGradient2();


        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(900, 900);
        frame.setVisible(true);

        for (int i = 0; i < 300; i++) {
            x++;
            y++;

            drawPanel.repaint();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

    }



    class DrawPanelGradient2 extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());


            Graphics2D g2d = (Graphics2D)g;
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            Color startColor = new Color(red, green, blue);

            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);

            Color endColor = new Color(red, green, blue);

            GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
            g2d.setPaint(gradient);
            g2d.fillOval(x, y, 100, 100);
        }
    }
}
