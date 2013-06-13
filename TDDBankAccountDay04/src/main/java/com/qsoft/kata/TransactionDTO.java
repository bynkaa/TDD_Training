package com.qsoft.kata;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/13/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    String accountNumber;
    long timeStamp;
    long amount;
    String description;

    public TransactionDTO(String accountNumber, Long timeStamp, long amount, String description) {
        this.accountNumber = accountNumber;
        this.timeStamp = timeStamp;
        this.amount = amount;
        this.description = description;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public long getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
