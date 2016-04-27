package com.bank.shares.generator.exceptions;

/**
 * Created by tomasz on 4/15/16.
 */
public class NoArgumentException extends Exception{
    @Override
    public String getMessage() {
        return "There should be two arguments: -nc(number of Client Accounts to be generated), -nt(number of Transfers to be generated).";
    }

    @Override
    public String toString() {
        return "There should be two arguments: -nc(number of Client Accounts to be generated), -nt(number of Transfers to be generated).";
    }
}
