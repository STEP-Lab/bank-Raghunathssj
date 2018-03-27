package com.bank;

public class InvalidAmountForTransactionException extends Throwable {
    InvalidAmountForTransactionException(){
        super("Amount is not valid for transaction");
    }
}
