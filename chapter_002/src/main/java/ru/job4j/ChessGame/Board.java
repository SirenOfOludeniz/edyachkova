package ru.job4j.ChessGame;

public class Board {
    Figure[][] figures = new Figure[8][8];
    boolean move (Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException
    {
        boolean figurecanmove = true;
        try {

       if(figures[source.getX()][source.getY()] != null) { //если нет, FigureNotFoundException
            //проверка, может ли фигура так двигаться
           for (int i = 0; i < figures[source.getX()][source.getY()].way(source, dest).length ; i++) {
              if (figures[source.getX()][source.getY()].way(source, dest)[i] == null) {
                  figurecanmove = true;
           }
          }
            if(figurecanmove) {
               figures[dest.getX()][dest.getY()].copy(dest);
            }




       }
    }
    catch (FigureNotFoundException a) {
        System.out.println("Figure not found in source Cell.");
    }
    return figurecanmove;

    }
}
