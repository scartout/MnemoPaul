package pl.scartout.mnemopaul.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.service.WordService;
 
@WebServlet("/update")
public class WordUpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        long word_id = Long.valueOf(request.getParameter("word_id"));
        String card_pl = request.getParameter("InputWord_pl");
        String card_en = request.getParameter("InputWord_en");
        String deck = request.getParameter("InputDeck");
        String tag = request.getParameter("InputTag");
        updateWord(word_id, card_pl, card_en, deck, tag);
        response.sendRedirect(request.getContextPath() + "/wordlist");
    }

    private void updateWord(long word_id, String card_pl, String card_en, String deck, String tag) {
        WordService wordService = new WordService();
        Word word = WordService.getWordById(word_id);
        if (card_pl != "") word.setCard_pl(card_pl);
        if (card_en != "") word.setCard_en(card_en);
        if (deck != "") word.setDeck(deck);
        if (tag != "") word.setTag(tag);
        wordService.updateWord(word);
    }

}