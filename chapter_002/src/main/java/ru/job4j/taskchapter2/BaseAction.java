package ru.job4j.taskchapter2;

public abstract class BaseAction implements UserAction {
    String name;
    int key;


    public BaseAction(String name, int key) { //такие же конструкторы нужно будет создать в классах наследниках
        this.name = name;
        this.key = key;
    }

    public String info() {return name + key(); }

}
