package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "FindName";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> item = tracker.findByName(name);
        if (item.size() > 0) {
            for (Item rsl : item) {
                out.println(rsl);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
