package ru.job4j;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TestCheckTime {
    @Test
    public void addTestArrayList() {
        CheckTime checkTime = new CheckTime();
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Время добавления элементов в ArrayList = " + checkTime.add(list, 0));
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
        checkTime.add(arlist,0);
        System.out.println("Время удаления 20 000 ти элементов в ArrayList = " + checkTime.deleteByObject(arlist, 0));
    }
    @Test
    public void deleteByObjectTestLinkedList() {
        CheckTime checkTime = new CheckTime();
        Collection<String> linklist = new LinkedList<>();
        checkTime.add(linklist, 0);
        System.out.println("Время удаления 20 000 ти элементов в LinkedList = " + checkTime.deleteByObject(linklist, 0));
    }
    @Test
    public void deleteByObjectTestTreeSet() {
        CheckTime checkTime = new CheckTime();
        Collection<String> set = new TreeSet<>();
        checkTime.add(set, 0);
        System.out.println("Время удаления 20 000 ти элементов в TreeSet = " + checkTime.deleteByObject(set, 0));
    }
    @Test
    public void deleteByIteratorTestArrayList() {
        CheckTime checkTime = new CheckTime();
        Collection<String> arlist = new ArrayList<>();
        System.out.println("Время удаления 20ти элементов в ArrayList с итератором = " + checkTime.deleteByIterator(arlist, 0));
    }
    @Test
    public void deleteByIteratorTestLinkedList() {
        CheckTime checkTime = new CheckTime();
        Collection<String> linklist = new LinkedList<>();
        System.out.println("Время удаления 20ти элементов в LinkedList с итератором = " + checkTime.deleteByIterator(linklist, 0));
    }
    @Test
    public void deleteByIteratorTestTreeSet() {
        CheckTime checkTime = new CheckTime();
        Collection<String> set = new TreeSet<>();
        System.out.println("Время удаления 20ти элементов в TreeSet с итер.= " + checkTime.deleteByIterator(set, 0));
    }
    @Test
    public void deleteForArrayListAndLinkedList1() {
        CheckTime checkTime = new CheckTime();
        List<String> linklist = new LinkedList<>();
        checkTime.add(linklist, 0);
        System.out.println("Время удаления 20ти элементов в LinkedList с итератором = " + checkTime.deleteForArrLAndLinkedL(linklist, 0));
    }
    @Test
    public void deleteForArrayListAndLinkedList2() {
        CheckTime checkTime = new CheckTime();
        List<String> arrlist = new ArrayList<>();
        checkTime.add(arrlist, 0);
        System.out.println("Время удаления 20ти элементов в LinkedList с итератором = " + checkTime.deleteForArrLAndLinkedL(arrlist, 0));
    }

    @Test
    public void deleteForTreeSet() {
        CheckTime checkTime = new CheckTime();
        TreeSet<String> set = new TreeSet<>();
        checkTime.add(set, 0);
        System.out.println("Время удаления 20ти элементов в TreeSet с итер.= " + checkTime.deleteForTreeSet(set, 0));
    }
}

