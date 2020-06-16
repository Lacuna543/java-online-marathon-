package Sprint01.task1.task2;

public class Employee {
    public String fullName;
    public float salary;

    public static void main(String[] args) {

        String employeesInfo = "[";

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.fullName = "Garry Petrovsky";
        emp2.fullName = "Bob Roork";

        emp1.salary = 10000.6f;
        emp2.salary = 9000.6f;

        Employee[] employees = {emp1, emp2};

        for (Employee employee : employees) {
            employeesInfo = employeesInfo.concat("{fullName: \"" + employee.fullName + "\", salary: " + employee.salary + "}, " + "]");
        }

    }
}
