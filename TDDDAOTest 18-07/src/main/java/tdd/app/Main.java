package tdd.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tdd.persistence.dao.BankAccountDAO;
import tdd.persistence.model.BankAccountDTO;

/**
 * User: BinkaA
 * Date: 7/3/13
 * Time: 1:48 PM
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml");
        BankAccountDAO bankAccountDAO = (BankAccountDAO) appContext.getBean("bankAccountDAO");
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setAccountNumber("1234567890");
        bankAccountDAO.save(bankAccountDTO);
    }
}
