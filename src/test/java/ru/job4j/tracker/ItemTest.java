package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareToName() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third"),
                new Item("Four")
        );
        List<Item> result = Arrays.asList(
                new Item("First"),
                new Item("Four"),
                new Item("Second"),
                new Item("Third")
        );
        Collections.sort(items, new SortByName());
        assertThat(items.toString(), is(result.toString()));
    }

    @Test
    public void compareToNameReverse() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third"),
                new Item("Four")
        );
        List<Item> result = Arrays.asList(
                new Item("Third"),
                new Item("Second"),
                new Item("Four"),
                new Item("First")
        );
        Collections.sort(items, new SortByNameRevers());
        assertThat(items.toString(), is(result.toString()));
    }
}