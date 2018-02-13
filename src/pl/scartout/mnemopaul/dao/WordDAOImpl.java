package pl.scartout.mnemopaul.dao;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.util.ConnectionProvider;
 
public class WordDAOImpl implements WordDAO {
	
	private static final String CREATE_WORD = 
		    "INSERT INTO word(card_pl, card_en, deck, tag, date, user_id) "
		    + "VALUES(:card_pl, :card_en, :deck, :tag, :date, :user_id);";
	private static final String READ_SINGLE_WORD = 
	        "SELECT word_id, card_pl, card_en, deck, tag, date, user.user_id "
	        + "FROM word LEFT JOIN user ON word.user_id=user.user_id WHERE word_id = :word_id;";
	private static final String READ_FIRST_WORD = 
	        "SELECT word_id, card_en, card_pl, deck, tag, date, user.user_id "
	        + "FROM word LEFT JOIN user ON word.user_id=user.user_id "
	        + "WHERE user.user_id = :userId AND (date<Now() OR date IS NULL) ORDER BY date, word_id ASC LIMIT 1;";
	private static final String READ_ALL_WORDS_TO_IMPORT = 
	        "SELECT word_id, card_en, card_pl, deck, tag, date, user.user_id "
	        + "FROM word LEFT JOIN user ON word.user_id=user.user_id "
	        + "WHERE user.user_id = :userId ORDER BY word_id;";
	private static final String READ_ALL_WORDS_TO_IMPORT_BY_DECK = 
	        "SELECT word_id, card_en, card_pl, deck, tag, date, user.user_id "
	        + "FROM word LEFT JOIN user ON word.user_id=user.user_id "
	        + "WHERE user.user_id = :userId AND deck=:deck ORDER BY word_id;";
	private static final String READ_ALL_WORDS_BY_ID = 
	        "SELECT word_id, card_en, card_pl, deck, tag, date, user.user_id "
			+ "FROM word LEFT JOIN user ON word.user_id=user.user_id WHERE user.user_id = :userId ORDER BY word_id;";
	private static final String READ_ALL_WORDS_BY_DECK = 
			"SELECT word_id, card_en, card_pl, deck, tag, date, user.user_id "
			 + "FROM word LEFT JOIN user ON word.user_id=user.user_id "
			 + "WHERE user.user_id = :userId AND deck = :deck AND (date<Now() OR date IS NULL) ORDER BY date, word_id ASC LIMIT 1;";
	private static final String READ_ALL_DECKS = 
			"SELECT DISTINCT deck FROM word WHERE user_id=:userId;";	
	private static final String UPDATE_WORD = 
			"UPDATE word set card_pl=:card_pl, card_en=:card_en, deck=:deck, tag=:tag, date=:date, user_id=:user_id "
		    + "WHERE word_id = :word_id;";
	private static final String DELETE_WORD = 
			"DELETE FROM word WHERE word_id = :id;";
	    
	private NamedParameterJdbcTemplate template;
		     
	public WordDAOImpl() {
		    template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	@Override
	public Word create(Word word) {
		   Word resultWord = new Word(word);
		   KeyHolder holder = new GeneratedKeyHolder();
		   Map<String, Object> paramMap = new HashMap<String, Object>();
		   paramMap.put("card_pl", word.getCard_pl());
		   paramMap.put("card_en", word.getCard_en());
		   paramMap.put("deck", word.getDeck());
		   paramMap.put("tag", word.getTag());
		   paramMap.put("date", word.getDate());
		   paramMap.put("user_id", word.getUser().getUser_id());
		   SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		   int update = template.update(CREATE_WORD, paramSource, holder);
		   if(update > 0) {
		        resultWord.setWord_id((Long)holder.getKey());
		   }
		   return resultWord;
		   }
 
    @Override
    public Word read(Long primaryKey) {
        SqlParameterSource paramSource = new MapSqlParameterSource("word_id", primaryKey);
        Word word = template.queryForObject(READ_SINGLE_WORD, paramSource, new WordRowMapper());
        return word;
    }
 
    @Override
    public boolean update(Word word) {
           boolean result = false;
           Map<String, Object> paramMap = new HashMap<String, Object>();
           paramMap.put("word_id", word.getWord_id());
           paramMap.put("card_pl", word.getCard_pl());
 		   paramMap.put("card_en", word.getCard_en());
 		   paramMap.put("deck", word.getDeck());
 		   paramMap.put("tag", word.getTag());
 		   paramMap.put("date", word.getDate());
 		   paramMap.put("user_id", word.getUser().getUser_id());
 		   SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
           int update = template.update(UPDATE_WORD, paramSource);
           if(update > 0) {
               result = true;
           }
           return result;
    }
 
    @Override
    public boolean delete(Long id) {
    	SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        template.update(DELETE_WORD, paramSource);
        return true;
    }

    @Override
    public List<Word> getAll(long userId) {
    	SqlParameterSource paramSource = new MapSqlParameterSource("userId", userId);
    	List<Word> words = template.query(READ_FIRST_WORD, paramSource, new WordRowMapper());
        return words;
    }
    
    @Override
    public List<Word> getExport(long userId) {
    	SqlParameterSource paramSource = new MapSqlParameterSource("userId", userId);
    	List<Word> words = template.query(READ_ALL_WORDS_TO_IMPORT, paramSource, new WordRowMapper());
        return words;
    }
    
    @Override
    public List<Word> getExportByDeck(long userId, String deck) {
    	SqlParameterSource paramSource = new MapSqlParameterSource("userId", userId).addValue("deck", deck);
    	List<Word> words = template.query(READ_ALL_WORDS_TO_IMPORT_BY_DECK, paramSource, new WordRowMapper());
        return words;
    }
    
    @Override
    public List<Word> getAllOrderById(long userId) {
    	SqlParameterSource paramSource = new MapSqlParameterSource("userId", userId);
    	List<Word> words = template.query(READ_ALL_WORDS_BY_ID, paramSource, new WordRowMapper());
        return words;
    }
    
    @Override
    public List<Word> getAllByDeck(long userId, String deck) {
    	SqlParameterSource paramSource = new MapSqlParameterSource("userId", userId).addValue("deck", deck);
    	List<Word> words = template.query(READ_ALL_WORDS_BY_DECK, paramSource, new WordRowMapper());
        return words;
    }
    
    @Override
    public List<Word> getAllDeck(long userId) {
    	SqlParameterSource paramSource = new MapSqlParameterSource("userId", userId);
    	List<Word> words = template.query(READ_ALL_DECKS, paramSource, new WordRowMapperOnlyDeck());
        return words;
    }

    private class WordRowMapper implements RowMapper<Word> {
        
        public Word mapRow(ResultSet resultSet, int row) throws SQLException {
            Word word = new Word();
            word.setWord_id(resultSet.getLong("word_id"));
            word.setCard_en(resultSet.getString("card_en"));
            word.setCard_pl(resultSet.getString("card_pl"));
            word.setDeck(resultSet.getString("deck"));
            word.setTag(resultSet.getString("tag"));
            word.setDate(resultSet.getDate("date"));
            User user = new User();
            user.setUser_id(resultSet.getLong("user_id"));
            word.setUser(user);
            return word;
        }
    }
    
    private class WordRowMapperOnlyDeck implements RowMapper<Word> {
        @Override
        public Word mapRow(ResultSet resultSet, int row) throws SQLException {
            Word word = new Word();
            word.setDeck(resultSet.getString("deck"));
            return word;
        }
    }
 
}