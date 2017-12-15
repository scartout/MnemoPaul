package pl.scartout.mnemopaul.dao;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.util.ConnectionProvider;
 
public class UserDAOImpl implements UserDAO {
 
	private static final String CREATE_USER = 
		    "INSERT INTO user (username, password, email) VALUES(:username, :password, :email);";
	private static final String READ_USER = 
		    "SELECT user_id, username, password, email, role FROM user WHERE user_id = :user_id";
	private static final String READ_USER_BY_USERNAME =
			"SELECT user_id, username, password, email, role FROM user WHERE username = :username";
	private static final String READ_ALL_USERS = 
		    "SELECT user_id, username, password, email, role FROM user ORDER BY role, user_id ASC";
	private static final String UPDATE_USER_ROLE = 
			"UPDATE user set user_id=:user_id, username=:username, password=:password, email=:email, role=:role "
			+ "WHERE user_id = :user_id;";
	private static final String DELETE_USER = 
			"DELETE FROM user WHERE user_id = :id;";
		 
	private NamedParameterJdbcTemplate template;
		     
	public UserDAOImpl() {
		    template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
    @Override
    public User create(User user) {
        User resultUser = new User(user);
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		int update = template.update(CREATE_USER, paramSource, holder);
        if(update > 0) {
        	resultUser.setUser_id((Long)holder.getKey());
        }
        
		return resultUser;  
    }
 
    @Override
    public User read(Long primaryKey) {
    	User resultUser = null;
        SqlParameterSource paramSource = new MapSqlParameterSource("user_id", primaryKey);
        resultUser = template.queryForObject(READ_USER, paramSource, new UserRowMapper());
        return resultUser;
    }
    
    @Override
    public boolean update(User user) {
        boolean result = false;
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", user.getUser_id());
        paramMap.put("username", user.getUsername());
		paramMap.put("password", user.getPassword());
		paramMap.put("email", user.getEmail());
		paramMap.put("role", user.getRole());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        int update = template.update(UPDATE_USER_ROLE, paramSource);
        if(update > 0) {
            result = true;
        }
        return result;
    }
    
    @Override
    public boolean delete(Long id) {
    	SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        template.update(DELETE_USER, paramSource);
        return true;
    }
 
    @Override
    public List<User> getAll() {
    	List<User> users = template.query(READ_ALL_USERS, new UserRowMapper());
    	return users;
    }
    
    @Override
    public User getUserByUsername(String username) {
        User resultUser = null;
        SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
        resultUser = template.queryForObject(READ_USER_BY_USERNAME, paramSource, new UserRowMapper());
        return resultUser;
    }
    
    private class UserRowMapper implements RowMapper<User> {
    	 
	    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	        User user = new User();
	        user.setUser_id(resultSet.getLong("user_id"));
	        user.setUsername(resultSet.getString("username"));
	        user.setPassword(resultSet.getString("password"));
	        user.setEmail(resultSet.getString("email"));
	        user.setRole(resultSet.getString("role"));
	        return user;
	    }
    }

}