package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int id = Integer.valueOf(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            out.println("True");
        } else {
            out.println("False");
        }
        return true;
    }
}
