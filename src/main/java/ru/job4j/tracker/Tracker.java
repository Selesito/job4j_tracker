package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public final class Tracker {
    private static Tracker instance = null;
    private final ArrayList<Item> items = new ArrayList<Item>();
    private int ids = 1;

    private Tracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        this.items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        ArrayList<Item> temp = new ArrayList<Item>();
        for (Item value : items) {
            temp.add(value);
        }
        temp.trimToSize();
        return temp;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<Item>();
        for (int i = 0; i < items.size(); i++) {
            if (key.equals(items.get(i).getName())) {
                result.add(items.get(i));
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }
}