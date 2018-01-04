package ru.job4j;

import java.util.*;

public class CheckTime {
    public long add(Collection<String> collection, int amount) {
        Date current = new Date();
        for (int i = 0; i < 100 ; i++) {
            collection.add("Vasya");
        }
        Date newtime = new Date();
        long operationTime = newtime.getTime() - current.getTime();
        System.out.println("opertime =" + operationTime);
        //System.out.println(collection);
        return operationTime;
    }

    public long deleteByObject(Collection<String> collection, int amount) {
        Date current = new Date();
        for (int i = 0; i < 20 ; i++) {
            collection.remove("Vasya");
        }
        Date newtime = new Date();
        long operationTime = newtime.getTime() - current.getTime();
        return operationTime;
    }
    public long deleteByIterator(Collection<String> collection, int amount) {
        Date current = new Date();
        Iterator iterator = collection.iterator();
        for (int i = 0; i < 20; i++) {
            while (iterator.hasNext()) {
               collection.remove(iterator.next());
            }
        }
        Date newtiem = new Date();
        long operationTime = newtiem.getTime() - current.getTime();
        return operationTime;
    }
    public long deleteForArrLAndLinkedL(List<String> arrlist, int amount) {
        Date current = new Date();
        for (int i = 0; i < 20 ; i++) {
            arrlist.remove(0); //удаление первых 20ти элементов
        }
        Date  newtime = new Date();
        long operationTime = newtime.getTime() - current.getTime();
        return operationTime;
    }
    public long deleteForTreeSet(TreeSet<String> set, int amount) {
        Date current = new Date();
        for (int i = 0; i < 20 ; i++) {
            set.remove(set.first()); //удаление первых 20ти элементов
        }
        Date  newtime = new Date();
        long operationTime = newtime.getTime() - current.getTime();
        return operationTime;
    }
}





















