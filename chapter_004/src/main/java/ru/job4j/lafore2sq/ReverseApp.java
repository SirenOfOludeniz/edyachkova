package ru.job4j.lafore2sq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {
    public static void main(String[] args) throws IOException {
        String input, ouput;
        while (true) {
            System.out.println("Enter a string: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            Reverser theReverser = new Reverser((input));
            ouput = theReverser.doRev();
            System.out.println("Reversed: " + ouput);
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
