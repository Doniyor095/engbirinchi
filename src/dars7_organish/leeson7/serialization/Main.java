package concurency.leeson7.serialization;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

//        Path path = Paths.get("java-io", "persons", UUID.randomUUID().toString() + ".txt");
        Path path = Paths.get("java-io", "persons", "0f56e1dd-e741-4171-8598-a31c1c54a850.txt");

        Person person = new Person("Sherzod", 12);

        // SERIALIZE
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
//            objectOutputStream.writeObject(person);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Person p = (Person) objectInputStream.readObject();
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
