package FileIO.nio;

import java.nio.file.*;
import java.io.IOException;
import java.net.URI;

public class UsingPath {

    static void showPathInfo(Path p, String title) {
        System.out.println(title);
        System.out.format("\ttoString: %s%n", p.toString());
        System.out.format("\tgetFileName: %s%n", p.getFileName());
        System.out.format("\tgetNameCount: %d%n", p.getNameCount());
        for (int i=0; i<p.getNameCount(); i++)
            System.out.format("\t\tgetName(%d): %s%n", i, p.getName(i));
        System.out.format("\tsubpath(0,2): %s%n", p.subpath(0,2));
        System.out.format("\tgetParent: %s%n", p.getParent());
        System.out.format("\tgetRoot: %s%n", p.getRoot());
    }

    static void paths() {

        // a relative path
        Path p = Paths.get("./files");
        showPathInfo(p, "./files");

        // an absolute path
        p = FileSystems.getDefault().getPath("/users/prm1");
        showPathInfo(p, "/users/prm1");

        // a URI path
        p = Paths.get(URI.create("file:///Users/prm1/UsingPath.java"));
        showPathInfo(p, "file:///Users/prm1/UsingPath.java");

        // normalizing a path
        p = Paths.get("./files/../files/./image.png");
        showPathInfo(p.normalize(), "./files/../files/./image.png -> normalized");

        // relative to absolute
        p = Paths.get("./files/../files/./image.png");
        showPathInfo(p.toAbsolutePath(), "./files/../files/./image.png -> toAbsolutePath");

        // TODO: examine Path.relativize and Path.resolve

        // TODO: compare paths using Path.equals, Path.startsWith, and Path.endsWith
    }

    static void checkAccessibility(Path p) {
        System.out.format("%s:\n", p.toString());
        System.out.format("\texists: %b\n", Files.exists(p));
        System.out.format("\tnotExists: %b\n", Files.notExists(p));
        System.out.format("\tisRegularFile: %b\n", Files.isRegularFile(p));
        System.out.format("\tisReadable: %b\n", Files.isReadable(p));
        System.out.format("\tisWriteable: %b\n", Files.isWritable(p));
        System.out.format("\tisExecutable: %b\n", Files.isExecutable(p));
    }

    static void fileAccessibility() {
        checkAccessibility(Paths.get("./files/"));
        checkAccessibility(Paths.get("./files/image.png"));
        checkAccessibility(Paths.get("./files/notexisting.file"));
    }

    static void copyFile(Path from, Path to) throws IOException{
        try {
            Files.copy(from, to);
        }
        catch (FileAlreadyExistsException ex) {
            System.out.println("copy destination already exists");
        }

    }

    public static void main(String[] args) throws IOException {

        //paths();
        //fileAccessibility();
        copyFile(Paths.get("./files/"), Paths.get("./copies/"));
        copyFile(Paths.get("./files/image.png"), Paths.get("./copies/image.png"));

        System.out.println("done.");
    }
}