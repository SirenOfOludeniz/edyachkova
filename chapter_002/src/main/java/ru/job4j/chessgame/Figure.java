package ru.job4j.chessgame;

public abstract class Figure {
    final Cell position = null;
    public Figure(Cell position) {

    }
    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);
}
