package ru.job4j.jmm;

public class ShareObject {
    public int age;
    public int amount;
    public static final ShareObject unique = new ShareObject();

}
