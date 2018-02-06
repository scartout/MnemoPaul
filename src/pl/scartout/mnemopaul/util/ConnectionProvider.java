package pl.scartout.mnemopaul.util;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class ConnectionProvider {
 
    private static DataSource dataSource;
 
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
 
    public static DataSource getDataSource() {
        if (dataSource == null) {
            try {
                Context initialContext = new InitialContext();
                Context envContext = (Context) initialContext
                        .lookup("java:comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/mnemopaul");
                dataSource = ds;
            } catch (NamingException e) {
            	Logger LOGGER = Logger.getAnonymousLogger();
    			LOGGER.log( Level.SEVERE, e.toString(), e );
            }
        }
         
        return dataSource;
    }
}