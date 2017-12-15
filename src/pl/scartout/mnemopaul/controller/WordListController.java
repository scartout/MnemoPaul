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
 
@WebServlet("/wordlist")
public class WordListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	User loggedUser = (User) request.getSession().getAttribute("user");
    	Long user_id = loggedUser.getUser_id();
        request.setAttribute("user", user_id);
    	saveWordsInRequest(request, user_id);
    	
        request.getRequestDispatcher("WEB-INF/wordlist.jsp").forward(request, response);
    }
    
    private void saveWordsInRequest(HttpServletRequest request, Long user_id) {
        WordService wordService = new WordService();
        List<Word> allWords = wordService.getAllWordOrderById(user_id);
        request.setAttribute("words", allWords);
    }

}