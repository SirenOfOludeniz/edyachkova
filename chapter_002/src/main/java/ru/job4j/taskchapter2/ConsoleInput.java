package ru.job4j.taskchapter2;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);
    public String action(String choice) {
        System.out.println(choice);
        return scanner.nextLine();
    }

    @Override
    public int action(String choice, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.action(choice));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }

    }


}
