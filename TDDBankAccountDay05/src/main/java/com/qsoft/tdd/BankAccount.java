package com.qsoft.tdd;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/18/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;

    public static void setBankAccountDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }

    public static BankAccountDTO open(String accountNumber) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        bankAccountDao.save(bankAccountDTO);
        return bankAccountDTO;

    }

    public static BankAccountDTO get(String accountNumber) {
        return bankAccountDao.get(accountNumber);
    }

    public static void deposit(String accountNumber, long amount, String description) {
        //To change body of created methods use File | Settings | File Templates.
        doTransaction(accountNumber,amount,description);
    }

    public static void withDraw(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,-amount,description);

    }
    private static void doTransaction(String accountNumber, long amount, String description){
        BankAccountDTO b = bankAccountDao.get(accountNumber);
        b.setBalance(b.getBalance() + amount);
        bankAccountDao.save(b);
        Transaction.save(accountNumber,amount,description);
    }

    public static List<TransactionDTO> getTransactions(String accountNumber) {
        return Transaction.getTransactions(accountNumber);
    }
    //
    public static List<TransactionDTO> getTransactions(String accountNumber,long startTime,long stopTime) {
        if (startTime > stopTime)
            return null;
        return Transaction.getTransactions(accountNumber,startTime,stopTime);
    }
}
