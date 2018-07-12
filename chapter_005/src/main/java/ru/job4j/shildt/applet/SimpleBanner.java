package ru.job4j.shildt.applet;

import java.applet.Applet;
import java.awt.*;

public class SimpleBanner extends Applet implements Runnable{
    String msg = " A Simple Moving Banner.";
    Thread t = null;
    int state;
    volatile boolean stopFlag;
    public void init() {
        setBackground(Color.DARK_GRAY);
        setForeground(Color.blue);
    }
    public void start() {
        t = new Thread(this);
        stopFlag = false;
        t.start();
    }
    //точка входа в поток исполнения, прокручивающий баннер
    @Override
    public void run() {
        //воспроизвести баннер повторно
        for (;;) {
            try {
                repaint();
                Thread.sleep(250);
                if (stopFlag)
                    break;
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
    //приостановить баннер
    public void stop() {
        stopFlag = true;
        t = null;
    }
    //воспроизвести баннер
    public void paint(Graphics g) {
        char ch;

        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;

        g.drawString(msg, 50, 30);
    }
}
