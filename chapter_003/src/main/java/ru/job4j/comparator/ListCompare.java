package ru.job4j.comparator;
/**
 * //компаратор принимает в качестве 1го объекта список
 //и будет сравнивать этот список с кучей других списков
 //если бы тут был метод он бы принимал в кач-ве параметра (List<List<Integer>> list)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class ListCompare implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            int size = 0;
            int element = 0;
            int counter = 0;
            if (o1.containsAll(o2) && o1.size() == o2.size()) {
                size = 0;
            }
            if (o1.size() > o2.size()) {
                size = 1;
            }
            if (o1.size() < o2.size()) {
                size = -1;
            }
            if (!(o1.containsAll(o2)) && (o1.size() == o2.size())) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i)) {
                        element = o1.get(i) > o2.get(i) ? 1 : -1;
                        break;
                    }
                }
            }
            return size != 0 ? size : element;
        }
}
