package ru.job4j.service;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class SetOnHashTableTest {
    @Test
    public void setHashTableTest() {
        SetOnHashTable<String>  words = new SetOnHashTable(10);
        words.add("dog");
        words.add("cat");
        words.add("moon");
        words.add("sun");
        words.add("sea");
        words.add("water");
        words.add("moon");

        for (int i = 0; i < words.sizeArray; i++) {
            System.out.println(words.objects[i]);
        }
    }

}