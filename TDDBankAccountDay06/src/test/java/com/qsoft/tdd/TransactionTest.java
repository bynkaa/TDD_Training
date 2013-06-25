package com.qsoft.tdd;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/25/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionTest {
    BankAccountDao bankAccountDao = mock(BankAccountDao.class);
    String accountNumber = "1234567890";
    TransactionDao transactionDao = mock(TransactionDao.class);
    Calendar calendar = mock(Calendar.class);
    @Before
    public void setUp(){
        reset(bankAccountDao);
        BankAccount.setBankAccountDao(bankAccountDao);
        BankAccount.setCalendar(calendar);
        Transaction.setTransactionDao(transactionDao);
        Transaction.setCalendar(calendar);
    }
    @Test
    public void testDepositShouldSaveTransactionToDB(){
        BankAccountDTO b = BankAccount.openAccount(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        when(calendar.getTimeInMillis()).thenReturn(100L);
        BankAccount.deposit(accountNumber, 50L, "deposit 50K");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao,times(1)).save(argument.capture());
        assertEquals("1234567890",argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getAmount());
        assertEquals(100L,argument.getValue().getTimeStamp());

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
    @Test
    public void testGetTransactionOccurred(){
        BankAccount.getTransaction(accountNumber);
        verify(transactionDao,times(1)).get("1234567890");

    }
    @Test
    public void testGetNTransactionOccurred(){
        BankAccount.getTransaction(accountNumber,2);
        verify(transactionDao,times(1)).get("1234567890",2);
    }

    @Test
    public void testGetTransactionOccurredInAPeriod(){
        BankAccount.getTransaction(accountNumber,50L,100L);
        verify(transactionDao,times(1)).get("1234567890",50L,100L);
    }
}
