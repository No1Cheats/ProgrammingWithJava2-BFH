package Streams.topic09;

public class NamedClassesMain {

  public static void main(String[] args) {

    Runnable r1 = new PrintHelloJohn();
    Runnable r2 = new PrintHelloTom();

    Runnable[] runnables = {r1, r2};
    for (Runnable runnable : runnables) {
      runnable.run();
    }
  }

}
