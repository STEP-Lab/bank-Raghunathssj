package com.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountNumber {
    private static final Pattern PATTERN = Pattern.compile("\\d{4}-\\d{4}");
    private final String accountNumber;

    private AccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        Matcher matcher = PATTERN.matcher(accountNumber);
        if (!matcher.matches()) {
            throw new InvalidAccountNumberException();
        }
    }

    public static AccountNumber createAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        validateAccountNumber(accountNumber);
        return new AccountNumber(accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
