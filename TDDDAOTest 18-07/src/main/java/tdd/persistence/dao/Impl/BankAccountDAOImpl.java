package tdd.persistence.dao.Impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tdd.persistence.dao.BankAccountDAO;
import tdd.persistence.model.BankAccountDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        validateBankAccount(bankAccountDTO);
        entityManager.persist(bankAccountDTO);

    }

    @Override
    public BankAccountDTO get(String accountNumber) {
        //
        if (!isValidateName(accountNumber)){
            System.out.println("illegal account number format");
            return null;
        }
        //
        Query query = entityManager.createNamedQuery("bank_account.findByName");
        query.setParameter("accountNumber",accountNumber);
        if (query.getResultList().isEmpty())
            return null;
        return (BankAccountDTO)query.getResultList().get(0);
    }

    public void validateBankAccount(BankAccountDTO bankAccountDTO){
        if (bankAccountDTO == null)
            throw new RuntimeException("bank account empty");
        if (!isValidateName(bankAccountDTO.getAccountNumber()))
            throw new RuntimeException("illegal format account number");
        if (bankAccountDTO.getBalance() < 0 )
            throw new RuntimeException("not allowed negative balance");
        if (bankAccountDTO.getOpenTimeStamp() < 0)
            throw new RuntimeException("not allowed negative OpenTime");
    }
    public boolean isValidateName(String accountNumber){
        if (accountNumber.length() != 10)
            return false;
        for (int i = 0; i < 10; i++){
            if (accountNumber.charAt(i) >= '0' && accountNumber.charAt(i) <= '9')
                return true;
        }
        return false;

    }
}
