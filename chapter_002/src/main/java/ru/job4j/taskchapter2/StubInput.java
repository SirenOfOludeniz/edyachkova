package ru.job4j.taskchapter2;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0; //счетчик


    public StubInput(String[] answers)
    { this.answers = answers; }


    public String action(String choice) {
        System.out.println(choice);
        System.out.println("position: " + position);
        System.out.println("answers[0] :" + answers[0]);
        System.out.println("answers[1] :" + answers[1]);
        System.out.println("answers[2] :" + answers[2]);
        System.out.println("answers[3] :" + answers[3]);
       // System.out.println(answers[position]);
        return answers[position++]; // получать значения из нашего массива и делать постинкремент для увеличения значения

    }

    @Override
    public int action(String choice, int[] range) {
        return 0;
    }


}
