package Streams.topic09;

public class LambdaExpressionsMain {

  public static void main(String[] args) {

    Runnable r1 = () -> System.out.println("Hello John!");
    Runnable r2 = () -> System.out.println("Hello Tom!");

    Runnable[] runnables = {r1, r2};
    for (Runnable runnable : runnables) {
      runnable.run();
    }
  }

}
