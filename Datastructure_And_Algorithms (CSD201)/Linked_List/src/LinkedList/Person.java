package LinkedList;
/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
public class Person {
    String name;
    int age;

    Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "(" + name + ", " + age + ")";
    }
}
