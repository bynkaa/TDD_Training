package com.qsoft.kata;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/12/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountTest {
    BankAccountDao bankAccountDao = mock(BankAccountDao.class);
    TransactionDao transactionDao = mock(TransactionDao.class);
    Calendar calendar = mock(Calendar.class);
    @Before
    public void setUp(){
        BankAccount.setBankAccountDao(bankAccountDao);
        Transaction.setTransactionDao(transactionDao);
        Transaction.setCalendar(calendar);
    }
    //
    @Test
    public void testOpenNewAccount(){
        BankAccount.open("1234567890");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao,times(1)).create(argument.capture());
        assertEquals("1234567890", argument.getValue().getAccountNumber());
        assertEquals(0,argument.getValue().getBalance());
    }
    //
    @Test
    public void testGetAccount(){
        BankAccountDTO b = new BankAccountDTO("1234567890");
        BankAccount.getAccount(b.getAccountNumber());
        verify(bankAccountDao, times(1)).get("1234567890");
    }
    //
    @Test
    public void testBankAccountDeposit(){
        BankAccountDTO b = new BankAccountDTO("1234567890");
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        BankAccount.deposit("1234567890",50L,"first deposit");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao,times(1)).save(argument.capture());
        assertEquals("1234567890",argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getBalance());
    }
    @Test
    public void testDepositTransactionShouldBeSaveToDB(){
        BankAccountDTO b = new BankAccountDTO("1234567890");
        when(bankAccountDao.get(b.getAccountNumber())).thenReturn(b);
        when(calendar.getTimeInMillis()).thenReturn(100L);
        BankAccount.deposit("1234567890",50L,"first deposit");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao,times(1)).save(argument.capture());
        assertEquals(b.getAccountNumber(),argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getAmount());
        assertEquals(100L,argument.getValue().getTimeStamp());

    }

}
