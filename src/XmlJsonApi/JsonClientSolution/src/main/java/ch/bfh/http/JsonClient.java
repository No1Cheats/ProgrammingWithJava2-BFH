package ch.bfh.http;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.bfh.models.Person;

public class JsonClient {

	public static void main(String[] args)  {

        final String URL_BASE = "http://localhost:8080/people/";

        String search = "";
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.print("Enter your search argument: ");
            search = scanner.nextLine();

            if (search.length() > 0) {

                try {
                    URL url = new URL(URL_BASE + search);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    
                    conn.setRequestMethod("GET");
                    conn.connect();
                    int res = conn.getResponseCode();
                    if (res != 200) {
                        System.out.format("Response code %d is not ok.\n");
                    }
                    else {
                        ObjectMapper mapper = new ObjectMapper();
                        Person[] result = mapper.readValue(url.openStream(), Person[].class);

                        System.out.format("search result %d:\n", result.length);
                        for (int i=0; i<result.length; i++) {
                            System.out.format("\t%d\t %s\t %s\t %s\t %s\n",
                                result[i].getId(), 
                                result[i].getName(), 
                                result[i].getFirstname(), 
                                result[i].getZIP(), 
                                result[i].getCity());
                        }
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();;
                }
            }

        } while (search.length() > 0);

        scanner.close();

	}

}
