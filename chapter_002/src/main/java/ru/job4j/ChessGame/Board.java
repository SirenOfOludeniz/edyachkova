package ru.job4j.ChessGame;

public class Board {
    Figure[][] figures = new Figure[8][8];
    boolean move (Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException
    {   boolean existfigure = true;
        try {
       if(figures[source.getX()][source.getY()] != null) {

       }
    }
    catch (FigureNotFoundException a) {
        System.out.println("Figure not found in source Cell.");
    }
    return existfigure;

    }
}
