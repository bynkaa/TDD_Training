package com.qsoft.tdd;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/18/13
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccounTest {
    BankAccountDao bankAccountDao = mock(BankAccountDao.class);
    TransactionDao transactionDao = mock(TransactionDao.class);
    Calendar calendar = mock(Calendar.class);
    public String accountNumber = "1234567890";
    @Before
    public void setUp(){
        reset(bankAccountDao);
        reset(transactionDao);
        BankAccount.setBankAccountDao(bankAccountDao);
        BankAccount.setCalendar(calendar);
        Transaction.setTransactionDao(transactionDao);
        Transaction.setCalendar(calendar);
    }
    @Test
    public void testOpenNewBankAccount(){
        when(calendar.getTimeInMillis()).thenReturn(100L);
        BankAccountDTO b = BankAccount.open(accountNumber);
        verify(bankAccountDao,times(1)).save(b);
        assertEquals("1234567890", b.getAccountNumber());
        assertEquals(0L,b.getBalance());
        assertEquals(100L,b.getTimeStamp());
    }
    @Test
    public void testGetBankAccount(){
        BankAccount.get(accountNumber);
        verify(bankAccountDao,times(1)).get("1234567890");
    }
    @Test
    public void testBankAccountDeposit(){
        BankAccountDTO b = BankAccount.open(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        BankAccount.deposit(accountNumber,50L,"deposit 50K");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao,times(2)).save(argument.capture());
        assertEquals("1234567890",argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getBalance());
    }
    @Test
    public void testDepositTransactionShouldBeSavetoDB(){
        BankAccountDTO b = BankAccount.open(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        when(calendar.getTimeInMillis()).thenReturn(100L);
        BankAccount.deposit(accountNumber,50L,"deposit 50K");
        //
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        //
        verify(transactionDao,times(1)).save(argument.capture());
        TransactionDTO actual = argument.getValue();

        assertEquals(actual.getAccountNumber(),accountNumber);
        assertEquals(actual.getDescription(),"deposit 50K");
        assertEquals(actual.getTimeStamp(),100L);
        assertEquals(actual.getAmount(),50L);


    }
    @Test
    public void testWithDrawBehaviour(){
        BankAccountDTO b = BankAccount.open(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        BankAccount.withDraw(accountNumber,50L,"withdraw 50K");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao,times(2)).save(argument.capture());
        assertEquals("1234567890",argument.getValue().getAccountNumber());
        assertEquals(-50L,argument.getValue().getBalance());
    }
    @Test
    public void testWithDrawTransactionShouldBeSaveToDB(){
        BankAccountDTO b = BankAccount.open(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        when(calendar.getTimeInMillis()).thenReturn(100L);
        BankAccount.withDraw(accountNumber,50L,"deposit 50K");
        //
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        //
        verify(transactionDao,times(1)).save(argument.capture());
        TransactionDTO actual = argument.getValue();
        assertEquals(actual.getAccountNumber(),accountNumber);
        assertEquals(actual.getDescription(),"deposit 50K");
        assertEquals(actual.getTimeStamp(),100L);
        assertEquals(actual.getAmount(),-50L);
    }
    @Test
    public void testGetTransactionOccurred(){
        BankAccount.getTransactions(accountNumber);
        verify(transactionDao,times(1)).get(accountNumber);

    }
    @Test
    public void testGetTransactionOccurredInASpecialPeriod(){
        BankAccount.getTransactions(accountNumber,1000L,4000L);
        verify(transactionDao,times(1)).get(accountNumber,1000L,4000L);
    }
    //
    @Test
    public void testGetTransactionOccurredInAPeriodThatStartTimeGreaterThanStoptime(){
        List<TransactionDTO> actual = BankAccount.getTransactions(accountNumber,100L,50L);
        assertEquals(null,actual);
    }
    //
    @Test
    public void testGetNTransactionOccurred(){
        BankAccount.getTransactions(accountNumber,10);
        verify(transactionDao,times(1)).get(accountNumber,10);
    }


}
