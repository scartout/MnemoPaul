package pl.scartout.mnemopaul.dao;
 
public class MysqlDAOFactory extends DAOFactory {
 
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
 
    @Override
    public WordDAO getWordDAO() {
        return new WordDAOImpl();
    }
 
}