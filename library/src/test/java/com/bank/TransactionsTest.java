package com.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

    private Transactions transactions;

    @Before
    public void setUp() {
        transactions = new Transactions();
    }

    @Test
    public void mustRecordDebitTransaction() throws InvalidAmountForTransactionException {
        transactions.debit(1000,"to_someone");
        assertThat(transactions.transactions,hasItem(new DebitTransaction(new Date(),1000,"to_someone")));
    }

    @Test
    public void mustRecordCreditTransaction() throws InvalidAmountForTransactionException {
        transactions.credit(1000,"from_me");
        assertThat(transactions.transactions,hasItem(new CreditTransaction(new Date(),1000,"from_me")));
    }

    @Test
    public void mustRecordBothCreditAndDebitTransactions() throws InvalidAmountForTransactionException {
        transactions.debit(2000,"to_me");
        transactions.credit(3000,"from_someone");
        assertThat(transactions.transactions,hasItems(new DebitTransaction(new Date(),2000,"to_me"),new CreditTransaction(new Date(),3000,"from_someone")));
    }

    @Test
    public void shouldFilterTransactionsByType() throws InvalidAmountForTransactionException {
        transactions.debit(1000,"to_me");
        transactions.credit(2000,"from_me");
        transactions.debit(1500,"to_me");
        assertThat(transactions.filterByType("debit").transactions,hasItems(new DebitTransaction(1000,"to_me"),new DebitTransaction(1500,"to_me")));
    }

    @Test
    public void shouldFilterTransactionsByAmountAtLeastGivenAmount() throws InvalidAmountForTransactionException {
        transactions.debit(1000,"to_me");
        transactions.credit(3000,"from_me");
        transactions.debit(500,"to_me");
        assertThat(transactions.filterByAmountAtLeast(1000).transactions,hasItems(new CreditTransaction(3000,"from_me"),new DebitTransaction(1000,"to_me")));
    }

    @Test
    public void shouldFilterTransactionsByAmountLesserThanGivenAmount() throws InvalidAmountForTransactionException {
        transactions.debit(1000,"to_me");
        transactions.credit(3000,"from_me");
        transactions.debit(500,"to_me");
        assertThat(transactions.filterByAmountLesserThan(1000).transactions,hasItem(new DebitTransaction(500,"to_me")));
    }
}
