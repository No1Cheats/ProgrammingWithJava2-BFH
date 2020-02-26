package FileIO.ex2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        encryptFile("src/FileIO/files/test", 2);
        decryptFile("src/FileIO/files/testencrypted", 2);
    }

    public static void encryptFile(String path, int num) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(path);
            out = new FileOutputStream(path + "encrypted");
            int c;

            while ((c = in.read()) >= 0) {
                if (c != 32) {
                    out.write(c + (num % 26));
                } else {
                    out.write(32);
                }

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

    public static void decryptFile(String path, int num) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(path);
            out = new FileOutputStream(path + "decrypted");
            int c;

            while ((c = in.read()) >= 0) {
                if (c != 32) {
                    out.write(c - (num % 26));
                } else {
                    out.write(32);
                }

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
