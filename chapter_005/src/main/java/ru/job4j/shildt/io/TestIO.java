package ru.job4j.shildt.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestIO {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /**
         * InputStreamReader = это поток ввода, преобразующий байты в символы
         *
         * System.in ссылается на стандартный поток ввода (это и есть поток ввода)
         * System.out ссылается на стандартный поток вывода (а это - поток вывода)
         *
         * read() читает символ из потока ввода и возвращается его в виде целочисленного
         * значения
         *
         */

    }
}
