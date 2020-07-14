package Sprint02.task3;

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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studyYears == student.studyYears &&
                Objects.equals(studyPlace, student.studyPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studyPlace, studyYears);
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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return experienceYears == worker.experienceYears &&
                Objects.equals(workPosition, worker.workPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workPosition, experienceYears);
    }
}

public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        if (persons == null) {
            return new ArrayList<>();
        }
        if (persons.size() == 0) {
            return persons;
        }
//        persons.removeIf(Objects::isNull);
        List<Student> studentList = new ArrayList<>();
        List<Worker> workerList = new ArrayList<>();
        List<Person> output = new ArrayList<>();
        for (Person person : persons) {
            if (person ==  null) {continue;}
            if (person instanceof Student && !studentList.contains(person)) {
                studentList.add((Student) person);
            }
            if (person instanceof Worker && !workerList.contains(person)) {
                workerList.add((Worker) person);
            }
        }


        if (!studentList.isEmpty()) {
            Student maxYearOfStudents = Collections.max(studentList, Comparator.comparingInt(Student::getStudyYears));
            int maxStudyYears = maxYearOfStudents.getStudyYears();

            for (Student student : studentList) {
                if (student.getStudyYears() == maxStudyYears) {
                    output.add(student);
                }
            }
        }
        if (!workerList.isEmpty()) {
            Worker maxYearOfWorkers = Collections.max(workerList, Comparator.comparingInt(Worker::getExperienceYears));
            int maxWorkYears = maxYearOfWorkers.getExperienceYears();

            for (Worker worker : workerList) {
                if (worker.getExperienceYears() == maxWorkYears) {
                    output.add(worker);
                }
            }
        }
           /* if (person instanceof Student && ((Student) person).getStudyYears() == maxStudyYears ) {
                studentList.add((Student) persons);
                output.add((Person) studentList);
            } else if (person instanceof Worker && ((Worker) person).getExperienceYears() == maxWorkYears){
                workerList.add((Worker) persons);
                output.add((Person) workerList);
            }*/
        return output;
    }
}





