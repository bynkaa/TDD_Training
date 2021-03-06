package dao;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import tdd.persistence.dao.BankAccountDAO;
import tdd.persistence.dao.TransactionDAO;
import tdd.persistence.model.BankAccountDTO;
import tdd.persistence.model.TransactionDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * User: BinkaA
 * Date: 7/19/13
 * Time: 1:44 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class BankAccountDAOTest {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private DataSource dataSourceTest;
    private IDatabaseTester databaseTester;
    @Autowired
    private BankAccountDAO bankAccountDAO;
    @Autowired
    private TransactionDAO transactionDAO;
    private String accountNumber = "1234567890";
    @Before
    public void setup() throws Exception {
        IDataSet dataSet = readDataset();
        cleanlyInsert(dataSet);
    }
    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        databaseTester = new DataSourceDatabaseTester(dataSourceTest);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @Test
    public void testGetAccountNotExistInDB(){
        BankAccountDTO bankAccountDTO = bankAccountDAO.get("1234567899");
        assertEquals(bankAccountDTO,null);
    }
    @Test
    public void testGetAccountWithIllegalFormatAccountNumber(){
        BankAccountDTO bankAccountDTO = bankAccountDAO.get("1234babvdjah");
        assertEquals(bankAccountDTO,null);
    }

    @Test
    public void testGetBankAccount(){
        BankAccountDTO bankAccountDTO = bankAccountDAO.get(accountNumber);
        assertEquals(accountNumber,bankAccountDTO.getAccountNumber());
        assertEquals(100,bankAccountDTO.getBalance());
        assertEquals(100,bankAccountDTO.getOpenTimeStamp());
    }

    @Test
    public void testSaveBankAccount(){
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setAccountNumber("1234567890");
        bankAccountDAO.save(bankAccountDTO);
        BankAccountDTO savedBankAccount = bankAccountDAO.get("1234567890");
        assertEquals(bankAccountDTO,savedBankAccount);
    }

    @Test
    public void testSaveIlegalBankAccountHasNagativeBalance(){
        try{
            BankAccountDTO bankAccountDTO = new BankAccountDTO("1234567890",-10);
            bankAccountDAO.save(bankAccountDTO);
            fail();
        }catch (RuntimeException re){
            assertEquals("not allowed negative balance",re.getMessage());
        }

    }

    @Test
    public void testGetAllTransaction(){
        List<TransactionDTO> transactionList = transactionDAO.get(accountNumber);
        assertEquals(1,transactionList.size());
        TransactionDTO actualTransaction = transactionList.get(0);
        assertEquals(accountNumber,actualTransaction.getAccountNumber());
        assertEquals(100L,actualTransaction.getAmount());
        assertEquals(100L,actualTransaction.getTimeStamp());
        assertEquals("deposit 100K",actualTransaction.getDescription());
    }

    @Test
    public void testSaveTransaction(){
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,100L,100L,"deposit 100K");
        transactionDAO.save(transactionDTO);
        List<TransactionDTO> transactionList = transactionDAO.get(accountNumber);
        assertEquals(2,transactionList.size());
        TransactionDTO actualTransaction = transactionList.get(1);
        assertEquals(accountNumber,actualTransaction.getAccountNumber());
        assertEquals(100L,actualTransaction.getAmount());
        assertEquals(100L,actualTransaction.getTimeStamp());
        assertEquals("deposit 100K",actualTransaction.getDescription());
    }
    @Test
    public void testGetTransactionInAPeriodTime(){
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,200L,199L,"deposit 200K");
        transactionDAO.save(transactionDTO);
        List<TransactionDTO> transactionDTOList = transactionDAO.get(accountNumber,100L,200L);
        assertEquals(2,transactionDTOList.size());
    }
    @Test
    public void testGetNTransactions(){
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,200L,200L,"deposit 200K");
        transactionDAO.save(transactionDTO);
        List<TransactionDTO> transactionDTOList = transactionDAO.get(accountNumber,1);
        assertEquals(1,transactionDTOList.size());
        TransactionDTO actualTransaction = transactionDTOList.get(0);
        assertEquals(accountNumber,actualTransaction.getAccountNumber());
        assertEquals(200L,actualTransaction.getAmount());
        assertEquals(200L,actualTransaction.getTimeStamp());
        assertEquals("deposit 200K",actualTransaction.getDescription());
    }


    private IDataSet readDataset() throws DataSetException {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));

    }

}