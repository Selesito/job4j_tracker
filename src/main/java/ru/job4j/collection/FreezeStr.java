package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean result = true;
        HashMap<String, Integer> collectLeft = comp(new ArrayList<>(Arrays.asList(left.split(""))));
        HashMap<String, Integer> collRight = comp(new ArrayList<>(Arrays.asList(right.split(""))));
        if (!collectLeft.equals(collRight)) {
            result = false;
        }
        return result;
    }

    public static HashMap<String, Integer> comp(ArrayList<String> collect) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String value : collect) {
            int count = 0;
            if (!result.containsKey(value)) {
                count++;
            } else if (result.containsKey(value)) {
                count = result.get(value);
                count++;
            }
            result.put(value, count);
        }
        return result;
    }
}
