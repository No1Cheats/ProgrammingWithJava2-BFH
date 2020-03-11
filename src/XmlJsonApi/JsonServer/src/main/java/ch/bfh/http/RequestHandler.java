package ch.bfh.http;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Date;

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

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.readValue(new File("src/XmlJsonApi/JsonServer/post.json"), ObjectNode.class);
        System.out.println(node.get("Java").asText());


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
