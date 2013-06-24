package com.qsoft.tdd;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountTest {
    BankAccountDao bankAccountDao = mock(BankAccountDao.class);
    String accountNumber = "1234567890";
    TransactionDao transactionDao = mock(TransactionDao.class);
    Calendar calendar = mock(Calendar.class);
    @Before
    public void setUp(){
        reset(bankAccountDao);
        BankAccount.setBankAccountDao(bankAccountDao);
        Transaction.setTransactionDao(transactionDao);
        Transaction.setCalendar(calendar);
    }
    @Test
    public void testOpenNewAccount(){
        BankAccount.openAccount(accountNumber);
        ArgumentCaptor<BankAccountDTO>  argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao,times(1)).save(argument.capture());
        assertEquals(accountNumber,argument.getValue().getAccountNumber());
        assertEquals(0,argument.getValue().getBalance());
    }
    @Test
    public void testGetNewAccount(){
        BankAccount.getAccount(accountNumber);
        verify(bankAccountDao,times(1)).get(accountNumber);
    }
    @Test
    public void testDepositShouldIncreaseBalance(){
        BankAccountDTO b = BankAccount.openAccount(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        BankAccount.deposit(accountNumber,50L,"deposit 50K");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao,times(2)).save(argument.capture());
        assertEquals(accountNumber,argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getBalance());
    }
    @Test
    public void testDepositShouldSaveTransactionToDB(){
        BankAccountDTO b = BankAccount.openAccount(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        when(calendar.getTimeInMillis()).thenReturn(100L);
        BankAccount.deposit(accountNumber,50L,"deposit 50K");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao,times(1)).save(argument.capture());
        assertEquals("1234567890",argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getAmount());
        assertEquals(100L,argument.getValue().getTimeStamp());

    }
    @Test
    public void testWithdrawShouldDecreaseBalance(){
        BankAccountDTO b = BankAccount.openAccount(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        BankAccount.withdraw(accountNumber,50L,"deposit 50K");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao,times(2)).save(argument.capture());
        assertEquals(accountNumber,argument.getValue().getAccountNumber());
        assertEquals(-50L,argument.getValue().getBalance());
    }
    @Test
    public void testWithdrawShouldSaveTransactionToDB(){
        BankAccountDTO b = BankAccount.openAccount(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        when(calendar.getTimeInMillis()).thenReturn(100L);
        BankAccount.withdraw(accountNumber,50L,"deposit 50K");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao,times(1)).save(argument.capture());
        assertEquals("1234567890",argument.getValue().getAccountNumber());
        assertEquals(-50L,argument.getValue().getAmount());
        assertEquals(100L,argument.getValue().getTimeStamp());

    }
}
