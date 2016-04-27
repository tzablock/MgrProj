package com.bank.shares.generator.exceptions;

/**
 * Created by tomasz on 4/16/16.
 */
public class BooleanPossibilityException extends Exception {
    @Override
    public String getMessage() {
        return "Possibility should be between 0.0 and 100.0.";
    }

    @Override
    public String toString() {
        return "Possibility should be between 0.0 and 100.0.";
    }
}
