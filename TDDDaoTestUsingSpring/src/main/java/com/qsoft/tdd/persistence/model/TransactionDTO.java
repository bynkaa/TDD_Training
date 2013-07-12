package com.qsoft.tdd.persistence.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQueries(
       {
            @NamedQuery(
                    name = "transaction.findByName", query = "select t FROM TransactionDTO t where t.accountNumber =:accountNumber"
            ),

            @NamedQuery(
                    name = "transaction.getNTransaction", query = "select t from TransactionDTO t where " +
                                                                "t.accountNumber =:accountNumber order by t.timeStamp desc"
            ),
            @NamedQuery(
                    name = "transaction.getInPeriod", query = "select t from  TransactionDTO  t " +
                    "where t.accountNumber =:accountNumber and t.timeStamp >= :startTime and t.timeStamp <= :stopTime"
            )
       }
)
@Table(name = "transaction")
@SequenceGenerator(name = "transaction_id_seq", sequenceName = "transaction_id_seq")
public class TransactionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transaction_id_seq")
    @Column(name = "transaction_id")
    private Long id;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "amount")
    private long amount;
    @Column(name = "timestamp")
    private long timeStamp;
    @Column(name = "description")
    private String description;

    public TransactionDTO(){

    }
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
