package ru.job4j.departamentsort;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class DepartamentSortTest {
    @Test
    public void sortTest() {
        SortDepartament sort = new SortDepartament();
        /*String[] designations = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };*/
        String[] designations = {
                "K2\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K1\\SK2",
                "K1\\SK1"
        };
        //sort.addDepartment(designations);
        sort.sortNameDepartamens(designations);
//        for (int i = 0; i <  sort.addDepartment(designations).length; i++) {
//            System.out.println(sort.addDepartment(designations)[i]);
//        }
    }
    @Test
    public void addDepartTest() {
        SortDepartament sortDepartament = new SortDepartament();
        String[] designations = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        sortDepartament.addDepart(designations);
    }
    @Test
    public void addDepartamentTest() {
        SortDepartament sortDepartament = new SortDepartament();
        String[] desigs = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        ArrayList<String> designations = new ArrayList<String>();
        //designations= Arrays.asList(desigs);
       Collections.addAll(designations, desigs);
        sortDepartament.addDepartment(designations);
    }
}
