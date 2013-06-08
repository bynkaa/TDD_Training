package com.qsoft.tdd;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/8/13
 * Time: 1:46 PM
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
        BankAccount.openAccount("1234567890");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(bankAccountDao).create(argument.capture());
        assertEquals("1234567890", argument.getValue().getAccountNumber());
        assertEquals(0L,argument.getValue().getBalance().longValue());
    }
}
