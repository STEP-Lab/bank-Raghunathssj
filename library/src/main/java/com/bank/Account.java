package com.bank;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private float balance;

    public Account(AccountNumber accountNumber, float balance) throws MinimumBalanceException {
        validateBalance(balance);
        this.balance = balance;
    }

    private void validateBalance(float balance) throws MinimumBalanceException {
        if (balance < MINIMUM_BALANCE) {
            throw new MinimumBalanceException();
        }
    }

    public float getBalance() {
        return balance;
    }

    public float debit(float amount) throws MinimumBalanceException {
        validateBalance(balance - amount);
        return balance -= amount;
    }

    public float credit(float amount) {
        return balance += amount;
    }
}
