package com.qsoft.tdd;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    static Calendar calendar;
    static TransactionDao transactionDao;
    public static void save(String accountNumber, long amount, String description) {
        long timeStamp = calendar.getTimeInMillis();
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,amount,timeStamp,description);
        transactionDao.save(transactionDTO);

    }
}
