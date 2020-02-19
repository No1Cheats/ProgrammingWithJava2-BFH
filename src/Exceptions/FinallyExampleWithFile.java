package Exceptions;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyExampleWithFile {

    public static void main(String[] args) throws Exception {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(".\\files\\goodData.txt"));
            System.out.println("Reading number from file");
            int res = scanner.nextInt();
            System.out.println("number is " + res);
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