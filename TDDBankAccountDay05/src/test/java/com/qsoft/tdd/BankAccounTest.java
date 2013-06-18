package com.qsoft.tdd;

import org.junit.Before;
import org.junit.Test;

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
        BankAccount.open(accountNumber);
        verify(bankAccountDao,times(1)).save("1234567890");
    }

}
