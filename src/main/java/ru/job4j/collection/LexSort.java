package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] rslLeft = left.split("\\.");
        String[] rslRight = right.split("\\.");
        int leftResult = Integer.parseInt(rslLeft[0]);
        int rightResult = Integer.parseInt(rslRight[0]);
        return Integer.compare(leftResult, rightResult);
    }
}
