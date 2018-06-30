package ru.job4j.service;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
@ThreadSafe
public class DynamicArray<E> implements SimpleContainer<E> {
    @GuardedBy("this")
   volatile Object[] container = new Object[10];
   volatile int index = 0;
   volatile int modCount = 0;

    public DynamicArray() {
        //зачем я его тут использую 0_о?
        arraycopy();
    }

    public void arraycopy() {
        synchronized (this) {
            int size = 0;
            Object[] copy = new Object[container.length];
            if (index == container.length) {
                copy = this.container;
                size = ((this.container.length * 3)/2 + 1);
                this.container = new Object[size];
                System.arraycopy(copy, 0, this.container, 0, copy.length);
            }
        }

    }


    @Override
    public void add(E o) {
        synchronized (this) {
            arraycopy();
            this.container[index++] = o;
            this.modCount++;
        }
    }

    @Override
    public E get(int position) {
        synchronized (this) {
            return (E) this.container[position];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int indexIter;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index < container.length && DynamicArray.this.container[indexIter] != null) {
                    result = true;
                }
                return result;
            }

            /**
             *  Object[] container = DynamicArray.this.container;
             *  скопировано из метода next в ArrayList
             *  там нечно похожее
             *
             */

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] containerIterator = DynamicArray.this.container;
                if (indexIter >= containerIterator.length) {
                    throw new ConcurrentModificationException();
                }
               // System.out.println("modCount = " + modCount);
                // System.out.println("expectedModCount = " + expectedModCount);


                return (E)DynamicArray.this.container[indexIter++];

            }
        };
    }
}
