package ru.job4j.departamentsort;

import java.util.*;

public class SortDepartament {
    public String[] sortNameDepartamens(String[] strings) {
       Comparator<String> nameCompare = new SortByName();
       Arrays.sort(strings, nameCompare);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        return strings;
    }
    public String[] addDepart(String[] deps) {
        String[] strings;
        int counter = 0;
        String lastDepart= deps[deps.length - 1];
        char changeSymbol1, changeSymbol2, changeSymbol3;

        char[] chars;
        int number1, number2, number3;
        changeSymbol1 = lastDepart.charAt(10);
        changeSymbol2 = lastDepart.charAt(5);
        changeSymbol3 = lastDepart.charAt(1);

        System.out.println("charAt = " + lastDepart.charAt(10));
        number1 = Character.getNumericValue(lastDepart.charAt(10));
        number2 = Character.getNumericValue(lastDepart.charAt(5));
        number3 = Character.getNumericValue(lastDepart.charAt(1));

        System.out.println("number = " + number1);
        for (int i = number1; i >= 0 ; i--) {
            --number1;
            //генерируем строку, которую будем искать, и вставим, если не найдем
        lastDepart = lastDepart.substring(0, 9) + number1;
            System.out.println("подстрока с 0 по 9 символ " + lastDepart.substring(0, 9));

            for (int j = 0; j < deps.length; j++) {
                if (deps[j].equals(lastDepart)) {
                    counter++;
                }
                if (counter == 0) {
                    // мне нужно добавить в конец элемент, который отсутствует
                   deps = Arrays.copyOf(deps, deps.length + 1);
                  deps[deps.length - 1] = lastDepart;
                }
            }

        }

        Set<String> names = new HashSet<>();
        return deps;
    }
    public TreeSet<String> addDepartment(ArrayList<String> departs) {
        String[] partDesig;
        TreeSet<String> data = new TreeSet<>(departs);
        TreeSet<String> newdata = new TreeSet<>();
        for (String name : data) { //здесь ConcurrentModificationException
            partDesig = name.split("\\\\");
            for (String value : partDesig) {
                name += value;
                newdata.add(name);
            }
        }
        System.out.println(newdata);
        return newdata;
    }

}
















