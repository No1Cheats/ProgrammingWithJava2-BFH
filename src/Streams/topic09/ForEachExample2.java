package Streams.topic09;

import java.util.Set;

public class ForEachExample2 {

  public static void main(String[] args) {

    Set<String> names = Set.of("Tim", "John", "Sue", "Pete", "Mary");
    String label = "Player: ";

    // Standard for-each loop
    for (String name : names) {
      System.out.println(label + name);
    }

    // Reading a free variable = OK
    names.forEach(name -> System.out.println(label + name));
  }

}
