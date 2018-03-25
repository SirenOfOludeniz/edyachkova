package ru.job4j.service;

public class LinkedNode<T> {
    Node<T> first;

    public Node<T> linked() {
         this.first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        this.first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        return first;
    }

    boolean hasCycle(Node first) {
        boolean result = false;
        Node<T> check = first;
       Node<T> current = first;
        while (current.next != null) {
            check = current;
           while (current.next != null) {
               if (current.next == check) {
                   result = true;
                   break;
               }
               current = current.next;
           }
            //во внешнем же цикле значение current не меняется?
           current = check; //на случай, если меняется из-за внутреннего цикла
            current = current.next;
        }
        return result;

    }

}
