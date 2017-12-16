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
            b1 = source.getY() - source.getX();
            //b1 = source.getY() - (k1 * source.getX()); // диагональ y = kx + b, b > 0 или b < 0 или b = 0, тогда y = x
            //b2 = source.getY() - (k2 * source.getX()); // диагональ y = (-k)x + b , здесь b всегда больше 0, т.к. k2 = -1
            b2 = source.getY() + source.getX();

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

            System.out.println("RU beginX :" + beginx);
            System.out.println("RU beginY :" + beginy);

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

            // записываем в массив клетки куда можно пойти по диагонали RightUp
            for (int i = 0; i < arraylenght; i++) {
                diagonalRightUp[i].setX(beginx + i);
                diagonalRightUp[i].setY(beginy + i);
                System.out.println("x :" + diagonalRightUp[i].getX() + "y :" + diagonalRightUp[i].getY());
            }

            //массив для диагонали RightDown

            if (b2 < 9) {
                beginx = 1;
                beginy = b2 - 1;
            }
            if (b2 >= 9) {
                beginy = 8;
                beginx = b2 - 8;
            }
            System.out.println("RD beginx :" + beginx);
            System.out.println("RD beginy :" + beginy);

            if (beginx == 1) {
                arraylenght = beginy;
            }
            if (beginy == 8) { // если что, тут подправить
                arraylenght = 8 - beginx + 1;
            }
            System.out.println("Длина массива диагонали RightDown :" + arraylenght);

            Cell[] diagonalRightDown = new Cell[arraylenght];

            for (int i = 0; i < diagonalRightDown.length; i++) {
                diagonalRightDown[i].setX(beginx + i);
                diagonalRightDown[i].setX(beginy - i);
            }



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
