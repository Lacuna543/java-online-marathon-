package Sprint02.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class Person {
    public String getName() {
        return name;
    }

    String name;
}

class Student extends Person {
    String studyPlace;

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    int studyYears;
}

class Worker extends Person {
    String workPosition;

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    int experienceYears;
}

public class MyUtils {
   /* public List<Person> maxDuration(List<Person> persons) {
        // Code
    }*/
}
