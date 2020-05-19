package Streams.topic09;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ForEachExample3 {

  public static void main(String[] args) {
    Set<String> names = Set.of("Tim", "John", "Sue", "Pete", "Mary");
    int counter = 1;

    // Standard for-each loop
    for (String name : names) {
      System.out.println("Player" + counter++ + ": " + name);
    }

    // Modifying a free variable = NOT OK
    //names.forEach(name -> System.out.println("Player" + counter++ + ": " + name));

    // Using an array of length 1 = hackish, but OK
    int[] arrayCounter = {0};
    names.forEach(name -> System.out.println("Player" + arrayCounter[0]++ + ": " + name));

    // Using an AtomicInteger = OK
    AtomicInteger atomicCounter = new AtomicInteger(0);
    names.forEach(name -> System.out.println("Player" + atomicCounter.getAndIncrement() + ": " + name));

  }
}
