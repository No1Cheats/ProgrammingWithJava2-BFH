package ch.bfh.http;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class RequestHandler implements Runnable {

    static final Charset UTF8 = Charset.forName("UTF-8");

    private Socket socket;
    private OutputStream out;

    public RequestHandler(Socket s) {
        socket = s;
    }

    protected void print(String s) throws IOException{
        out.write(s.getBytes(UTF8));
    }

    protected void sendHeader(String type) throws IOException {
        print("HTTP/1.1 200 OK\n");
        print("Server: Simple HTTP Server 1.0\n");
        print(String.format("Date: %s\n", new Date()));
        print(String.format("Content-type: %s\n", type));
    }

    protected void sendHtml(String html) throws IOException {

        sendHeader("text/html");

        byte[] buf = (html == null) ? new byte[0] : html.getBytes(UTF8);
        print(String.format("Content-length: %d\n\n", buf.length));
        out.write(buf);

        out.flush();
        out.close();
    }

    protected void sendPeopleSearchResult(String search) throws IOException {

        System.out.println("searching for '" + search + "'");

        sendHeader("application/json");

        JsonFactory factory = new JsonFactory();
        StringWriter json = new StringWriter(512);
        JsonGenerator generator = factory.createGenerator(json);

        generator.writeStartArray(); // Start with left bracket i.e. [

        if (search != null && search.length() > 0) {

            Path source = Paths.get(String.format("src/XmlJsonApi/JsonServerSolution/files/people.csv.split/%s.split", search.charAt(0)));

            try (BufferedReader in = Files.newBufferedReader(source, UTF8)) {

                String line = null;

                while ((line = in.readLine()) != null) {

                    String[] values = line.split(",");

                    if (values[1].startsWith(search)) {
                        generator.writeStartObject(); // Start with left brace i.e. {
                        generator.writeStringField("id", values[0]);
                        generator.writeStringField("name", values[1]);
                        generator.writeStringField("firstname", values[2]);
                        generator.writeStringField("zip", values[3]);
                        generator.writeStringField("city", values[4]);
                        generator.writeEndObject(); // End with right brace i.e }
                    }
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }

        // Close JSON generator and string writer
        generator.close();
        json.close();

        byte[] buf = json.toString().getBytes(UTF8);
        print(String.format("Content-length: %d\n\n", buf.length));
        out.write(buf);

        out.flush();
        out.close();
    }

    @Override
	public void run() {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF8));
             OutputStream out = socket.getOutputStream()) {

            this.out = out;
            String input = in.readLine();

            if (input != null && input.startsWith("GET")) {

                String url = input.substring(4, input.indexOf(' ', 5)).trim();
                System.out.println("GET " + url);

                if (url.startsWith("/people/")) {
                    sendPeopleSearchResult(url.substring(8));
                }
                else {
                    sendHtml("<html><head></head><body><h1>HTML-Request with url: '"+url+"'</h1></body></html>");
                }
			}

		} catch (IOException ex) {
			System.err.println("Server error : " + ex);
		}

	}

}
