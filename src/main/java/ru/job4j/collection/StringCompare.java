package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int count = Math.min(left.length(), right.length());
        for (int i = 0; i < count; i++) {
            char rslLeft = left.charAt(i);
            char rslRight = right.charAt(i);
            result = Character.compare(rslLeft, rslRight);
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
