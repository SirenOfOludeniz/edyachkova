package ru.job4j.service;

import java.lang.reflect.ParameterizedType;

public class AbstractSimpleClass<E> {


    Object[] objects;
    int index = 0;

    public AbstractSimpleClass(int size) {
        this.objects = new Object[size];
        Class<E> t = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            E value = t.newInstance();
            System.out.printf("string " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public <K> K print(K value) {
        System.out.println(value);
        return value;
    }

    public void add(E value) { //lowCasting понижаем тип до типа Object
        this.objects[index++] = value;
    }

    public E get(int position) {
        //делаем приведение типов
        return (E) this.objects[position];

    }
}
