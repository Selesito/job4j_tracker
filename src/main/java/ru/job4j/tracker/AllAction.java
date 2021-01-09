package ru.job4j.tracker;

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
        Item[] item = tracker.findAll();
        for (Item rsl : item) {
            out.println(rsl);
        }
        return true;
    }
}
