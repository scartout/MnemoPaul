package pl.scartout.mnemopaul.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.service.WordService;
 
@WebServlet("/date")
public class WordDateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	long word_id = Long.parseLong(request.getParameter("word_id"));
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = null;
		try {
			date = df.parse(request.getParameter("date"));
		} catch (ParseException e) {
			
		}
        updateWord(word_id, date);
        response.sendRedirect(request.getContextPath() + "/repeat");
    }
    
    private void updateWord(long word_id, Date date) {
        WordService wordService = new WordService();
        Word word = WordService.getWordById(word_id);
        word.setDate(date);
        wordService.updateWord(word);

    }
}