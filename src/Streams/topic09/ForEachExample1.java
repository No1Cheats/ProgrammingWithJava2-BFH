package Streams.topic09;

import java.util.Set;

public class ForEachExample1 {

  public static void main(String[] args) {

    Set<String> names = Set.of("Tim", "John", "Sue", "Pete", "Mary");

    // Standard for-each loop
    for (String name : names) {
      System.out.println(name);
    }

    // For-each loops with lambda expression
    names.forEach(name -> System.out.println(name));
    
    // Version with method reference
    names.forEach(System.out::println);
  }
}
