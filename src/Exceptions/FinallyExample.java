package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyExample {

    public static void main(String[] args) throws Exception {

        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            System.out.print("Please type a number: ");
            int res = scanner.nextInt();
            System.out.println("You typed number " + res);
        }
        catch (InputMismatchException ex){
            System.out.println("This is not a correct number");
        }
        finally {
            scanner.close();
            System.out.println("Scanner closed");
        }


    }

}