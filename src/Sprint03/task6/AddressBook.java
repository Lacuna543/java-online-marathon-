package Sprint03.task6;


import java.util.*;

public class AddressBook implements Iterable{
    private NameAddressPair[] addressBook;
    private int counter = 0;



    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person {
            private final String firstName;
            private final String lastName;

            @Override
            public boolean equals(Object obj) {
                return obj instanceof Person
                        && this.firstName.equals(((Person) obj).firstName)
                        && this.lastName.equals((((Person) obj).lastName));
            }

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }
        }
    }

    private class AddressBookIterator implements Iterator {

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size();
        }

        @Override
        public String next() {

            return "First name: " +
                    addressBook[counter].person.firstName +
                    ", Last name: " +
                    addressBook[counter].person.lastName +
                    ", Address: " +
                    addressBook[counter++].address;
        }
    }

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {

        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(newPerson)) {
                return false;
            }
        }
        if (counter == addressBook.length) {
            NameAddressPair[] newBiggerAddressBook = new NameAddressPair[addressBook.length * 2];
            System.arraycopy(addressBook, 0, newBiggerAddressBook, 0, addressBook.length);
            addressBook = newBiggerAddressBook;
        }
        addressBook[counter++] = new NameAddressPair(newPerson, address);
        return true;
    }

    public String read(String firstName, String lastName) {

        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(newPerson)) {
                return addressBook[i].address;
            }
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {

        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(newPerson)) {
                addressBook[i].address = address;
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

    public void sortedBy(SortOrder2 sortOrder2) {

        Arrays.sort(addressBook, 0, counter, new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {

                int result = o1.person.firstName.compareTo(o2.person.firstName);
                if (result == 0) {
                    result = o1.person.lastName.compareTo(o2.person.lastName);
                }
                return sortOrder2 == SortOrder2.ASC ? result : -result;
            }
        });
    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();
    }
}

enum SortOrder {ASC, DESC}