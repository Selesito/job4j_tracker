package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс содержит описание модели банковского счета.
 * @author Vitaliy Morozov
 * @version 1.0
 */
public class Account {
    /**
     *В модели хранятся реквезиты и баланс счета!
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор класса, принимает аргументы для инициализации реквезитов и бланаса!
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределен метод equals!
     * @param o
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
