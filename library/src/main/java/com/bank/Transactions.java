package com.bank;

import java.util.ArrayList;

public class Transactions {

    protected ArrayList<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<>();
    }

    public void debit(float amount, String to) {
        this.transactions.add(new DebitTransaction(amount, to));
    }
}
