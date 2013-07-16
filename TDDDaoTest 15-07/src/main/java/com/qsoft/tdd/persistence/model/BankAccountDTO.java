package com.qsoft.tdd.persistence.model;

import javax.persistence.*;

/**
 * User: BinkaA
 * Date: 7/2/13
 * Time: 1:42 PM
 */
@Entity
@NamedQueries(
    @NamedQuery(
            name = "bank_account.findByName", query = "select b FROM BankAccountDTO b where b.accountNumber =:accountNumber"
    )
)
@Table(name = "bank_account")
@SequenceGenerator(name = "account_id_seq", sequenceName = "account_id_seq")
public class BankAccountDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "account_id_seq")
    @Column(name = "account_id")
    private long bankAccountId;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "balance")
    private long balance = 0;
    @Column(name = "open_timestamp")
    private long openTimeStamp;
    public BankAccountDTO(){

    }
    public BankAccountDTO(String accountNumber){
        this.accountNumber = accountNumber;
        balance = 0;
    }
    public BankAccountDTO(String accountNumber, long balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

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
