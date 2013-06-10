package com.qsoft.tdd;

import org.junit.Before;

import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/10/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionTest {
    TransactionDao transactionDao = mock(TransactionDao.class);
    @Before
    public void setUp(){
        Transaction.setTransactionDao(transactionDao);
    }

}
