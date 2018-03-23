package com.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
    protected CreditTransaction(Date date, float amount, String from) throws InvalidAmountForTransactionException {
        super(date, amount, from);
    }

    public CreditTransaction(float amount, String from) throws InvalidAmountForTransactionException {
        this(new Date(),amount, from);
    }
}
