package com.qsoft.tdd;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/10/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionTest {
    TransactionDao transactionDao = mock(TransactionDao.class);
    Calendar calendar = mock(Calendar.class);
    @Before
    public void setUp(){
        Transaction.setTransactionDao(transactionDao);
        Transaction.setCalendar(calendar);
    }
    @Test
    public void testSaveTransaction(){
        //long timeStamp = Calendar.getInstance().getTimeInMillis();
        long timeStamp = 10000L;

        when(calendar.getTimeInMillis()).thenReturn(timeStamp);
        Transaction.save("123456789",50L,"first deposit");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(transactionDao).save(argument.capture());
        assertEquals("123456789",argument.getValue().getAccountNumber());
        assertEquals(50L,argument.getValue().getAmount());
        assertEquals(timeStamp,argument.getValue().getTimeStamp(),100);
        assertEquals("first deposit",argument.getValue().getDescription());

    }


}
