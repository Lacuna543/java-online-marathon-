package Sprint05.task4;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String idCode;


    public void setFirstName(String firstName) {
        if (firstName.matches("[A-Z][\\w- ]+")) {
            this.firstName = firstName;
        } else if (this.firstName == null) {
            throw new NameException("Incorrect value " + firstName + " for firstName" + " (should start from upper case and contains only alphabetic characters and symbols -, _); ");
        }
    }

    public void setLastName(String firstName) {
        if (lastName.matches("[A-Z][\\w- ]+")) {
            this.lastName = firstName;
        } else if (this.lastName == null) {
            throw new NameException("Incorrect value " + lastName + " for lastName" +
                    " (should start from upper case and contains only alphabetic characters and symbols -, _); ");
        }
    }

    public void setIdCode(String idCode) throws CodeException {
        if (!idCode.matches("\\d{10}")) {
            throw new CodeException("");
        }
        this.idCode = idCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(idCode, person.idCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }

    @Override
    public String toString() {
        return ": " + firstName + " " + lastName + ": " + idCode;
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();
        String message = "";
        try{
            person.setFirstName(firstName);
            person.setLastName(lastName);
        }catch (NameException nameException){
            message +=nameException.toString();
        }
        try {
            person.setIdCode(idCode);
        }catch (CodeException codeException){
            message +=codeException.toString();
        }
        if (message.isEmpty()) {
            return person;
        }
        throw new IllegalArgumentException(message);
    }

}

class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String message) {
        super(message);
    }
}
