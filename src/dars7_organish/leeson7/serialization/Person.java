package concurency.leeson7.serialization;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;

    private transient int age; // ignore field

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
