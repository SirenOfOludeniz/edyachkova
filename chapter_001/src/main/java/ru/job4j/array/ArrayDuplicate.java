package ru.job4j.array;
import java.util.Arrays;
public class ArrayDuplicate {
    public  int a = 0;
   /* public static void main(String[] args) {
        String[] stroka = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = remote(stroka);
        for (int i = 0; i < stroka.length - a; i++) {
            System.out.println(result[i]);
        }
    }*/
    public  String[] remote(String[] array) {
        String elmass;
        //int a = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].equals(array[j]) && i != j && j != (array.length - 1 - i) && i < j) {
                    elmass = array[j];
                    array[j] = array[array.length - 1 - i];
                    array[array.length - 1 - i] = elmass;
                    a++;
                   // System.out.println("a =" +a);
                }
            }
        }
        //System.out.println("a после цикла=" + a);

        return Arrays.copyOf(array, array.length - a);
    }
}
