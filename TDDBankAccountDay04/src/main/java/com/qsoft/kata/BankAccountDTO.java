package com.qsoft.kata;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/12/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String accountNumber;
    private int balance;

    public BankAccountDTO(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
    public boolean equals(Object o){
        if (o == this)
            return true;
        BankAccountDTO b = (BankAccountDTO) o;
        return accountNumber.equals(b.accountNumber) && balance == b.balance;
    }
}
