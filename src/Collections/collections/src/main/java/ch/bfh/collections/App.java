package ch.bfh.collections;

import java.util.*;

public final class App {

    private App() {
    }

    static void stringList() {
        // creates a collection of strings
        ArrayList<String> list = new ArrayList<String>();

        // the list collection can only handle strings
        list.add("hello");
        System.out.println(list.get(0));

        Iterable<String> x;
    }

    public static void main(String[] args) {

    }
}
