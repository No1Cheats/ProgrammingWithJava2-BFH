import java.util.Scanner;

public class ExceptionMisuse {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type a number: ");

        int res = 0;
        try {
            res = scanner.nextInt();
        }
        catch (Exception ex) {
            double d = scanner.nextDouble();
            res = (int)Math.round(d);
        }

        scanner.close();

        System.out.println("You typed number " + res);
    }

}