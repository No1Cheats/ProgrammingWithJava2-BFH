package Generics;

import java.util.ArrayList;
import java.util.List;

public class ComparablePair <S extends Comparable<S>, T extends Comparable<T>> extends Pair<S, T>
        implements Comparable<Pair<S, T>> {


    public ComparablePair(S first, T second) {
        super(first, second);
    }

    @Override
    public int compareTo(Pair<S, T> other) {
        int c = this.getFirst().compareTo(other.getFirst());
        if (c == 0) {
            return this.getSecond().compareTo(other.getSecond());
        }
        return c;
    }


    public static void main(String[] args) {
        ComparablePair<Integer, String> p1 = new ComparablePair<>(3, "Hello");
        ComparablePair<Integer, String> p2 = new ComparablePair<>(3, "World");
        ComparablePair<Integer, String> p3 = new ComparablePair<>(2, "Hello");
        ComparablePair<Integer, String> p4 = new ComparablePair<>(2, "World");
        ComparablePair<Integer, String> p5 = new ComparablePair<>(4, "Hello");
        ComparablePair<Integer, String> p6 = new ComparablePair<>(4, "World");

        List<ComparablePair<Integer, String>> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);

        //Collections.sort(list);
        System.out.println(list);
    }

}
