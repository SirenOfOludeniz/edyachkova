package ru.job4j.shildt.applet;

import java.applet.Applet;
import java.awt.*;
/*
<applet code="Sample" width =300 height=50>
</applet>
 */
public class Sample extends Applet{
    String msg;

    //set up background color and foreground
    public void init() {
        setBackground(Color.cyan);
        setForeground(Color.black);
        msg = " Inside init() --";
    }
    //initialize output symbol string
    public void start() {
        msg += " Inside start()--";
    }
    //to output symbol string msg in applet`s window
    public void paint(Graphics g) {
        msg += " Inside paint().";
        g.drawString(msg, 10, 30);
    }
}
