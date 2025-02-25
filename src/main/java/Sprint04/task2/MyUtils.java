package Sprint04.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MyUtils {
    public static class Student {
        private int id;
        private String name;
        // Constructor, methods, Code

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

    }
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> set = new HashSet<>(list1);

        set.retainAll(list2);

            return set;
    }
}
