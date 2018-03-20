package com.bank;

public class InsufficientFundsException extends Throwable {
    InsufficientFundsException() {
        super("Insufficient funds in account");
    }
}
