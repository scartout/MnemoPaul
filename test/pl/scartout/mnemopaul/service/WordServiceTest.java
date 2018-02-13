package pl.scartout.mnemopaul.service;

import java.util.Date;

import org.junit.Test;

import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.service.WordService;

public class WordServiceTest {
	
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
	public void shouldCreateWord() {
		WordService wordservice = new WordService();
		Word word = wordservice.createWordObject("Card pl", "Card en", "Deck", "Tag", new Date(), createUser());
		Word word2 = new Word(word);
	}
		
}
