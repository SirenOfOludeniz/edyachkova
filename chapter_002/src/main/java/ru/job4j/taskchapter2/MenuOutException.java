package ru.job4j.taskchapter2;

public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) { // класс принимает сообщение об ошибки в свой конструктор
        super(msg); // передает сообщение об ошибке в конструктор родителя. Под родителем иммется ввиду RuntimeException?
    }

}
