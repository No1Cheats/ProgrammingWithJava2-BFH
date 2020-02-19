package Exceptions.averageCalculator;

import java.util.Scanner;

public class StringNumberSource implements INumberSource {
    Scanner scanner;

    public StringNumberSource(String numbers){
        scanner = new Scanner(numbers);
        scanner.useDelimiter(",");
    }

    @Override
    public boolean hasMoreNumbers() {
        if(scanner.hasNext()){
            return true;
        } else {
            scanner.close();
            return false;
        }
    }

    @Override
    public int nextNumber() throws InvalidNumberException {
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }else{
            scanner.close();
            throw new InvalidNumberException();
        }
    }
}
