package ru.job4j.gui;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(20, 50, 100, 100);

    }
}
