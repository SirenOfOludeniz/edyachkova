package ru.job4j.test;



public class TestDoubleFind {
    /**
     * //здесь поиск числа в диапазоне чисел от 0 до n
     //если диапазон массива будет задан не с 0,
     //то этот метод не будет работать
     * @param array
     * @param key
     * @return
     */
   public int doubleFind(int[] array, int key) {

       int downBound = 0;
       int upBound = array.length;
       int current = 0;
       while (current != key) {
           current = (downBound + upBound) / 2;
           if (current > key) {
               upBound = current;
           } else {
               downBound = current;
               upBound = (current + current * 2) / 2;
           }
       }
       return current;
   }

    /**
     * метод работает с отсортированным диапазоном чисел
     * началом диапазона может быть любое число
     * @param array
     * @param key
     * @return
     */
   public int doubleFindVariant2(int[] array, int key) {
       int downBound = array[0];
       int upBound = array[array.length - 1];
       int current = 0;
       while (current != key) {
           current = (downBound + upBound) / 2;
           if (current > key) {
               upBound = current;
           } else {
               downBound = current;
               upBound = (current + current * 2) / 2;
           }
       }
       return current;
   }
}
