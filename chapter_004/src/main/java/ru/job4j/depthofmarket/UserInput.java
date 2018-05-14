package ru.job4j.depthofmarket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput implements Input{

    Scanner scanner = new Scanner(System.in);

    public String actionString(String choice) {
        System.out.println(choice);
        return scanner.nextLine();
    }

    public int actionInt(String choice) {
        System.out.println(choice);
        return Integer.parseInt(scanner.nextLine()) ;
    }
}
