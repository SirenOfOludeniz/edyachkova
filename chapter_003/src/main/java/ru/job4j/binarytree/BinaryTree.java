package ru.job4j.binarytree;


public class BinaryTree {


}
class Node {
    int iData;
    double fData;
    Node leftChild; // и здесь
    Node rightChild; //здесь почему-то было node
    public void displayNode() {

    }
}
class Tree {
    private Node root;
    public Node find(int key) {
        Node current = root; //начать с корневого узла
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }
    public void insert(int id, double dd) {

    }
    public void delete(int id) {

    }
}
class TreeApp {
    public static void main(String[] args) {
        Tree theTree = new Tree();
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);

        Node found = theTree.find(25);
        if (found != null) {
            System.out.println("Found the node with key 25");
        } else {
            System.out.println("Could not find node with key 25");
        }
    }
}
