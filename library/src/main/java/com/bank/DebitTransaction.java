package com.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

    public DebitTransaction(float amount, String to) {
        this(new Date(), amount, to);

    }

    protected DebitTransaction(Date date, float amount, String to) {
        super(date, amount, to);
    }
}
