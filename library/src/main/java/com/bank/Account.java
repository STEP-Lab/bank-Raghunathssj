package com.bank;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private final AccountNumber accountNumber;
    private float balance;

    private Account(AccountNumber accountNumber, float balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    private static void validateBalance(float balance) throws MinimumBalanceException {
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

    public static Account createAccount(String number, float amount) throws InvalidAccountNumberException, MinimumBalanceException {
        AccountNumber accountNumber = new AccountNumber(number);
        validateBalance(amount);
        return new Account(accountNumber,amount);
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }
}
