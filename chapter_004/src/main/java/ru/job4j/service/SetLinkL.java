package ru.job4j.service;

public class SetLinkL<E> extends DynamicLinkedList<E> {
    @Override
    public void add(E value) {
        //todo переменная size откуда? пока замена на метод
//        for (int i = 0; i < size; i++) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(value)) {
                return;
            }
        }
        super.add(value);
    }
}
