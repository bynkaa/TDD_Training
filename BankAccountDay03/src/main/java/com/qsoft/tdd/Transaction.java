package com.qsoft.tdd;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/10/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDao transactionDao;
    private static Calendar calendar;

    public static void setTransactionDao(TransactionDao transactionDao) {
        Transaction.transactionDao = transactionDao;
    }

    public static void save(String accountNumber, long amount, String description) {
        Long timeStamp = calendar.getTimeInMillis();
        System.out.println(timeStamp);
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,amount,timeStamp,description);
        transactionDao.save(transactionDTO);
    }

    public static void setCalendar(Calendar calendar) {
        Transaction.calendar = calendar;
    }
}
