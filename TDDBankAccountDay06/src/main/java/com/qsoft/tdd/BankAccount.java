package com.qsoft.tdd;

import javax.sql.rowset.spi.TransactionalWriter;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;
    private static Calendar calendar;

    public static void setBankAccountDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }


    public static BankAccountDTO openAccount(String accountNumber) {
        //To change body of created methods use File | Settings | File Templates.
        long timeStamp = calendar.getTimeInMillis();
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber,timeStamp);
        bankAccountDao.save(bankAccountDTO);
        return bankAccountDTO;
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return bankAccountDao.get(accountNumber);

    }

    public static void deposit(String accountNumber, long amount, String description) {
        BankAccountDTO bankAccountDTO = getAccount(accountNumber);
        bankAccountDTO.setBalance(bankAccountDTO.getBalance() + amount);
        bankAccountDao.save(bankAccountDTO);
        //
        Transaction.save(accountNumber,amount,description);


    }

    public static void withdraw(String accountNumber, long amount, String description) {
        BankAccountDTO bankAccountDTO = getAccount(accountNumber);
        bankAccountDTO.setBalance(bankAccountDTO.getBalance() - amount);
        bankAccountDao.save(bankAccountDTO);
        //
        Transaction.save(accountNumber,-amount,description);

    }

    public static List<TransactionDTO> getTransaction(String accountNumber) {
        return Transaction.get(accountNumber);

    }

    public static List<TransactionDTO> getTransaction(String accountNumber, int number) {
        return Transaction.get(accountNumber,number);
    }

    public static List<TransactionDTO> getTransaction(String accountNumber, long startTime, long stopTime) {
        if (startTime > stopTime)
            return null;
        else
            return Transaction.get(accountNumber,startTime,stopTime);

    }

    public static void setCalendar(Calendar calendar) {
        BankAccount.calendar = calendar;
    }
}
