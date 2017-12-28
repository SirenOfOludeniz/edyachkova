package ru.job4j.taskchapter2;

public interface Input {
    String action(String choice);
    int action(String choice, int[] range); // перегрузила метод  action

}