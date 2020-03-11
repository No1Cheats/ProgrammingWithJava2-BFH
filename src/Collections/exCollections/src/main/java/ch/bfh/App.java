package ch.bfh;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class App {

    private static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/Collections/exCollections/files/people.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            Person person = new Person(line);
            people.add(person);
        }
        br.close();

        //Mehrer Listne programmieren die IList implementiere


        long startTime = System.currentTimeMillis();

        String myPerson = people.get(10).getName();
        System.out.println(myPerson);

        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time was: " + (endTime-startTime) + "ms.");
        System.out.println("done.");
    }


}
