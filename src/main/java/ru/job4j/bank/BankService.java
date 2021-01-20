package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис для работы с клиентами
 * @author Vitaliy Morozov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.По умолчанию нужно добавить
     * пустой список - ArrayList. В методо есть проверка, если такой
     * есть второго добавлять не нужно!
     * @param user принимает пользователя и список счетов.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю.Изначально ищем пользователя по паспорту,
     * и проверяем что такого счета еще нет у пользователя.
     * @param passport принмает паспорт пользователя.
     * @param account  банковский счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> acc = users.get(user);
            if (!acc.contains(account.getRequisite())) {
                acc.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     * @param passport принимает на вход паспорт.
     * @return возвращает найденого пользователя или же null/
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.contains(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * @param passport паспорт пользователя.
     * @param requisite счёт пользователя.
     * @return возвращает счет пользователя или null, если отсутствует.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> acc = users.get(user);
            for (Account rsl : acc) {
                if (rsl.getRequisite().contains(requisite)) {
                    result = rsl;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Если на счете srcAccount  не хвататет денег, должне вернуть false.
     * @param srcPassport паспорт пользователя, с которго списываю деньги.
     * @param srcRequisite реквизиты пользователя, с которго списываю деньги.
     * @param destPassport паспорт пользователя на который перечисляются деньги.
     * @param destRequisite паспорт пользователя на который перечисляются деньги.
     * @param amount количество пречисляемых денег.
     * @return метод должен вернуть успешность проделанной операции.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            dest.setBalance(dest.getBalance() + amount);
            src.setBalance(src.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
