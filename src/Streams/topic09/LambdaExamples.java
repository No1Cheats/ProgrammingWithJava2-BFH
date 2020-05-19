package Streams.topic09;

public class LambdaExamples {

  public static void main(String[] args) {

    FunctionalInterface f1, f2, f3, f4;

    // General form
    f1 = (String str, int x) -> {
      return str.length() <= x;
    };

    // Short form 1: Inferred parameter types
    f2 = (str, x) -> {
      return str.length() <= x;
    };

    // Short form 2: Single-line return value
    f3 = (str, x) -> str.length() <= x;

    // Different parameter names
    f4 = (s, l) -> s.length() <= l;

    FunctionalInterface[] array = {f1, f2, f3, f4};
    for (FunctionalInterface f_i : array) {
      System.out.println(f_i.apply("Hello", 4));
    }
    // prints 4x "false"
  }

}
