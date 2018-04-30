package com.bank;

import java.util.ArrayList;
import java.util.Objects;

public class Transactions {

    protected ArrayList<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<>();
    }

    public void debit(float amount, String to) throws InvalidAmountForTransactionException {
        add(new DebitTransaction(amount, to));
    }

    public void credit(float amount, String from) throws InvalidAmountForTransactionException {
        add(new CreditTransaction(amount,from));
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Transactions filterByType(String type) {
        Transactions transactions = new Transactions();
        for (Transaction transaction: this.transactions){
            if (transaction.getType().equals(type)){
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    private void add(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public Transactions filterByAmountAtLeast(float amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction: this.transactions){
            if (transaction.getAmount()>=amount){
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public Transactions filterByAmountLesserThan(float amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction: this.transactions){
            if (transaction.getAmount()<amount){
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transactions)) return false;
        Transactions that = (Transactions) o;
        return Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transactions);
    }
}
