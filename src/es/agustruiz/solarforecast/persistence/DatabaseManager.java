package es.agustruiz.solarforecast.persistence;

import java.sql.*;
import es.agustruiz.solarforecast.logger.MyLogger;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class DatabaseManager {
    
    public static final String LOG_TAG = DatabaseManager.class.getName();
    
    protected static final String JDBC_DRIVER = JdbcConfiguration.JDBC_DRIVER;
    protected static final String DB_URL = JdbcConfiguration.DB_URL;
    protected static final String USER = JdbcConfiguration.DB_USER;
    protected static final String PASS = JdbcConfiguration.DB_PASS;
    
    protected Connection connection = null;
    protected Statement statement = null;

    public DatabaseManager() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            
            MyLogger.i(LOG_TAG, "Database connection OK");
        } catch (ClassNotFoundException ex) {
            MyLogger.e(LOG_TAG, "Error registring JDBC driver: " + ex.toString());
        } catch (SQLException ex){
            MyLogger.e(LOG_TAG, "SQLException: " + ex.toString());
        }
    }

}
