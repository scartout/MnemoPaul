package pl.scartout.mnemopaul.dao;
 
import java.util.List;
 
import pl.scartout.mnemopaul.model.User;

public interface UserDAO extends GenericDAO<User, Long> {
 
    List<User> getAll();
    
    User getUserByUsername(String username);
     
}