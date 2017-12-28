package ru.job4j.coffeemachine;

public class CoffeeMachine {
    public static void main(String[] args) {
        for (int i = 0; i < changes(50, 35).length; i++) {
            System.out.println(changes(50, 35)[i]);

        }
    }
    public static int[] changes(int value, int price) {
        int moneta10, moneta5, moneta2, moneta1;
        int counter = 0;
        int change = value - price;
       moneta10 = change/10;
       moneta5 = (change - (moneta10*10))/5;
       moneta2 = (change - ((moneta5 *5) + (moneta10*10)))/2;
       moneta1 = change -((moneta10*10) + (moneta5*5) + (moneta2*2));
       counter = moneta1 + moneta2 + moneta5 + moneta10;
       int[] changessss = new int[counter];
        for (int i = 0; i < moneta10 ; i++) {
            changessss[i] = 10;
        }
        for (int i = moneta10; i < moneta5 + moneta10 ; i++) {
            changessss[i] = 5;
        }
        for (int i = moneta10 + moneta5; i < moneta10 + moneta5 + moneta2; i++) {
            changessss[i] = 2;

        }
        for (int i = moneta10 + moneta5 + moneta2; i < moneta10 + moneta5 + moneta2 + moneta1; i++) {
            changessss[i] = 1;

        }
        return changessss;
    }
}
