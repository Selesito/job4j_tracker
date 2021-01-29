package ru.job4j.search;

import ru.job4j.lambda.Attachment;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = (Person person) -> person.getName().contains(key);
        Predicate<Person> surname = (Person person) -> person.getSurname().contains(key);
        Predicate<Person> phone = (Person person) -> person.getPhone().contains(key);
        Predicate<Person> address = (Person person) -> person.getAddress().contains(key);
        Predicate<Person> combine = name.or(surname).or(phone).or(address);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}