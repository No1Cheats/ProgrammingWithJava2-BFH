package Exceptions.averageCalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws InvalidNumberException, IOException {

        //INumberSource source = new RandomNumberSource(5);
        //INumberSource source = new StringNumberSource("7,5,9,11");

        BufferedReader in = new BufferedReader(new FileReader(".\\files\\goodData.txt"));
        List<String> numbers = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null){
            numbers.add(line);
        }

        INumberSource source = new FileNumberSource(numbers);


        int sum = 0;
        int count = 0;

        while (source.hasMoreNumbers()) {
            sum += source.nextNumber();
            count ++;
        }

        System.out.println("Average is " + (sum / count));
    }
}