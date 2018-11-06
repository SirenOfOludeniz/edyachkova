package hh.task;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class MiniumMissedNumber {
   /* public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream("C:/input.txt");
        byte[] numbers = new byte[inputStream.available()];
        int amount = inputStream.read(numbers);
        Set<Integer> set = new TreeSet<>();
        //TreeSet не хранит дубликатов и автоматически сортирует элементы
        for (int a : numbers) {
            set.add(a);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        //избавляемся от отрицательных чисел
        //а еще способы есть?
        ArrayList<Integer> positiveNums = new ArrayList<>();
        for (int a : list) {
            if (a > 0) {
                positiveNums.add(a);
            }
        }
        //очищаем list
        list.clear();
        //сохраняем пропущенные числа в list
        for (int i = 0; i < positiveNums.size(); i++) {
            int result = positiveNums.get(i + 1) - positiveNums.get(i);
            if (result > 1) {
                for (int j = 1; j < result; j++) {
                    list.add(positiveNums.get(i) + j);
                }

            }
        }
        //сохраняем минимальное пропущенное число
        int min = Collections.min(list);


    }*/
}
