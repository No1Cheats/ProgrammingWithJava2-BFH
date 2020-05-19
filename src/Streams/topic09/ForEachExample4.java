package Streams.topic09;

import java.util.Set;

public class ForEachExample4 {

  public static void main(String[] args) {

    Set<String> names = Set.of("Tim", "John", "Sue", "Pete", "Mary");

    names.forEach(System.out::println);
  }

}
