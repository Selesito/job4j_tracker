package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list, int value) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {

            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > value;
            }
        };

        return loop(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list, String value) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {

            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains(value);
            }
        };
        return loop(list, predicate);
    }

    private static List<Attachment> loop(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment attachment : list) {
            if (predicate.test(attachment)) {
                result.add(attachment);
            }
        }
        return result;
    }
}
