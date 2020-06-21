package Sprint03.task6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder2 {ASC, DECS}

public class AddressBook2 implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter;

    public AddressBook2(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {

        if (counter > addressBook.length) {
            return false;
        }
        NameAddressPair nameAddressPair = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
        addressBook[counter++] = nameAddressPair;
        return true;
    }

    public String read(String firstName, String lastName) {
        for (NameAddressPair pair : addressBook) {
            if (pair.person.firstName.equals(firstName) && pair.person.lastName.equals(lastName)) {
                return pair.address;
            }
        }
        return "";

    }

    public boolean update(String firstName, String lastName, String address) {
        for (NameAddressPair pair : addressBook) {
            if (pair.person.firstName.equals(firstName) && pair.person.lastName.equals(lastName)) {
                pair.address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(newPerson)) {
                System.arraycopy(addressBook, i + 1, addressBook, i, addressBook.length - 1 - i);
                counter--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder2 order) {
        Arrays.sort(addressBook, 0, counter, new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {

                int result = o1.person.firstName.compareTo(o2.person.firstName);
                if (result == 0) {
                    result = o1.person.lastName.compareTo(o2.person.lastName);
                }
                return order == SortOrder2.ASC ? result : -result;
            }
        });
    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size();
        }

        @Override
        public String next() {
            String record = "First name: " + addressBook[counter].person.firstName +
                    ", last name: " + addressBook[counter].person.lastName +
                    ", address " + addressBook[counter].address;
            counter++;
            return record;
        }
    }

    private static class NameAddressPair {
        private String address;
        private Person person;


        private NameAddressPair(Person person, String address) {
            this.address = address;
            this.person = person;
        }


        private static class Person {
            private final String firstName;
            private final String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) &&
                        Objects.equals(lastName, person.lastName);
            }


        }
    }
}
