package pl.scartout.mnemopaul.dao;

import java.util.List;

import pl.scartout.mnemopaul.model.Word;
 
public interface WordDAO extends GenericDAO<Word, Long> {

	public List<Word> getAll(long i);

	public List<Word> getAllOrderById(long i);

	public List<Word> getAllByDeck(long user_id, String deck);

	public List<Word> getAllDeck(long user_id);
}