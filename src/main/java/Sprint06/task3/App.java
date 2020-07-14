package Sprint06.task3;

import java.util.List;
import java.util.function.BinaryOperator;
    import java.util.stream.Collectors;

class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

public class App {
    static BinaryOperator<String> greetingOperator = (name, surname) -> {
    return "Hello " + name + " " + surname + "!!!";

    };

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> greetingOperator) {

        return people.stream().map(person -> greetingOperator.apply(person.name, person.surname)).collect(Collectors.toList());
        // Write your code here

    }
}
