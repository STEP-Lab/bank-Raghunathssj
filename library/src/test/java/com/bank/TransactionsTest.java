package com.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    @Test
    public void mustRecordDebitTransaction() {
        Transactions transactions = new Transactions();
        transactions.debit(1000,"to_someone");
        assertThat(transactions.transactions,hasItem(new DebitTransaction(new Date(),1000,"to_someone")));
    }

    @Test
    public void mustRecordCreditTransaction() {
        Transactions transactions = new Transactions();
        transactions.credit(1000,"from_me");
        assertThat(transactions.transactions,hasItem(new CreditTransaction(new Date(),1000,"from_me")));
    }

    @Test
    public void mustRecordBothCreditAndDebitTransactions() {
        Transactions transactions = new Transactions();
        transactions.debit(2000,"to_me");
        transactions.credit(3000,"from_someone");
        assertThat(transactions.transactions,hasItems(new DebitTransaction(new Date(),2000,"to_me"),new CreditTransaction(new Date(),3000,"from_someone")));
    }
}
