package pl.scartout.mnemopaul.dao;
 
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.scartout.mnemosyne.exception.NoSuchDbTypeException;

public abstract class DAOFactory {
	
	public static final int MYSQL_DAO_FACTORY = 1;
	
	public abstract UserDAO getUserDAO();
 
    public abstract WordDAO getWordDAO();
    
    public static DAOFactory getDAOFactory() {
    	DAOFactory factory = null;
    	try {
    		factory = getDAOFactory(MYSQL_DAO_FACTORY);
    	}catch (NoSuchDbTypeException e) {
    		Logger LOGGER = Logger.getAnonymousLogger();
			LOGGER.log( Level.SEVERE, e.toString(), e );
    	}
    	return factory;
    }
    
    private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException {
        switch (type) {
        case MYSQL_DAO_FACTORY:
            return new MysqlDAOFactory();
        default:
            throw new NoSuchDbTypeException();
        }
    }
    
}