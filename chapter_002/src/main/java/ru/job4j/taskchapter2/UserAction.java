package ru.job4j.taskchapter2;

public interface UserAction {
    int key(); //ключ, по которому мы будем у пользователя запрашивать какое действие он хочет выполнить
    void execute(Input input, Tracker tracker); //этот метод будет выполнять основное действие

    String info(); // будет сообщать пользователю, что данный метод делает
}
