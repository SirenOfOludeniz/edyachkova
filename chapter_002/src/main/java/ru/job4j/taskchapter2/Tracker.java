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

    public void delete(Item item) { //копирование из массива findAll() в массив this.items[]

        int deleteposiotion = 0;

        for (int i = 0; i < findAll().length ; i++) {
            if(findAll()[i].equals(item)) {
                deleteposiotion = i;
            }
        }

        if (deleteposiotion == 0) {
            System.arraycopy(findAll(), 1, this.items, 0, findAll().length - 1);
        }
        if (deleteposiotion != 0 && deleteposiotion != findAll().length - 1) {
            System.arraycopy(findAll(), 0, this.items, 0, deleteposiotion);
            System.arraycopy(findAll(), deleteposiotion + 1, this.items, deleteposiotion, findAll().length - deleteposiotion - 1);
        }
        if (deleteposiotion == findAll().length - 1) {
            System.arraycopy(findAll(), 0, this.items, 0, findAll().length - 1);
        }

    }











    /*public void delete(Item item) { //копирование из массива this.items[] в массив findAll()

        int deleteposition = 0;

        for (int i = 0; i < this.items.length ; i++) {
            if(this.items != null && this.items[i].equals(item)) {
                deleteposition = i;
            }
        }

       if(deleteposition == 0) {
            System.arraycopy(this.items,1,findAll(),0,findAll().length-1);
           System.out.println("deleteposition: " + deleteposition);
       }

       if(deleteposition != 0 && deleteposition != findAll().length) {
            System.arraycopy(this.items, 0, findAll(), 0, deleteposition);
            //сначала копируем кусок массива до удаляемого элемента
           System.arraycopy(this.items, deleteposition +1, findAll(), deleteposition,findAll().length - deleteposition - 1);
           //затем копируем кусок массива после удаляемого элемента
           System.out.println("deleteposition: " + deleteposition);
        }

        if(deleteposition == findAll().length -1) {
            System.arraycopy(this.items, 0, findAll(), 0, findAll().length - 1);
            System.out.println("deleteposition: " + deleteposition);
        }





    }
    /* public void delete(Item item) { // копирование из массива findAll в копию, а потом из копии опять в findAll
        Item[] copyresult  = new Item[findAll().length - 1];

        int deleteposition = 0;

      for (int i = 0; i < findAll().length ; i++) {
          if(findAll()[i].equals(item)) {
              deleteposition = i;
          }

      }
      if(deleteposition == 0) { // удалить из начала
          System.arraycopy(findAll(), 1, copyresult, 0, findAll().length - 1);
          System.arraycopy(copyresult,0, findAll(),0, copyresult.length);
          System.out.println("deleteposition: " + deleteposition);
      }
      if(deleteposition != 0 && deleteposition != findAll().length) { //удалить из середины
          System.arraycopy(findAll(), 0, copyresult, 0, findAll().length - deleteposition);
          System.arraycopy(findAll(), deleteposition + 1, copyresult, deleteposition, findAll().length -deleteposition -1);
          System.arraycopy(copyresult,0, findAll(),0, copyresult.length);
           System.out.println("deleteposition: " + deleteposition);
      }
      if(deleteposition == findAll().length - 1) { //удалить из конца
          System.arraycopy(findAll(), 0, copyresult, 0, findAll().length - 1);
          System.arraycopy(copyresult,0, findAll(),0, copyresult.length);
           System.out.println("deleteposition: " + deleteposition);
      }

      for (int i = 0; i < copyresult.length ; i++) {
          System.out.print("copyresult " + i + " " + copyresult[i] + " ");

      }

      System.out.println(" ");

      for (int i = 0; i < findAll().length; i++) {
          System.out.print("findAll " + i + " " + findAll()[i] + " " );
      }
  }*/


   /* public void delete(Item item) {
        for (int i = 0; i < items.length; i++) {
           if (this.items[i] != null && items[i].getId().equals(item.getId())) { // надо this или не надо
              this.items[i] = null;
           }
        }
    }*/

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
        int counter = 0;
        for (int i = 0; i < findAll().length - 1 ; i++) {
            if (findAll()[i].getName().equals(key)) {
                counter++;
            }
        }
        Item[] copyitems = new Item[counter];

        for (int i = 0, count = 0; i < counter ; i++) {
            if (findAll()[i].getName().equals(key)) {
                copyitems[count] = findAll()[i];
                count++;
            }

        }
        return copyitems;
    }

 /* public Item[] findByName(String key) {
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






















