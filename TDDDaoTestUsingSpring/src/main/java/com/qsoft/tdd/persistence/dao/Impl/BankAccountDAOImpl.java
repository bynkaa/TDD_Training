package com.qsoft.tdd.persistence.dao.Impl;

import com.qsoft.tdd.persistence.dao.BankAccountDAO;
import com.qsoft.tdd.persistence.model.BankAccountDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User: BinkaA
 * Date: 7/2/13
 * Time: 1:50 PM
 */
@Component
@Transactional
public class BankAccountDAOImpl implements BankAccountDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void save(BankAccountDTO bankAccountDTO) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BankAccountDTO get(String accountNumber) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
