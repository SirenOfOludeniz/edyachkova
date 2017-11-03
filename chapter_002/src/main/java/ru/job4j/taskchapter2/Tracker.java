package ru.job4j.taskchapter2;
import java.util.Arrays;
public class Tracker {
    private Item[] items = new Item[100];
    private int index = 0;

    public Item add(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = item;
                index++;
               break;
            }
        }
        return item;
    }
    public void update(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
                System.out.println(this.items[i]);
                break;
            }
        }
    }

    public void delete(Item item) {
        for (int i = 0; i < this.index; i++ ) {
            Item it = this.items[i];
            if (it != null && it.getId().equals(item.getId())) {
                System.arraycopy(this.items, i + 1, this.items, i, index--);
                break;
            }
        }
    }




    public Item[] findAll() {
        return Arrays.copyOf(this.items, index);
    }




    public Item[] findByName(String key) {
        int count = 1;
        Item[] result = new Item[count];
        for (int i = 0; i < index; i++) {
            if (this.items[i] != null
                    && this.items[i].getName().equals(key)) {
                if (result[count - 1] != null) {
                    Item[] tmp = result;
                    result = new Item[++count];
                    System.arraycopy(tmp, 0, result, 0, count - 1);
                }
                result[count - 1] = this.items[i];
            }
        }
        return result;
    }








    public Item findById(String id) {
        Item copyitem = new Item(); // может тут причина null? в том, что copyitem ничего не присваивается?
        // и там остается null, как изначально и был



        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                copyitem = this.items[i];
            } else {
                copyitem = null; // в трэк студио написано, что findById() возвращает или item или null
           }
           break;

        }
        return copyitem;
    }

    public Item[] getItems() {
        return items;
    }
}






















