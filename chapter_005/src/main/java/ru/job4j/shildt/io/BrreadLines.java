package ru.job4j.shildt.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrreadLines {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String str;
       /* do {
            str = reader.readLine();
            System.out.println(str);
        } while (!str.equals("stop"));*/

       int b;
       b = 'A';
       System.out.write(b);
       System.out.write('\n');
    }
}
