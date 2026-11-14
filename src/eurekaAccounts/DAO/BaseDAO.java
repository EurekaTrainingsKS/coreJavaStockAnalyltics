package eurekaAccounts.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    private static String jdbcURL = "jdbc:postgresql://endeavourtech.ddns.net:50271/StocksDB";
    private static String userName = "evr_sql_app";
    private static String password = "5LViU5pLkSjRHECec9NF4wRxxV";
    protected Connection jdbcConnection;

    public BaseDAO(){
        try {
            jdbcConnection = DriverManager.getConnection(jdbcURL,userName,password);
        }
        catch (SQLException e){
            System.out.println("An exception occured while trying to connect SQL DB:"+e);
        }
    }
}