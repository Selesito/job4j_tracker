package ru.job4j.tracker;

import java.util.List;

public class AllAction implements UserAction {
    private final Output out;

    public AllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        List<Item> items = tracker.findAll();
        for (Item rsl : items) {
            out.println(rsl);
        }
        return true;
    }
}
