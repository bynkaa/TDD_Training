package com.qsoft.tdd;

import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/10/13
 * Time: 1:48 PM
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
    @Test
    public void testOpenNewAccount(){
        BankAccount.openAccount("0123456789");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao).create(argument.capture());
        assertEquals("0123456789", argument.getValue().getAccountNumber());
        assertEquals(0L,argument.getValue().getBalance().longValue());
    }
    @Test
    public void testGetAccount(){
        BankAccountDTO b = new BankAccountDTO("0123456789");
        when(bankAccountDao.get("0123456789")).thenReturn(b);
        assertEquals(b,BankAccount.getAccount(b.getAccountNumber()));
    }
    @Test
    public void testDeposit(){
        BankAccountDTO b = new BankAccountDTO("0123456789");
        when(bankAccountDao.get(b.getAccountNumber())).thenReturn(b);
        BankAccount.deposit(b.getAccountNumber(),50L,"first deposit");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao).save(argument.capture());
        assertEquals("0123456789",argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getBalance().longValue());
    }

   @Test
    public void testWithDraw(){
       BankAccountDTO b = new BankAccountDTO("0123456789",100L);
       when(bankAccountDao.get(b.getAccountNumber())).thenReturn(b);
       BankAccount.withDraw(b.getAccountNumber(),50L,"first withdraw");
       ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
       verify(bankAccountDao).save(argument.capture());
       assertEquals(b.getAccountNumber(),argument.getValue().getAccountNumber());
       assertEquals(50L,argument.getValue().getBalance().longValue());
   }

    @Test
    public void testDepositTransactionShouldBeSaveToDB(){
        BankAccountDTO b = new BankAccountDTO("0123456789");
        when(bankAccountDao.get(b.getAccountNumber())).thenReturn(b);
        long timeStamp = 10000L;
        when(calendar.getTimeInMillis()).thenReturn(timeStamp);
        BankAccount.deposit("0123456789",50L,"first deposit");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao).save(argument.capture());
        assertEquals("0123456789",argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getAmount());
        assertEquals("first deposit", argument.getValue().getDescription());
        assertEquals(10000L,argument.getValue().getTimeStamp());
    }
    @Test
    public void testWithdrawTransactionShouldBeSaveToDB(){
        BankAccountDTO b = new BankAccountDTO("0123456789");
        when(bankAccountDao.get(b.getAccountNumber())).thenReturn(b);
        long timeStamp = 10000L;
        when(calendar.getTimeInMillis()).thenReturn(timeStamp);
        BankAccount.withDraw("0123456789",50L,"first deposit");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao).save(argument.capture());
        assertEquals("0123456789",argument.getValue().getAccountNumber());
        assertEquals(-50L,argument.getValue().getAmount());
        assertEquals("first deposit", argument.getValue().getDescription());
        assertEquals(10000L,argument.getValue().getTimeStamp());

    }
    @Test
    public void testGetTransactionsOccurred(){
        TransactionDTO t1 = new TransactionDTO("0123456789",0L,50L,"first deposit");
        TransactionDTO t2 = new TransactionDTO("0123456789",0L,-30L,"first withdraw");
        List<TransactionDTO> expectedTransactions = new ArrayList<TransactionDTO>();
        expectedTransactions.add(t1);
        expectedTransactions.add(t2);
        when(transactionDao.get("0123456789")).thenReturn(expectedTransactions);
        List<TransactionDTO> actualTransactions = BankAccount.getTransactions("0123456789");
        verify(transactionDao,times(1)).get("0123456789");
        assertEquals(2, actualTransactions.size());
        for (int i = 0; i < expectedTransactions.size(); i++){
            assertEquals(expectedTransactions.get(i),actualTransactions.get(i));
        }
    }

    @Test
    public void testGetTransactionsInAPeriod(){
        TransactionDTO t1 = new TransactionDTO("0123456789",0L,50L,"first deposit");
        TransactionDTO t2 = new TransactionDTO("0123456789",90L,-30L,"first withdraw");
        List<TransactionDTO> expectedTransactions = new ArrayList<TransactionDTO>();
        expectedTransactions.add(t1);
        expectedTransactions.add(t2);
        when(transactionDao.get("0123456789",0L,100L)).thenReturn(expectedTransactions);
        List<TransactionDTO> actualTransactions = BankAccount.getTransactions("0123456789",0L,100L);
        verify(transactionDao,times(1)).get("0123456789",0L,100L);
        assertEquals(2,actualTransactions.size());
        for (int i = 0; i < expectedTransactions.size(); i++){
            assertEquals(expectedTransactions.get(i),actualTransactions.get(i));
        }

    }

    @Test
    public void testGetANumberTransactions(){
        TransactionDTO t1 = new TransactionDTO("0123456789",0L,50L,"first deposit");
        TransactionDTO t2 = new TransactionDTO("0123456789",90L,-30L,"first withdraw");
        List<TransactionDTO> expectedTransactions = new ArrayList<TransactionDTO>();
        expectedTransactions.add(t1);
        expectedTransactions.add(t2);
        when(transactionDao.get("0123456789",2)).thenReturn(expectedTransactions);
        List<TransactionDTO> actualTransactions = BankAccount.getTransactions("0123456789",2);
        verify(transactionDao,times(1)).get("0123456789",2);
        assertEquals(2,actualTransactions.size());
        for (int i = 0; i < expectedTransactions.size(); i++){
            assertEquals(expectedTransactions.get(i),actualTransactions.get(i));
        }

    }

}
