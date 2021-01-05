package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] copyItems = Arrays.copyOf(items, size);
        return copyItems;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                result[count++] = items[i];
            }
        }
        result = Arrays.copyOf(items, count);
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index >= 0) {
            item.setId(id);
            items[index] = item;
            result = true;
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean delete(int id) {
        boolean result = false;
        int distPos = indexOf(id);
        if (distPos >= 0) {
            System.arraycopy(items, distPos + 1, items, distPos, size - distPos);
            items[size - 1] = null;
            size--;
            result = true;
        }
        return result;
    }
}