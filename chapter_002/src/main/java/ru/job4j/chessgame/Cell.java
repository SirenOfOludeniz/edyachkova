package ru.job4j.chessgame;

public class Cell {
    private int x; //или здесь public надо?
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Cell() {

    }
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
