package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель хранения данных пользователя!
 * @author Vitaliy Morozov
 * @version 1.0
 */
public class User {
    /**
     * В модели данных хранятся паспорт пользователя и ФИО!
     */
    private String passport;
    private String username;

    /**
     * Конструктор класса принимает для инициализации данные пользователя
     * @param passport паспорт пользователя
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределен метод equals!
     * @param o Входящий параметр!
     * @return возвращает результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}