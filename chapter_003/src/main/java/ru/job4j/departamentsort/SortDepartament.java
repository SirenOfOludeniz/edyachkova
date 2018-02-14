package ru.job4j.departamentsort;

import java.util.*;

public class SortDepartament {
    public String[] sortNameDepartamens(String[] strings) {
       Comparator<String> nameCompare = new SortByName();
       Arrays.sort(strings, nameCompare);
       for (String name : strings) {
           System.out.println(name);
       }
        return strings;
    }

    public TreeSet<String> addDepartment(ArrayList<String> departs) {
        String[] partDesig;
        TreeSet<String> data = new TreeSet<>(departs);
        System.out.println(data);
        TreeSet<String> newdata = new TreeSet<>();
        //String name = "";
        for (String dep : data) {
            String name = "";
            partDesig = dep.split("\\\\");
            for (String value : partDesig) {
                if (name.length() > 1) {
                    name = name + "\\" + value;
                } else {
                    name += value;
                }
                newdata.add(name);
            }
        }
        System.out.println(newdata);
        return newdata;
    }
    public ArrayList<String> sortReversed(TreeSet<String> set) {
        ArrayList<String> list = new ArrayList<>(set);
        Collections.reverse(list);
        System.out.println(list);
        return list;
    }

}
















