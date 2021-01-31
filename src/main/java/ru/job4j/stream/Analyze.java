package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(p -> p.getScore())
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                .mapToInt(p -> p.getScore())
                .average()
                .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(s -> s.getName(),
                        LinkedHashMap::new,
                        Collectors.averagingDouble(p -> p.getScore())))
                .entrySet().stream().map(i -> new Tuple(i.getKey(), i.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                .mapToInt(p -> p.getScore())
                .sum()))
                .max(Comparator.comparingDouble(i -> i.getScore()))
                .orElse(new Tuple("no name", 0D));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(s -> s.getName(),
                        LinkedHashMap::new,
                        Collectors.summingDouble(p -> p.getScore())))
                .entrySet().stream().map(i -> new Tuple(i.getKey(), i.getValue()))
                .max(Comparator.comparingDouble(i -> i.getScore()))
                .orElse(new Tuple("no name", 0D));
    }
}