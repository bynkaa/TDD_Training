package com.qsoft.tdd.persistence.model;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    private String accountNumber;
    private long amount;
    private long timeStamp;
    private String description;

    public TransactionDTO(String accountNumber, long amount, long timeStamp, String description) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.description = description;

    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getAmount() {
        return amount;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getDescription() {
        return description;
    }


}
