package ru.job4j.taskchapter2;
import java.util.Arrays;
public class Tracker {
    private Item[] items = new Item[100];

    public Item add(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (this.items[i] == null) { // надо this или не надо?
                this.items[i] = item;
               break;
            }
        }
        return item;
    }
    public void update(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) { // надо this или не надо?
                this.items[i] = item;
                System.out.println(this.items[i]);
                break;
            }
        }
    }
    public void delete(Item item) {
        for (int i = 0; i < items.length; i++) {
           if (this.items[i] != null && items[i].getId().equals(item.getId())) { // надо this или не надо
              this.items[i] = null;
           }
        }
    }

    public Item[] findAll() {
        int counter = 0;
        Item[] copyarray = new Item[items.length];
        for (int origin = 0, copy = 0; origin < this.items.length; origin++) {
           // System.out.println(items[origin] + " "+origin);
            //System.out.println(items[copy] + " " + copy);
            if ((items[origin] != (null))) {
                copyarray[copy] = items[origin];
                copy++;
                counter++;
            }

        }
        return Arrays.copyOf(copyarray, counter);
    }

  public Item[] findByName(String key) {
        Item[] copyitem = new Item[findAll().length];
        int counter = 0;
      for (int i = 0, copy = 0; i < findAll().length ; i++) {
          if(findAll()[i].getName().equals(key)) {
              copyitem[copy] = findAll()[i];
              copy++;
              counter++;
          }
      }
      return Arrays.copyOf(copyitem,counter);
  }




   /* public Item[] findByName(String key) {
        Item[] copyitem = new Item[items.length];
        int counter = 0;
        for (int origin = 0, copy = 0; origin < items.length; origin++) {
            if (items[origin].getName().equals(key)) {
                copyitem[copy] = items[origin];
                copy++;
                counter++;
            }
        }
        return Arrays.copyOf(copyitem, copyitem.length - counter);
    }*/

  public Item findById(String id) {
        Item copyitem = new Item();
      for (int i = 0; i < findAll().length ; i++) {
          if(findAll()[i] != null && findAll()[i].getId().equals(id)) {
              copyitem = findAll()[i];
          }
          else copyitem = null;
      }
      return copyitem;
  }




   /* public Item findById(String id) {
        Item copyitem = new Item(); // может тут причина null? в том, что copyitem ничего не присваивается?
        // и там остается null, как изначально и был



        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                copyitem = this.items[i];
            } else {
                copyitem = null; // в трэк студио написано, что findById() возвращает или item или null
           }

        }
        return copyitem;
    }*/
}






















