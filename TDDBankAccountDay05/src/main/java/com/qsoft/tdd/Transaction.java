package com.qsoft.tdd;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/18/13
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDao transactionDao;
    private static Calendar calendar;
    public static void setTransactionDao(TransactionDao transactionDao) {
        Transaction.transactionDao = transactionDao;
    }

    public static TransactionDTO createTransaction(String accountNumber, long amount, String description) {
        long timeStamp = calendar.getTimeInMillis();
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,timeStamp,amount,description);
        return transactionDTO;
    }

    public static void setCalendar(Calendar calendar) {
        Transaction.calendar = calendar;
    }

    public static void save(String accountNumber, long amount, String description) {
        TransactionDTO t = createTransaction(accountNumber, amount, description);
        transactionDao.save(t);
    }

    public static List<TransactionDTO> getTransactions(String accountNumber) {

        return transactionDao.get(accountNumber);
    }
}
