package com.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

    private String type = "debit";

    public DebitTransaction(float amount, String to) throws InvalidAmountForTransactionException {
        this(new Date(), amount, to);

    }

    protected DebitTransaction(Date date, float amount, String to) throws InvalidAmountForTransactionException {
        super(date, amount, to);
    }

    @Override
    public String getType() {
        return type;
    }
}
