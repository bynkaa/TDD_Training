package com.qsoft.tdd;

import org.junit.*;
import org.mockito.ArgumentCaptor;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/10/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountTest {

    BankAccountDao bankAccountDao = mock(BankAccountDao.class);
    @Before
    public void setUp(){
        BankAccount.setBankAccountDao(bankAccountDao);
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
        when(bankAccountDao.get(b.getAccountNumber())).thenReturn(b);
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


}
