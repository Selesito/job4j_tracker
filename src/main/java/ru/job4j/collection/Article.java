package ru.job4j.collection;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean result = true;
        ArrayList<String> originRsl = new ArrayList<>(Arrays.asList(origin.split("\\b+")));
        String[] lineRsl = line.split("\\s");
        for (String rsl : lineRsl) {
            if (!originRsl.contains(rsl)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
