package com.qsoft.tdd;

import org.junit.Before;

import static org.mockito.Mockito.mock;

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


}
