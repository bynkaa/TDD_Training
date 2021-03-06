package com.qsoft.kata;

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
 * Date: 6/12/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountTest {
    BankAccountDao bankAccountDao = mock(BankAccountDao.class);
    TransactionDao transactionDao = mock(TransactionDao.class);
    Calendar calendar = mock(Calendar.class);
    String accountNumber = "1234567890";
    @Before
    public void setUp(){
        reset(bankAccountDao);
        reset(transactionDao);
        reset(calendar);
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
        BankAccountDTO b = BankAccount.open(accountNumber);
        BankAccount.getAccount(b.getAccountNumber());
        verify(bankAccountDao, times(1)).get("1234567890");
    }

    //
    @Test
    public void testBankAccountDeposit(){
        // stub a bankAccount
        BankAccountDTO b = BankAccount.open(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        //
        BankAccount.deposit("1234567890",50L,"first deposit");
        // verify
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao,times(1)).save(argument.capture());
        assertEquals("1234567890",argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getBalance());
    }

    public void stubATransaction(){
        BankAccountDTO b = BankAccount.open(accountNumber);
        when(bankAccountDao.get(b.getAccountNumber())).thenReturn(b);
        when(calendar.getTimeInMillis()).thenReturn(100L);
    }
    //
    @Test
    public void testDepositTransactionShouldBeSaveToDB(){
        // stub a transaction
        stubATransaction();
        BankAccount.deposit(accountNumber,50L,"first deposit");
        //
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        // verify
        verify(transactionDao,times(1)).save(argument.capture());
        assertEquals(accountNumber,argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getAmount());
        assertEquals(100L,argument.getValue().getTimeStamp());

    }

    @Test
    public void testBankAccountWithDraw(){
        // stub a bank account
        BankAccountDTO b = BankAccount.open(accountNumber);
        when(bankAccountDao.get("1234567890")).thenReturn(b);
        //--
        BankAccount.withDraw("1234567890",50L,"first withdraw");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        // verify
        verify(bankAccountDao).save(argument.capture());
        assertEquals("1234567890",argument.getValue().getAccountNumber());
        assertEquals(-50L,argument.getValue().getBalance());
    }

    @Test
    public void testWithDrawTransactionShouldBeSaveToDB(){
        // stub a bank account
        stubATransaction();
        //
        BankAccount.withDraw(accountNumber,50L,"first withdraw");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        // verify
        verify(transactionDao).save(argument.capture());
        assertEquals(accountNumber,argument.getValue().getAccountNumber());
        assertEquals(-50L,argument.getValue().getAmount());
        assertEquals(100L,argument.getValue().getTimeStamp());
    }
    //
    public void createListTransactions(){
        BankAccountDTO bankAccountDTO = BankAccount.open(accountNumber);
        when(bankAccountDao.get(accountNumber)).thenReturn(bankAccountDTO);
        when(calendar.getTimeInMillis()).thenReturn(0L).thenReturn(99L);
        BankAccount.deposit(accountNumber,100L,"first deposit");
        BankAccount.withDraw(accountNumber,50L,"first withdraw");
    }

    @Test
    public void testGetTransactionOccurred(){

        ArgumentCaptor<TransactionDTO> transactionRecords = ArgumentCaptor.forClass(TransactionDTO.class);
        createListTransactions();
        verify(transactionDao,times(2)).save(transactionRecords.capture());
        List<TransactionDTO> savedRecords = transactionRecords.getAllValues();
        when(transactionDao.get(accountNumber)).thenReturn(savedRecords);
        List<TransactionDTO> actualRecords = BankAccount.getTransactionOccured("1234567890");
        assertEquals(savedRecords,actualRecords);
    }
    @Test
    public void testGetTransactionInAPeriod(){

        ArgumentCaptor<TransactionDTO> transactionRecords = ArgumentCaptor.forClass(TransactionDTO.class);
        createListTransactions();
        verify(transactionDao,times(2)).save(transactionRecords.capture());
        List<TransactionDTO> savedRecords = transactionRecords.getAllValues();
        when(transactionDao.get(accountNumber,0L,100L)).thenReturn(savedRecords);
        List<TransactionDTO> actualRecords = BankAccount.getTransactionOccured("1234567890",0L,100L);
        assertEquals(savedRecords,actualRecords);
    }
    @Test
    public void testGetNewestNTransactions(){
        ArgumentCaptor<TransactionDTO> transactionRecords = ArgumentCaptor.forClass(TransactionDTO.class);
        createListTransactions();
        verify(transactionDao,times(2)).save(transactionRecords.capture());
        List<TransactionDTO> savedRecords = transactionRecords.getAllValues();
        when(transactionDao.get(accountNumber,2)).thenReturn(savedRecords);
        List<TransactionDTO> actualRecords = BankAccount.getTransactionOccured("1234567890",2);
        assertEquals(savedRecords,actualRecords);
    }

}
