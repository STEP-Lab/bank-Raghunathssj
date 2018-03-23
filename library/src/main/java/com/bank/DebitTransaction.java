package com.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

    public DebitTransaction(float amount, String to) throws InvalidAmountForTransactionException {
        this(new Date(), amount, to);

    }

    protected DebitTransaction(Date date, float amount, String to) throws InvalidAmountForTransactionException {
        super(date, amount, to);
    }
}
