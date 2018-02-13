package ru.job4j.departamentsort;

import java.util.ArrayList;

public class SortDepArrayList {
    public ArrayList<String> addDepartament(ArrayList<String> list) {
        String[] nameDepart;
        //ArrayList<String> allDeps = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String delimeter = "\\\\";
            nameDepart = list.get(i).split(delimeter);

        }

        return list;
    }
    public ArrayList<String> sortDepartament(ArrayList<String> list) {
        return list;
    }
}

