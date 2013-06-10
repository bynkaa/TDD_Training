package com.qsoft.tdd;

import org.junit.*;
import org.mockito.ArgumentCaptor;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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


}
