package com.example.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Account implements AccountService {

    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private final Supplier<LocalDate> today;

    public Account() {
        this(LocalDate::now);
    }

    public Account(Supplier<LocalDate> today) {
        this.today = today;
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Cannot deposit a negative amount");
        } else {
        balance += amount;
        transactions.add(new Transaction(amount, today.get(), balance));
        }
    }

    @Override
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Withdrawal amount exceeds available balance");
        }
        balance -= amount;
        transactions.add(new Transaction(-amount, today.get(), balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date || Amount || Balance");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.println(
                    t.getDate().format(FORMATTER)
                    + " || " + t.getAmount()
                    + " || " + t.getBalance()
            );
        }
    }

}
