package ch.bfh.http;

import java.util.Scanner;

public class JsonClient {

	public static void main(String[] args)  {

        final String URL_BASE = "base URL for your json server";

        String search = "";
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.print("Enter your search argument: ");
            search = scanner.nextLine();

            if (search.length() > 0) {

            }

        } while (search.length() > 0);

        scanner.close();

	}

}
