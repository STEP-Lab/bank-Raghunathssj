package com.bank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account = Account.createAccount("1234-1234",2000);
    }

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(),2000,0);
    }

    @Test(expected = MinimumBalanceException.class)
    public void mustThrowExceptionIfMinimumBalanceIsNotPresent() throws MinimumBalanceException, InvalidAccountNumberException {
        Account.createAccount("1234-1542",200);
    }

    @Test
    public void debitAmountFromAccount() throws MinimumBalanceException {
        assertEquals(account.debit(200),1800,0);
    }

    @Test(expected =MinimumBalanceException.class)
    public void mustThrowMinimumBalanceExceptionIfMinimumBalanceIsNotPresent() throws MinimumBalanceException {
        account.debit(2100);
    }

    @Test
    public void creditAmountFromAccount() {
        assertEquals(account.credit(1000),3000,0);
    }
}
