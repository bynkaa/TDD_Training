package com.qsoft.tdd.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: BinkaA
 * Date: 7/2/13
 * Time: 1:42 PM
 */
@Entity
@Table(name = "bank_account")
public class BankAccountDTO {
    @Id
    @Column("account_id")
    private long bankAccountId;
    @Column("account_number")
    private String accountNumber;
    @Column("balance")
    private long balance = 0;
    @Column("openTimeStamp")
    private long openTimeStamp;

    public long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getOpenTimeStamp() {
        return openTimeStamp;
    }

    public void setOpenTimeStamp(long openTimeStamp) {
        this.openTimeStamp = openTimeStamp;
    }
}
