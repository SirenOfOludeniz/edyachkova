package ru.job4j.comparator;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;
public class ListCompareTest {
   @Test
   public void comapareListTestLeftEqualRight() {
       ListCompare listCompare = new ListCompare();
       ArrayList<Integer> list = new ArrayList<>();
       ArrayList<Integer> list1 = new ArrayList<>();
       list.addAll(Arrays.asList(4, 1, 0));
       list1.addAll(Arrays.asList(4, 1, 0));
       System.out.println(listCompare.compare(list, list1));
       int result = 0;
       assertThat(listCompare.compare(list, list1), is(result));
   }
   @Test
    public void compareListLeftLessThanRight() {
       ListCompare listCompare = new ListCompare();
       ArrayList<Integer> list = new ArrayList<>();
       ArrayList<Integer> list1 = new ArrayList<>();
       list.addAll(Arrays.asList(2, 1, 4, 5, 9));
       list1.addAll(Arrays.asList(4, 1, 0, 2, 9));
       System.out.println(listCompare.compare(list, list1));
       int result = -1;
       assertThat(listCompare.compare(list, list1), is(result));
   }
   @Test
    public void compareListWhenLeftGreaterThanRight() {
       ListCompare listCompare = new ListCompare();
       ArrayList<Integer> list = new ArrayList<>();
       ArrayList<Integer> list1 = new ArrayList<>();
       list.addAll(Arrays.asList(2, 1, 4, 5, 9));
       list1.addAll(Arrays.asList(0, 3, 0, 2, 9));
       System.out.println(listCompare.compare(list, list1));
       int result = 1;
       assertThat(listCompare.compare(list, list1), is(result));
   }
}
