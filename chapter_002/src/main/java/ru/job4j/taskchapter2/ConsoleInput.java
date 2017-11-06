package ru.job4j.taskchapter2;

import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);
    public String action(String choice) {
        System.out.println(choice);
        return scanner.nextLine();
    }
}
