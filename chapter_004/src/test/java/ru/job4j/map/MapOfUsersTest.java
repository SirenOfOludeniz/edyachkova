package ru.job4j.map;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class MapOfUsersTest {
    @Test
    public void displayEqualUsersTest() {
        MapOfUsers mapOfUsers = new MapOfUsers();
       mapOfUsers.addEqualFieldUsers();
    }
}