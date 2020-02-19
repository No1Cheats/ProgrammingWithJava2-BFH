package Exceptions.averageCalculator;

import java.util.List;
import java.util.Scanner;

public class FileNumberSource implements INumberSource{
    String result = "";
    Scanner scanner;

    public FileNumberSource(List<String> numbers) throws InvalidNumberException{
        for(String number:numbers){
            String res = String.join(",",numbers);//converting the ArrayList into a String
            scanner = new Scanner(res);
            scanner.useDelimiter(",");
        }
    }

    @Override
    public boolean hasMoreNumbers() {
        if(scanner.hasNext()){
            return true;
        }
        return false;
    }

    @Override
    public int nextNumber() throws InvalidNumberException {
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        } else {
            throw new InvalidNumberException();
        }
    }
}
