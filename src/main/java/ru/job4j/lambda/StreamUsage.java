package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(10, -12, 14, -16, 18, 20, -22, -67, -30, 40, 60);
        List<Integer> rsl = number.stream().filter(
                num -> num > 0
        ).collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}
