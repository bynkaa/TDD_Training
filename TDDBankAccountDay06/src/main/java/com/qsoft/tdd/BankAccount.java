package com.qsoft.tdd;

import javax.sql.rowset.spi.TransactionalWriter;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;

    public static void setBankAccountDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }

    public static BankAccountDTO openAccount(String accountNumber) {
        //To change body of created methods use File | Settings | File Templates.
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
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

    public static void getTransaction(String accountNumber) {
        Transaction.get(accountNumber);

    }
}
