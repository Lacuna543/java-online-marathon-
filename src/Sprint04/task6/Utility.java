package Sprint04.task6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Employee extends Person {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}

class Developer extends Employee {
    private Level level;

    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + ", Level: " + level.name();
    }
}

enum Level {
    JUNIOR, MIDDLE, SENIOR
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName() == null || o2.getName() == null) {
            return 0;
        }
        int result = o1.getName().compareTo(o2.getName());
        return result != 0
                ? result
                : Integer.compare(o1.getAge(), o2.getAge());
    }
}

class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int result = new PersonComparator().compare(o1, o2);
        return result != 0
                ? result
                : Double.compare(o1.getSalary(), o2.getSalary());
    }
}

class DeveloperComparator implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) {
        int result = new EmployeeComparator().compare(o1, o2);
        return result != 0
                ? result
                : o1.getLevel().compareTo(o2.getLevel());

    }
}

public class Utility {
    public static <T extends Person> void sortPeople(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);

    }
}
