package Sprint02.task4;

import java.math.BigDecimal;
import java.util.*;

class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getExperience() == employee.getExperience() &&
                Objects.equals(name, employee.name) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getExperience(), basePayment);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", basePayment=" + basePayment +
                '}';
    }


}
class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return new BigDecimal(coefficient).multiply(super.getPayment());

    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }
}
public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {

        if (workers == null || workers.size() == 0) {
            return new ArrayList<>();
        }
        BigDecimal maxPayment = new BigDecimal(0);
        int maxExperience = 0;
        for (Employee employee : workers) {
            if (employee == null) {
                continue;
            }
            if (employee.getPayment().compareTo(maxPayment) > 0) {
                maxPayment = employee.getPayment();
            }
            if (employee.getExperience() > maxExperience) {
                maxExperience = employee.getExperience();
            }
        }
        Set<Employee> set = new LinkedHashSet<>();
        for (Employee employee : workers) {
            if (employee == null) {
                continue;
            }
            if (employee.getExperience() == maxExperience || employee.getPayment().compareTo(maxPayment) == 0) {
                set.add(employee);
            }
        }
        return new ArrayList<>(set);
    }
}