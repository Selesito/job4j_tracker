package ru.job4j.tracker;

public class AllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] item = tracker.findAll();
        for (Item rsl : item) {
            System.out.println(rsl);
        }
        return true;
    }
}
