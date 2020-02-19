package Exceptions;

import java.util.Scanner;

public class ExceptionsExample {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type a number: ");
        int res = scanner.nextInt();
        scanner.close();

        System.out.println("You typed number " + res);
    }

}