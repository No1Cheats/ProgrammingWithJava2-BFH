package FileIO.ex1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Creating the directory people.csv if it doesn't already exist
        File file = new File("src/FileIO/people.split");
        boolean directoryCreated = file.mkdir();
        if (directoryCreated) {
            System.out.println("Directory created");
        }

        //Try in-case we can't find the people.csv file
        try (BufferedReader br = new BufferedReader(new FileReader("src/FileIO/files/people.csv"))) {
            String line;
            BufferedWriter bw = null;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                FileWriter fw = new FileWriter("src/FileIO/people.split/" + values[1].charAt(0) + ".split", true);
                bw = new BufferedWriter(fw);
                bw.write(line);
                bw.flush();
            }
            bw.close();
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("people.csv can't be found");
        }
    }
}
