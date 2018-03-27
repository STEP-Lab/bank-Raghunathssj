package com.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
    private String type = "credit";

    protected CreditTransaction(Date date, float amount, String from) throws InvalidAmountForTransactionException {
        super(date, amount, from);
    }

    @Override
    public String getType() {
            return type;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    public CreditTransaction(float amount, String from) throws InvalidAmountForTransactionException {
        this(new Date(),amount, from);
    }
}
