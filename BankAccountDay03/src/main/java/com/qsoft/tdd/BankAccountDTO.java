package com.qsoft.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/10/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String accountNumber;
    private Long balance;
    public BankAccountDTO(String s) {
        this.accountNumber = s;
        balance = 0L;

    }

    public BankAccountDTO(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void addBalance(long amount) {
        this.balance += amount;

    }

    public void subtractBalance(long amount) {
        if (this.balance >= amount){
             balance -= amount;
        }
        else
            balance = 0L;

    }
}
