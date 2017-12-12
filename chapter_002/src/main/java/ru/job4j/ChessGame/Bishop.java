package ru.job4j.ChessGame;

public class Bishop extends Figure { //по условию нужен implements, но
    // я не думаю, что implements применимо к абстрактному классу Figure

    public Bishop(Cell position) {
        super(position);
    }
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] copyway = new Cell[dest.getX() - source.getX()];
        try {
             /*Метод должен работать так. dest - задают ячейку куда следует пойти.
             Если фигура может туда пойти.
             то Вернуть массив ячеек. которые должна пройти фигура.
              */
        Cell[] cellway = new Cell[dest.getX() - source.getX()];
        // количество клеток по диагонали, которые должен пройти слон куда-либо
            //совпадают с количеством клеток в проекции на любую из осей координат
            for (int i = 0; i < cellway.length ; i++) {
                cellway[i] = copyway[i];
            }
            // ГДЕ ПИСАТЬ САМУ ЛОГИКУ ТОГО, ЧТО СЛОН ХОДИТ ПО-ДИАГОНАЛИ?


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
