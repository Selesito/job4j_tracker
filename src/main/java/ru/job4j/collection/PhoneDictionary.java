package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person rsl : persons) {
            if (rsl.getSurname().contains(key) || rsl.getName().contains(key)
                    || rsl.getAddress().contains(key) || rsl.getPhone().contains(key)) {
                result.add(rsl);
            }
        }
        return result;
    }
}
