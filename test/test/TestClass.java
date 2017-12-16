package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.Test;

import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.service.WordService;

public class TestClass {
	
	public User createUser() {
		User user = new User();
		user.setUser_id(999999);
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("username@mail.com");
		user.setRole("user");
		return user;
	}
	
	@Test
	public void ifWordCreateObjectWorks() {
		WordService wordservice = new WordService();
		Word word = wordservice.createWordObject("Card pl", "Card en", "Deck", "Tag", new Date(), createUser());
		Word word2 = new Word(word);
		assertNotNull(word2);
	}
	
	@Test
	public void ifWordEqualsWorks() {
		WordService wordservice = new WordService();
		Word wordone = wordservice.createWordObject("Card pl", "Card en", "Deck", "Tag", new Date(), createUser());
		Word wordtwo = wordservice.createWordObject("Card pl", "Card en", "Deck", "Tag", new Date(), createUser());
		assertTrue(wordone.equals(wordtwo));
	}
	
	@Test
	public void ifWordHashCodeWorks() {
		WordService wordservice = new WordService();
		Word wordone = wordservice.createWordObject("Card pl", "Card en", "Deck", "Tag", new Date(), createUser());
		Word wordtwo = wordservice.createWordObject("Card pl", "Card en", "Deck", "Tag", new Date(), createUser());
		int wordonehc = wordone.hashCode();
		int wordtwohc = wordtwo.hashCode();
		boolean result = (wordonehc == wordtwohc) ? true : false; 
		assertTrue(result);
	}
	
	@Test
	public void ifUserCreateObjectWorks() {
		User user = new User();
		user.setUser_id(0);
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("username@mail.com");
		user.setRole("user");
		User user2 = new User(user);
		assertNotNull(user2);
	}
	
	@Test
	public void ifUserEqualsWorks() {
		User userone = new User(createUser());
		User usertwo = new User(createUser());
		assertTrue(userone.equals(usertwo));
	}
	
	@Test
	public void ifUserHashCodeWorks() {
		User userone = new User(createUser());
		User usertwo = new User(createUser());
		int useronehc = userone.hashCode();
		int usertwohc = usertwo.hashCode();
		boolean result = (useronehc == usertwohc) ? true : false; 
		assertTrue(result);
	}
		
}
