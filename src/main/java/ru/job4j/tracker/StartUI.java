package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMМ-EEEE-yyyy HH:mm:ss");
        String currentDateTime = item.getCreated().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTime);
    }
}
