package ru.job4j.Task_chapter2;
import java.util.Arrays;
public class Tracker {
    private Item[] items = new Item[100];

    public Item add(Item item) {
        for (int i = 0; i < items.length; i++) {
            if(this.items[i] == null) { // надо this или не надо?
                this.items[i] = item;
                break;
            }
        }
        return item;
    }
    public void update(Item item) {
        for (int i = 0; i < items.length ; i++) {
            if(this.items[i].getId().equals(item.getId())) { // надо this или не надо?
                this.items[i] = item;
            }
        }
    }
    public void delete(Item item) {
        for (int i = 0; i < items.length; i++) {
            if(items[i].getId().equals(item.getId())) { // надо this или не надо
                this.items[i] = null;
            }
        }
    }

    public Item[] findAll() {
        int counter = 0;
        Item[] copyarray = new Item[items.length];
        for (int origin = 0, copy = 0; origin < this.items.length ; origin++) {
            if(!(items[origin].equals(null))) {
                copyarray[copy] = items[origin];
                copy++;
                counter++;
            }
        }
        return Arrays.copyOf(copyarray, copyarray.length-counter);
    }
    public Item[] findByName(String key) {
        Item[] copyitem = new Item[items.length];
        int counter = 0;
        for (int origin = 0,copy = 0; origin < items.length ; origin++) {
            if(items[origin].getName().equals(key)) {
                copyitem[copy] = items[origin];
                copy++;
                counter++;
            }
        }
        return Arrays.copyOf(copyitem,copyitem.length - counter);
    }

    public Item findById(String id) {
        Item copyitem = new Item();

        for (int i = 0; i < items.length; i++) {
            if(items[i].getId().equals(id)) {
                copyitem = items[i];
            }
            else copyitem = null;

        }
        return copyitem;
    }
}






















