package com.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void mustAddTimeInDebitTransaction() {
        Date date = new Date();
        Transaction transaction = new DebitTransaction(date, 1000, "to_someone");
        assertThat(transaction.getDate(), is(date));
    }

    @Test
    public void mustAddTimeInCreditTransaction() {
        Date date = new Date();
        Transaction transaction = new CreditTransaction(date, 1000, "from_me");
        assertThat(transaction.getDate(), is(date));
    }
}
