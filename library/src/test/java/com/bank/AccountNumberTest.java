package com.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void mustThrowExceptionIfAccountNumberContainsCharacters() throws InvalidAccountNumberException{
        AccountNumber.createAccountNumber("123d-c134");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void mustThrowExceptionIfHyphenIsNotAtCenter() throws InvalidAccountNumberException{
        AccountNumber.createAccountNumber("123412-34");
    }

    @Test
    public void shouldNotThrowExceptionIfValidNumberIsGiven() throws InvalidAccountNumberException {
        assertThat(AccountNumber.createAccountNumber("1234-1234").getAccountNumber(),is("1234-1234"));
    }
}
