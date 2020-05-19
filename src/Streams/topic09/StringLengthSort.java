package Streams.topic09;

import java.util.Arrays;
import java.util.Comparator;

public class StringLengthSort {

  static String[] names = {"Tim", "John", "Sue", "Peter", "Mary"};

  public static void main(String[] args) {

    // Version 1: Anonymous class
    Arrays.sort(names, new Comparator<String>() {
      @Override
      public int compare(String str1, String str2) {
        return str1.length() - str2.length();
      }
    });

    // Version 2: Lambda expression
    Arrays.sort(names, (s1, s2) -> s1.length() - s2.length());
  }
}
