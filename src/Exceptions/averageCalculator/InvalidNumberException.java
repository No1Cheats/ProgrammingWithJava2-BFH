package Exceptions.averageCalculator;

public class InvalidNumberException extends Throwable{
    public InvalidNumberException(){
        System.out.println("Not a number");
    }
}
