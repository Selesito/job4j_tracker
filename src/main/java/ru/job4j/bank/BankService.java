package ru.job4j.bank;

import javax.swing.text.html.Option;
import java.util.*;

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
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет к пользователю.Изначально ищем пользователя по паспорту,
     * и проверяем что такого счета еще нет у пользователя.
     * @param passport принмает паспорт пользователя.
     * @param account  банковский счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport).orElse(null);
        if (user != null) {
            List<Account> acc = users.get(user);
            if (!acc.contains(account)) {
                acc.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     * @param passport принимает на вход паспорт.
     * @return возвращает найденого пользователя или же null/
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * @param passport паспорт пользователя.
     * @param requisite счёт пользователя.
     * @return возвращает счет пользователя или null, если отсутствует.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> result = Optional.empty();
        User user = findByPassport(passport).orElse(null);
        return user != null ? users.get(user)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst()
                : result;
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            src.get().setBalance(src.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
