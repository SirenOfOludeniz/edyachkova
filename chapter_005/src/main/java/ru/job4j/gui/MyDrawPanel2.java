package ru.job4j.gui;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel2 extends JPanel{
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("phoro.jpg").getImage();
        g.drawImage(image, 3,4, this);
    }
}
