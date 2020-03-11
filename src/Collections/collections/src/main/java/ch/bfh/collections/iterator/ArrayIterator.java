package ch.bfh.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E> {

    private E[] array;
    private int nextIndex;

    public ArrayIterator(E[] array) {
        this.array = array;
        this.nextIndex = 0;
    }
    @Override
    public boolean hasNext() {
        return nextIndex < ((array == null) ? 0 : array.length);
    }

    @Override
    public E next() {
        if (!this.hasNext())
            throw new NoSuchElementException();
        return array[nextIndex++];
    }

    public static void main(String[] args) {
        
        String[] array = new String[] { "alpha", "beta", "gamma" };
        ArrayIterator<String> iterator = new ArrayIterator<>(array);

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

}