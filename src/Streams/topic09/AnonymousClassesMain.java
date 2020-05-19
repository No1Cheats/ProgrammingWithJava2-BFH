package Streams.topic09;

public class AnonymousClassesMain {

  public static void main(String[] args) {

    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello John!");
      }
    };

    Runnable r2 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello Tom!");
      }
    };

    Runnable[] runnables = {r1, r2};
    for (Runnable runnable : runnables) {
      runnable.run();
    }
  }

}
