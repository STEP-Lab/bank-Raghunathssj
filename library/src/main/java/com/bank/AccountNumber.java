package com.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountNumber {
    private static final Pattern PATTERN = Pattern.compile("\\d{4}-\\d{4}");

    public AccountNumber(String number) throws InvalidAccountNumberException {
        validateAccountNumber(number);
        String number1 = number;
    }

    private void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        Matcher matcher = PATTERN.matcher(accountNumber);
        if (!matcher.matches()) {
            throw new InvalidAccountNumberException();
        }
    }
}
