package ru.job4j.pingpong;
import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable{
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        int stepX = (int) (Math.random() * 10);
        int stepY = (int) (Math.random() * 10);
        while (!current.isInterrupted()) {
            if(this.rect.getX() >= 300) {
                stepX = (int) (Math.random() * 10) * (-1);
            } else if(this.rect.getX() <= 0) {
                stepX = (int) (Math.random() * 10);
            }

            if(this.rect.getY() >= 300) {
                stepY = (int) (Math.random() * 10) * (-1);
            } else if(this.rect.getY() <= 0) {
                stepY = (int) (Math.random() * 10);
            }

            this.rect.setX(this.rect.getX() + stepX);
            this.rect.setY(this.rect.getY() + stepY);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

   /* @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            this.rect.setX(this.rect.getX() + 1);
            if (this.rect.getX() <= 0) {
                movingRight();
            } else if (this.rect.getX() >= 300) {
                movingtLeft();
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void movingtLeft() {
        while (this.rect.getX() >= 0) {
            this.rect.setX(this.rect.getX() - 1);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void movingRight() {
        while (this.rect.getX() <= 300) {
            this.rect.setX(this.rect.getX() + 1);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/




}
