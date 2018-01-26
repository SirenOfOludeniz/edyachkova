package ru.job4j.loop;

public class Counter {

public  int add(int start, int finish) {
   int i; int sum = 0;
   int elemdiapason = 0;

    for (i = start; i <= finish; i++) {
        if (i % 2 == 0) {
            i = i + elemdiapason;
            System.out.println(i);
            sum = sum + i;
        }
    }
    return sum;
}




}