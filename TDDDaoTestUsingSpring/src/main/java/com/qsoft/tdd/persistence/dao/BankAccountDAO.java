package com.qsoft.tdd.persistence.dao;

import com.qsoft.tdd.persistence.model.BankAccountDTO;

/**
 * User: BinkaA
 * Date: 7/2/13
 * Time: 1:48 PM
 */
public interface BankAccountDAO {
    public void save(BankAccountDTO bankAccountDTO);
    public BankAccountDTO get(String accountNumber);
}
