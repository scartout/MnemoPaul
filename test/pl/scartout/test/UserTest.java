package pl.scartout.test;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import pl.scartout.mnemopaul.model.User;

public class UserTest {

	@Test
	public void create() {
		User user = new User();
	}
	
	@Test
	public void equalsContract() {
	    EqualsVerifier.forClass(User.class).verify();
	}
	
	@Test
	public void shouldCreateUser() {
		User user = new User();
		user.setUser_id(0);
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("username@mail.com");
		user.setRole("user");
		User user2 = new User(user);
	}
	
}
