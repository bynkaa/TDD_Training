package com.qsoft.tdd;

import com.qsoft.tdd.persistence.dao.TransactionDAO;
import com.qsoft.tdd.persistence.model.TransactionDTO;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    static Calendar calendar;
    static TransactionDAO transactionDao;
    public static void save(String accountNumber, long amount, String description) {
        long timeStamp = calendar.getTimeInMillis();
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,amount,timeStamp,description);
        transactionDao.save(transactionDTO);

    }

    public static void setTransactionDao(TransactionDAO transactionDao) {
        Transaction.transactionDao = transactionDao;
    }

    public static void setCalendar(Calendar calendar) {
        Transaction.calendar = calendar;
    }

    public static List<TransactionDTO> get(String accountNumber) {
        return transactionDao.get(accountNumber);

    }

    public static List<TransactionDTO> get(String accountNumber, int number) {
        return transactionDao.get(accountNumber,number);

    }

    public static List<TransactionDTO> get(String accountNumber, long startTime, long stopTime) {

        return transactionDao.get(accountNumber,startTime,stopTime);
    }
}
