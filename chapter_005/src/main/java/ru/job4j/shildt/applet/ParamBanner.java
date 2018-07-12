package ru.job4j.shildt.applet;

import java.applet.Applet;
import java.awt.*;

/*
<applet code="ParamBanner" width=300 height=50>
<param name=message value="Java makes the Web move!">
</applet>
 */
public class ParamBanner extends Applet implements Runnable{
   String msg;
   Thread t = null;
   volatile boolean stopFlag;
   int state;

   public void init() {
       setBackground(Color.blue);
       setForeground(Color.cyan);
   }
   public void start() {
       msg = getParameter("message");
       if (msg == null) msg = "Message not found";
        msg = " " + msg;
        t = new Thread(this);
        stopFlag = false;
        t.start();


   }
    @Override
    public void run() {
        for (;;) {
            try {
                repaint();
                Thread.sleep(250);
                if (stopFlag)
                    break;
            } catch (InterruptedException e) {
                System.out.println("interrupted ");
            }
        }
    }
    public void stop() {
       stopFlag = true;
       t = null;
    }
    public void paint(Graphics g) {
       char ch;

       ch = msg.charAt(0);
       msg = msg.substring(1, msg.length());
       msg += ch;

       g.drawString(msg, 50, 30);
    }
}
