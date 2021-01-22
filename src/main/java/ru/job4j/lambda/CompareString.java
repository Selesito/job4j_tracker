package ru.job4j.lambda;

import java.util.Comparator;

public class CompareString {
    public static void main(String[] args) {
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compareTo - " + left + " : " + right);
            return right.compareTo(left);
        };
    }
}