package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListToMapTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(10, "Surname1"));
        students.add(new Student(40, "Surname4"));
        students.add(new Student(50, "Surname5"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(70, "Surname7"));
        students.add(new Student(80, "Surname8"));
        students.add(new Student(20, "Surname2"));
    }

    @Test
    public void whenEnterListToMap() {
        Map<String, Student> result = ListToMap.listToMap(students);
        Map<String, Student> expected = new HashMap<>();
        for (Student student : students) {
            String key = student.getSurname();
            if (expected.containsKey(key)) {
                expected.replace(key, student);
            } else {
                expected.put(key, student);
            }
        }
        assertThat(result, is(expected));
    }
}