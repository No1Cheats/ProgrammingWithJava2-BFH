// ------------------
// copied from: https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
// (with modifications)
// ------------------
package FileIO.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/FileIO/files/image.png");
            out = new FileOutputStream("src/FileIO/files/image copy.png");
            int c;

            while ((c = in.read()) >= 0) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}