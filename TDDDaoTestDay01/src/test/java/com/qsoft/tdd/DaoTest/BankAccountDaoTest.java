package com.qsoft.tdd.DaoTest;

import com.qsoft.tdd.BankAccountDTO;
import com.qsoft.tdd.BankAccountDao;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/28/13
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDaoTest {
    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
//    create db schemal
    @BeforeClass
    public static void createSchema() throws SQLException {
        String schemaFileName = System.class.getResource("/schema.sql").toString();
        System.out.println(schemaFileName);
        RunScript.execute(JDBC_URL, USER, PASSWORD, schemaFileName, Charset.forName("UTF8"), false);
    }
    // populate the table with test data
    @Before
    public void importDataSet() throws Exception {
        IDataSet dataSet = readDataSet();
        cleanlyInsert(dataSet);
    }
    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));
    }
    //
    @Test
    public void testFindByAccountNumber() throws Exception {
        BankAccountDao bankAccountDao = new BankAccountDao(dataSource());
        BankAccountDTO b = bankAccountDao.get("1234567890");
        Assert.assertEquals("1234567890",b.getAccountNumber());

    }

    private DataSource dataSource(){
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}
