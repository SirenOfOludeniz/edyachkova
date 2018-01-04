package ru.job4j;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TestCheckTime {
    @Test
    public void addTestArrayList() {
        Date bbb = new Date();
        CheckTime checkTime = new CheckTime();
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Время добавления элементов в ArrayList = " + checkTime.add(list, 0));
        Date aaa = new Date();
        long e = aaa.getTime() - bbb.getTime();
        System.out.println("e = " + e);

    }
    @Test
    public void addTestLinkedList() {
        CheckTime checkTime = new CheckTime();
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println("Время добавления элементов в LinkedList = " + checkTime.add(linkedList, 0));
    }
    @Test
    public void addTestTreeSet() {
        CheckTime checkTime = new CheckTime();
        TreeSet<String> set = new TreeSet<>();
        System.out.println("Время добавления элементов в TreeSet = " + checkTime.add(set, 0));
    }
    @Test
    public void deleteByObjectTestArrayList() {
        CheckTime checkTime = new CheckTime();
        Collection<String> arlist = new ArrayList<>();
        System.out.println("Время удаления 20ти элементов в ArrayList = " + checkTime.deleteByObject(arlist, 0));
    }
    @Test
    public void deleteByObjectTestLinkedList() {
        CheckTime checkTime = new CheckTime();
        Collection<String> linklist = new LinkedList<>();
        System.out.println("Время удаления 20ти элементов в LinkedList = " + checkTime.deleteByObject(linklist, 0));
    }
    @Test
    public void deleteByObjectTestTreeSet() {
        CheckTime checkTime = new CheckTime();
        Collection<String> set = new TreeSet<>();
        System.out.println("Время удаления 20ти элементов в TreeSet = " + checkTime.deleteByObject(set, 0));
    }
}
