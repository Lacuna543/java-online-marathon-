package Sprint02.task1;

public class Person {

    String name;
    int age;
    String healthInfo;

    public Person(int age, String name,  String healthInfo) {

        this.name = name;
        this.age = age;
        this.healthInfo = healthInfo;
    }
    String getHealthStatus() {
        return name + " " + healthInfo;
    }
}

class Child extends Person {

    String childIDNumber;

    public Child(int age, String name, String healthInfo, String childIDNumber) {
        super(age, name, healthInfo);
        this.childIDNumber = childIDNumber;
    }



}
