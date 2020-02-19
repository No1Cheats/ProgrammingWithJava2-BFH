import java.util.Scanner;

public class ExceptionsExampleCorrected {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type a number: ");
        int res = 0;
        if (scanner.hasNextInt())
            res = scanner.nextInt();
        scanner.close();

        System.out.println("You typed number " + res);
    }

}