package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1rsl = o1.split("/");
        String[] o2rsl = o1.split("/");
        int rsl = o2rsl[0].compareTo(o1rsl[0]);
        if (rsl != 0) {
            return rsl;
        }
        return o1.compareTo(o2);
    }
}
