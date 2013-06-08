package com.qsoft.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/8/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String accountNumber;
    private Long balance;
    public BankAccountDTO(String s) {
        this.accountNumber = s;
        this.balance = 0L;

    }
    //
    public String getAccountNumber(){
        return accountNumber;
    }
    //
    public Long getBalance(){
        return balance;
    }
}
