package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        Tracker tracker = new Tracker();
        tracker.add(item);
        System.out.println(tracker.findById(1));


    }
}
