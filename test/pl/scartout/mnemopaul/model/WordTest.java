package pl.scartout.mnemopaul.model;

import static org.assertj.core.api.Assertions.assertThat;

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
	
	@Test
	public void verifyToString() {
		Word word = new Word();
	    word.setWord_id(9999999L);
	    word.setCard_pl("plworld");
	    assertThat(word.toString()).isEqualTo("Word - 9999999 - plworld");
	}
	
}
