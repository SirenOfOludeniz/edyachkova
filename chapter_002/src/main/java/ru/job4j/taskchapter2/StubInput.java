package ru.job4j.taskchapter2;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0; //счетчик
    private long datecreate = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }
    public String action(String choice) {
        return answers[position++]; // получать значения из нашего массива и делать постинкремент для увеличения значения
    }

    @Override
    public int action(String choice, int[] range) {
        return 0;
    }

    public long inputdate(String askdate) {
        return datecreate;
    }
}
