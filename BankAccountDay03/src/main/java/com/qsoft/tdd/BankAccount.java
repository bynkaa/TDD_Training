package com.qsoft.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/10/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;

    public static void setBankAccountDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }

    public static void openAccount(String s) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(s);
        bankAccountDao.create(bankAccountDTO);
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return bankAccountDao.get(accountNumber);
    }

    public static void deposit(String accountNumber, long amount, String description) {
        BankAccountDTO bankAccountDTO = getAccount(accountNumber);
        bankAccountDTO.addBalance(amount);
        bankAccountDao.save(bankAccountDTO);
    }
}
