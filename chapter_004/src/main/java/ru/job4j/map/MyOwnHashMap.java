package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyOwnHashMap<K,V> implements Iterable<Entry<K,V>>{
    Entry[] entrySet;
    int indexLength = 0;
    int sizeArray;

    public MyOwnHashMap(int size) {
        this.sizeArray = size;
        this.entrySet = new Entry[size];
    }

    public void overSize() {
        int size;
        Entry[] copy;
        if (this.indexLength == this.entrySet.length) {
            copy = this.entrySet;
            size = this.entrySet.length * 2;
            this.sizeArray = size;
            this.entrySet = new Entry[size];
            System.arraycopy(copy, 0, this.entrySet, 0, copy.length);
        }
    }

    public int hashFunction(int key) {
        return key % this.entrySet.length;
    }

    public boolean contains(K keyUnique) {
        boolean result = false;
        for (Entry<K,V> entry : this.entrySet) {
            if (entry.key.equals(keyUnique) && entry.key.hashCode() == keyUnique.hashCode()) {
                result = true;
            }
        }
        return result;
    }

    public boolean insert(K key, V value) {
        overSize();
        boolean result = true;
        int hash = hashFunction(key.hashCode());
        if (!contains(key)) {
            this.entrySet[hash] = new Entry(key, value);
            indexLength++;
        }
        return true;
    }

    public V get(K key) {
        V aim = null;
        for (Entry<K,V> entry : entrySet) {
            if (entry.key.equals(key)) {
                aim = entry.value;
            }
        }
        return aim;
    }

    public boolean delete(K key) {
        boolean result = true;
        for (Entry<K,V> entry : entrySet) {
            if (entry.key.equals(key)) {
               entry = null;
            }
            else result = false;
        }

        return result;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (entrySet[indexLength] != null) {
                    result = true;
                }
                return result;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                else
                return entrySet[indexLength++];
            }
        };
    }
}

class Entry<K,V> {
    K key;
    V value;
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}