package FileIO.nio;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
import java.io.IOException;
import java.net.URI;

public class SmallFiles {

    public static void main(String[] args) throws Exception {

        Path file = Paths.get("./files/image.png");
        byte[] image = Files.readAllBytes(file);
        System.out.println(image.length + " bytes read");

        file = Paths.get("./files/goodData.txt");
        List<String> lines = Files.readAllLines(file, Charset.forName("UTF-8"));
        System.out.println(lines.size() + " lines read");
    }
}