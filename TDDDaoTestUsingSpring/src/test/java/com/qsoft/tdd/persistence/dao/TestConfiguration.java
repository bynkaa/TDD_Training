package com.qsoft.tdd.persistence.dao;

import com.qsoft.tdd.persistence.model.BankAccountDTO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: BinkaA
 * Date: 7/9/13
 * Time: 1:54 PM
 */
public class TestConfiguration {
    @Test
    public void testConfiguration(){
        ApplicationContext appContext = new ClassPathXmlApplicationContext("test-context.xml");
        BankAccountDAO bankAccountDAO = (BankAccountDAO) appContext.getBean("bankAccountDAO");
        bankAccountDAO.get("1234567890");
    }
}
