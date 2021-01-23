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
        Predicate<Person> combine = (Person person) -> name.test(person)
                || surname.test(person)
                || phone.test(person)
                || address.test(person);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}