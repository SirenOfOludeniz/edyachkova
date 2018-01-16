package ru.job4j.taskchapter2;

import java.util.ArrayList;

public interface Input {
    String action(String choice);
    int action(String choice, ArrayList<Integer> range); // перегрузила метод  action

}