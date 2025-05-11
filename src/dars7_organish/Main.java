package dars7_organish;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student user = new Student("Doniyor", 25);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("java-io/my-file.txt"))) {
            oos.writeObject(user);
            System.out.println("yozildi.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("java-io/my-file.txt"))) {
            Student readStudent = (Student) ois.readObject();
            System.out.println("O‘qilgan obyekt: " + readStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Externalizable{
    String name;
    int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        name = in.readUTF();
        age = in.readInt();
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}