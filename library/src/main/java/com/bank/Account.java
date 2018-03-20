package com.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private final String accountNumber;
    private float balance;
    private static final Pattern PATTERN = Pattern.compile("\\d{4}-\\d{4}");

    public Account(String accountNumber, float balance) throws MinimumBalanceException, InvalidAccountNumberException {
        Matcher matcher = PATTERN.matcher(accountNumber);
        if (!matcher.matches()) {
            throw new InvalidAccountNumberException();
        }
        this.accountNumber = accountNumber;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public float withdraw(float amount) throws MinimumBalanceException {
        validateBalance(this.getBalance() - amount);
        return balance -= amount;
    }
}
