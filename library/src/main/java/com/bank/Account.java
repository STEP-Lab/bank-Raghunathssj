package com.bank;

import java.util.ArrayList;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private final AccountNumber accountNumber;
    private float balance;
    private Transactions transactions;

    private Account(AccountNumber accountNumber, float balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new Transactions();
    }

    private static void validateBalance(float balance) throws MinimumBalanceException {
        if (balance < MINIMUM_BALANCE) {
            throw new MinimumBalanceException();
        }
    }

    public float getBalance() {
        return balance;
    }

    public float debit(float amount, String to) throws MinimumBalanceException, InvalidAmountForTransactionException {
        validateBalance(balance - amount);
        transactions.debit(amount,to);
        return balance -= amount;
    }

    public float credit(float amount, String from) throws InvalidAmountForTransactionException {
        transactions.credit(amount,from);
        return balance += amount;
    }

    public static Account createAccount(String number, float amount) throws InvalidAccountNumberException, MinimumBalanceException {
        AccountNumber accountNumber = AccountNumber.createAccountNumber(number);
        validateBalance(amount);
        return new Account(accountNumber,amount);
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions.getTransactions();
    }
}
