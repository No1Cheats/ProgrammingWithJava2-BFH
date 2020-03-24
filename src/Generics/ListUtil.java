package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T entry : list) {
            if (predicate.test(entry)) {
                result.add(entry);
            }
        }
        return result;
    }

    public static <T> List<T> map(List<T> list, Function<T> function) {
        List<T> result = new ArrayList<>();
        for (T entry : list) {
            result.add(function.apply(entry));
        }
        return result;
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        T min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            T current = list.get(i);
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> List<T> getLower(List<T> list, T element){
        List<T> result = new ArrayList<>();
        for(T current : list){
            if(current.compareTo(element) <= 0){
                result.add(current);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Sue", "Tom", "Mike", "Pete", "Joe", "Mia", "Zoe", "Tim");

        System.out.println(filter(names, s -> s.startsWith("T")));
        System.out.println(map(names, s -> s.toUpperCase()));
        System.out.println(getMin(names));
        System.out.println(getLower(names, "Pete"));

    }

}
