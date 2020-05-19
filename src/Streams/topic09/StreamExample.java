package Streams.topic09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamExample {

  public static void main(String[] args) {

    List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "c1", "d1", "c3", "a3");

    // Iterative solution
    List<String> filteredList = new ArrayList<>();
    for (String s : list) {
      if (s.startsWith("c")) {
        filteredList.add(s.toUpperCase());
      }
    }
    Collections.sort(filteredList);
    for (String s : filteredList) {
      System.out.println(s); // prints C1 C2 C3
    }

    // Solution with streams
    list.stream()
      .filter(s -> s.startsWith("c"))
      .map(String::toUpperCase)
      .sorted()
      .forEach(System.out::println); // prints C1 C2 C3
  }

}
