package ru.job4j.map;

import org.junit.Test;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class MapTestTest {
    @Test
    public void mapTest() {
        MapTest mapTest = new MapTest();
        MapTest.User first = new MapTest.User("Petr");
        MapTest.User second = new MapTest.User(null);
        System.out.println(first.equals(second));
        //assertThat(first, is(second));


       /* Map<MapTest.User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);*/

       MapTest.User third = new MapTest.User(null);
        //System.out.println(third.name == null);
    }

}