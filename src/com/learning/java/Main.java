package com.learning.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final String INPUT_PATH = "tests/people";

    public static void main(String[] args) throws IOException {
        Instant start = Instant.now();
        Collection<Person> people = readPeople();
        Instant end = Instant.now();

        System.out.println(people.getClass().getCanonicalName());

        System.out.println("Duration load: " + Duration.between(start, end).toNanos());

        System.out.println(people.size() + " people loaded");

        Person personToFind = getPersonFromCsvLine("Seymour,Melhuish,smelhuishrr@forbes.com,Male,France,11/12/1994");

        start = Instant.now();
        System.out.println("found: " + people.contains(personToFind));
        end = Instant.now();

        System.out.println("Duration search: " + Duration.between(start, end).toNanos());

        Runtime rt = Runtime.getRuntime();
        long usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024;

        System.out.println("memory usage: " + usedKB);

    }

    private static Collection<Person> readPeople() throws IOException {
        Path path = Paths.get(INPUT_PATH);
        Set<Person> people = new HashSet<>();
        //Set<Person> people = new TreeSet<>();
        //List<Person> people = new ArrayList<>();
        //List<Person> people = new LinkedList<>();

        Files.newDirectoryStream(path).forEach(csvFile -> {
            try (BufferedReader bufferedReader = Files.newBufferedReader(csvFile)) {
                bufferedReader.lines()
                        .skip(1)
                        .map(Main::getPersonFromCsvLine)
                        .collect(Collectors.toCollection(() -> people));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        return people;
    }

    private static Person getPersonFromCsvLine(String line) {
        String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        int field = 0;



        return new PersonBuilder()
                .firstName(fields[field++].replace("\"", ""))
                .lastName(fields[field++].replace("\"", ""))
                .email(fields[field++].replace("\"", ""))
                .gender(fields[field++].replace("\"", ""))
                .country(fields[field++].replace("\"", ""))
                .birthDate(fields[field].replace("\"", ""))
                .build();
    }
}
