package Generics;

public class SeriesTester {

    public static void main(String[] args) {
        Series<Integer> s1 = new Series<Integer>(0, x -> x + 1, x -> x <= 10);
        Series<Integer> s2 = new Series<Integer>(1, x -> 2 * x, x -> x <= 80);
        Series<String> s3 = new Series<String>("", s -> s + "*", s -> s.length() < 7);
        Series<String> s4 = new Series<String>("Hello", s -> s.substring(0, s.length() - 1), s -> !s.equals(""));

        while (s1.hasNext()) {
            System.out.print(s1.next() + " ");
        }
        System.out.println();
        s1.reset();

        int i = 1;
        for (Series<?> series : new Series[] { s1, s2, s3, s4 }) {
            System.out.print("s" + (i++) + " = ");
            System.out.println(series.toList());
        }

    }
}
