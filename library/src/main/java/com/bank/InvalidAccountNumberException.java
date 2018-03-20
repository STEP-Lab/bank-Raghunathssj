package com.bank;

public class InvalidAccountNumberException extends Throwable {
    InvalidAccountNumberException(){
        super("Invalid account number");
    }
}
