package hh.task;


import java.io.IOException;
import java.util.*;

public class MinimumNumber {
    public static void main(String[] args) throws IOException{
        MinimumNumber minimumNumber = new MinimumNumber();

       String array = "-200 -100 1 8 4";
        System.out.println(minimumNumber.findMinimumNumber(array));




    }
    public int findMinimumNumber(String source) {
        String[] numbers = source.split(" ");
        int size = numbers.length;
        int[] positiveNums = new int[size];
        for (int i = 0; i < size; i++) {
            int tmp = Integer.parseInt(numbers[i]);
            if (tmp > 0) { //сохраняем только положительные числа
                positiveNums[i] = tmp;
            }
        }

        //избавляемся от дубликатов
        Set<Integer> set = new HashSet<>();
        for(int a : positiveNums) {
            set.add(a);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        int[] result = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            result[i] = list.get(i);
        }
        //сортируем массив
        sort(result);
        //ищем пропущенное число
        int min = findNumbers(result)[0];
        System.out.println(Arrays.toString(findNumbers(result)));

        return min;
    }

    public int[] findNumbers(int[] souce) {
        ArrayList<Integer> missedNums = new ArrayList<>();
        int size = souce.length;
        for (int i = 0; i < size; i++) {
            if (i + 1 < size) {
                int difference = souce[i + 1] - souce[i];
                if (difference > 1) {
                    for (int j = 1; j < difference; j++) {

                        missedNums.add(souce[i] + j);
                    }
                }
            }
        }
        int[] result = new int[missedNums.size()];
        for (int i = 0; i < missedNums.size(); i++) {
            result[i] = missedNums.get(i);
        }
        sort(result);
        return result;
    }

    /**
     * Применим алгоритм сортировки Шелла
     * @param array
     */
    public void sort(int[] array) {
        int inner, outer;
        int temp;
        int h = 1;
        int nElems = array.length;
        while (h <= nElems/3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1)/3;
        }

    }

}
