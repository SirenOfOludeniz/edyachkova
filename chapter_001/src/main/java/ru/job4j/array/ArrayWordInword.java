package ru.job4j.array;

public class ArrayWordInword {
    /*public static void main(String[] args) {
        String fullword = "dinozavr";
        String shortword = "dino";
        System.out.println(contains(fullword,shortword));
    }*/
    public static boolean contains(String origin, String bun) {
       char[] full = origin.toCharArray();
       boolean a = false;

        for (int i = 0; i < (origin.length() - bun.length()) + 1; i++) {
            String fulw = new String(full, i, (bun.length()));
            System.out.println("fulw " + fulw);
            if (fulw.equals(bun)) {
                a = true;
                break;
            } else {
                a = false;
            }
            System.out.println(fulw);
        }

        return a;
    }
    }


