package dars7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("java-io/my-file.txt.txt");
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.length() = " + file.length());
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

        System.out.println("file.canWrite() = " + file.canWrite());

//        BufferedOutputStream res = new BufferedOutputStream(new FileWriter(file));

        Path path = Path.of("java-io/my-file.txt");
        Files.write(path, "hello wpsy".getBytes(), StandardOpenOption.APPEND);
        Files.write(path, "wjdfhgwv".getBytes(), StandardOpenOption.APPEND);
    }
}
