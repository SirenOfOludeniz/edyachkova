package ru.job4j.start;
import ru.job4j.example.*;

import java.util.*;

public class Tracker {
    //обеспечивает добавление заявок, удаление, редактирование, поиск. Класс-хранилище информации
    private   Item[] items = new Item[10]; //внутреннее (потому что private) поле, содержащее заявки
    private int position = 0;
    private static final Random RN = new Random();
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    protected Item findById(String id) {
        Item result = null;
       for(Item item : items) {
           if(item != null && item.getId().equals(id)) {
               result = item;
               break;
           }
       }
       return  result;
    }
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
    public Item[] getAll() {
        Item[] result = new Item[position];
        for(int index =0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }



   /* public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.items[0] = new Item("item","desc",01);
        tracker.items[1] = new Task("task","desc");
        tracker.items[2] = new Bug();

        for (Item item : tracker.items) {
            if(item instanceof Task) {
                Task task = (Task) item;//приведение типа Up Casting повышаем дочерний до родительского
                System.out.println(task.calculatePrice());
            }

        System.out.println(item.getName() + " " + item.getDescription()); }

    }*/
}
