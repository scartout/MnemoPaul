package pl.scartout.mnemopaul.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import pl.scartout.mnemopaul.dao.DAOFactory;
import pl.scartout.mnemopaul.dao.UserDAO;
import pl.scartout.mnemopaul.model.User;

public class UserService {
   
    private String encryptPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(password.getBytes());
        String md5Password = new BigInteger(1, digest.digest()).toString(16);
        return md5Password;
    }

	public void addUser(String username, String password, String email) {
    	try {
    	User user = new User();
        user.setUsername(username);
        String md5Pass = encryptPassword(password);
        user.setPassword(md5Pass);
        user.setEmail(email);
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        userDao.create(user);
    	}catch (DuplicateKeyException e) {
    	}
    }	
    
    public List<User> getAllUser() {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        List<User> users = userDao.getAll();
        return users;
    }
    
    public User getUserById(long user_id) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        User user = userDao.read(user_id);
        return user;
    }
     
    public User getUserByUsername(String username) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        User user = userDao.getUserByUsername(username);
        return user;
    }

    public boolean updateUser(User user) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        boolean result = userDao.update(user);
        return result;
    }
    
    public static boolean deleteUser(Long user_id) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        boolean result = userDao.delete(user_id);
        return result;
    }

}