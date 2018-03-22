package com.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
    protected CreditTransaction(Date date, float amount, String from) {
        super(date, amount, from);
    }
}
