package ru.job4j.shildt.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin;

        try {
            fin = new FileInputStream("C:\\1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Write true name");
            return;
        }
         try {
            do {
                i = fin.read();
                System.out.print((char)i);
            } while (i != -1);
         } catch (IOException e) {
             System.out.println("Mistake of reading from file");
         }
         try {
            fin.close();
         } catch (IOException e) {
             System.out.println("Mistake of closing file");
         }
    }
}
