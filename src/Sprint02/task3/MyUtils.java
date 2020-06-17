package Sprint02.task3;

import java.util.*;

import java.util.*;

class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {

    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getStudyYears() == student.getStudyYears() &&
                Objects.equals(getStudyPlace(), student.getStudyPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStudyPlace(), getStudyYears());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", studyPlace='" + studyPlace + '\'' +
                ", studyYears=" + studyYears +
                '}';
    }
}

class Worker extends Person {

    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return getExperienceYears() == worker.getExperienceYears() &&
                Objects.equals(getWorkPosition(), worker.getWorkPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWorkPosition(), getExperienceYears());
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + super.getName() + '\'' +
                ", workPosition='" + workPosition + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}

public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        List<Student> studentList = new ArrayList<>();
        List<Worker> workerList = new ArrayList<>();
        Set<Person> output = new LinkedHashSet<>();

        if (persons == null) {
            return null;
        }
        if (persons.size() == 0) {
            return persons;
        }

     //   persons.add(new Person("Ivan"));

        Student maxYearOfStudents = Collections.max(studentList, Comparator.comparingInt(Student::getStudyYears));
        Worker maxYearOfWorkers = Collections.max(workerList, Comparator.comparingInt(Worker::getExperienceYears));

        int maxStudyYears = maxYearOfStudents.getStudyYears();
        int maxWorkYears = maxYearOfWorkers.getExperienceYears();

        for (Person person : persons) {

              if (person instanceof Student && ((Student) person).getStudyYears() == maxStudyYears ) {
                studentList.add((Student) persons);
                output.add((Person) studentList);
            } else if (person instanceof Worker && ((Worker) person).getExperienceYears() == maxWorkYears){
                  workerList.add((Worker) persons);
                  output.add((Person) workerList);
              }

        }
        return new ArrayList<>(output);


    }
}
