package concurency.leeson7.javanio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("java-io");
        Path target = Path.of("java-io/my-file.txt.log");

//        List<String> list = Files.readAllLines(path);
//        list.forEach(System.out::println);

//        Files.deleteIfExists(target);
//        Files.delete(target);
//        Files.createFile(target);
//        Files.isDirectory(target);
//        Files.isRegularFile(target);
//        Files.isHidden(target);


        DirectoryStream<Path> paths = Files.newDirectoryStream(path);
        for (Path path1 : paths) {
            if (Files.isDirectory(path1)) {
                System.out.println(path1.toAbsolutePath().toString());
            } else if (Files.isRegularFile(path1)) {
                System.out.println(path1.toFile().getAbsolutePath());
            }
        }


//        try {
//            Files.write(target, "Sherzod Xolmahammatov".getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


//        try {
////            List<String> strings = Files.readAllLines(path);
////            System.out.println(strings);
//            Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
