package task3;

public class Employee {
    private float salary;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee(String fullName, float salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

public Employee(){

}

}
