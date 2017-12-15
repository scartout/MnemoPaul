package pl.scartout.mnemopaul.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.service.WordService;
 
@WebServlet("/review")
public class ReviewController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	User loggedUser = (User) request.getSession().getAttribute("user");
        long user_id  = loggedUser.getUser_id();
        request.setAttribute("user", user_id);
        String deck = request.getParameter("deck");
        if (deck.equals("null")) saveWordsInRequest(request, user_id);
        else saveWordsInRequest(request, user_id, deck);
        request.getRequestDispatcher("WEB-INF/review.jsp").forward(request, response);
    }
    
    private void saveWordsInRequest(HttpServletRequest request, long user_id) {
    	WordService wordService = new WordService();
        List<Word> allWords = wordService.getAllWord(user_id);
        request.setAttribute("words", allWords);
    }
    
    private void saveWordsInRequest(HttpServletRequest request, long user_id, String deck) {
        WordService wordService = new WordService();
        List<Word> allWords = wordService.getAllWordByDeck(user_id, deck);
        request.setAttribute("words", allWords);
    }
    
}