package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;
    private final List<Item> items = new ArrayList<>();
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

    public List<Item> findAll() {
        List<Item> temp = new ArrayList<>();
        for (Item value : items) {
            temp.add(value);
        }
        return temp;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
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
            ids--;
        }
        return result;
    }
}