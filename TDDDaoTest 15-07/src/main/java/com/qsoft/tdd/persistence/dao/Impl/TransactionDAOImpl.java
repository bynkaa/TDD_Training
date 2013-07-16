package com.qsoft.tdd.persistence.dao.Impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.qsoft.tdd.persistence.dao.TransactionDAO;
import com.qsoft.tdd.persistence.model.TransactionDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional
public class TransactionDAOImpl implements TransactionDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void save(TransactionDTO transactionDTO) {
        entityManager.persist(transactionDTO);
    }

    public List<TransactionDTO> get(String accountNumber) {
        Query query = entityManager.createNamedQuery("transaction.findByName");
        query.setParameter("accountNumber",accountNumber);
        return query.getResultList();

    }

    public List<TransactionDTO> get(String accountNumber, int number) {
        Query query = entityManager.createNamedQuery("transaction.getNTransaction");
            query.setParameter("accountNumber",accountNumber);
        query.setMaxResults(number);
        return query.getResultList();
    }

    public List<TransactionDTO> get(String accountNumber, long startTime, long stopTime) {
        Query query = entityManager.createNamedQuery("transaction.getInPeriod");
        query.setParameter("accountNumber",accountNumber);
        query.setParameter("startTime",startTime);
        query.setParameter("stopTime",stopTime);
        return query.getResultList();
    }
}
