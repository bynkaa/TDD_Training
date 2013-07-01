package com.qsoft.tdd;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/22/13
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDao {
    private Connection dbConnection;
    public BankAccountDao(DataSource dataSource) throws SQLException {
        this.dbConnection = dataSource.getConnection();
    }

    public void save(BankAccountDTO bankAccountDTO) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public BankAccountDTO get(String accountNumber) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
