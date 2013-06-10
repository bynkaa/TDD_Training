package com.qsoft.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/10/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDao transactionDao;

    public static void setTransactionDao(TransactionDao transactionDao) {
        Transaction.transactionDao = transactionDao;
    }
}
