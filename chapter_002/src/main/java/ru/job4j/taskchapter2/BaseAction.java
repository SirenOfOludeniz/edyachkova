package ru.job4j.taskchapter2;

public abstract class BaseAction implements UserAction {

    public BaseAction(String name, int key) { //такие же конструкторы нужно будет создать в классах наследниках

    }

    public String info() { return "я не знаю что тут нужно вернуть."; }

}
