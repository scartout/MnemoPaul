package pl.scartout.mnemopaul.model;

import static org.assertj.core.api.Assertions.assertThat;

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
	
	@Test
	public void verifyToString() {
		User user = new User();
	    user.setUser_id(9999999L);
	    user.setUsername("username");
	    assertThat(user.toString()).isEqualTo("User - 9999999 - username");
	}
	
}
