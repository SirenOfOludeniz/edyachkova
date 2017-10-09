package ru.job4j.array;

public class Massivi {
  /* public static void main(String[] args) {
        int[] massiv1 = {1,4,5,6,8};
        int[] massiv2 = {2,3,4};
        int[] massiv3 = new int[massiv1.length + massiv2.length];
        massiv3 = UnitArray(massiv1, massiv2,massiv3);
        for (int i = 0; i < massiv3.length ; i++) {
            System.out.println(massiv3[i]);
        }

    }*/
    public static int[] UnitArray(int[] ar1, int[] ar2, int[] ar3) {
        int size;
        int a = 0;
        int b =0;
        if(ar1.length<ar2.length) size = ar1.length;
        else  size = ar2.length;
        for (int i = 0; i <size ; i++) {
            if(ar1[i] < ar2[i]) {
                ar3[i + a] = ar1[i];
                ar3[i + 1 + a] = ar2[i];
            }
            else { ar3[i + a] = ar2[i];
                  ar3[i + 1 + a] = ar1[i]; }
            a++;
        }
        System.out.println("bu = " + (size*2));

        for (int i = size*2 ; i < ar3.length  ; i++) {
            if(ar1.length > ar2.length) {

                ar3[i] = ar1[ar2.length +b];
            }
            else {ar3[i] = ar2[ar1.length+ b];}
            b++;


        }
        return ar3;
    }
}
