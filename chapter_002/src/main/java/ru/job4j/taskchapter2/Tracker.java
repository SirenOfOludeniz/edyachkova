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
        for (Item item1 : this.items) {
            if (item.getId().equals(item)) {
                this.items.set(this.items.indexOf(item1), item);
                break;
            }
        }
        }

       /*for (Item item1 : this.items) {
           if (item1.getId().equals(item.getId())) {
               this.items.add(item);
           }
       }*/


    public void delete(Item item) {
        this.items.remove(item);

        /*for (Item item1 : this.items) {
            if (item1.getId().equals(item.getId())) {
                this.items.remove(item1); // так нормально удалять?
            }
        }*/
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
        Item result = new Item();
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = this.items.get(this.items.indexOf(item));
            }
        }
        return result;
      /* Item copyitem = new Item();
       for (Item item : this.items) {
           if (item.getId().equals(id)) {
               copyitem = item;
           }
           else copyitem = null;
       }
        return copyitem;*/
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}






















