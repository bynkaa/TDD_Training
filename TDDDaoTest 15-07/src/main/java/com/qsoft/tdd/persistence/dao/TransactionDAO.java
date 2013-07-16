package com.qsoft.tdd.persistence.dao;

import com.qsoft.tdd.persistence.model.TransactionDTO;

import java.util.List;

/**
 * User: BinkaA
 * Date: 7/8/13
 * Time: 2:02 PM
 */
public interface TransactionDAO {
    public void save(TransactionDTO transactionDTO);

    public List<TransactionDTO> get(String accountNumber);

    public List<TransactionDTO> get(String accountNumber, int number);

    public List<TransactionDTO> get(String accountNumber, long startTime, long stopTime);
}
