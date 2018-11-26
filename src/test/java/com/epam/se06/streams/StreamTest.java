package com.epam.se06.streams;

import lombok.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class StreamTest {

    private Collection<Employee> employees;

    @BeforeEach
    void createEmployees() {
        employees = getEmployees();
    }

    @Test
    void name() {
        long countIvans = employees.stream()
                                   .map(Employee::getPerson)
                                   .filter(person -> person.getFirstName().equals("Иван"))
                                   .peek(System.out::println)
                                   .count();

        System.out.println(countIvans);


//        int countIvans = 0;
//        for (Employee employee : employees) {
//            Person person = employee.getPerson();
//            if (person.getFirstName().equals("Иван")) {
//                System.out.println(person.getFullName());
//                ++countIvans;
//            }
//        }
//        System.out.println(countIvans);
    }

    private static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(
                        new Person("Иван", "Мельников", 30),
                        Arrays.asList(
                                new JobHistoryEntry(2, "dev", "EPAM"),
                                new JobHistoryEntry(1, "dev", "google")
                        )),
                new Employee(
                        new Person("Александр", "Дементьев", 28),
                        Arrays.asList(
                                new JobHistoryEntry(1, "tester", "EPAM"),
                                new JobHistoryEntry(1, "dev", "EPAM"),
                                new JobHistoryEntry(1, "dev", "google")
                        )),
                new Employee(
                        new Person("Дмитрий", "Осинов", 40),
                        Arrays.asList(
                                new JobHistoryEntry(3, "QA", "yandex"),
                                new JobHistoryEntry(1, "QA", "mail.ru"),
                                new JobHistoryEntry(1, "dev", "mail.ru")
                        )),
                new Employee(
                        new Person("Анна", "Светличная", 21),
                        Collections.singletonList(
                                new JobHistoryEntry(1, "tester", "T-Systems")
                        )),
                new Employee(
                        new Person("Игорь", "Толмачёв", 50),
                        Arrays.asList(
                                new JobHistoryEntry(5, "tester", "EPAM"),
                                new JobHistoryEntry(6, "QA", "EPAM")
                        )),
                new Employee(
                        new Person("Иван", "Александров", 33),
                        Arrays.asList(
                                new JobHistoryEntry(2, "QA", "T-Systems"),
                                new JobHistoryEntry(3, "QA", "EPAM"),
                                new JobHistoryEntry(1, "dev", "EPAM")
                        ))
        );
    }
}

@Value
class Person {

    String firstName;
    String lastName;
    int age;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

@Value
class JobHistoryEntry {

    int duration;
    String employer;
    String position;
}

@Value
class Employee {

    private final Person person;
    private final List<JobHistoryEntry> jobHistory;
}