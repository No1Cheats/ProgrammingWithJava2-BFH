package Exceptions.averageCalculator.solution;

public class App {

    public static void main(String[] args) {

        //INumberSource source = new RandomNumberSource(15);
        //INumberSource source = new StringNumberSource("7.5,5.55.55,9.5,11");
        INumberSource source = new FileNumberSource(".\\files\\bigData.txt");
        long sum = 0L;
        int count = 0;

        while (source.hasMoreNumbers()) {
            try {
                sum += source.nextNumber();
                count ++;
            }
            catch (InvalidNumberException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(sum + " / " + count);
        if (count > 0)
            System.out.println("Average is " + (sum / count));
        else
            System.out.println("no valid numbers in number source");
    }
}