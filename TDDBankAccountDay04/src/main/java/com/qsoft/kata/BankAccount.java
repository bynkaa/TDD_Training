package com.qsoft.kata;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/12/13
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;

    public static void setBankAccountDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }

    public static BankAccountDTO open(String accountNumber) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        bankAccountDao.create(bankAccountDTO);
        return bankAccountDTO;

    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return bankAccountDao.get(accountNumber);
    }

    public static void deposit(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,amount,description);
    }

    public static void withDraw(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,-amount,description);
    }

    private static void doTransaction(String accountNumber,long amount,String description){
        BankAccountDTO b = bankAccountDao.get(accountNumber);
        b.setBalance(b.getBalance() + amount);
        bankAccountDao.save(b);
        Transaction.save(accountNumber,amount,description);
    }

    public static List<TransactionDTO> getTransactionOccured(String acountNumber) {
        return Transaction.getTransactions(acountNumber);
    }
    //
    public static List<TransactionDTO> getTransactionOccured(String acountNumber,Long startTime,long stopTime) {
        return Transaction.getTransactions(acountNumber,startTime,stopTime);
    }
    //
    public static List<TransactionDTO> getTransactionOccured(String acountNumber,int n) {
        return Transaction.getTransactions(acountNumber,n);
    }
}
