package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListCompare implements Comparator<List<Integer>> {


    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        int result = 0;
        int resultArrayElement = 0;
        int counter = 0;
        if (o1.size() == o2.size() && o1.containsAll(o2)) {
            result = 0;
        }
        if (o1.size() > o2.size()) {
            result = 1;
        }
        if (o1.size() < o2.size()) {
            result = -1;
        }
        if ((o1.size() == o2.size()) && !(o1.containsAll(o2))) {
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i) > o2.get(i)) {
                    resultArrayElement = 1;
                }
                if (o1.get(i) < o2.get(i)) {
                    resultArrayElement = -1;
                }
                if (o1.get(i) == o2.get(i)) {
                    resultArrayElement = 0;
                }
            }
        }

        return result;
    }


}
