package pl.scartout.test;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import pl.scartout.mnemopaul.model.Word;

public class WordTest {

	@Test
	public void create() {
		Word word = new Word();
	}
	
	@Test
	public void equalsContract() {
	    EqualsVerifier.forClass(Word.class).verify();
	}
	
}
