package com.qsoft.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
        Transaction.setTransactionDao(transactionDao);
        Transaction.setCalendar(calendar);
    }
    @Test
    public void testOpenNewBankAccount(){
        BankAccountDTO b = BankAccount.open(accountNumber);
        verify(bankAccountDao,times(1)).save(b);
        assertEquals("1234567890", b.getAccountNumber());
        assertEquals(0L,b.getBalance());
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
        TransactionDTO t = Transaction.createTransaction(accountNumber,50L,"deposit 50K");
        BankAccount.deposit(accountNumber,50L,"deposit 50K");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao,times(1)).save(argument.capture());
        TransactionDTO actual = argument.getValue();
        assertTrue(t.equals(actual));
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
        TransactionDTO t = Transaction.createTransaction(accountNumber,-50L,"withdraw 50K");
        BankAccount.withDraw(accountNumber,50L,"withdraw 50K");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao,times(1)).save(argument.capture());
        TransactionDTO actual = argument.getValue();
        assertTrue(t.equals(actual));
    }


}
