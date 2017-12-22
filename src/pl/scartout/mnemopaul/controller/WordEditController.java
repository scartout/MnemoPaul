package pl.scartout.mnemopaul.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.service.WordService;
 
@WebServlet("/edit")
public class WordEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        long word_id = Long.valueOf(request.getParameter("word_id"));
        saveWordInRequest(request, word_id);
        request.getRequestDispatcher("WEB-INF/edit.jsp").forward(request, response);
    }

    private void saveWordInRequest(HttpServletRequest request, long word_id) {
        Word word2 = WordService.getWordById(word_id);
        request.setAttribute("words", word2);
    }

}