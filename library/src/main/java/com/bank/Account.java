package com.bank;

public class Account {
    private final String accountNumber;
    private final int balance;

    public Account(String acccountNumber, int balance) {
        this.accountNumber = acccountNumber;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}
