package Streams.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Series<V> implements Iterator<V> {

    private V initialValue;
    private V currentValue;
    private Function<V> update;
    private Predicate<V> condition;

    public Series(V initialValue, Function<V> update, Predicate<V> condition) {
        this.initialValue = initialValue;
        this.currentValue = initialValue;
        this.update = update;
        this.condition = condition;
    }

    private Series() {
    }

    public Series(V initialValue, Function<V> update, V endValue) {
        this(initialValue, update, value -> !value.equals(update.apply(endValue)));
    }

    public boolean hasNext() {
        return this.condition.test(this.currentValue);
    }

    public V next() {
        if (!this.hasNext()) {
            throw new IllegalStateException();
        }
        V next = this.currentValue;
        this.currentValue = this.update.apply(this.currentValue);
        return next;
    }

    public void reset() {
        this.currentValue = this.initialValue;
    }

    public List<V> toList() {
        List<V> list = new ArrayList<>();
        V currentValue = this.currentValue;
        this.currentValue = this.initialValue;
        while (this.hasNext()) {
            list.add(this.next());
        }
        this.currentValue = currentValue;
        return list;
    }

    public Series<V> map(Function<V> function) {

        Series<V> parent = this;

        return new Series<V>() {

            @Override
            public boolean hasNext() {
                return parent.hasNext();
            }

            @Override
            public V next() {
                V next = parent.next();
                return function.apply(next); //This is where its at function is applied before it is returned
            }

            @Override
            public void reset() {
                parent.reset();
            }
        };
    }

    public Series<V> limit(long maxLength) {

        Series<V> parent = this;

        return new Series<V>() {

            private int counter = 0;

            @Override
            public boolean hasNext() {
                return (this.counter < maxLength) && parent.hasNext();
            }

            @Override
            public V next() {
                this.counter++;
                return parent.next();
            }

            @Override
            public void reset() {
                this.counter = 0;
                parent.reset();
            }
        };
    }

    public static void main(String[] args) {

        //Series<Integer> s1 = new Series<>(0, x -> x + 1, x -> x <= 10);
        //System.out.println(s1.toList());
        // prints [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        //Series<Integer> s2 = s1.map(x -> x * x).limit(5);
        //System.out.println(s2.toList());
        // prints [0, 1, 4, 9, 16]
    }



}
