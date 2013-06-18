package com.qsoft.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/18/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    private String accountNumber;
    private long timeStamp;
    private long amount;
    private String description;
    public TransactionDTO(String accountNumber, long timeStamp, long amount, String description) {
        this.accountNumber = accountNumber;
        this.timeStamp = timeStamp;
        this.amount = amount;
        this.description = description;
    }
}
