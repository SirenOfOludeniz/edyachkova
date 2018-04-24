package ru.job4j.tree;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void treeTest() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);
        tree.add(10);
        tree.add(3);
        tree.add(20);
        tree.add(35);
        tree.add(7);
        tree.add(23);
        tree.add(100);
        tree.add(90);
        tree.add(150);

        assertThat(tree.find(20, 5),is(20));
        assertThat(tree.find(3,5),is(3));
        assertThat(tree.find(10, 5),is(10));
        assertThat(tree.find(35,5),is(35));
        assertThat(tree.find(7,5),is(7));
        assertThat(tree.find(23, 5),is(23));
        assertThat(tree.find(100, 5),is(100));
        assertThat(tree.find(90, 5),is(90));


        Iterator<Integer> iterrr = tree.iterator();
        while (iterrr.hasNext()) {
            System.out.println("next " + iterrr.next());
        }




























    }

}