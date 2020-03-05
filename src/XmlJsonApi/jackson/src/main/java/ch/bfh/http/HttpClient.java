package ch.bfh.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

	public static void main(String[] args)  {

        try {
            URL url = new URL("https://www.bfh.ch");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();
            int res = conn.getResponseCode();
            if (res != 200) {
                System.out.format("Response code %d is not ok.\n");
            }
            else {
                BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
                String line = "";
                while ((line = rdr.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();;
        }
	}

}
