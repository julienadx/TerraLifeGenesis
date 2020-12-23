package com.terra.exceptions;

public class NoMoneyException extends Exception {

    public NoMoneyException(String message) {
        super(message);
    }

    public NoMoneyException() {
        this("you have no money");
    }
}
