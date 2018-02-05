package pl.scartout.mnemopaul.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Immutable;

import pl.scartout.mnemopaul.model.User;

@Immutable
final public class Word {

	@NotNull
	private long word_id;
	@Size(min=0, max=200)
	private String card_pl;
	@Size(min=0, max=200)
	private String card_en;
	private String deck;
	private String tag;
	private Date date;
	@NotNull
	private User user;
	
	public Word() {}

	public Word(Word word) {
		this.word_id = word.word_id;
		this.card_pl = word.card_pl;
		this.card_en = word.card_en;
		this.deck = word.deck;
		this.tag = word.tag;
		this.date = word.date;
		this.user = new User(word.user);
	}

	public long getWord_id() {
		return word_id;
	}

	public void setWord_id(long word_id) {
		this.word_id = word_id;
	}

	public String getCard_pl() {
		return card_pl;
	}

	public void setCard_pl(String card_pl) {
		this.card_pl = card_pl;
	}

	public String getCard_en() {
		return card_en;
	}

	public void setCard_en(String card_en) {
		this.card_en = card_en;
	}

	public String getDeck() {
		return deck;
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Word [word_id=" + word_id + ", card_pl=" + card_pl + ", card_en=" + card_en + ", deck=" + deck
				+ ", tag=" + tag + ", date=" + date + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card_en == null) ? 0 : card_en.hashCode());
		result = prime * result + ((card_pl == null) ? 0 : card_pl.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((deck == null) ? 0 : deck.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + (int) (word_id ^ (word_id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (card_en == null) {
			if (other.card_en != null)
				return false;
		} else if (!card_en.equals(other.card_en))
			return false;
		if (card_pl == null) {
			if (other.card_pl != null)
				return false;
		} else if (!card_pl.equals(other.card_pl))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (deck == null) {
			if (other.deck != null)
				return false;
		} else if (!deck.equals(other.deck))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (word_id != other.word_id)
			return false;
		return true;
	}

}