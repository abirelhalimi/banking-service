package com.example.test;

import java.time.LocalDate;

class Transaction {

    private int amount;
    private LocalDate date;
    private int balance;

    public Transaction(int amount, LocalDate date, int balance) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
