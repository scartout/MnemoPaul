package pl.scartout.mnemopaul.service;

import java.util.Date;
import java.util.List;

import pl.scartout.mnemopaul.dao.DAOFactory;
import pl.scartout.mnemopaul.dao.WordDAO;
import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.model.User;
 
public class WordService {
    
	public void addWord(String card_pl, String card_en, String deck, String tag, Date date, User user) {
        Word word = createWordObject(card_pl, card_en, deck, tag, date, user);
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        wordDao.create(word);
    }
     
    public Word createWordObject(String card_pl, String card_en, String deck, String tag, Date date, User user) {
        Word word = new Word();
        word.setCard_pl(card_pl);
        word.setCard_en(card_en);
        word.setDeck(deck);
        word.setTag(tag);
        word.setDate(date);
        User userCopy = new User(user);
        word.setUser(userCopy);
        return word;
    }

    public List<Word> getAllWord(long user_id) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        List<Word> words = wordDao.getAll(user_id);
        return words;
    }
    
    public List<Word> getAllWordByDeck(long user_id, String deck) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        List<Word> words = wordDao.getAllByDeck(user_id, deck);
        return words;
    }
    
    public List<Word> getAllWordExport(long user_id) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        List<Word> words = wordDao.getExport(user_id);
		return words;
    }
    
    public List<Word> getAllWordExportByDeck(long user_id, String deck) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        List<Word> words = wordDao.getExportByDeck(user_id, deck);
        return words;
    }
    
    public List<Word> getAllWordOrderById(Long user_id) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        List<Word> words = wordDao.getAllOrderById(user_id);
        return words;
    }
    
    public static Word getWordById(long word_id) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        Word word = wordDao.read(word_id);
        return word;
    }
    
    public List<Word> getAllDecks(long user_id) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        List<Word> words = wordDao.getAllDeck(user_id);
        return words;
    }
    
    public boolean updateWord(Word word) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        boolean result = wordDao.update(word);
        return result;
    }
    
    public static boolean deleteWord(long word_id) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        WordDAO wordDao = factory.getWordDAO();
        boolean result = wordDao.delete(word_id);
        return result;
    }
    
}