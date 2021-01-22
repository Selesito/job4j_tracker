package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compareTo - " + left + " : " + right);
            return right.compareTo(left);
        };
    }

}
