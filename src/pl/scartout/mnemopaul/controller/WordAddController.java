package pl.scartout.mnemopaul.controller;
 
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.service.WordService;
 
@WebServlet("/new")
public class WordAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getUserPrincipal() != null) {
            request.getRequestDispatcher("WEB-INF/new.jsp").forward(request, response);
        } else {
            response.sendError(403);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String card_pl = request.getParameter("InputWord_pl");
        String card_en = request.getParameter("InputWord_en");
        String deck = request.getParameter("InputDeck");
        String tag = request.getParameter("InputTag");
        Timestamp data = null;
        User authenticatedUser = (User) request.getSession().getAttribute("user");
        if(request.getUserPrincipal() != null) {
            WordService wordService = new WordService();
            wordService.addWord(card_pl, card_en, deck, tag, data, authenticatedUser);
            response.sendRedirect(request.getContextPath() + "/new");
        } else {
            response.sendError(403);
        }
    }
}