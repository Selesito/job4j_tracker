package ru.job4j.tracker;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenAllItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("All item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new AllAction(output),
                new Exit()
        };
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Show")
                .add("1. Exit")
                .add("=== Show all items ====")
                .add("Item{id=1, name='All item'}")
                .add("Menu.")
                .add("0. Show")
                .add("1. Exit")
                .toString();
                new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(expect));
    }

    @Test
    public void whenIdItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindIdAction(output),
                new Exit()
        };
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. FindId")
                .add("1. Exit")
                .add("=== Find item by Id ====")
                .add("Item{id=1, name='Find item'}")
                .add("Menu.")
                .add("0. FindId")
                .add("1. Exit")
                .toString();
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(expect));
    }

    @Test
    public void whenNameItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item itemOne = tracker.add(new Item("Find Id item"));
        Item itemTwo = tracker.add(new Item("Find Name item"));
        Input in = new StubInput(
                new String[] {"0", itemTwo.getName(), "1"}
        );
        UserAction[] actions = {
                new FindNameAction(output),
                new Exit()
        };
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. FindName")
                .add("1. Exit")
                .add("=== Find items by name ====")
                .add("Item{id=2, name='Find Name item'}")
                .add("Menu.")
                .add("0. FindName")
                .add("1. Exit")
                .toString();
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(expect));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"6", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}