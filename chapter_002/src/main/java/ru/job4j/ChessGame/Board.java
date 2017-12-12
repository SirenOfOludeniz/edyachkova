package ru.job4j.ChessGame;

public class Board {
    Figure[][] figures = new Figure[8][8];
    boolean move (Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException
    {   boolean existfigure = true;
        try {
        //как проверить, что Cell source содержит или не содержит фигуру?
            //может ли она ТАК двигаться? тип как слон, к примеру?
            if (figures[0][0].position == source) {
                // проверка может ли двигаться фигура,
                //да, слона с клеткой в конструкторе нужно создать в другом месте, но пока создам тут
                //для попытки изобразить логику проверки на то, может двигаться или нет
                Bishop bishop = new Bishop(source);
               // bishop.way(source, dest)

            }
    }
    catch (FigureNotFoundException a) {
        System.out.println("Figure not found in source Cell.");
    }
    return existfigure;

    }
}
