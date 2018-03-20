package com.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private static final int MINIMUM_BALANCE = 1000;
    private final String accountNumber;
    private final float balance;
    private static final Pattern PATTERN = Pattern.compile("\\d{4}[-]\\d{4}");

    public Account(String accountNumber, float balance) throws MinimumBalanceException, InvalidAccountNumberException {
        Matcher matcher = PATTERN.matcher(accountNumber);
        if (!matcher.matches()){
            throw new InvalidAccountNumberException();
        }
        this.accountNumber = accountNumber;
        if (balance < MINIMUM_BALANCE) {
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
