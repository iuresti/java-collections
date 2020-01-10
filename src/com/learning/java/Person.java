package com.learning.java;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String country;
    private LocalDate birthDate;

    private static Comparator<Person> comparator = Comparator.comparing((Person p) -> p.firstName)
            .thenComparing((Person p) -> p.lastName)
            .thenComparing((Person p) -> p.birthDate);

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, birthDate);
    }

    @Override
    public int compareTo(Person o) {
        return comparator.compare(this, o);
    }
}
