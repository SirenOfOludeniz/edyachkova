package ru.job4j.ChessGame;

public class Bishop extends Figure { //по условию нужен implements, но
    // я не думаю, что implements применимо к абстрактному классу Figure

    public Bishop(Cell position) {
        super(position);
    }
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] copyway = new Cell[dest.getX() - source.getX()];
        int b1 = 0; int b2 = 0; int k1 = 1; int k2 = -1;
        int beginx = 0; int beginy = 0;
        int endx = 0; int endy = 0;
        int arraylenght = 0;

        try {
            b1 = source.getY() - (k1 * source.getX()); // диагональ y = kx + b, b > 0 или b < 0 или b = 0, тогда y = x
            b2 = source.getY() - (k2 * source.getX()); // диагональ y = (-k)x + b , здесь b всегда больше 0

            // любая точка source лежит на таких двух диагоналях

            //диагональ y = kx + b
            if (b1 > 0) {
              beginy = b1 + 1;
              beginx = 1;
            }
            if (b1 < 0) {
                beginx = Math.abs(b1) + 1;
                beginy = 1;
            }
            if (b1 == 0) {
                beginx = 1;
                beginy = 1;
            }

            System.out.println("beginX :" + beginx);
            System.out.println("beginY :" + beginy);

            if (beginx == 1 && beginy != 1) {
                arraylenght = 8 - beginy + 1;
            }
            if (beginx != 1 && beginy == 1) {
                arraylenght = 8 - beginx + 1;
            }
            if (beginx == 1 && beginy == 1) {
                arraylenght = 8;
            }

            System.out.println("Длина массива для диагонали RightUp :" + arraylenght);


            Cell[] diagonalRightUp = new Cell[arraylenght];







       /* Cell[] cellway = new Cell[dest.getX() - source.getX()]; // задали массив
        // количество клеток по диагонали, которые должен пройти слон куда-либо
            //совпадают с количеством клеток в проекции на любую из осей координат
            for (int i = 0; i < cellway.length ; i++) {
                cellway[i] = copyway[i];
            }
            // ГДЕ ПИСАТЬ САМУ ЛОГИКУ ТОГО, ЧТО СЛОН ХОДИТ ПО-ДИАГОНАЛИ?*/


            return copyway ; }
        catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
            System.out.println("Фигура туда не может пойти");
        }
        return copyway;
    }
    public Figure copy(Cell dest) {
        return new Bishop(dest);

    }
}
