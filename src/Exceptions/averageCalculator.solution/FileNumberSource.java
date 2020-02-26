package Exceptions.averageCalculator.solution;

import java.io.*;
import java.util.Scanner;

public class FileNumberSource implements INumberSource {

    Scanner scanner;
    
    public FileNumberSource(String path) {
        try {
            scanner = new Scanner(new File(path));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            scanner = null;
        }
    }

    public boolean hasMoreNumbers() {
        return ((scanner != null) && (scanner.hasNextLine()));
    }

    public int nextNumber() throws InvalidNumberException {
        try {
            return scanner.nextInt();
        }
        catch (NumberFormatException ex) {
            throw new InvalidNumberException(ex);
        }
   }
}
