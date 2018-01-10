package ru.job4j.taskchapter2;
import java.util.ArrayList;
import java.util.Arrays;
public class Tracker {
    //Item[] list = new Item[100];
    private ArrayList<Item> items = new ArrayList<>();
    private int index = 0;

    public Item add(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i) == null) {
                this.items.add(i, item);
                index++;
               break;
            }
        }
        return item;
    }
    public void update(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(item.getId())) {
                this.items.add(i, item);
                System.out.println(this.items.get(i));
                break;
            }
        }
    }

    public void delete(Item item) {
        for (int i = 0; i < this.index; i++) {
            Item it = this.items.get(i);
            if (it != null && it.getId().equals(item.getId())) {
                System.arraycopy(this.items, i + 1, this.items, i, index--);
                break;
            }
        }
    }




    public ArrayList<Item> findAll() {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println("items " + this.items.get(i));
        }

        return this.items;
    }

   /* public Item[] findAll2() {
        return Arrays.copyOf(this.items, index);
    }*/





    public ArrayList<Item> findByName(String key) {
        int count = 1;
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            if (this.items.get(i) != null
                    && this.items.get(i).getName().equals(key)) {
                if (result.get(count - 1) != null) {
                    ArrayList<Item> tmp = result;
                    result = new ArrayList<Item>();
                    System.arraycopy(tmp, 0, result, 0, count - 1);
                }
                result.add((count - 1), this.items.get(i));
            }
        }
        return result;
    }
//    public Item findById(String id) { //Вариант Ярослава
//        for (int i = 0; i < this.items.length; i++) {
//            if (this.items[i] != null && this.items[i].getId().equals(id)) {
//                return this.items[i];
//            } /*else {
//                copyitem = null; // в трэк студио написано, что findById() возвращает или item или null
//           }*/ //убрано по причине возвращения null, даже если добавлена Item методом Add
//            break;
//
//        }
//        return null;
//    }








   public Item findById(String id) { //мой актуальный вариант
       Item copyitem = new Item(); // может тут причина null? в том, что copyitem ничего не присваивается?
         //и там остается null, как изначально и был

       for (int i = 0; i < this.items.size(); i++) {
           if (this.items.get(i) != null && this.items.get(i).getId().equals(id)) {
                copyitem = this.items.get(i);
            } else {
                copyitem = null; // в трэк студио написано, что findById() возвращает или item или null
         } //убрано по причине возвращения null, даже если добавлена Item методом Add
          break;

        }
        return copyitem;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}






















