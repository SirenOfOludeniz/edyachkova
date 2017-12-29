package ru.job4j.coffeemachine;

public class CoffeeMachine {
    public static void main(String[] args) {
        int[] nums = {15, 7, 1};
        //universalcoins(100, 35, nums);
        for (int i = 0; i < universalcoins(100, 35, nums).length; i++) {
            System.out.println(universalcoins(100, 35, nums)[i]);

        }
    }
    /*public static void main(String[] args) {
        System.out.println(5/7);
//        for (int i = 0; i < changes(50, 35).length; i++) {
//            System.out.println(changes(50, 35)[i]);
//
//        }
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
    }*/

    public static int[] universalcoins(int value, int price, int[] coins) {
        //нужно ли сначала отсортировать по убыванию входящий массив int[] coins?
        int change = value - price;
        int sumcoins;
        int counter = 0;
        int[] arraymonetki = new int[coins.length]; //каждый элемент хранит количество монеток одного номинала

            for (int i = 0; i < coins.length ; i++) {
                if (change/coins[i] != 0) { //почему здесь coins[0] = 0, а не 15
                sumcoins = change/coins[i];
                arraymonetki[i] = sumcoins;
                change = change - (sumcoins*coins[i]);
                counter = sumcoins + counter;
                }
                else coins[i] = 0;
            }
            int counter2 = 0;
        int[] changes = new int[counter];

        for (int j = 0; j < coins.length ; j++) {
            if (coins[j] != 0) {
            for (int i = 0; i <arraymonetki[j] ; i++) {
                    changes[counter2++] = coins[j];

                }
            }
        }

        return changes;
    }
}
