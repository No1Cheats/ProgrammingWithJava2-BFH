package Exceptions.averageCalculator;

public class App {

    public static void main(String[] args) {

        //INumberSource source = new RandomNumberSource(0);
        //INumberSource source = new StringNumberSource("7,5,9,11");

        int sum = 0;
        int count = 0;

        /*while (source.hasMoreNumbers()) {
            sum += source.nextNumber();
            count ++;
        }*/

        System.out.println("Average is " + (sum / count));
    }
}