import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyGoodPractice {

    public static void main(String[] args) throws Exception {

        try {
            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(".\\files\\noFile.txt"));
                System.out.println("Reading number from file");
                int res = scanner.nextInt();
                System.out.println("number is " + res);
            }
            finally {
                if (scanner != null)
                    scanner.close();
                System.out.println("Scanner closed");
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("This is not a correct number");
        }
        catch (Exception ex) {
            System.out.println("Something went wrong");
        }
    }
}