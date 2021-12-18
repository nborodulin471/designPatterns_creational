package builder;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected String address;
    protected int age;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, String address, int age) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(surname, age, address);
    }

    public boolean hasAddress(String address) {
        if (this.address.equals(address)) {
            return true;
        }

        return false;
    }

    public boolean hasAge(int publicAge) {

        if (this.age == age) {
            return true;
        }

        return false;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        if (hasAddress(address)) {
            this.address = address;
        }

    }

    public int getAge() {
        return age;
    }

    public void happyBirthday(int publicAge) {

        if (hasAge(publicAge)) {
            age += 1;
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", adress='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, address, age);
    }

}
