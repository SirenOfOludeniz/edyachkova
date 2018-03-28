package ru.job4j.test;



public class TestDoubleFind {
   public int doubleFind(int[] array, int key) {
       int downBound = 0;
       int upBound = array.length;
       int current = 0;
       while (current!= key) {
           current = (downBound + upBound)/2;
           if (current > key) {
               upBound = current;
           }
           else {
               downBound = current;
               upBound = (current + current * 2)/2;

           }
       }
       return current;
   }
}
