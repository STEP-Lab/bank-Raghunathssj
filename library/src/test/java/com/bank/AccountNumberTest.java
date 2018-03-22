package com.bank;

import com.bank.AccountNumber;
import com.bank.InvalidAccountNumberException;
import org.junit.Test;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void mustThrowExceptionIfAccountNumberContainsCharacters() throws InvalidAccountNumberException{
        new AccountNumber("123d-c134");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void mustThrowExceptionIfHyphenIsNotAtCenter() throws InvalidAccountNumberException{
        new AccountNumber("123412-34");
    }
}
