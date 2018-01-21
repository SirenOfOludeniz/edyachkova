package ru.job4j.taskchapter2;
import java.util.ArrayList;
import java.util.Arrays;
public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();


    public Item add(Item item) {
        this.items.add(item);
        return item;
    }

    public void update(Item item) {
        for (int i = 0; i < this.items.size() ; i++) {
            if (this.items.get(i).getId().equals(item.getId())) {
                this.items.set(i, item);
                break;
            }
        }
        }


    public void delete(Item item) {
        this.items.remove(item);
    }

    public ArrayList<Item> findAll() {
        return this.items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

   public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = this.items.get(this.items.indexOf(item));
            }
        }
        return result;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}






















