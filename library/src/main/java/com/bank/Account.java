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

    private float getBalance() {
        return balance;
    }

    public float withdraw(float amount) throws MinimumBalanceException {
        validateBalance(this.getBalance() - amount);
        return balance -= amount;
    }

    public float deposit(float amount) {
        return balance += amount;
    }
}
