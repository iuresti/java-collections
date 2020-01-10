package com.learning.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonBuilder {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/d/yyyy");

    private Person person;

    public PersonBuilder() {
        person = new Person();
    }

    public PersonBuilder firstName(String firstName) {
        person.setFirstName(firstName);

        return this;
    }

    public PersonBuilder lastName(String lastName) {
        person.setLastName(lastName);

        return this;
    }

    public PersonBuilder email(String email) {
        person.setEmail(email);

        return this;
    }

    public PersonBuilder gender(String gender) {
        person.setGender(gender);

        return this;
    }

    public PersonBuilder country(String country) {
        person.setCountry(country);

        return this;
    }

    public PersonBuilder birthDate(String birthDate) {
        person.setBirthDate(LocalDate.parse(birthDate, DATE_TIME_FORMATTER));

        return this;
    }

    public Person build() {
        return person;
    }

}
