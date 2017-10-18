package ru.job4j.zayavki_moya_versiya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Приветствие!");
        System.out.println("Программа учета заявок.");
        System.out.println("Программа умеет: добавлять новые заявки(ввести add), редактировать заявки(ввести edit)" +
                "удалять заявки (ввести delete), отображать список всех заявок (ввести show), отображать заявки с условием фильтра (ввести show_with_filter)" +
                "добавлять к заявке комментарии (ввести add_comment)");
        System.out.println("Введите нужную вам комманду");

        String s = reader.readLine();

        Menu menu = new Menu();
        menu.commands(s);

    }
}
