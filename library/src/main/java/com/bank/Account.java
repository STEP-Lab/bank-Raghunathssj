package com.bank;

public class Account {
    public static final int MinimumBalance = 1000;
    private final String accountNumber;
    private final int balance;

    public Account(String acccountNumber, int balance) throws MinimumBalanceException {
        this.accountNumber = acccountNumber;
        if(balance < MinimumBalance){
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
