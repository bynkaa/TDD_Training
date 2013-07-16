package com.qsoft.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qsoft.tdd.persistence.dao.BankAccountDAO;
import com.qsoft.tdd.persistence.model.BankAccountDTO;
import com.qsoft.tdd.persistence.model.TransactionDTO;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class BankAccount {
    @Autowired
    private static BankAccountDAO bankAccountDAO;

    private static Calendar calendar = Calendar.getInstance();

    public static void setBankAccountDao(BankAccountDAO bankAccountDao) {
        BankAccount.bankAccountDAO = bankAccountDao;
    }


    public static BankAccountDTO openAccount(String accountNumber) {
        //To change body of created methods use File | Settings | File Templates.
        long timeStamp = calendar.getTimeInMillis();
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setAccountNumber(accountNumber);
        bankAccountDTO.setOpenTimeStamp(timeStamp);
        bankAccountDAO.save(bankAccountDTO);
        return bankAccountDTO;
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return bankAccountDAO.get(accountNumber);

    }

    public static void deposit(String accountNumber, long amount, String description) {
        BankAccountDTO bankAccountDTO = getAccount(accountNumber);
        bankAccountDTO.setBalance(bankAccountDTO.getBalance() + amount);
        bankAccountDAO.save(bankAccountDTO);
        //
        Transaction.save(accountNumber,amount,description);


    }

    public static void withdraw(String accountNumber, long amount, String description) {
        BankAccountDTO bankAccountDTO = getAccount(accountNumber);
        bankAccountDTO.setBalance(bankAccountDTO.getBalance() - amount);
        bankAccountDAO.save(bankAccountDTO);
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
