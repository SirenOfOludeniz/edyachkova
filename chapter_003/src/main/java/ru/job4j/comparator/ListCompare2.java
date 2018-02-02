package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListCompare2 {
    /*public List<List<Integer>> compareListsOfInteger(List<List<Integer>> lists) {
        List<List<Integer>> sortedLists = new ArrayList<List<Integer>>();
        sortedLists.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int resultSize1 = 0;
                int resultArrayElement = 0;
                int counter = 0;
                if (o1.containsAll(o2) && o1.size() == o2.size()) {
                    resultSize1 = 0;
                }
                if (o1.size() > o2.size()) {
                    resultSize1 = 1;
                }
                if (o1.size() < o2.size()) {
                    resultSize1 = -1;
                }
                if (!(o1.containsAll(o2)) && (o1.size() == o2.size())) {
                    for (int i = 1; i < o1.size() + 1; i++) {
                        if (o1.get(i) > o2.get(i)) {
                            resultArrayElement = 1;
                            counter += resultArrayElement;
                        }
                        if (o1.get(i) < o2.get(i)) {
                            resultArrayElement = -1;
                            counter += resultArrayElement;
                        }
                        if (o1.get(i) == o2.get(i)) {
                            resultArrayElement = 0;
                            counter += resultArrayElement;
                        }
                    }
                }

                return resultSize1 != 0 ? resultSize1 : counter ;
            }
        });
        return sortedLists;
    }*/


}
