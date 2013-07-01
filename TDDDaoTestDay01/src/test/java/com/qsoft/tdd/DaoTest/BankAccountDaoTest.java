package com.qsoft.tdd.DaoTest;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/28/13
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDaoTest {
    private final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private final String USER = "sa";
    private final String PASSWORD = "";
//    create db schemal
    @BeforeClass
    public void createSchema() throws SQLException {
        String schemaFileName = System.class.getResource("/schema.sql").toString();
        System.out.println(schemaFileName);
        RunScript.execute(JDBC_URL, USER, PASSWORD, schemaFileName, Charset.forName("UTF8"), false);
    }

    private DataSource dataSource(){
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}
