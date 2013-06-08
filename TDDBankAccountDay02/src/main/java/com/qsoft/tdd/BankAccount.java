package com.qsoft.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/8/13
 * Time: 1:49 PM
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

    public static BankAccountDTO getAccount(String s) {

        return bankAccountDao.get(s);
    }
}
