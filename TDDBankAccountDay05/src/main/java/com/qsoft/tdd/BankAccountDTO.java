package com.qsoft.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/18/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String accountNumber;
    private long balance = 0;

    public BankAccountDTO(String accountNumber) {
        this.accountNumber = accountNumber;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
}
