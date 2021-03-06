package ru.job4j;
import java.util.*;
public class CheckTime {
    public long add(Collection<String> collection, int amount) {
        Date current = new Date();
        for (int i = 0; i < 1000000; i++) {
            collection.add("Vasya" + i);
        }
        Date newtime = new Date();
        long operationTime = newtime.getTime() - current.getTime();
        System.out.println("Время добавления 1 000 000 элементов :" + operationTime);
        return operationTime;
    }
    public long deleteByObject(Collection<String> collection, int amount) {
        Date current = new Date();
        for (int i = 0; i < 20000; i++) {
            collection.remove("Vasya" + i);
        }
        Date newtime = new Date();
        long operationTime = newtime.getTime() - current.getTime();
        return operationTime;
    }
    public long deleteByIterator(Collection<String> collection, int amount) {
        Date current = new Date();
        Iterator iterator = collection.iterator();
        for (int i = 0; i < 20000; i++) {
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
        for (int i = 0; i < 20000; i++) {
            arrlist.remove(0); //удаление первых 20ти элементов
        }
        Date  newtime = new Date();
        long operationTime = newtime.getTime() - current.getTime();
        return operationTime;
    }

    /**
     *
     * @param set
     * @param amount
     * @return
     *       //set.remove(set.first());
    //        for (int i = 0; i < 20000 ; i++) {
    //            set.remove(set.first()); //удаление первых 20ти элементов
    //        }
     */
    public long deleteForTreeSet(TreeSet<String> set, int amount) {
        Date current = new Date();
        set.remove(set.first());
        Date  newtime = new Date();
        long operationTime = newtime.getTime() - current.getTime();
        return operationTime;
    }
}





















