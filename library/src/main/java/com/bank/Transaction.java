package com.bank;

import java.util.Date;
import java.util.Objects;

public abstract class Transaction {
    protected final float amount;
    protected final String to;
    protected Date date;

    public Transaction(Date date, float amount, String to) {
        this.to = to;
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Float.compare(that.amount, amount) == 0 &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, to);
    }
}
