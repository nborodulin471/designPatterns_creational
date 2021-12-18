package builder;

public class PersonBuilder {
    private String name;
    private String surname;
    private String address;
    private int age;

    public PersonBuilder() {
    }

    public PersonBuilder(String surname, int age, String address) {
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public PersonBuilder setName(String name) { /*...*/

        this.name = name;
        return this;

    }

    public PersonBuilder setSurname(String surname) {

        this.surname = surname;
        return this;

    }

    public PersonBuilder setAge(int age) throws IllegalStateException {

        this.age = age;
        return this;

    }

    public PersonBuilder setAddress(String address) {

        this.address = address;
        return this;

    }

    public Person build() {

        if (isValueFilled(name) || isValueFilled(address) || isValueFilled(surname)
                || age <= 0 && age > 200) {
            throw new IllegalStateException(String.format("%s is not correctly filled",
                    (isValueFilled(name) ? "Object" : name)));
        }

        return new Person(name, surname, address, age);

    }

    private boolean isValueFilled(String value) {

        if (value == null || value.isEmpty()) {
            return true;
        }

        return false;

    }

}
