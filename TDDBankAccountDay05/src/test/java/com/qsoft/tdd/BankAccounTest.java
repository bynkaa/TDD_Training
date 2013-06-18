package com.qsoft.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

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
    public String accountNumber = "1234567890";
    @Before
    public void setUp(){
        reset(bankAccountDao);
        BankAccount.setBankAccountDao(bankAccountDao);
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


}
